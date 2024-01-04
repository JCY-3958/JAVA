package chapter6.sec07;

public class CarExample {

	public static void main(String[] args) {
		
		//기본 생성자를 통해서 인스턴스화가 가능
		Car myCar1 = new Car();
		
		//Car 클래스 내에 매개변수 3개를 이용하는 생성자가 없으면 오류
		Car myCar2 = new Car("그랜저", "검정", "250");
		
		System.out.println("company : " + myCar2.company);
		
		Car myCar3 = new Car("자가용");
		System.out.println("myCar3.company : " + myCar3.company);
		
		Car myCar4 = new Car("자가용", "빨강");
		System.out.println("myCar4.company : " + myCar4.company);
		System.out.println("myCar4.color : " + myCar4.color);
		
		Car myCar5 = new Car("자가용", "빨강", 250);
		System.out.println("myCar5.model : " + myCar5.model);
		System.out.println("myCar5.color : " + myCar5.color);
		System.out.println("myCar5.maxspeed : " + myCar5.maxspeed);
	}

}
