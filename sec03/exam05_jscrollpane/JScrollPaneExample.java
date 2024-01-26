package sec03.exam05_jscrollpane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneExample extends JFrame{
	private JScrollPane scrollImage;
	private JLabel lb1Image;
	
	public JScrollPaneExample() {
		this.setTitle("JScrollPaneExample");
		this.setSize(350, 230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JFrame 중앙에 JScrollPane 추가
		this.getContentPane().add(getScrollImage(), BorderLayout.CENTER);
	}
	
	//JScrollPane 생성
	private JScrollPane getScrollImage() {
		if(scrollImage == null) {
			//스크롤이 Label에 붙는다. 사진 크기가 변하면 생겼다가 사라졌다가.
			scrollImage = new JScrollPane(getLb1Image());
		}
		return scrollImage;
	}
	
	//JLabel 생성 
	public JLabel getLb1Image() {
		if(lb1Image == null) {
			lb1Image = new JLabel();
			lb1Image.setIcon(new ImageIcon(getClass().getResource("snow.jpg")));
		}
		return lb1Image;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JScrollPaneExample jFrame = new JScrollPaneExample();
				jFrame.setVisible(true);
			}
		});
	}

}
