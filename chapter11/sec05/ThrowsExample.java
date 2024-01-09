package chapter11.sec05;

public class ThrowsExample {

	public static void main(String[] args){
		try {
			findClass();
		} catch(ClassNotFoundException e) {
			System.out.println("예외 처리 : " + e.toString());
		}
	}
	
	//예외 발생 시 호출한 쪽으로 예외를 넘겨줌.
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}

}
