import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

//Dialog로 만들면 재고관리 창 제어 불가 가능하게 만들 수 있음
public class CompanyAdd extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String company_name, product, bank, account, email;
	private int amount, per_price, auto_standard, order_amount;

	/**
	 * Create the frame.
	 */
	public CompanyAdd(JFrame parent) {
		super(parent, "품목 추가", true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 윈도우 x를 눌러도 그 창만 꺼지게
		setBounds(100, 100, 560, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("거래처 추가");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 10, 100, 31);
		contentPane.add(lblNewLabel);

		// 카테고리
		JLabel lblNewLabel_1 = new JLabel("거래처명");
		lblNewLabel_1.setBounds(37, 71, 52, 15);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(106, 68, 106, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		// --------------------------------------------------------

		// 품목
		JLabel lblNewLabel_2 = new JLabel("품목");
		lblNewLabel_2.setBounds(37, 108, 52, 15);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(106, 105, 106, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// --------------------------------------------------------

		// 수량
		JLabel lblNewLabel_3 = new JLabel("은행");
		lblNewLabel_3.setBounds(37, 147, 52, 15);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 144, 106, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// --------------------------------------------------------

		// 단위당 가격
		JLabel lblNewLabel_4 = new JLabel("계좌");
		lblNewLabel_4.setBounds(37, 188, 57, 15);
		contentPane.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(106, 185, 106, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// --------------------------------------------------------

		// 자동 발주 기준 수량
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setBounds(287, 60, 109, 36);
		contentPane.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(408, 68, 106, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		// --------------------------------------------------------

		JButton btnNewButton = new JButton("취소");
		btnNewButton.setBounds(439, 260, 95, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 확인 버튼 클릭 시 textfield에 입력한 내용을 DB에 추가
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setBounds(320, 260, 95, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result1, result2, result3; // result4;
				boolean dupl_check = true;
				// 모든 필드에 값이 있어야함
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0
						&& textField_2.getText().length() > 0 && textField_3.getText().length() > 0
						&& textField_4.getText().length() > 0) {

					// 수량과 가격에 숫자 입력했는지
					String check = "^[0-9]*$";
					result1 = Pattern.matches(check, textField_2.getText());
					result2 = Pattern.matches(check, textField_3.getText());
					result3 = Pattern.matches(check, textField_4.getText());
					// result4 = Pattern.matches(check, textField_5.getText());
					if (result1 && result2 && result3) {
						System.out.println("숫자만 입력되었습니다.");
						company_name = textField.getText();
						product = textField_1.getText();
						System.out.println("이거 왜 안나옴 : " + textField_2.getText());
						bank = textField_2.getText();
						account = textField_3.getText();
						email = textField_4.getText();

						// 수량과 가격에는 음수가 들어갈 수 없음
						if (amount < 0 || per_price < 0 || auto_standard < 0 || order_amount < 0) {
							JOptionPane.showMessageDialog(CompanyAdd.this, "수량과 가격에는 음수가 들어갈 수 없습니다.");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
						} else {
							try {
								DBConn.DBconnection();

								String sql1 = "" + "select product from inventory where product = ?";
								PreparedStatement pstmt = DBConn.conn.prepareStatement(sql1);
								pstmt.setString(1, product);
								ResultSet rs = pstmt.executeQuery();

								if (rs.next()) {
									String sql2 = ""
											+ "insert into company (company_name, product, bank, account, email) "
											+ "values(?, ?, ?, ?, ?) ";

									PreparedStatement pstmt2 = DBConn.conn.prepareStatement(sql2);
									pstmt2.setString(1, company_name);
									pstmt2.setString(2, product);
									pstmt2.setString(3, bank);
									pstmt2.setString(4, account);
									pstmt2.setString(5, email);
									pstmt2.executeUpdate();
									JOptionPane.showMessageDialog(CompanyAdd.this, "거래처가 추가되었습니다.");

									// 품목이 추가되면 재고화면의 table을 업데이트 해야함
									CompanyPage inven = new CompanyPage();
									inven.refreshTable();
									dispose();
								}

								pstmt.close();
								DBConn.conn.close();

							} catch (Exception e1) {
								e1.printStackTrace();
								try {
									DBConn.conn.close();
								} catch (SQLException e2) {
									e2.printStackTrace();
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(CompanyAdd.this, "수량과 가격에 문자를 입력할 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(CompanyAdd.this, "항목이 비어있습니다.");
				}
			}
		});
	}
}