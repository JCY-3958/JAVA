package sec06.exam03_jradiobutton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JRadioButtonExample extends JFrame{
	private JPanel radioPanel;
	private JRadioButton rbBird;
	private JRadioButton rbCat;
	private JLabel lblPicture;
	private JRadioButton rbSnow;
	private JRadioButton rbGame;
	
	public JRadioButtonExample() {
		setTitle("JRadioButtomExample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getRadioPanel(), BorderLayout.SOUTH);
		this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
		pack();
	}
	
	//JRadioButton이 배치된 JPanel 생성
	public JPanel getRadioPanel() {
		if(radioPanel == null) {
			radioPanel = new JPanel();
			radioPanel.setLayout(new FlowLayout());
			radioPanel.add(getRbBird());
			radioPanel.add(getRbCat());
			radioPanel.add(getRbSnowman());
			radioPanel.add(getRbGame());
			
			//배타적 선택을 위해 ButtonGroup에 두 개의 JRadioButton 추가
			ButtonGroup group = new ButtonGroup();
			group.add(getRbBird());
			group.add(getRbCat());
			group.add(getRbSnowman());
			group.add(getRbGame());
		}
		return radioPanel;
	}
	
	//JRadioButton 생성
	public JRadioButton getRbBird() {
		if(rbBird == null) {
			rbBird = new JRadioButton();
			rbBird.setText("Bird");
			//rbBird.setSelected(true); //기본으로 선택되도록 설정
			rbBird.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
					JOptionPane.showMessageDialog(JRadioButtonExample.this, "끼룩끼룩");
					System.out.println("끼룩끼룩");
				}
			});
			
		}
		return rbBird;
	}
	
	//JRadioButton 생성
	public JRadioButton getRbCat() {
		if(rbCat == null) {
			rbCat = new JRadioButton();
			rbCat.setText("Cat");
			rbCat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("Cat.gif")));
					JOptionPane.showMessageDialog(JRadioButtonExample.this, "애옹");
					System.out.println("애옹");
				}
			});
			
		}
		return rbCat;
	}
	
	public JRadioButton getRbGame() {
		if(rbGame == null) {
			rbGame = new JRadioButton();
			rbGame.setText("Game");
			rbGame.setSelected(true);
			rbGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("game.png")));
					JOptionPane.showMessageDialog(JRadioButtonExample.this, "너 재능없어 접어");
					System.out.println("outstanding");
				}
			});
		}
		return rbGame;
	}
	
	public JRadioButton getRbSnowman() {
		if(rbSnow == null) {
			rbSnow = new JRadioButton();
			rbSnow.setText("snowman");
			rbSnow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
					JOptionPane.showMessageDialog(JRadioButtonExample.this, "추웡");
					System.out.println("추웡");
				}
			});
		}
		return rbSnow;
	}
	
	//이미지를 보여줄 JLabel 생성
	public JLabel getLblPicture() {
		if(lblPicture == null) {
			lblPicture = new JLabel();
			lblPicture.setIcon(new ImageIcon(getClass().getResource("game.png")));
		}
		return lblPicture;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JRadioButtonExample jFrame = new JRadioButtonExample();
				jFrame.setVisible(true);
			}
		});
	}

}
