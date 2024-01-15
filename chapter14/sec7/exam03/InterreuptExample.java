package chapter14.sec7.exam03;

public class InterreuptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		thread.interrupt(); //인터럽트 메서드 호출
	}

}
