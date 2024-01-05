package chapter7.sec04;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		//부모 객체 생성해서 areaCircle 실행  3.14159 * r * r
		Calculator cal = new Calculator();
		System.out.println("원 면적 : " + cal.areaCircle(r));
		System.out.println();
		
		//자식 객체 생성해서 areaCircle 실행  Math.PI * r * r
		Computer com = new Computer();
		System.out.println("원 면적 : " + com.areaCircle(r));
	}

}
