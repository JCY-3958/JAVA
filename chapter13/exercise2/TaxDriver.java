package chapter13.exercise2;

public class TaxDriver {
	// 근로소득자와 사업소득자의 세금을 계산한다
	
	public static void main(String[] args) {
		
		// 이름이 ‘선남’이고 번호가 100이고 월급이 3,000,000인
		// SalaryTaxPayer 객체를 생성하고 payer1이 가리키게 한다
		SalaryTaxPayer payer1 = new SalaryTaxPayer("박사장", 101, 3000000);

		// payer1의 모든 데이터를 출력한다
		System.out.println(payer1.toString());
		
		// payer1의 세금을 계산하여 출력한다
		System.out.println(payer1.computeTax());
		System.out.println();
		
		// 이름이 ‘선녀’이고 번호가 200이고 총매출액이 120,000,00이고
		// 총비용이 75,000,000인 BusinessTaxPayer 객체를 생성하고 payer2가 가리키게 한다
		BusinessTaxPayer payer2 = new BusinessTaxPayer("치킨사장", 500, 120000000, 75000000);
		
		// payer2의 모든 데이터를 출력한다
		System.out.println(payer2.toString());
		
		// payer2의 세금을 계산하여 출력한다
		System.out.println(payer2.computeTax());
		System.out.println();
		
		//-----------------------------
		
		SalaryTaxPayer payer3 = new SalaryTaxPayer("신입", 11, 2600000);

		System.out.println(payer3.toString());
		
		System.out.println(payer3.computeTax());
		System.out.println();
	}
}