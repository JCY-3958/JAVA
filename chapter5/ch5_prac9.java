package chapter5;

import java.util.*;

public class ch5_prac9 {

	public static void main(String[] args) {
		/*
		 * 키보드로 학생의 수와 각 학생들의 점수를 입력 받고 while문과 nextLine을 이용해 최고 점수 및 평균 점수를 출력
		 */
		Scanner input = new Scanner(System.in);
		int num; // 메뉴 번호 선택
		int student = 0; // 학생 수
		int[] scoreList = null; // 학생 수에 따른 배열
		int max = 0; // 최고 점수
		int sum = 0; // 평균을 위한 총점
		double avg; // 평균
		boolean run = true; // while이 계속 돌것인가 결정

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			num = Integer.parseInt(input.nextLine());

			switch (num) {
			case 1: {
				System.out.print("학생수> ");
				student = Integer.parseInt(input.nextLine());
				scoreList = new int[student];
				break;
			}
			case 2: {
				if (scoreList == null) {
					System.out.println("다시 시도해보세요.");
					break;
				}

				for (int i = 0; i < scoreList.length; i++) {
					System.out.printf("scoreList[%d] : ", i);
					scoreList[i] = Integer.parseInt(input.nextLine());
					sum += scoreList[i];
					if (scoreList[i] > max)
						max = scoreList[i];
				}
				break;
			}
			case 3: {
				if (scoreList == null) {
					System.out.println("다시 시도해보세요.");
					break;
				}

				for (int i = 0; i < scoreList.length; i++) {
					System.out.printf("scoreList[%d] : " + scoreList[i] + "\n", i);
				}
				break;
			}
			case 4: {
				if (scoreList == null) {
					System.out.println("다시 시도해보세요.");
					break;
				}

				avg = (double) sum / student;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
				break;
			}
			case 5:
				System.out.print("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("다시 시도해보세요.");

			}
		}

	}
}
