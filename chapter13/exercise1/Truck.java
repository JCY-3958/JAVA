package chapter13.exercise1;
// 실습과제 11.3: Truck.java

// 트럭를 모델한다

public class Truck extends Vehicle {
	// 트럭의 적재 중량에 대한 객체 변수를 선언한다
	private double weight;

	// 트럭의 모델명, 가격과 적재 중량을 주어진 값으로 초기화하면서 객체를 생성한다
	public Truck(String model, long price, double weight) {
		super(model, price);
		this.weight = weight;
	}

	// 트럭의 적재 중량을 반환한다
	public double getWeight() {
		return weight;
	}

	// 트럭의 적재 중량을 주어진 값으로 변경한다
	public void setWeight(int weight) {
		this.weight = weight;
	}

	// 트럭의 세금을 계산한다
	// 부모에서 만든 추상 메서드 tax를 자식에서 구현해야한다.
	@Override
	public double Tax() {
		double tax = 0;
		if (weight >= 10000) {
			tax = price * 0.04;
		} else if (weight >= 5000) {
			tax = price * 0.02;
		} else {
			tax = price * 0.01;
		}
		return tax;
	}

	// 트럭의 모델명, 가격과 적재 중량을 반환한다
	//부모의 toString을 super로 받고 나머지 뒤는 자식에 맞게 작성해주는 것
	public String toString() {
		return super.toString() + ", 적재 중량 : " + weight + "\n";
	}

}
