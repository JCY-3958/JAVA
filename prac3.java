package chapter4;

import java.util.Scanner;

public class prac3 {

	public static void main(String[] args) {
		/*
		 * 과목의 성적 평가 = 출석, 과제, 수시시험, 중간시험, 기말시험 반영율은 출석 10%, 과제 40%, 수시시험 10%, 중간시험 20%,
		 * 기말시험 20% 총점 90 ~ 100 = A 총점 80 ~ 89 = B 총점 70 ~ 79 = C 총점 60 ~ 69 = D 총점 0 ~
		 * 59 = F 출석, 과제, 수시시험, 중간시험, 기말시험 입력받음.
		 */

		int attendance;
		int subject;
		int mid_test;
		int mid_exam;
		int final_exam;
		
		double total;
		char grade;

		Scanner input = new Scanner(System.in);

		System.out.print("출석 점수를 입력하세요 : ");
		attendance = input.nextInt();
		System.out.print("과제 점수를 입력하세요 : ");
		subject = input.nextInt();
		System.out.print("수시시험 점수를 입력하세요 : ");
		mid_test = input.nextInt();
		System.out.print("중간시험 점수를 입력하세요 : ");
		mid_exam = input.nextInt();
		System.out.print("기말시험 점수를 입력하세요 : ");
		final_exam = input.nextInt();

		total = (attendance * 0.1) + (subject * 0.4) + (mid_test * 0.1) + (mid_exam * 0.2) + (final_exam * 0.2);
		total = (double)((int)(total * 10 + 0.5) / 10);
		
		if (total >= 90 && total <= 100) {
			grade = 'A';
		} else if (total >= 80) {
			grade = 'B';
		} else if (total >= 70) {
			grade = 'C';
		} else if (total >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}

		System.out.println("총점 : " + total);
		System.out.println("학점 : " + grade);

	}

}
