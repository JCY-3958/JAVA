package chapter7.sec03.exam02;

public class SmartPhone extends Phone {
	public SmartPhone(String model, String color) {
		super(model, color); // 생략 불가능
		System.out.println("SmartPhone(String model, String color) 생성자 실행");
	}

}
