package chapter9.sec05.exam01;

public class A {
	//A의 인스턴스 필드와 메서드
	int field1;
	void method1() {}
	
	//A의 정적 필드와 메서드
	static int field2;
	static void method2() {}
	
	//인스턴스 멤버 클래스
	class B {
		void method() {
			//A의 인스턴스 필드와 메서드 사용
			field1 = 10;
			method1();
			
			//A의 정적 필드와 메서드 사용
			field2 = 10;
			method2();
		}
	}
	
	//정적 멤버 클래스
	static class C {
		void method() {
			//A의 인스턴스 필드와 메서드 사용 불가
			//field1 = 10;
			//method1();
			
			//A의 정적 필드와 메서드 사용
			field2 = 10;
			method2();
		}
	}
}
