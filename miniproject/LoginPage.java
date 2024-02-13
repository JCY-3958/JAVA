package miniproject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LoginPage extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	//프로그램 시작 부분
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
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
	}
	
	public LoginPage() {
		//기본 구조, 제목 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 윈도우 x를 눌러도 그 창만 꺼지게
		setBounds(100, 100, 560, 330);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(12, 10, 522, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("자동 발주 프로그램");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("HY중고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(163, 21, 194, 55);
		lblNewLabel.setBorder(new LineBorder(Color.WHITE, 3)); 

		panel.add(lblNewLabel);
		//------------------------------------------
		
		//비밀번호 입력 필드-----------------------------------
		JLabel lblNewLabel_1 = new JLabel("비밀번호 입력");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("HY중고딕", Font.BOLD, 17));
		lblNewLabel_1.setBounds(40, 116, 139, 35);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 117, 308, 35);
		panel.add(passwordField);
		//------------------------------------------
	
		//패스워드 최대 10자리 입력 가능하게 제한
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				passwordField = (JPasswordField) e.getSource();//이벤트 발생
				int textLeng = passwordField.getPassword().length;
				if(textLeng > 9) {
					e.consume(); //이벤트 소멸 메서드
				}
			}
		});
		//---------------------------------------------------
		
		JButton btnNewButton = new JButton("비밀번호 재설정");
		btnNewButton.setFont(new Font("HY중고딕", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetPassword resetpassword = new ResetPassword();
				resetpassword.setVisible(true);
			}
		});
		btnNewButton.setBounds(40, 210, 139, 35);
		btnNewButton.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton.setForeground(new Color(0, 102, 204));
		btnNewButton.setBackground(Color.GRAY); // 코랄색 배경
		btnNewButton.setForeground(Color.WHITE); // 글자색 흰색
        btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		//로그인 버튼-------------------------------------------
		JButton btnNewButton_1 = new JButton("로그인");
		 btnNewButton_1.setForeground(Color.WHITE);
	        btnNewButton_1.setBackground(Color.GRAY);
	        btnNewButton_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
	        btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(293, 210, 95, 35);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//버튼 클릭 시 입력한 비밀번호와 DB에 있는 비빌번호가 일치하는지 확인
				String inputPassword = new String(passwordField.getPassword());
				try {
					DBConn.DBconnection();
					
					String sql = "" +
							"select * from user";
					
					PreparedStatement pstmt = DBConn.conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						String dbPassword = rs.getString("userinfo");
					
						if(inputPassword.equals(dbPassword)) {
							System.out.println("-----로그인 성공-----");
							//메인화면 띄우기
							MainPage mainPage = new MainPage();
							mainPage.setVisible(true);
							setVisible(false);
							dispose();
							DBConn.conn.close();
						} else {
							System.out.println("-----로그인 실패-----");
							JOptionPane.showMessageDialog(LoginPage.this,
									"비밀번호가 일치하지 않습니다..");
							passwordField.setText("");
						}
					} else {
						System.out.println("테이블에 사용자가 없습니다.");
						JOptionPane.showMessageDialog(LoginPage.this,
								"테이블에 사용자가 없습니다.");
					}
					
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
				
			}
		});
		//------------------------------------------
		
		//프로그램 종료---------------------------------
		JButton btnNewButton_2 = new JButton("종료");
		btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.setBackground(Color.GRAY);
        btnNewButton_2.setFont(new Font("HY중고딕", Font.BOLD, 14));
        btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(404, 210, 95, 35);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//------------------------------------------
	}
}