package chapter13.exercise4;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		String flag = "예";
		PairOfDice dice = new PairOfDice();
		Player player1, player2;

		player1 = new Player("박사장");
		player2 = new Player("정마담");

		Scanner input = new Scanner(System.in);

		do {
			System.out.println(player1.getName() + "\t" + player2.getName());
			player1.roll(dice); // 플레이어1이 주사위를 이용해 roll(던짐)
			player2.roll(dice);

			System.out.println();

			if (player1.getScore() > player2.getScore()) {
				System.out.println(player1.getName() + "가(이) 이겼다.");
			} else if (player1.getScore() < player2.getScore()) {
				System.out.println(player2.getName() + "가(이) 이겼다.");
			} else {
				System.out.println("비겼다.");
			}
			
			// 게임 진행 여부
			System.out.println("\n 게임 계속?(예, 아니오) : ");
			flag = input.nextLine();
		} while (flag.equals("예"));
	}

}
