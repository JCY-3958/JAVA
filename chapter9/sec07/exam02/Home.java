package chapter9.sec07.exam02;

public class Home {
	private RemoteControl rc = new RemoteControl() {

		@Override
		public void turnOn() {
			System.out.println("티비 온");
		}

		@Override
		public void turnOff() {
			System.out.println("티비 오프");
		}
		
	};
	
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	public void use2() {
		RemoteControl rc = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("에어컨 온");
			}

			@Override
			public void turnOff() {
				System.out.println("에어컨 오프");
			}
			
		};
		rc.turnOn();
		rc.turnOff();
	}
	
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
}
