package chapter8.sec04;

public interface RemoteControl {
	//상수 필드
	public final static int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메서드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
