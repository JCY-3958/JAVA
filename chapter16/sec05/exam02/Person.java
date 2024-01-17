package chapter16.sec05.exam02;

public class Person {
	public void ordering(Comparable comparable) {
		String a = "박사장";
		String b = "이사장";
		
		int result = comparable.compare(a, b);
		
		if(result < 0) {
			System.out.println(a + "은 " + b + "보다 앞에 옴");
		} else if(result == 0) {
			System.out.println(a + "은 " + b + "과 같다.");
		} else {
			System.out.println(a + "은 " + b + "보다 뒤에 옴");
		}
	}
}
