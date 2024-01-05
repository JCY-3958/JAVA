package chapter7.sec02;

public class Phone {
	//필드
	public String model;
	public String color;
	
	//메서드
	public void bell() {
		System.out.println("따르릉");
	}
	
	public void sendVoice(String message) {
		System.out.println("누고 : " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("난데 : " + message);
	}
	
	public void hangUp() {
		System.out.println("뚜뚜뚜");
	}
}
