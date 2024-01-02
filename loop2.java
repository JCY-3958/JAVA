package chapter4;

import java.util.*;

public class loop2 {

	public static void main(String[] args) {
		/*
		 * 점수들의 카운트 구하기
		 */
		Scanner input = new Scanner(System.in);

		int score; //입력 받는 점수
		int totalCount = 0; //전체 count 수
		int Acount = 0; //각 count 수
		int Bcount = 0;
		int Ccount = 0;
		int Dcount = 0;
		int Fcount = 0;

		//입력을 받는다.
		System.out.print("점수를 입력하세요 : ");
		score = input.nextInt();

		//socre의 입력이 -1이 될 때 까지
		while (score != -1) {
			//위에서 점수 하나 들어왔으니 +1
			totalCount++;

			//점수가 90점 이상이면 Acount + 1
			if (90 <= score)
				Acount++;

			if (80 <= score && score < 90)
				Bcount++;

			if (70 <= score && score < 80)
				Ccount++;

			if (60 <= score && score < 70)
				Dcount++;

			if (score < 60)
				Fcount++;
			
			//다시 반복해서 -1을 입력할 때 까지 반복
			System.out.print("점수를 입력하세요 : ");
			score = input.nextInt();
		}

		System.out.println("점수들의 총 수 : " + totalCount);
		System.out.println("A학점의 총 수 : " + Acount);
		System.out.println("B학점의 총 수 : " + Bcount);
		System.out.println("C학점의 총 수 : " + Ccount);
		System.out.println("D학점의 총 수 : " + Dcount);
		System.out.println("F학점의 총 수 : " + Fcount);

	}

}
