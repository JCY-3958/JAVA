package chapter6.sec15;

//클래스는 대문자로 시작
//객체 변수는 소문자로 시작

public class Singleton { //클래스는 public
	//static : 파일을 호출하면 바로 생성 
	private static Singleton singleton = new Singleton();
	
	//생성자는 private
	private Singleton() { 
		
	}
	
	//static 바로 생성
	public static Singleton getInstance() {
		return singleton;
	}
}
