package chapter11.sec05;

public class ThrowsExample2 {

	//메인에서도 예외 떠넘기기 가능. JVM이 최종으로 예외 처리를하고 내용은 콘솔에 출력 
	public static void main(String[] args) throws Exception {
		findClass();
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}

}
