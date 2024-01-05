package chapter7.sec10.exam01;

public abstract class Phone {
	//필드
	String owner;
	
	//생성자
	Phone(String owner) {
		this.owner = owner;
	}
	
	//메서드
	void turnOn() {
		System.out.println("폰 전원 켜짐");
	}
	
	void turnOff() {
		System.out.println("폰 전원 꺼짐");
	}
	
}
