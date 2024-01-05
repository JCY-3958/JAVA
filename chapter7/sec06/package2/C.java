package chapter7.sec06.package2;

import chapter7.sec06.package1.*;

public class C {
	public void method() {
		//A클래스는 protected 이기 때문에 다른 패키지에서 사용 불가. 일반적인 import로도 불가
		/*
		A a = new A();
		a.field = "value";
		a.method();
		*/
	}
}
