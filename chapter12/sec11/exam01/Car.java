package chapter12.sec11.exam01;

public class Car {
	public static void main(String[] args) {
		
		//방법 1
		Class clazz = Car.class;
		
		//방법 2
		//Class clazz = Class.forName("chapter12.sec11.exam01.Car");
		
		//방법 3
		//Car car = new Car();
		//Class clazz = car.getClass();
		
		System.out.println("패키지 : " + clazz.getPackageName());
		System.out.println("클래스 간단 이름 : " + clazz.getSimpleName());
		System.out.println("클래스 전체 이름 : " + clazz.getName());
		
	}
	
}
