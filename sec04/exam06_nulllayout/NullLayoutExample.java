package sec04.exam06_nulllayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NullLayoutExample extends JFrame{
	private JButton btnOk;
	
	public NullLayoutExample() {
		this.setTitle("NullLayoutExample");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//NullLayout 설정과 버튼 추가
		this.getContentPane().setLayout(null);
		this.getContentPane().add(getBtnOk());
	}
	
	public JButton getBtnOk() {
		if(btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("확인");
			//버튼 위치
			btnOk.setBounds(100, 50, 70, 60);
		}
		return btnOk;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				NullLayoutExample jFrame  = new NullLayoutExample();
				jFrame.setVisible(true);
			}
		});
	}

}
