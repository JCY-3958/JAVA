package chapter13.exercise7;

import java.util.Scanner;

public class ConcertDriver {

	public static void main(String[] args) {
		//객체 생성
		Concert concert = new Concert("하현우", 100, 10000, 20000);
		
		System.out.println("콘서트 판매 프로그램을 시작합니다.");
		Scanner input = new Scanner(System.in);
		
		boolean done = false;
		
		while(!done) {
			//티켓 방법을 입력 받는다.
			if(concert.webSalesOnly()) {
				System.out.print("\n인터넷 판매이면 S, 현장 판매로 바꾸려면 V, 판매를 종료하려면 F를 입력하세요: ");
			}else {
				System.out.print("\n현장 판매이면 S, 판매를 종료하려면 F를 입력하세요: ");
			}
			
			String response = input.next();
			
			// 티켓 판매 방법에 따라 티켓을 판다
            // 판매 종료를 원하면 판매를 종료하게 만든다
            // 인터넷 판매이면 티켓을 인터넷 가격으로 판다
            // 현장 판매로 바꾸기를 원하면 티켓을 현장 가격으로 판다
            // 티켓 판매 방법이 틀리게 입력되면 오류 메시지를 출력한다.
			if(response.equals("F")) {
				done = true;
			} else if(response.equals("S")) {
				concert.doTicketSale();
			} else if(response.equals("V")) {
				concert.webSalesOver();
			} else {
				System.out.println("잘못 선택하셨습니다.");
			}
			
			//판매 후 남은 티켓들의 수
			System.out.println("남은 티켓들의 수 : " + concert.getTicketLeft());
		}
		
		//팔린 티켓 수와 총 판매 금액을 출력한다.
		System.out.println("\n" + concert.getSingerName() + " 콘서트 티켓 판매 내역 : ");
		System.out.println("팔린 티켓 수 : " + concert.getSaledTicket() + " 총 판매 금액 : " + concert.getTotalProfit());
		
	}

}
