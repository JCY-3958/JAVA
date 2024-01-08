package chapter8.sec04;

public class Television implements RemoteControl{
	private int volume;

	//추상 메서드 오버라이딩
	@Override
	public void turnOn() {
		System.out.println("티비 켜기");
	}

	@Override
	public void turnOff() {
		System.out.println("티비 끄기");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}
		else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}
		else {
			this.volume = volume;
		}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	
	
	
	
	
}
