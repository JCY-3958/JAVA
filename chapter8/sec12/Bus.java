package chapter8.sec12;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("레츠고");
	}
	
	public void checkFare() {
		System.out.println("잠깐");
	}
	
}
