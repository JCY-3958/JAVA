package chapter7.sec07.exam01;

class A {}
	
class B extends A {}
	
class C extends A {}

class D extends B {}

class E extends C {}
	/* 		A
	 * 	  /   \
	 *   B     C
	 *   |	   |
	 *   D     E  */
	//자식에서 부모 쪽으로 타입 변환 가능(자동 타입 변환)
public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b; //자식에서 부모로 변환 가능
		A a2 = c;
		A a3 = d; //손자에서 조부모 변환 가능
		A a4 = e;
		
		B b1 = d; //자식에서 부모로 변환 가능
		C c1 = e;
		
		//컴파일 에러. 직접적인 부모가 아니기 때문에 변환 불가능
		//B b3 = e;
		//C c2 = d;
	}

}
