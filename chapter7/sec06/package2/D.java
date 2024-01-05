package chapter7.sec06.package2;

import chapter7.sec06.package1.*;

public class D extends A{ //다른 패키지라서 import한 뒤 상속을 받음
	public D() {
		super();
	}
	
	public void method1() {
		this.field = "value";
		this.method();
	}
	
	
	//protected로 설정된 다른 패키지의 클래스를 상속을 받더라도 직접적인 객체 생성은 불가
	//protected 상속 : 간접적으로 필드나 메서드를 이용 가능
	/*
	public void method2() {
		A a = new A();
		a.field = "value";
		a.method();
	}
	*/
	
	

}
