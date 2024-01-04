package chapter6.exam03.package1;

//B는 A와 같은 패키지 내에 있음
public class B {
	public void method() {
		//객체 생성
		A a = new A();
		
		a.field1 = 1; //A클래스에서 public, 모든 곳에서 접근 가능
		a.field2 = 1; //A클래스에서 default, 같은 패키지 내에서 접근 가능
		//a.field3 = 1; //A클래스에서 private, 같은 파일 내에서만 접근 가능
		
		a.method1();
		a.method2();
		//a.method3(); //private
		
		
	}
}
