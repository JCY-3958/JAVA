package chapter14.sec6.eaxm01;

public class User2Thread extends Thread {
	private Calculator calculator;

	public User2Thread() {
		setName("User2Thread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory2(50);
	}
}
