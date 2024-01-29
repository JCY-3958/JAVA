package sec07.exam02_jtextfield_jpasswordfield;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //인터페이스로 모든 것 다 구현해야함
import java.awt.event.KeyAdapter; // 상속으로 쓸것만 구현
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextFieldJPasswordFieldExample extends JFrame{
	private JTextField txtId;
	private JPasswordField txtPassword;
	
	public String checkId = "winter";
	public String checkPw = "12345";
	public boolean check = false;
	
	public JTextFieldJPasswordFieldExample() {
		this.setTitle("JTextField & JPasswordField");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 2));
		this.getContentPane().add(new JLabel("아이디", JLabel.CENTER));
		this.getContentPane().add(getTxtId());
		this.getContentPane().add(new JLabel("패스워드", JLabel.CENTER));
		this.getContentPane().add(getTxtPassword());
		this.setSize(400, 200);
	}
	
	//JTextField 생성
	public JTextField getTxtId() {
		if(txtId == null) {
			txtId = new JTextField();
			txtId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = txtId.getText();
					if(id.equals(checkId)) {
						JOptionPane.showMessageDialog(
								JTextFieldJPasswordFieldExample.this, "아이디 일치");
						check = true;
					} else {
						JOptionPane.showMessageDialog(
								JTextFieldJPasswordFieldExample.this, "아이디 불일치");
					}
				}
			});
		}
		return txtId;
	}
	
	//JPasswordField 생성
	public JPasswordField getTxtPassword() {
		if(txtPassword == null) {
			txtPassword = new JPasswordField();
			txtPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = new String(txtPassword.getPassword());
					if(password.equals(checkPw) && check) {
						JOptionPane.showMessageDialog(
								JTextFieldJPasswordFieldExample.this, "아이디와 패스워드 일치");
						JOptionPane.showMessageDialog(
								JTextFieldJPasswordFieldExample.this, "환영합니다.");
					} else {
						JOptionPane.showMessageDialog(
								JTextFieldJPasswordFieldExample.this, "아이디 혹은 패스워드 불일치");
					}
				}
			});
		}
		return txtPassword;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTextFieldJPasswordFieldExample jFrame = new
						JTextFieldJPasswordFieldExample();
				jFrame.setVisible(true);
			}
		});
	}

}
