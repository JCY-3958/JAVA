package chapter7.sec08.exam01;

public class Car {
	//Tire 객체를 가진 tire 필드 생성
	public Tire tire;
	
	public void run() { // Car가 움직이면
		tire.roll(); // tire가 roll하여 굴러 가도록
	}
}
