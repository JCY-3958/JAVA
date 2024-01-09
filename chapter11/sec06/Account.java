package chapter11.sec06;

public class Account {
	//필드
	private long balance;
	
	//생성자
	public Account() {}
	
	//메서드
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException { //예외 떠넘기기
		if(balance < money) {
			throw new InsufficientException("잔고 부족 : " +(money-balance) + " 모자람"); //예외 발생키시는 곳
		}
		balance -= money;
	}
}
