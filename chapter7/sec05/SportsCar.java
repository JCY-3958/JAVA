package chapter7.sec05;

public class SportsCar extends Car {

	@Override
	public void speedUp() {
		speed += 10;
	}
	
	/*//부모의 stop 메서드가 final 이기 때문에 재정의 불가능
	@Override
	public void stop() {
		System.out.println("장비를 정지합니다.");
		speed = 0;
	}
	*/
}
