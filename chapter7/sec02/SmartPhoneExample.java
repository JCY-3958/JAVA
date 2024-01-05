package chapter7.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("Z flip flip flip flip flip 20", "은색");
		
		//Phone으로부터 상속받은 필드 읽기
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
		
		//SmartPhone의 필드 읽기
		System.out.println("와이파이 상태 : " + myPhone.wifi);
		
		//Phone으로부터 상속받은 메서드 호출
		myPhone.bell();
		myPhone.sendVoice("마 뜨급나 함 사울래");
		myPhone.receiveVoice("마 니 몇 살이고");
		myPhone.sendVoice("서른마흔 다읏살");
		myPhone.hangUp();
		
		//SmartPhone의 메서드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}

}
