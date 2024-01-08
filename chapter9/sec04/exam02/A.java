package chapter9.sec04.exam02;

public class A {
	//메서드
	void useB() {
		class B { //로컬 클래스
			int field1 = 1; //인스턴스 필드
			static int field2 = 2; //정적 필드
		
			B() { //생성자
				System.out.println("B-생성자 실행");
			}
			
			void method1() { // 인스턴스 메서드
				System.out.println("B-method1 실행");
			}
			
			static void method2() { // 정적 메서드
				System.out.println("B-method2 실행");
			}
		}
		
		B b = new B(); //로컬 객체 생성
		
		System.out.println(b.field1);
		b.method1();
		
		System.out.println(B.field2);
		B.method2();
	}
}
