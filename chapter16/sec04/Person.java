package chapter16.sec04;

public class Person {	
	public void action(Calcuable calcuable) {
		double result = calcuable.calc(10, 4); //리턴값이 있는 경우 담을 그릇이 필요
		System.out.println("result : " + result);
	}
}
