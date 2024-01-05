package chapter7.sec05;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	
	public final void stop() { //자식 클래스에서 재정의 불가
		System.out.println("장비를 정지합니다.");
		speed = 0;
	}
}
