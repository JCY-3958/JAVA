package chapter7.sec08.exam02;

public class Driver {
	//차량을 운전하는데 누가? 드라이버가
	//생성자의 매개변수에 객체(Vehicle)를 넣어준다. Vehicle에는 run이 있다.
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
