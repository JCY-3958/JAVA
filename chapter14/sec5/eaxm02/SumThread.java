package chapter14.sec5.eaxm02;

public class SumThread extends Thread{
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<=100; i++) {
			sum += i;
		}
	}
}
