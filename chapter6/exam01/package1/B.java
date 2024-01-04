package chapter6.exam01.package1;

public class B {
	A a; // A클래스에 접근하여 a 객체 선언, 에러가 없으니 A클래스에 접근이 가능함
	
	//A클래스에서 boolean 타입은 public 이라서 접근 가능
	A a1 = new A(true);
	
	//A클래스에서 int 타입은 default 라서 접근 가능
	A a2 = new A(1);
	
	//A클래스에서 String 타입은 private 라서 접근 불가능 
	//A a3 = new A("문자열");

}
