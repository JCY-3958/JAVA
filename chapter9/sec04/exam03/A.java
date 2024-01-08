package chapter9.sec04.exam03;

public class A {
	public void method1(int arg) { //final int arg
		int var = 1; //final int var = 1;
		
		class B {
			void method2() {
				System.out.println("avg : " + arg);
				System.out.println("var : " + var);
				
				//로컬 변수 수정 불가
				//arg = 2;
				//var = 2;
				
			}
		}
		
		B b = new B();
		b.method2();
		
		//로컬 변수 수정 불가
		//arg = 3;
		//var = 3;
	}
}
