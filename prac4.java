package chapter4;

import java.util.Scanner;

public class prac4 {

	public static void main(String[] args) {
		/*
		 * 문제 1. 할인점에서 고객에게 청구 금액을 계산하는 프로그램을 설계하고 작성하라.
		 * 고객이 30만원 이상 구매하면 3만원을 할인해 주어야 하고,
		 * 30만원 미만 10만원 이상을 구매하면 5,000원을 할인해 주어야 하며,
		 * 10만원 미만을 구매하면 할인이 없어야 한다.
		 * 키보드로 부터 구매 금액을 입력 받아야 한다.
		 * 구매 금액과 청구 금액을 출력해야 한다.*/
		int purchase;
		
		Scanner input = new Scanner(System.in);
		
		//구매 금액 입력 받기
		System.out.print("구매 금액을 입력하세요 : ");
		purchase = input.nextInt();
		System.out.println("구매 금액 : " + purchase);
		
		if(purchase >= 300000) {
			purchase -= 30000;
		} else if(purchase >= 100000) {
			purchase -= 5000;
		}
		
		System.out.print("청구 금액 : " + purchase);

	}

}
