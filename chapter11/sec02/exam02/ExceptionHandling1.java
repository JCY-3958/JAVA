package chapter11.sec02.exam02;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		try {
			Class.forName("java.lang.String");
			System.out.println("클래스 존재1");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");
			System.out.println("클래스 존재2");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
