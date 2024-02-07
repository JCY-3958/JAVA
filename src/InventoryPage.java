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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InventoryPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private static java.lang.String[] columnNames = {
			"카테고리", "품목", "단위당 가격", "수량", "자동 발주 기준 수량", "기준 미달 시 발주 수량"
		};
	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	private JButton btnNewButton_2;
	private static DefaultTableModel tableModel = new DefaultTableModel(columnNames , 0);
	public String product;

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
			DBConn.DBconnection();
			
			String sql = "" +
					"select * from inventory";
			
			
			PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
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
			DBConn.conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				DBConn.conn.close();
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
					DBConn.DBconnection();;
					
					//판매 버튼을 누르면 inventory 테이블의 모든 품목의 재고가 -1 감소
					String sql1 = "" +
							"update inventory set amount = amount - 1";
					PreparedStatement pstmt1 = DBConn.conn.prepareStatement(sql1);
					pstmt1.executeUpdate();
					refreshTable(); //여기 안에서 DB 커넥션을 끊어줌
					
					DBConn.DBconnection();; //그래서 여기서 다시 연결해줘야함
					
					//DB에서 가져온 품목의 재고가 발주 기준 수량보다 작은 애들 가져옴
					String sql2 = "" +
							"select category, product, amount, per_price, order_amount " +
							"from inventory " +
							"where amount <= auto_standard";
					PreparedStatement pstmt2 = DBConn.conn.prepareStatement(sql2);
					ResultSet rs1 = pstmt2.executeQuery();
					
					//한 줄 씩 가져와서 처리
					while(rs1.next()) {
						String product = rs1.getString("product");
						System.out.println("발주 기준 수량보다 작은 애들 : " + product);
						int order_amount = rs1.getInt("order_amount");
						String category = rs1.getString("category");
						int per_price = rs1.getInt("per_price");
						
						//현재 날짜 가져오기
						long currentTime = System.currentTimeMillis();
						Date currentDate = new Date(currentTime);
						
						
						//수량 = 수량 + 발주 수량
						String sql3 = "" +
								"update inventory set amount = amount + " + order_amount +
								" where product = ?";
						PreparedStatement pstmt3 = DBConn.conn.prepareStatement(sql3);
						pstmt3.setString(1, product);
						pstmt3.executeUpdate();
						
						
						//해당 품목을 파는 거래처명 가져오기
						String sql4 = "" +
								"select company_name from company where product = ?";
						PreparedStatement pstmt4 = DBConn.conn.prepareStatement(sql4);
						System.out.println("거래처명 가져올 품목: " + product);
						pstmt4.setString(1, product);
						ResultSet rs2 = pstmt4.executeQuery();
						
						while(rs2.next()) {
							String company_name = rs2.getString("company_name");
							System.out.println("거래처명 : " + company_name);
							
							//발주 내역에 추가
							String sql5 = "" +
									"insert into order_list values(?, ?, ?, ?, ?, ?, ?)";
							PreparedStatement pstmt5 = DBConn.conn.prepareStatement(sql5);
							pstmt5.setString(1, category); // 카테고리
							pstmt5.setString(2, product); // 품목
							pstmt5.setInt(3, per_price); // 단위당 가격
							pstmt5.setInt(4, order_amount); // 발주 수량
							pstmt5.setInt(5, (order_amount * per_price)); // 총 가격(발주 수량 * 단위당 가
							pstmt5.setString(6, company_name); // 거래처명
							pstmt5.setDate(7, currentDate); // 발주 날짜(현재 날짜)
							pstmt5.executeUpdate();
							pstmt5.close();
						}
						pstmt4.close();
						pstmt3.close();
					}
					
					rs1.close();
					pstmt1.close();
					pstmt2.close();
					
					refreshTable(); //여기 안에서 DB 커넥션을 끊어줌
					DBConn.conn.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
					try {
						DBConn.conn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		//--------------------------------------------------------------------------------
		
		//테이블에 있는 행 클릭 시 해당 행의 항목 삭제 버튼
		btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(413, 260, 95, 23);
		contentPane.add(getBtnConfirm());
		
		//어떤 행을 선택했는지 테이블에 마우스 리스너 달기
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				if(rowIndex != -1) {
					//클릭된 행의 셀값 읽기
					product = (String) table.getValueAt(rowIndex, 1);
					//StateInfo info = new StateInfo();
					//info.setProduct(product);
					System.out.println("선택된 행의 품목명 : " + product);
				}
			}
		});
		
		//--------------------------------------------------------------------------------
		
		//추가 버튼 클릭 시 품목 추가 창 띄움
		
		contentPane.add(ProductAdd());
		//--------------------------------------------------------------------------------

		
	}

	//카테고리 콤보 박스 클릭 시 선택된 카테고리만 테이블에 출력
	public JComboBox comboBox() {
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selectedItem = (String) comboBox.getSelectedItem();
					System.out.println("선택된 카테고리: " + selectedItem);
					tableModel.setRowCount(0); //원래 표시되던 테이블 목록 초기화
					try {
						DBConn.DBconnection();;
						
						String sql = "" +
								"select * from inventory where category = ? ";
						
						PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
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
						DBConn.conn.close();
						
					} catch(Exception e1) {
						e1.printStackTrace();
						try {
							DBConn.conn.close();
						} catch (SQLException e2) {
							e2.printStackTrace();
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
							InventoryPage.this,
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
									"delete from inventory where product = ?";
							PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
							pstmt.setString(1, product);
							pstmt.executeUpdate();
							refreshTable();
							
							DBConn.conn.close();
							
							JOptionPane.showMessageDialog(InventoryPage.this,
									"삭제되었습니다.");
							product = null;
							
						} catch(Exception e1) {
							e1.printStackTrace();
							try {
								DBConn.conn.close();
							} catch (SQLException e2) {
								e2.printStackTrace();
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(InventoryPage.this,
							"삭제할 품목을 선택하세요.");
				}
				
			}
		});
		return btnNewButton_2;
	}
	//--------------------------------------------------------------------------------
	
	//추가 버튼 클릭 시 품목을 추가할 수 있는 Dialog 띄움
	public JButton ProductAdd() {
		JButton btnNewButton_2_1 = new JButton("추가");
		btnNewButton_2_1.setBounds(304, 260, 95, 23);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				ProductAdd productAdd = new ProductAdd(null);
				productAdd.setVisible(true);
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
	                "select * from inventory";
	        
	        PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            tableModel.addRow(new Object[]{
	                    rs.getString("category"),
	                    rs.getString("product"),
	                    rs.getInt("per_price"),
	                    rs.getInt("amount"),
	                    rs.getInt("auto_standard"),
	                    rs.getInt("order_amount")
	            });
	        }
	        
	        rs.close();
	        pstmt.close();
	        DBConn.conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
	        	DBConn.conn.close();
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	    }
	}
	//--------------------------------------------------------------------------------
	
}
