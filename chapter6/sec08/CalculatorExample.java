package chapter6.sec08;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator area = new Calculator();
		
		double result1 = area.areaRectangle(10);
		
		double result2 = area.aeraRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result1);
		System.out.println("직사각형의 넓이 : " + result2);
	}

}
