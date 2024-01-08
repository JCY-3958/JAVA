package chapter8.sec05;

public interface RemoteControl {
	public final static int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리");
			setVolume(MIN_VOLUME);
		}
		else {
			System.out.println("무음 해제");
		}
	}
	
	static void ChangeBettery() {
		System.out.println("건전지 교환 필요");
	}
}
