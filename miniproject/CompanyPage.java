package miniproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class CompanyPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private static java.lang.String[] columnNames = {
			"거래처명", "품목", "은행", "계좌", "이메일"
		};
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBox;
	private JButton btnNewButton_2;
	private static DefaultTableModel tableModel = new DefaultTableModel(columnNames , 0);
	private String product;

	/**
	 * Create the frame.
	 */
	public CompanyPage() {
		//메인창 설정
		setTitle("자동 발주 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("거래처 관리");
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel.setBackground(UIManager.getColor("Button.light")); // 배경 color
		lblNewLabel.setBorder(new LineBorder(Color.WHITE, 3));
		lblNewLabel.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		lblNewLabel.setBounds(33, 19, 126, 38);
		contentPane.add(lblNewLabel);
		//--------------------------------------------------------------------------------
		
		//카테고리 콤보 박스
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		comboBox.setBounds(182, 28, 139, 24);
		contentPane.add(comboBox());
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
		//--------------------------------------------------------------------------------
		
		//메인화면으로 다시 가는 버튼
		JButton btnNewButton = new JButton("메인화면으로");
		btnNewButton.setBounds(743, 24, 113, 32);
		btnNewButton.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton.setBackground(Color.GRAY); // 배경 color
		btnNewButton.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true); //메인화면 띄우기
				setVisible(false); //원래 있던 창 닫기
				dispose();
			}
		});
		//--------------------------------------------------------------------------------
		
		//table 만들고
		//DB에서 가져온 데이터 table로 띄우기
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 67, 823, 420);
		contentPane.add(scrollPane);
		tableModel.setRowCount(0); // 기존 데이터 제거
		table = new JTable(tableModel);
		try {
			DBConn.DBconnection();
			
			String sql = "" +
					"select * from Company";
			
			PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tableModel.addRow(new Object[] {rs.getString("company_name"),
					rs.getString("product"),
					rs.getString("bank"),
					rs.getString("account"),
					rs.getString("email")});
			}
			
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
		//--------------------------------------------------------------------------------
		
		
		
		//테이블에 있는 행 클릭 시 해당 행의 항목 삭제 버튼
		btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(761, 506, 95, 23);
		btnNewButton_2.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton_2.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_2.setBackground(Color.GRAY); // 배경 color
		btnNewButton_2.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(getBtnConfirm());
		
		//어떤 행을 선택했는지 테이블에 마우스 리스너 달기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				if(rowIndex != -1) {
					//클릭된 행의 셀값 읽기
					product = (String) table.getValueAt(rowIndex, 1);
				}
			}
		});
		
		//--------------------------------------------------------------------------------
		
		//추가 버튼 클릭 시 품목 추가 창 띄움
		
		contentPane.add(CompanyAdd());
		//--------------------------------------------------------------------------------

		
	}

	//카테고리 콤보 박스 클릭 시 선택된 카테고리만 테이블에 출력
	public JComboBox comboBox() {
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedItem = (String) comboBox.getSelectedItem();
					tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
					try {
						DBConn.DBconnection();
						String sql;
						
						if (selectedItem == null ) {
							sql = "select * from company order by company_name";
						}
						else if (!selectedItem.equals("전체")) {
							sql = "select * from company where company_name = ? order by company_name";
						} else {
							sql = "select * from company order by company_name";
						}
						
						
						PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
						
						if(selectedItem == null) {
							
						}else if(!selectedItem.equals("전체")) {
							pstmt.setString(1, selectedItem);
						}
						ResultSet rs = pstmt.executeQuery();
						
						while(rs.next()) {
							tableModel.addRow(new Object[] {rs.getString("company_name"),
								rs.getString("product"),
								rs.getString("bank"),
								rs.getString("account"),
								rs.getString("email")
								});
						}
						
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
		return comboBox;
	}
	//--------------------------------------------------------------------------------
	
	//삭체 버튼 클릭 시 ConfirmDialog 띄움
	public JButton getBtnConfirm() {
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				if(product != null && !product.isEmpty()) { // 선택된 행이 있는지 확인
					//ConfirmDialog를 보여줌
					int option = JOptionPane.showConfirmDialog(
							CompanyPage.this,
							"정말 삭제하시겠습니까?",
							"삭제",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.PLAIN_MESSAGE,
							null);
					
					//클릭된 버튼 확인
					if(option == JOptionPane.OK_OPTION) {
						try {
							DBConn.DBconnection();;
							
							String sql = "" +
									"delete from company where product = ?";
							PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
							pstmt.setString(1, product);
							pstmt.executeUpdate();
							refreshTable();
							
							DBConn.conn.close();
							
							JOptionPane.showMessageDialog(CompanyPage.this,
									"삭제되었습니다.");
							product = null;
							
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
				} else {
					JOptionPane.showMessageDialog(CompanyPage.this,
							"삭제할 거래처를 선택하세요.");
				}
				
			}
		});
		return btnNewButton_2;
	}
	//--------------------------------------------------------------------------------
	
	//추가 버튼 클릭 시 품목을 추가할 수 있는 Dialog 띄움
	public JButton CompanyAdd() {
		JButton btnNewButton_2_1 = new JButton("추가");
		btnNewButton_2_1.setBounds(654, 506, 95, 23);
		btnNewButton_2_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton_2_1.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_2_1.setBackground(Color.GRAY); // 배경 color
		btnNewButton_2_1.setForeground(Color.WHITE); // 글자색 흰색
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				CompanyAdd companyAdd = new CompanyAdd(null);
				companyAdd.setVisible(true);
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
			}
		});
		return btnNewButton_2_1;
	}
	
	//재고 화면의 Table 업데이트
	//static으로 잡아주면 다른 클래스에서 사용 가능
	// 안에 들어가는 변수도 다 static 설정해야함 
	public static void refreshTable() {
		tableModel.setRowCount(0);
		try {
			DBConn.DBconnection();;
	        
	        String sql = "" +
	                "select * from Company";
	        
	        PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            tableModel.addRow(new Object[]{
	                    rs.getString("Company_name"),
	                    rs.getString("product"),
	                    rs.getString("bank"),
	                    rs.getString("account"),
	                    rs.getString("email")
	            });
	        }
	        
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
	//--------------------------------------------------------------------------------
	public void updateCategoryComboBox() throws SQLException {
		DBConn.DBconnection();
	    String query = "SELECT DISTINCT company_name FROM company";
	    PreparedStatement preparedStatement = DBConn.conn.prepareStatement(query);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    // "전체" 옵션 추가
	    comboBox.removeAllItems();
	    comboBox.addItem("전체");

	    while (resultSet.next()) {
	       String company_name = resultSet.getString("company_name");
	       comboBox.addItem(company_name);
	    }

	    resultSet.close();
	    preparedStatement.close();
	    DBConn.conn.close();
	}
}
