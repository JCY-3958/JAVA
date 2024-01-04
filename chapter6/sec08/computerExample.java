package chapter6.sec08;

public class computerExample {

	public static void main(String[] args) {
		computer com = new computer();

		int result1 = com.sum(1, 2, 3);
		System.out.println("result1 = " + result1);

		int result2 = com.sum(1, 2, 3, 4, 5);
		System.out.println("result2 = " + result2);

		int[] values = { 1, 2, 3, 4, 5, 6 };
		int result3 = com.sum(values);
		System.out.println("result3 = " + result3);

		int result4 = com.sum(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		System.out.println("result4 = " + result4);
	}

}
