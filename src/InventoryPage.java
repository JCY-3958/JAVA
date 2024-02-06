import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InventoryPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private String selectedItem = "기타";
	private Connection conn;
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private String[] columnNames = {
			"카테고리", "품목", "단위당 가격", "수량", "자동 발주 기준 수량", "기준 미달 시 발주 수량"
		};
	private DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
	public String product;
	boolean confirm;

	/**
	 * Create the frame.
	 */
	public InventoryPage() {
		//메인창 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("재고 관리");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 97, 24);
		contentPane.add(lblNewLabel);
		//--------------------------------------------------------------------------------
		
		//카테고리 콤보 박스
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"기타", "과일", "시럽", "원두", "MD"}));
		comboBox.setBounds(123, 13, 77, 24);
		contentPane.add(comboBox());
		//System.out.println("선택된 카테고리: " + selectedItem);
		//--------------------------------------------------------------------------------
		
		//품목 콤보 박스
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(210, 13, 77, 24);
		contentPane.add(comboBox_1);
		//--------------------------------------------------------------------------------
		
		//메인화면으로 다시 가는 버튼
		JButton btnNewButton = new JButton("메인화면으로");
		btnNewButton.setBounds(395, 13, 113, 23);
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
		scrollPane.setBounds(33, 59, 475, 162);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://222.119.100.89:3382/shopping",
					"minishop",
					"2m2w"
					);
			
			String sql = "" +
					"select * from inventory";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tableModel.addRow(new Object[] {rs.getString("category"),
					rs.getString("product"),
					rs.getInt("per_price"),
					rs.getInt("amount"),
					rs.getInt("auto_standard"),
					rs.getInt("order_amount")});
				
				System.out.println(rs.getString("category") + "\t" +
						rs.getString("product") + "\t" +
						rs.getInt("per_price") + "\t" +
						rs.getInt("amount") + "\t" +
						rs.getInt("auto_standard") + "\t" +
						rs.getInt("order_amount")
						);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		scrollPane.setViewportView(table);
		//--------------------------------------------------------------------------------
		
		//판매 버튼을 누르면 inventory 테이블의 모든 품목의 재고가 -1 감소
		//DB에서 가져온 품목의 재고가 발주 기준 수량보다 작으면 발주 수량을 품목의 재고에 + 하고
		//발주 기준 수량 보다 작았던 품목의 카테고리, 품목, 발주 수량, 단위당 가격, 거래처명, 날짜를 발주 내역 테이블에 추가
		//거래처명은 거래처 테이블을 조회하여 그 품목을 파는 거래처명을 추가함.
		JButton btnNewButton_1 = new JButton("판매");
		btnNewButton_1.setBounds(33, 260, 95, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn = DriverManager.getConnection(
							"jdbc:mysql://222.119.100.89:3382/shopping",
							"minishop",
							"2m2w"
							);
					
					//판매 버튼을 누르면 inventory 테이블의 모든 품목의 재고가 -1 감소
					String sql1 = "" +
							"update inventory set amount = amount -1";
					PreparedStatement pstmt1 = conn.prepareStatement(sql1);
					pstmt1.executeUpdate();
					
					//DB에서 가져온 품목의 재고가 발주 기준 수량보다 작으면 발주 수량을 품목의 재고에 +
					String sql2 = "" +
							"select product, amount, auto_standard " +
							"from inventory " +
							"where amount < auto_standard";
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);
					pstmt2.executeQuery();
					//------하는중-------
					
					conn.close();
					
					
					
				} catch(Exception e1) {
					e1.printStackTrace();
					try {
						conn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		//--------------------------------------------------------------------------------
		
		//테이블에 있는 행 클릭 시 해당 행의 항목 삭제
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(413, 260, 95, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				//밑의 마우스 리스너를 통해 선택된 행의 품목명을 product로 가져옴
				//이미 선택이 되어있는 상태이니 삭제 버튼 클릭 시 삭제하겠냐고 물어보는 창 띄움
				DeletePage delete = new DeletePage();
				delete.setVisible(true);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn = DriverManager.getConnection(
							"jdbc:mysql://222.119.100.89:3382/shopping",
							"minishop",
							"2m2w"
							);
					
					String sql = "" +
							"delete from inventory where product = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, product);
					pstmt.executeUpdate();
					product = null; // 위에 if를 추가해서 선택한 행이 있는지 확인해야함
					
					conn.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
					try {
						conn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		//어떤 행을 선택했는지 테이블에 마우스 리스너 달기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				if(rowIndex != -1) {
					//클릭된 행의 셀값 읽기
					product = (String) table.getValueAt(rowIndex, 1);
					System.out.println("선택된 행의 품목명 : " + product);
				}
			}
		});
		
		
		
		//--------------------------------------------------------------------------------
		
		//추가 버튼 클릭 시 품목 추가 창 띄움
		JButton btnNewButton_2_1 = new JButton("추가");
		btnNewButton_2_1.setBounds(304, 260, 95, 23);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				ProductAdd productAdd = new ProductAdd();
				productAdd.setVisible(true); //품목 추가 창 띄우기
			}
		});
		//--------------------------------------------------------------------------------

		
	}
	
	public String getProductName(String product) {
		
		return product;
	}

	public JComboBox comboBox() {
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedItem = (String) comboBox.getSelectedItem();
					System.out.println("선택된 카테고리: " + selectedItem);
					tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						conn = DriverManager.getConnection(
								"jdbc:mysql://222.119.100.89:3382/shopping",
								"minishop",
								"2m2w"
								);
						
						String sql = "" +
								"select * from inventory where category = ? ";
						
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, selectedItem);
						ResultSet rs = pstmt.executeQuery();
						
						while(rs.next()) {
							tableModel.addRow(new Object[] {rs.getString("category"),
								rs.getString("product"),
								rs.getInt("per_price"),
								rs.getInt("amount"),
								rs.getInt("auto_standard"),
								rs.getInt("order_amount")});
							
							System.out.println(rs.getString("category") + "\t" +
									rs.getString("product") + "\t" +
									rs.getInt("per_price") + "\t" +
									rs.getInt("amount") + "\t" +
									rs.getInt("auto_standard") + "\t" +
									rs.getInt("order_amount")
									);
						}
						
						rs.close();
						pstmt.close();
						conn.close();
						
					} catch(Exception e1) {
						e1.printStackTrace();
						try {
							conn.close();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						
					}
				}
			});
		return comboBox;
	}
	
	public void setConfirm() {
		this.confirm = true;
	}
}
