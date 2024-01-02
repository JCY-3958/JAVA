package chapter4;

import java.util.*;

public class prac1 {

	public static void main(String[] args) {
		//부울 연산 ,if , 기본적인 입력문 사용
		//회사의 입사 지원 대상자 여부를 지원사의 평점과 토익 점수에 따라 다음과 같이 출력
		//평점이 4.0 이상, 토익 점수가 700이면 면접 대상
		//3.5 이상, 4.0미만 700이상이면 서류 전형 대상
		//3.0 이상, 3.5미만 700이상이면 필기 시험 대상
		//3.0미만, 700미만이면 지원 불가 출력
		//입사 지원 대상자의 평점과 토익 점수는 키보드로 부터 입력 받아야함
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("평점을 입력하세요(예 : 3.2) : ");
		double avg = input.nextDouble();
		
		System.out.print("토익 점수를 입력하세요 : ");
		int toic = input.nextInt();
		
		if(toic >= 700) {
			if(avg >= 4.0) {
				System.out.print("면접 대상자입니다.");
			}
			else if(avg >= 3.5) {
				System.out.print("서류 전형 대상자입니다.");
			}
			else if(avg >= 3.0) {
				System.out.print("필기 시험 대상자입니다.");
			}
			else {
				System.out.print("지원 불가입니다.");
			}
		}
		else {
			System.out.print("지원 불가입니다.");
		}

	}

}
