package chapter13.exercise1;
// 실습과제 11.3: Car.java

// 승용차를 모델한다

public class Car extends Vehicle {

	// 승용차의 배기량에 대한 객체 변수를 선언한다
	private int begi;

	// 승용차의 모델명, 가격과 배기량을 주어진 값으로 초기화하면서 객체를 생성한다
	// Car 생성자를 만든다. 모델명과 가격이 필요한데 Vehicle에 있어 상속을 받고
	// super로 부모의 모델명과 가격을 가져온다.
	public Car(String model, long price, int begi) {
		super(model, price);
		this.begi = begi;
	}

	// 승용차의 배기량을 반환한다
	public int getBegi() {
		return begi;
	}

	// 승용차의 배기량을 주어진 값으로 변경한다
	public void setBegi(int begi) {
		this.begi = begi;
	}

	// 승용차의 세금을 계산한다
	//부모에서 만든 추상 메서드 tax를 자식에서 구현해야한다.
	@Override
	public double Tax() {
		double tax = 0;
		if(begi >= 3000) {
			tax = price * 0.05;
		} else if(begi >= 1500) {
			tax = price * 0.03;
		}else {
			tax = price * 0.01;
		}
		return tax;
	}
	
	// 승용차의 모델명, 가격과 배기량을 반환한다
	//부모의 toString을 super로 받고 나머지 뒤는 자식에 맞게 작성해주는 것
	public String toString() {
		return super.toString() + ", 배기량 : " + begi + "\n";
	}
}
