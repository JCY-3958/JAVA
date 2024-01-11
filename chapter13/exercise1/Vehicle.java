package chapter13.exercise1;
//실습과제 11.3: Vehicle.java

//일반 차량을 모델한다

public abstract class Vehicle {
	// 차량의 모델명과 가격에 대한 객체 변수를 선언한다
	//필드를 작성
	private String model;
	protected long price; //자식에서 tax를 계산하기 위해 private -> protected로 변경

	// 차량의 모델명과 가격을 주어진 값으로 초기화하면서, 객체를 생성한다
	public Vehicle(String model, long price) {
		this.model = model;
		this.price = price;
	}

	// 차량의 모델을 반환한다
	public String getModel() {
		return model;
	}

	// 차량의 가격을 반환한다
	public long getPrice() {
		return price;
	}

	// 차량의 모델을 주어진 값으로 변경한다
	public void setModel(String model) {
		this.model = model;
	}

	// 차량의 가격을 주어진 값으로 변경한다
	public void setPrice(long price) {
		this.price = price;
	}

	// 차량의 모델명과 가격을 반환한다
	//출력이 자식에서 모델과 가격은 같으니 toString을 오버라이드 해주고 자식에서 뒤에 다른 부분만 고치면 된다.
	public String toString() {
		return "모델명: " + model + ", 가격: " + price;
	}
	
	// 차량의 세금을 계산한다
	//자식인 Car와 Truck에서 세금을 계산하니 추상 메서드로 선언만 해준다.
	public abstract double Tax();
	
	
}