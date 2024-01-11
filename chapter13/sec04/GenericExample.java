package chapter13.sec04;

public class GenericExample {

	//제한된 타입 파라미터를 갖는 제네릭 메서드 , Number 아래 shot, int, float 등등 이런 애들만 가능
	public static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("compare(" + t1.getClass().getSimpleName() +
				", " + t2.getClass().getSimpleName() + ")");
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return(v1 == v2);
	}
	
	public static void main(String[] args) {
		boolean result1 = compare(10, 20);
		System.out.println(result1);
		System.out.println();
		
		boolean result2 = compare(4.5, 4.5);
		System.out.println(result2);
	}

}
