package chapter6.Exercise20;

import java.util.*;

public class BankApplication {

	private static Account[] accountArray = new Account[100]; // 계좌 여러개 생성
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;

		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			int num = Integer.parseInt(input.nextLine());

			if (num == 1) {
				// 계좌 생성
				createAccount();
			} else if (num == 2) {
				// 계좌 목록 출력
				accountList();
			} else if (num == 3) {
				// 예금
				deposit();
			} else if (num == 4) {
				// 출금
				withdraw();
			} else if (num == 5) {
				// 종료
				run = false;
			}

		}
		System.out.println("프로그램 종료");
	}

	private static void createAccount() {
		System.out.println("----------------------");
		System.out.println("계좌 생성");
		System.out.println("----------------------");
		System.out.print("계좌 번호 : ");
		String ano = input.nextLine();
		System.out.print("계좌주 : ");
		String owner = input.nextLine();
		System.out.print("초기입금액 : ");
		int balance = Integer.parseInt(input.nextLine());

		// 입력 받은 값으로 객체 생성
		Account newAccount = new Account(ano, owner, balance);

		// accountArray 배열 이용
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break; // accountArray가 100개니까 넣기 성공하면 for문 빠져나옴
			} else if(ano.equals(accountArray[i].getAno())) {
				System.out.println("결과: 같은 계좌가 있습니다. 다시 시도하세요.");
				break;
			}
		}
	}

	private static void accountList() {
		System.out.println("----------------------");
		System.out.println("계좌 목록");
		System.out.println("----------------------");

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.println(accountArray[i].getAno() +
						"\t" + accountArray[i].getOwner() +
						"\t" + accountArray[i].getBalance());
			}
		}
	}

	private static void deposit() {
		System.out.println("----------------------");
		System.out.println("예금");
		System.out.println("----------------------");
		System.out.print("계좌번호 : ");
		String accountNo = input.nextLine();
		System.out.print("예금액 : ");
		int deopsitMoney = Integer.parseInt(input.nextLine());

		for (int i = 0; i < accountArray.length; i++) {
			// System.out.printf("accountArray[%d] : " + accountArray[i].getAno() + "\n", i);
			// System.out.println("accountNo : " + accountNo);
			if (accountNo.equals(accountArray[i].getAno())) {
				// System.out.println("is print this sentence?");
				accountArray[i].setBalance(accountArray[i].getBalance() + deopsitMoney);
				break;
			}
		}
	}

	private static void withdraw() {
		System.out.println("----------------------");
		System.out.println("출금");
		System.out.println("----------------------");
		System.out.print("계좌번호 : ");
		String accountNo = input.nextLine();
		System.out.print("출금액 : ");
		int withdrawMoney = Integer.parseInt(input.nextLine());

		for (int i = 0; i < accountArray.length; i++) {
			if (accountNo.equals(accountArray[i].getAno())) {
				if (accountArray[i].getBalance() < withdrawMoney) {
					System.out.println("예금액이 부족합니다.");
					break;
				} else {
					accountArray[i].setBalance(accountArray[i].getBalance() - withdrawMoney);
					break;
				}

			}
		}
	}

}
