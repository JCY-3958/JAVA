package sec01.exam02_swing;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame{
	public App() {
		setTitle("Swing App");
		setSize(600, 400);
		getContentPane().add(new JButton("마 뜨급나"), BorderLayout.CENTER);
		getContentPane().add(new JButton("함 사울래"), BorderLayout.WEST);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		App app = new App();
		app.setVisible(true);
	}

}
