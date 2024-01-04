package chapter6.exam01.package2;

import chapter6.exam01.package1.*;

public class C {
	//A클래스가 default가 되면 같은 패키지 내에 없기 때문에 불가능
	//A a;
	
	//다른 패키지에 있기 때문에 import를 해줘야 사용 가능 + B는 public
	B b;
	
	//public 이라서 접근 가능
	A a1 = new A(true);
	
	//default 라서 같은 패키지 내에서만 가능
	//A a2 = new A(1);
	
	//private 라서 같은 파일 내에서만 가능
	//A a3 = new A("문자열");
}
