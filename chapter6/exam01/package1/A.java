package chapter6.exam01.package1;

public class A { //접근 제한자가 default로 설정하면 같은 패키지 내에서만 접근 가능
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//생성자
	//public은 모든 곳에서 사용 가능
	public A(boolean b) {
		
	}
	
	//default는 같은 패키지 내에서 사용 가능
	A(int b) {
		
	}
	
	//private는 같은 파일 내에서만 사용 가능
	private A(String s) {
		
	}

}
