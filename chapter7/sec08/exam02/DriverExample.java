package chapter7.sec08.exam02;

public class DriverExample {

	public static void main(String[] args) {
		
		//운전자 객체 생성
		Driver driver = new Driver();
		
		//버스 객체 생성
		Bus bus = new Bus();
		driver.drive(bus); // Bus 객체를 운전하는 드라이버
		//위 두 문장은 driver.drive(new Bus());와 동일
		
		//택시 객체 생성
		Taxi taxi = new Taxi();
		driver.drive(taxi);
		//위 두 문장은 driver.drive(new Taxi());와 동일
	}

}
