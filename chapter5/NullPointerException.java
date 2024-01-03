package chapter5;

public class NullPointerException {

	public static void main(String[] args) {
		int[] intArray = null;
		intArray[0] = 10; // exception 오류

		String str = null;
		System.out.println("총 문자 수 : " + str.length()); // exception 오류
	}
}