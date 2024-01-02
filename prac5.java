package chapter4;

import java.util.Scanner;

public class prac5 {

	public static void main(String[] args) {
		/*
		 * 문제 2. 입력 받은 양의 정수가 3의 배수, 5의 배수 혹은 8의 배수인지를 알려주는 프로그램을 설계하고 작성하라. 양의 정수가 3의
		 * 배수이면 '3의 배수이다'를 출력하고 5의 배수이면 '5의 배수이다'를 출력하며 8의 배수이면 '8의 배수이다'를 출력하고 그 외의
		 * 경우이면 '어느 배수도 아니다'를 출력하라.
		 */
		Scanner input = new Scanner(System.in);

		boolean multiple = false;

		System.out.print("정수를 입력하세요 : ");
		int num = input.nextInt();

		if (num % 3 == 0) {
			System.out.println(num + "은(는) 3의 배수이다.");
			multiple = true;
		}

		if (num % 5 == 0) {
			System.out.println(num + "은(는) 5의 배수이다.");
			multiple = true;
		}

		if (num % 8 == 0) {
			System.out.println(num + "은(는) 8의 배수이다.");
			multiple = true;
		}

		if (multiple == false) {
			System.out.println(num + "은 어느 배수도 아니다.");
		}

	}

}
