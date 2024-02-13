package miniproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ResetPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String password;

	/**
	 * Create the frame.
	 */
	public ResetPassword() {
		setBackground(UIManager.getColor("Button.light"));
		//창이 열리면 DB에서 비밀번호 가져옴
		try {
			DBConn.DBconnection();
			
			String sql = "" +
					"select * from user";
			
			PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("userinfo");
			} else {
				System.out.println("테이블에 사용자가 없습니다.");
				JOptionPane.showMessageDialog(ResetPassword.this,
						"테이블에 사용자가 없습니다.");
			}
			
			DBConn.conn.close();
			rs.close();
			pstmt.close();
			
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
		//---------------------------------------------------
		
		//기본 창 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 윈도우 x를 눌러도 그 창만 꺼지게
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("비밀번호 재설정");
		lblNewLabel.setForeground(new Color(34, 34, 34));
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 18));
		lblNewLabel.setBackground(new Color(200, 166, 200)); //  배경
		lblNewLabel.setBounds(144, 20, 152, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호는 10자 이내입니다.");
		lblNewLabel_2.setForeground(new Color(34, 34, 34));
		lblNewLabel_2.setBounds(32, 214, 205, 15);
		lblNewLabel_2.setFont(new Font("HY중고딕", Font.BOLD, 14));
		lblNewLabel_2.setBackground(new Color(200, 166, 200)); //  배경
		contentPane.add(lblNewLabel_2);
		//---------------------------------------------------
		
		//현재 비밀번호-----------------------------------------
		JLabel lblNewLabel_1 = new JLabel("현재 비밀번호");
		lblNewLabel_1.setForeground(new Color(34, 34, 34));
		lblNewLabel_1.setBounds(22, 83, 92, 28);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(200, 166, 200)); //  배경
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 79, 285, 38);
		contentPane.add(passwordField);
		//---------------------------------------------------
		
		//새 비밀번호-----------------------------------------
		JLabel lblNewLabel_1_1 = new JLabel("새 비밀번호");
		lblNewLabel_1_1.setForeground(new Color(34, 34, 34));
		lblNewLabel_1_1.setBounds(22, 131, 92, 28);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(200, 166, 200)); //  배경
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(126, 127, 285, 38);
		contentPane.add(passwordField_1);
		//---------------------------------------------------
		
		//비밀번호 입력 후 확인 버튼---------------------------------
		//정상 작동 시 DB에 비밀번호 변경
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(password.equals(new String(passwordField.getPassword()))) { //DB에 있는 비밀번호(password)와 현재 비밀번호 입력이 같은지
					if(new String(passwordField_1.getPassword()).length() > 0) { //새 비밀번호를 입력했는지
						//현재 비밀번호 일치 + 새 비빌번호 올바르게 입력 시 DB에 비밀번호 변경
						if(!(password.equals(new String(passwordField_1.getPassword())))) { //현재 비밀번호와 새 비밀번호가 같지 않을 때 
							try {
								DBConn.DBconnection();
								
								String sql = "" +
										"update user set userinfo=? ";
								
								PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
								pstmt.setString(1, new String(passwordField_1.getPassword()));
								pstmt.executeUpdate();
								
								DBConn.conn.close();
								pstmt.close();
								
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
							
							//비밀번호 수정 성공
							JOptionPane.showMessageDialog(ResetPassword.this,
									"비밀번호 변경 성공");
							dispose();
						} else {
							JOptionPane.showMessageDialog(ResetPassword.this,
									"현재 비밀번호와 새 비밀번호가 같습니다.");
						}
						
					} else {
						JOptionPane.showMessageDialog(ResetPassword.this,
								"새 비밀번호를 입력하세요.");
					}
				} else {
					JOptionPane.showMessageDialog(ResetPassword.this,
							"현재 비밀번호가 일치하지 않습니다.");
				}
			}
		});
		btnNewButton.setBounds(249, 202, 77, 38);
		btnNewButton.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton.setBackground(Color.GRAY); // 배경 color
		btnNewButton.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		contentPane.add(btnNewButton);
		//---------------------------------------------------

		//비밀번호 변경 취소---------------------------------------
		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(349, 202, 75, 38);
		btnNewButton_1.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton_1.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_1.setBackground(Color.GRAY); // 배경 color
		btnNewButton_1.setForeground(new Color(34, 34, 34)); // 글자색 흰색
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//---------------------------------------------------

		//현재 비밀번호 입력 최대 10자리 입력 가능하게 제한
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) { //keyPrassed는 consume 함수 안먹음, 이유는 모름
				passwordField = (JPasswordField) e.getSource();//이벤트 발생
				int textLeng = passwordField.getPassword().length;
				if(textLeng > 9) {
					e.consume(); //이벤트 소멸 메서드
				}
			}
		});
		//---------------------------------------------------
		
		//새 비밀번호 입력 최대 10자리 입력 가능하게 제한
		passwordField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) { //keyPrassed는 consume 함수 안먹음, 이유는 모름
				passwordField_1 = (JPasswordField) e.getSource();//이벤트 발생
				int textLeng = passwordField_1.getPassword().length;
				if(textLeng > 9) {
					e.consume(); //이벤트 소멸 메서드
				}
			}
		});
		//---------------------------------------------------
		
		
	}
}
