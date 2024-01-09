package chapter11.sec06;

//Exception에서 상속을 받는다.(일반 예외)
public class InsufficientException extends Exception{
	//두 개의 생성자 선언
	public InsufficientException() {
	}
	
	//매개변수 사용하는 생성자 : message :에러가 발생을 하게 되면 message에 있는 내용 출력
	public InsufficientException(String message) {
		super(message);
	}
}
