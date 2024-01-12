package chapter13.exercise7;

import java.util.Scanner;

public class Concert {
	private String singerName; //가수 이름
	private int concertVolume; // 총 수용 인원 = 티켓 수
	private int saledTicket = 0; // 팔린 티켓 수
	private int internetTicketPrice; // 인터넷 티켓 가격
	private int onSiteTicektPrice; // 현장 티켓 가격
	private int totalProfit = 0; // 총 판매 금액
	private boolean internetSale = true; // 인터넷 판매 가능 여부

	public Concert(String singerName, int concertVolume, int internetTicketPrice, int onSiteTicektPrice) {
		this.singerName = singerName;
		this.concertVolume = concertVolume;
		this.internetTicketPrice = internetTicketPrice;
		this.onSiteTicektPrice = onSiteTicektPrice;
	}
	
	public void doTicketSale() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("남은 티켓들 수 <최대 " + getTicketLeft() + "> : ");
		int numberOfTicket = input.nextInt();
		
		//티켓을 판다.
		boolean saleCompleted = sellTickets(numberOfTicket);
		
		if(saleCompleted) {
			System.out.println("티켓들의 총 가격 : " + getSaleCost(numberOfTicket));
		} else {
			System.out.println("죄송합니다. 판매를 완료할 수 없습니다.");
		}
	}
	
	public boolean sellTickets(int numberOfTicket) {
		if(numberOfTicket > 0 && numberOfTicket <= getTicketLeft()) {
			saledTicket += numberOfTicket;
			totalProfit += getSaleCost(numberOfTicket);
			return true;
		} else {
			return false;
		}
	}
	
	public int getSaleCost(int numberOfTicket) {
		int saleCost = numberOfTicket;
		if(internetSale) {
			saleCost *= internetTicketPrice;
		}else {
			saleCost *= onSiteTicektPrice;
		}
		return saleCost;
	}
	
	public int getTicketLeft() {
		return concertVolume - saledTicket;
	}

	public boolean webSalesOnly() {
		return internetSale;
	}
	
	public void webSalesOver() {
		internetSale = false;
	}

	// -------------------------getter, setter--------------------------------------
	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public int getConcertVolume() {
		return concertVolume;
	}

	public void setConcertVolume(int concertVolume) {
		this.concertVolume = concertVolume;
	}

	public int getSaledTicket() {
		return saledTicket;
	}

	public void setSaledTicket(int saledTicket) {
		this.saledTicket = saledTicket;
	}

	public int getInternetTicket() {
		return internetTicketPrice;
	}

	public void setInternetTicket(int internetTicket) {
		this.internetTicketPrice = internetTicket;
	}

	public int getOnSiteTicekt() {
		return onSiteTicektPrice;
	}

	public void setOnSiteTicekt(int onSiteTicekt) {
		this.onSiteTicektPrice = onSiteTicekt;
	}

	public int getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(int totalProfit) {
		this.totalProfit = totalProfit;
	}

	public boolean isInternetSale() {
		return internetSale;
	}

	public void setInternetSale(boolean internetSale) {
		this.internetSale = internetSale;
	}

}
