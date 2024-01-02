package chapter4;

public class oddsum {

	public static void main(String[] args) {
		//1~100까지의 홀수의 합
		int sum = 0;
		for (int i = 1; i < 101; i += 2) {
			sum += i;
		}

		System.out.println(sum);
		
		//31~50까지의 짝수만 출력
		for(int i = 32; i < 51; i+=2) {
			System.out.println(i);
		}
	}

}
