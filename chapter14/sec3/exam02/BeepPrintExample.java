package chapter14.sec3.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					System.out.println("차");
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		});

		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("영");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

}
