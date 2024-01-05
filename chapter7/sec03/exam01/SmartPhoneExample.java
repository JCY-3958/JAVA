package chapter7.sec03.exam01;

public class SmartPhoneExample {

	public static void main(String[] args) {
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "아이보리");
		//부모 생성자를 먼저 호출 -> 자식 생성자 호출
		
		//Phone으로부터 상속 받은 필드 읽기
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
	}

}
