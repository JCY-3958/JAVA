package chapter8.sec10;

public class PromotionExample {

	public static void main(String[] args) {
		//구현 객체 생성
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		//인터페이스 변수 선언
		A a;
		
		//변수에 구현 객체 대입, 모두 자동 형변환이 일어남
		a = b;
		a = c;
		a = d;
		a = e;
		
		//B, C : 인터페이스 A를 구현
		//D, E : B, C를 상속받은 자식
		//B, C, D, E는 인터페이스 A 타입으로 대입 가능
		//인터페이스 안에 있는 메서드 사용 가능
	}

}
