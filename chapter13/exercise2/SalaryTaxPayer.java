package chapter13.exercise2;

//실습과제 11.1: SalaryTaxPayer.java
//근로소득자를 모델한다

public class SalaryTaxPayer extends TaxPayer
{
	private int salary;		// 월급

	// 근로소득자의 이름, 번호와 월급을 주어진 값으로 초기화한다
	public SalaryTaxPayer(String name, int number, int salary) {
		super(name, number);
		this.salary = salary;
	}

	// 근로소득자의 월급을 반환한다
	public int getSalary() {
		return salary;
	}

	// 근로소득자의 이름, 번호와 월급을 반환한다
	public String toString() {
		return super.toString() + " | 월급 : " + salary;
	}

	// 근로소득자의 월급을 주어진 값으로 변경한다
	public void setSalary() {
		this.salary = salary;
	}
	
	// 근로소득자의 세금을 계산한다
	public double computeTax() {
		long yearSalary = salary * 12;
		if(yearSalary > 80000000) {
			return yearSalary * 0.3;
		} else if(yearSalary > 60000000) {
			return yearSalary * 0.2;
		} else if(yearSalary > 40000000) {
			return yearSalary * 0.15;
		} else if(yearSalary > 20000000) {
			return yearSalary * 0.1;
		}else {
			return yearSalary * 0.05;
		}
	}
}
