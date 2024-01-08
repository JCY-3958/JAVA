package chapter9.sec07.exam01;

public class Car {
	//필드에 Tire 객체 대입
	private Tire tire1 = new Tire();
	
	//필드에 익명 자식 객체 대입
	private Tire tire2 = new Tire() {
		@Override
		public void roll() {
			System.out.println("익명 자식 tire 객체 1이 굴러가유");
		}
	};
	
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	public void run2() {
		Tire tire = new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 tire 객체 2이 굴러가유");
			}
		};
		
		tire.roll();
	}
	
	public void run3(Tire tire) {
		tire.roll();
	}
}
