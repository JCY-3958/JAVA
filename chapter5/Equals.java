package chapter5;

public class Equals {

	public static void main(String[] args) {
		String strVar1 = "홍길동";
		String strVar2 = "홍길동";
		
		if(strVar1 == strVar2) { // == 는 참조 주소 번지를 비교
			System.out.println("strVar1과 strVar2의 참조가 같다.");
		}
		else {
			System.out.println("strVar1과 strVar2의 참조가 다르다.");
		}
		
		if(strVar1.equals(strVar2)) { // equals는 데이터의 값을 비교한다.
			System.out.println("strVar1과 strVar2의 문자열이 같다.");
		}
		
		String strVar3 = new String("홍길동");
		String strVar4 = new String("홍길동");
		
		if(strVar3 == strVar4) { // == 는 참조 주소 번지를 비교
			System.out.println("strVar3과 strVar4의 참조가 같다.");
		}
		else {
			System.out.println("strVar3과 strVar4의 참조가 다르다.");
		}
		
		if(strVar3.equals(strVar4)) { // equals는 데이터의 값을 비교한다.
			System.out.println("strVar3과 strVar4의 문자열이 같다.");
		}
	}

}
