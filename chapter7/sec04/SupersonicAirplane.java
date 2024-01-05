package chapter7.sec04;

public class SupersonicAirplane extends Airplane { //자식
	//상수
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	//상태 필드
	public int flyMode = NORMAL;

	//메서드 재정의
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("찢었다 호빵맨");
		} else {
			super.fly(); //부모가 가진 메서드의 코드 그대로 활용
		}
	}
	
}
