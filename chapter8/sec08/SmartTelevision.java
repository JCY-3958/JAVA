package chapter8.sec08;

public class SmartTelevision implements RemoteControl, Searchable{

	@Override
	public void search(String url) {
		System.out.println(url + "을 검색");
	}

	@Override
	public void turnOn() {
		System.out.println("티비 키라");
	}

	@Override
	public void turnOff() {
		System.out.println("티비 끄라");
	}
	
}
