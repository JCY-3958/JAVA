package chapter9.sec02.exam01;

public class AExample {

	public static void main(String[] args) {
		//바깥 객체 생성
		A a = new A();
		
		A.B b = a.new B();
	}

}
