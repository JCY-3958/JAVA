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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

//Dialog로 만들면 재고관리 창 제어 불가 가능하게 만들 수 있음
public class ProductAdd extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String category, product;
	private int amount, per_price, auto_standard, order_amount;

	/**
	 * Create the frame.
	 */
	public ProductAdd(JFrame parent) {
		super(parent, "품목 추가", true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 윈도우 x를 눌러도 그 창만 꺼지게
		setBounds(100, 100, 560, 330);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("품목 추가");
		lblNewLabel.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel.setBackground(UIManager.getColor("Button.light")); // 배경 color
		lblNewLabel.setBorder(new LineBorder(Color.WHITE, 3));
		lblNewLabel.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		lblNewLabel.setBounds(33, 19, 116, 38);
		contentPane.add(lblNewLabel);
		
		//카테고리
		JLabel lblNewLabel_1 = new JLabel("카테고리");
		lblNewLabel_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(33, 81, 61, 15);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(106, 78, 138, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//--------------------------------------------------------
		
		//품목
		JLabel lblNewLabel_2 = new JLabel("품목");
		lblNewLabel_2.setBounds(33, 122, 61, 15);
		lblNewLabel_2.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 119, 138, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//--------------------------------------------------------

		//수량
		JLabel lblNewLabel_3 = new JLabel("수량");
		lblNewLabel_3.setBounds(37, 168, 61, 15);
		lblNewLabel_3.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 165, 138, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//--------------------------------------------------------

		//단위당 가격
		JLabel lblNewLabel_4 = new JLabel("단위당 가격");
		lblNewLabel_4.setBounds(14, 215, 80, 15);
		lblNewLabel_4.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 212, 138, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		//--------------------------------------------------------

		//자동 발주 기준 수량
		JLabel lblNewLabel_5 = new JLabel("자동발주 \r\n기준수량");
		lblNewLabel_5.setBounds(256, 70, 109, 36);
		lblNewLabel_5.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(377, 78, 138, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		//--------------------------------------------------------

		//발주 수량
		JLabel lblNewLabel_6 = new JLabel("발주 수량");
		lblNewLabel_6.setBounds(256, 122, 109, 15);
		lblNewLabel_6.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(377, 119, 138, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		//--------------------------------------------------------

		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(412, 246, 95, 23);
		btnNewButton.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton.setBackground(Color.GRAY); // 배경 color
		btnNewButton.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//확인 버튼 클릭 시 textfield에 입력한 내용을 DB에 추가
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setBounds(305, 246, 95, 23);
		btnNewButton_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton_1.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_1.setBackground(Color.GRAY); // 배경 color
		btnNewButton_1.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result1, result2, result3, result4;
				boolean dupl_check = true;
				//모든 필드에 값이 있어야함
				if(textField.getText().length() > 0 && textField_1.getText().length() > 0 &&
						textField_2.getText().length() > 0 && textField_3.getText().length() > 0 &&
						textField_4.getText().length() > 0 && textField_5.getText().length() > 0) {
					
					//수량과 가격에 숫자 입력했는지
					String check = "^[0-9]*$";
					result1 = Pattern.matches(check, textField_2.getText());
					result2 = Pattern.matches(check, textField_3.getText());
					result3 = Pattern.matches(check, textField_4.getText());
					result4 = Pattern.matches(check, textField_5.getText());
					if(result1 && result2 && result3 && result4) {
						category = textField.getText();
						product = textField_1.getText();
						amount = Integer.parseInt(textField_2.getText());
						per_price = Integer.parseInt(textField_3.getText());
						auto_standard = Integer.parseInt(textField_4.getText());
						order_amount = Integer.parseInt(textField_5.getText());
						
						//수량과 가격에는 음수가 들어갈 수 없음
						if(amount < 0 || per_price < 0 || auto_standard < 0 || order_amount < 0) {
							JOptionPane.showMessageDialog(ProductAdd.this,
									"수량과 가격에는 음수가 들어갈 수 없습니다.");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
						} else {
							try {
								DBConn.DBconnection();
								
								String sql1 = "" +
										"select product from inventory";
								PreparedStatement pstmt = DBConn.conn.prepareStatement(sql1);
								ResultSet rs = pstmt.executeQuery();
								
								//입력한 품목과 DB에 있는 품목 목록중에 같은 것이 있는지 검사
								while(rs.next()) {
									String dbProduct = rs.getString("product");
									if(product.equals(dbProduct)) {
										dupl_check = false;
										JOptionPane.showMessageDialog(ProductAdd.this,
												"품목은 중복될 수 없습니다.");
									}
								}
								
								//품목이 중복이 안될 때 DB에 추가
								if(dupl_check) {
									String sql2 = "" +
											"insert into inventory (category, product, per_price, amount, auto_standard, order_amount) " +
											"values(?, ?, ?, ?, ?, ?) ";
									
									PreparedStatement pstmt2 = DBConn.conn.prepareStatement(sql2);
									pstmt2.setString(1, category);
									pstmt2.setString(2, product);
									pstmt2.setInt(3, per_price);
									pstmt2.setInt(4, amount);
									pstmt2.setInt(5, auto_standard);
									pstmt2.setInt(6, order_amount);
									pstmt2.executeUpdate();
									JOptionPane.showMessageDialog(ProductAdd.this,
											"품목이 추가되었습니다.");	
									
									//품목이 추가되면 재고화면의 table을 업데이트 해야함
									InventoryPage inven = new InventoryPage();
									inven.refreshTable();
									dispose();
								}
								
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
					} else {
						JOptionPane.showMessageDialog(ProductAdd.this,
								"수량과 가격에 문자를 입력할 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(ProductAdd.this,
							"항목이 비어있습니다.");
				}
			}
		});
	}
}
