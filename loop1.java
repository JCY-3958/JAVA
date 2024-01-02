package chapter4;

import java.util.Scanner;

public class loop1 {

	public static void main(String[] args) {
		/*
		 * 점수를 입력 받아 점수에서 최고 점수, 최저 점수와 평균 점수를 계산 -99입력 시 프로그램 종료, while문 이용
		 */
		int score;
		int count = 0;
		int max = -1;
		int min = 101;
		int sum = 0;
		double avg = 0.0;

		Scanner input = new Scanner(System.in);

		System.out.print("점수를 입력하세요 : ");
		score = input.nextInt();

		while (score != -99) {
			// 점수가 하나 들어왔으니 count + 1
			count++;

			// 점수가 최저점인지 최고점인지 먼저 계산하여 변수에 넣어줌
			if (score > max)
				max = score;

			if (score < min)
				min = score;

			// 점수의 합계를 누적 계산
			sum += score;

			// -----------------------------------------------

			System.out.print("점수를 입력하세요 : ");

			// 점수 입력 받기
			score = input.nextInt();

		}
		// 평균을 계산
		avg = (double) sum / count;

		System.out.println("최고 점수 : " + max);
		System.out.println("최저 점수 : " + min);
		System.out.println("평균 점수 : " + avg);

	}

}
