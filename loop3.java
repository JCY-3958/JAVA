package chapter4;

import java.util.*;

public class loop3 {
	public static void main(String[] args) {
		/*
		 * 숫자 맞추기 게임을 하는 프로그램을 설계하고 작성하라.
		 * 프로그램은 1과 100사이의 임의의 정수를 선택해야 한다.1과 100도 선택될 수있다.
		 * 그 다음에 사용자에게 선택된 숫자를 맞춰보라고 요청한다.
		 * 사용자가 추측한 숫자에 대해 맞는지 아니면 추측한 숫자가 큰지 혹은 작은지를 알려주어야 한다.
		 * 사용자가 정확하게 맞추거나 맞추기를 그만 둘 때까지 수자 맞추기를 계속하라.
		 * 사용자가 그만두기를 원하는지를 결정하기 위해 감시 값을 사용하라.
		 * 맞출 때까지 추측한 횟수를 세고 사용자가 맞추고 난 후 그 횟수를 출력하라.
		 * 각 게임이 끝난후에 사용자가 맞추기 게임을 계속하기를 원하는지를 물어 보라.
		 * 사용자가 게임을 종료하기를 원할 때 까지 게임을 계속하게 하라.
		 */
		Scanner input = new Scanner(System.in);
		Random generator = new Random();

		int targetNumber; // 사용자가 맞추려하는 숫자
		int guessNumber; // 사용자가 추측한 숫자
		int count = 0; // 추측한 횟수
		final int sentinel = -1; // 사용자가 그만두기를 원하는지 감시하는 숫자
		String again = "예"; // 계속 여부
		targetNumber = generator.nextInt(100) + 1;

		//밖에서 게임을 계속할지
		while (again.equals("예")) {
			// 1부터 100사이의 임의의 정수 생성
			// targetNumber = (int)(Math.random()*100 + 1);
			
			System.out.println("랜덤 생성 숫자 : " + targetNumber);
			
			Out : while (true) {
				System.out.print("맞추려는 숫자를 입력하세요 : ");
				guessNumber = input.nextInt();

				count++;
				if(guessNumber == sentinel)
					break Out;
				
				if (targetNumber > guessNumber)
					System.out.println("추측한 숫자가 작습니다.");
				else if (targetNumber < guessNumber)
					System.out.println("추측한 숫자가 큽니다.");
				else if (targetNumber == guessNumber) {
					System.out.println("추측한 숫자가 맞습니다.");
					System.out.println("추측한 횟수 : " + count);
					break Out;
				}
			}
			System.out.print("다시 게임을 진행하겠습니까? 예, 아니오 : ");
			again = input.next();
			if(again.equals("아니오"))
				break;
			System.out.println("------숫자 맞추기 게임------");
			count = 0;
		}
	}
}
