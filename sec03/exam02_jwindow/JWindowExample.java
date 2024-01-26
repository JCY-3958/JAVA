package sec03.exam02_jwindow;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class JWindowExample extends JWindow{
	public JWindowExample() {
		this.setSize(600, 350);
		
		/*java.awt.GraphicsEnvironment는 그래픽 환경에 대한 정보를 가지고 있는 객체이다. 이 객체는 
		정적static 메소드인 getLocalGraphicsEnvironment()를 호출해서 얻을 수 있다. 
		GraphincsEnvironment의 getContentPoint() 메소드는 화면 중앙 지점의 X좌표와 Y좌표를 가지고 있는 Point 객체를 리턴한다.
		이렇게 얻은 화면 중앙 좌표와 윈도우 폭, 높이로 JWindow의 좌측 상단 모서리 좌표를 계산할 수 있다.
		그런 다음 JWindow의 setLocation() 메소드로 좌측 상단 모서리 좌표를 설정해주면 된다.
		 */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - this.getWidth() / 2;
		int leftTopY = centerPoint.y - this.getHeight() / 2;
		this.setLocation(leftTopX, leftTopY);
		
		/*
		JWindow에 이미지를 넣기 위해 26~27 라인에서 JLabel 컴포넌트를 활용하였다.
		JLabel은 글자 및 이미지를 포함할 수 있는 컴포넌트인데,
		setIcon() 메소드로 ImageIcon 객체를 매개값으로 주면 이미지를 나타낼 수 있다.
		ImageIcon 생성자는 이미지 파일의 URL 객체를 매개값으로 받는데,
		JWindowExample.class와 동일한 폴더에 있는 ‘game.png’ 파일에 대한
		URL 객체를 얻기 위해 다음 코드를 사용하였다
		*/
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getResource("game.png")));
		getContentPane().add(label, BorderLayout.CENTER);
		
		//마우스로 JWindow를 클릭했을 때 JWindow를 제거하기 위해 이벤트를 처리한 것이다. 
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable () {
			public void run() {
				JWindowExample jwindow = new JWindowExample();
				jwindow.setVisible(true);
				/*
				반대로 setVisible(false)을 호출하면 JWindow가 화면에서 사라지는데, 이것은 JWindow가 화
				면에서 완전히 제거되는 것이 아니라 단지 숨겨질 뿐이다.
				다시 setVisible(true)을 호출하면 언제든지 나타난다.
				만약 JWindow를 화면에서 완전히 제거하고 싶다면 dispose() 메소드를 호출하면 된다.
				*/
				
			}
		});
	}

}
