package chapter14.sec5.eaxm02;

public class JoinExample {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join(); //sumThread 종료 까지 기다림
		} catch(InterruptedException e) {}
		
		System.out.println("1~00합 : "+sumThread.getSum());
	}
}
