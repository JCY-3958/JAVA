package chapter7.sec02;

public class SmartPhone extends Phone{
	//필드
	public boolean wifi;
	
	//생성자
	public SmartPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	//메서드
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파잉이잉잉");
	}
	
	public void internet() {
		System.out.println("인터넷 연결");
	}
}
