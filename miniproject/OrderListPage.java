package miniproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class OrderListPage extends JFrame {
	private static String[] columnNames = {
			"카테고리", "품목", "발주수량", "단위당 가격", "총 가격", "거래처명", "날짜"
		};
	private static DefaultTableModel tableModel = new DefaultTableModel(columnNames , 0);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBox_category, comboBox_product, comboBox_company;
	private JTextField textField;
	private JTextField textField_1;
	private int total_order_amount = 0;
	private int total_price = 0;

	/**
	 * Create the frame.
	 */
	public OrderListPage() {
		//메인 창 설정
		setTitle("자동 발주 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("발주내역");
		lblNewLabel.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel.setBackground(UIManager.getColor("Button.light")); // 배경 color
		lblNewLabel.setBorder(new LineBorder(Color.WHITE, 3));
		lblNewLabel.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		lblNewLabel.setBounds(33, 19, 116, 38);
		contentPane.add(lblNewLabel);
		//---------------------------------------------------------
		
		//총 발주 수량이 얼마나 되는지
		JLabel lblNewLabel_1 = new JLabel("총 수량");
		lblNewLabel_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(47, 516, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("HY중고딕", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setBounds(113, 513, 169, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//------------------------------------------------------------------

		//발주된 품목들의 총 가격이 얼마나 되는지
		JLabel lblNewLabel_1_1 = new JLabel("총 가격");
		lblNewLabel_1_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(354, 516, 54, 15);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("HY중고딕", Font.BOLD, 12));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(420, 513, 169, 21);
		contentPane.add(textField_1);
		//------------------------------------------------------------------
		
		//콤보 박스들 구현
		comboBox_category = new JComboBox();
		comboBox_category.setBounds(173, 28, 139, 24);
		contentPane.add(get_comboBox_category());
		try {
			updateCategoryComboBox();
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(DBConn.conn != null) {
					DBConn.conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		comboBox_product = new JComboBox();
		comboBox_product.setBounds(324, 28, 139, 24);
		contentPane.add(get_comboBox_product());
		try {
			updateProductComboBox();
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(DBConn.conn != null) {
					DBConn.conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		comboBox_company = new JComboBox();
		comboBox_company.setBounds(475, 28, 139, 24);
		contentPane.add(get_comboBox_company());
		try {
			updateCompanyComboBox();
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(DBConn.conn != null) {
					DBConn.conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		//---------------------------------------------------------
		
		//발주 내역 테이블 띄우기
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 67, 823, 420);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		try {
			DBConn.DBconnection();
			tableModel.setRowCount(0); // 기존 데이터 제거
			
			String sql = "" +
					"select * from order_list order by date DESC";
			
			PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				total_order_amount += rs.getInt("order_amount");
				total_price += rs.getInt("total_price");
				tableModel.addRow(new Object[] {rs.getString("category"),
					rs.getString("product"),
					rs.getInt("order_amount"),
					rs.getInt("per_price"),
					rs.getInt("total_price"),
					rs.getString("company_name"),
					rs.getDate("date")
					});
			}
			textField.setText(Integer.toString(total_order_amount));
			textField_1.setText(Integer.toString(total_price));
			total_order_amount = 0;
			total_price = 0;
			
			rs.close();
			pstmt.close();
			DBConn.conn.close();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(DBConn.conn != null) {
					DBConn.conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		scrollPane.setViewportView(table);
		//------------------------------------------------------------------

		//메인화면으로 가는 버튼 구현
		JButton btn_ToMain = new JButton("메인화면으로");
		btn_ToMain.setBounds(743, 24, 113, 32);
		btn_ToMain.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btn_ToMain.setBorderPainted(false); // 버튼 테두리 제거
		btn_ToMain.setBackground(Color.GRAY); // 배경 color
		btn_ToMain.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btn_ToMain);
		btn_ToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true); //메인화면 띄우기
				setVisible(false); //원래 있던 창 닫기
				dispose();
			}
		});
		//------------------------------------------------------------------
	}
	
	//콤보 박스들에 아이템 표시 구현
	//콤보박스1_카테고리
	public JComboBox get_comboBox_category() {
		comboBox_category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox_category.getSelectedItem();
				tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
				try {
					DBConn.DBconnection();;
					String sql;
					
					if (!selectedItem.equals("전체")) {
						sql = "SELECT * FROM order_list WHERE category = ? order by category";
					} else {
		                sql = "SELECT * FROM order_list order by category";
		            }
					
					PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
					if (!selectedItem.equals("전체")) {
						pstmt.setString(1, selectedItem);
		            }
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						total_order_amount += rs.getInt("order_amount");
						total_price += rs.getInt("total_price");
						tableModel.addRow(new Object[] {rs.getString("category"),
							rs.getString("product"),
							rs.getInt("order_amount"),
							rs.getInt("per_price"),
							rs.getInt("total_price"),
							rs.getString("company_name"),
							rs.getDate("date")
							});
					}
					textField.setText(Integer.toString(total_order_amount));
					textField_1.setText(Integer.toString(total_price));
					total_order_amount = 0;
					total_price = 0;
					
					rs.close();
					pstmt.close();
					DBConn.conn.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(DBConn.conn != null) {
							DBConn.conn.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		return comboBox_category;
	}
	
	//콤보박스2_품목
	public JComboBox get_comboBox_product() {
		comboBox_product.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox_product.getSelectedItem();
				tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
				try {
					DBConn.DBconnection();;
					String sql;
					
					if (!selectedItem.equals("전체")) {
						sql = "SELECT * FROM order_list WHERE product = ?";
					} else {
		                sql = "SELECT * FROM order_list order by product";
		            }
					
					PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
					if (!selectedItem.equals("전체")) {
						pstmt.setString(1, selectedItem);
		            }
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						total_order_amount += rs.getInt("order_amount");
						total_price += rs.getInt("total_price");
						tableModel.addRow(new Object[] {rs.getString("category"),
							rs.getString("product"),
							rs.getInt("order_amount"),
							rs.getInt("per_price"),
							rs.getInt("total_price"),
							rs.getString("company_name"),
							rs.getDate("date")
							});
					}
					textField.setText(Integer.toString(total_order_amount));
					textField_1.setText(Integer.toString(total_price));
					total_order_amount = 0;
					total_price = 0;
					
					rs.close();
					pstmt.close();
					DBConn.conn.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(DBConn.conn != null) {
							DBConn.conn.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		return comboBox_product;
	}
	
	//콤보박스3_company
	public JComboBox get_comboBox_company() {
		comboBox_company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox_company.getSelectedItem();
				tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
				try {
					DBConn.DBconnection();;
					String sql;
					
					if (!selectedItem.equals("전체")) {
						sql = "SELECT * FROM order_list WHERE company_name = ? order by company_name";
					} else {
		                sql = "SELECT * FROM order_list order by company_name";
		            }
					
					PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
					if (!selectedItem.equals("전체")) {
						pstmt.setString(1, selectedItem);
		            }
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						total_order_amount += rs.getInt("order_amount");
						total_price += rs.getInt("total_price");
						tableModel.addRow(new Object[] {rs.getString("category"),
							rs.getString("product"),
							rs.getInt("order_amount"),
							rs.getInt("per_price"),
							rs.getInt("total_price"),
							rs.getString("company_name"),
							rs.getDate("date")
							});
					}
					textField.setText(Integer.toString(total_order_amount));
					textField_1.setText(Integer.toString(total_price));
					total_order_amount = 0;
					total_price = 0;
					
					rs.close();
					pstmt.close();
					DBConn.conn.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(DBConn.conn != null) {
							DBConn.conn.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		return comboBox_company;
	}
	//------------------------------------------------------------------
	
	//DB에서 카테고리 목록을 가져와 콤보박스에 추가하는 메소드
	public void updateCategoryComboBox() throws SQLException {
		DBConn.DBconnection();
	    String query = "SELECT DISTINCT category FROM order_list";
	    PreparedStatement preparedStatement = DBConn.conn.prepareStatement(query);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    // "전체" 옵션 추가
	    comboBox_category.removeAllItems();
	    comboBox_category.addItem("전체");

	    while (resultSet.next()) {
	       String category = resultSet.getString("category");
	       comboBox_category.addItem(category);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    DBConn.conn.close();
	}
	
	public void updateProductComboBox() throws SQLException {
		DBConn.DBconnection();
	    String query = "SELECT DISTINCT product FROM order_list";
	    PreparedStatement preparedStatement = DBConn.conn.prepareStatement(query);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    // "전체" 옵션 추가
	    comboBox_product.removeAllItems();
	    comboBox_product.addItem("전체");

	    while (resultSet.next()) {
	       String category = resultSet.getString("product");
	       comboBox_product.addItem(category);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    DBConn.conn.close();
	}
	
	public void updateCompanyComboBox() throws SQLException {
		DBConn.DBconnection();
	    String query = "SELECT DISTINCT company_name FROM order_list";
	    PreparedStatement preparedStatement = DBConn.conn.prepareStatement(query);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    // "전체" 옵션 추가
	    comboBox_company.removeAllItems();
	    comboBox_company.addItem("전체");

	    while (resultSet.next()) {
	       String category = resultSet.getString("company_name");
	       comboBox_company.addItem(category);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    DBConn.conn.close();
	}
	//------------------------------------------------------------------
}