package chapter8.sec07;

public class ServiceExample {

	public static void main(String[] args) {
		Service service = new ServiceImpl();
		
		//default 메서드 호출
		service.defaultMethod1();
		System.out.println();
		service.defaultMethod2();
		System.out.println();
		
		//정적 메서드 호출
		Service.staticMethod1();
		System.out.println();
		Service.staticMethod2();
		System.out.println();
	}

}
