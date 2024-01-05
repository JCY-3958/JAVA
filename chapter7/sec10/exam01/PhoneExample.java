package chapter7.sec10.exam01;

public class PhoneExample {

	public static void main(String[] args) {
		//Phone 클래스가 추상 클래스이기 때문에 객체 생성 불가능
		//Phone phone = new Phone();
		
		//자식 클래스에서 객체를 생성
		SmartPhone smartphone = new SmartPhone("홍길동");
		
		smartphone.turnOn();
		smartphone.internetSearch();
		smartphone.turnOff();
		
	}

}
