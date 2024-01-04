package chapter6.exam03.package1;

public class A {
	//필드
	public int field1;	//모든 곳에서 사용 가능
	int field2;			//같은 패키지 내에서 사용 가능
	private int field3;	//같은 클래스 파일 내에서 사용 가능
	
	//생성자
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}
	
	//메서드
	public void method1() {
		
	}
	
	void method2() {
		
	}
	
	//다른 메서드에서 호출해서 사용
	private void method3() {
		
	}
}
