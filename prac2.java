package chapter4;

import java.util.Scanner;

public class prac2 {

	public static void main(String[] args) {
		//총 이수학점이 140 이상, 토익 점수가 700 이상이면 졸업
		//140 이상, 700 미만, 수료
		//140 미만 졸업 불가
		//총 이수학점과 토익 점수에 따라 졸업/수료/졸업 불가 여부를 결정
		int totalcreditearned; // 총 이수학점
		
		int toic;
		
		Scanner input = new Scanner(System.in);
		System.out.print("총 이수 학점을 입력하세요 : ");
		totalcreditearned = input.nextInt();
		
		System.out.print("토익 점수를 입력하세요 : ");
		toic = input.nextInt();
		
		if(totalcreditearned >= 140) {
			if(toic >= 700) {
				System.out.println("졸업 가능입니다.");
			}
			else {
				System.out.println("수료 입니다.");
			}
		}
		else
			System.out.println("졸업 불가입니다.");
		
	}

}
