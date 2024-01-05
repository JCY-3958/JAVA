package chapter7.sec07.exam02;

public class Child extends Parent {
	
	//부모 메서드 2를 오버라이딩하여 내용 수정
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}
	
	//자식 객체에 새로운 메서드 추가
	public void method3() {
		System.out.println("Child-method3()");
	}
}
