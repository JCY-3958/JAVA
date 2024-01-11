package chapter13.exercise2;

//실습과제 11.1: BusinessTaxPayer.java
//사업소득자를 모델한다

public class BusinessTaxPayer extends TaxPayer
{
	private int sales;		// 총매출액
	private int expenses; 	// 총비용

	// 사업소득자의 이름, 번호, 총매출액과 총비용을 주어진 값으로 초기화한다
	public BusinessTaxPayer(String name, int number, int sales, int expenses) {
		super(name, number);
		this.sales = sales;
		this.expenses = expenses;
	}

	// 사업소득자의 총매출액을 반환한다
	public int getSales() {
		return sales;
	}

	// 사업소득자의 총비용을 반환한다
	public int getExpenses() {
		return expenses;
	}

	// 사업소득자의 이름, 번호, 총매출액과 총비용을 반환한다
	public String toString() {
		return super.toString() + " | 총매출액 : " + sales + " | 총비용 : " + expenses;
	}

	// 사업소득자의 총매출액을 주어진 값으로 변경한다
	private void setSales(int sales) {
		this.sales = sales;
	}

	// 사업소득자의 총비용을 주어진 값으로 변경한다
	public void setExpenses() {
		this.expenses = expenses;
	}

	// 사업소득자의 세금을 계산한다
	public double computeTax() {
		int taxPrice = sales - expenses;
		if(taxPrice >= 40000000) {
			return taxPrice * 0.2;
		} else if(taxPrice >= 0) {
			return taxPrice * 0.1;
		} else {
			return 0;
		}
	}
	
	
}