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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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

	/**
	 * Create the frame.
	 */
	public CompanyAdd(JFrame parent) {
		super(parent, "거래처 추가", true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 윈도우 x를 눌러도 그 창만 꺼지게
		setBounds(100, 100, 560, 330);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("거래처 추가");
		lblNewLabel.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel.setBackground(UIManager.getColor("Button.light")); // 배경 color
		lblNewLabel.setBorder(new LineBorder(Color.WHITE, 3));
		lblNewLabel.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		lblNewLabel.setBounds(33, 19, 125, 38);
		contentPane.add(lblNewLabel);

		// 카테고리
		JLabel lblNewLabel_1 = new JLabel("거래처명");
		lblNewLabel_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(42, 91, 52, 15);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(106, 88, 138, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		// --------------------------------------------------------

		// 품목
		JLabel lblNewLabel_2 = new JLabel("품목");
		lblNewLabel_2.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel_2.setBounds(33, 144, 61, 15);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(106, 141, 138, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		// --------------------------------------------------------

		// 수량
		JLabel lblNewLabel_3 = new JLabel("은행");
		lblNewLabel_3.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel_3.setBounds(33, 209, 61, 15);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 206, 138, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		// --------------------------------------------------------

		// 단위당 가격
		JLabel lblNewLabel_4 = new JLabel("계좌");
		lblNewLabel_4.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel_4.setBounds(290, 91, 46, 15);
		contentPane.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(348, 88, 138, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// --------------------------------------------------------

		// 자동 발주 기준 수량
		JLabel lblNewLabel_5 = new JLabel("이메일");
		lblNewLabel_5.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		lblNewLabel_5.setBounds(295, 140, 41, 22);
		contentPane.add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(348, 141, 138, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		// --------------------------------------------------------

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

		// 확인 버튼 클릭 시 textfield에 입력한 내용을 DB에 추가
		JButton btnNewButton_1 = new JButton("확인");
		btnNewButton_1.setBounds(305, 246, 95, 23);
		btnNewButton_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton_1.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_1.setBackground(Color.GRAY); // 배경 color
		btnNewButton_1.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 모든 필드에 값이 있어야함
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0
						&& textField_2.getText().length() > 0 && textField_3.getText().length() > 0
						&& textField_4.getText().length() > 0) {
					company_name = textField.getText();
					product = textField_1.getText();
					bank = textField_2.getText();
					account = textField_3.getText();
					email = textField_4.getText();
					try {
						DBConn.DBconnection();

						String sql1 = "" + "select product from inventory where product = ?";
						PreparedStatement pstmt = DBConn.conn.prepareStatement(sql1);
						pstmt.setString(1, product);
						ResultSet rs = pstmt.executeQuery();
						
						if (rs.next()) {
							String sql2 = "" + "insert into company (company_name, product, bank, account, email) "
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

				} else {
					JOptionPane.showMessageDialog(CompanyAdd.this, "항목이 비어있습니다.");
				}
			}
		});
	}
}