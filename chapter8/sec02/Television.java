package chapter8.sec02;

public class Television implements RemoteControl{
	
	@Override //RemoteControl의 추상메서드 turnOn 구체적으로 구현
	public void turnOn() {
		System.out.println("아빠 안 잔다.");
	}
}
