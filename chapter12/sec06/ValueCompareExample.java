package chapter12.sec06;

public class ValueCompareExample {

	public static void main(String[] args) {
		//포장에서 int의 범위는 -128 ~ 127
		Integer obj1 = 300; //범위를 넘어서 따로 객체 생성
		Integer obj2 = 300;
		System.out.println("== : " + (obj1 == obj2)); //번지 주소를 비교, 객체가 따로 되어 같지 않음
		System.out.println("equals() : " + obj1.equals(obj2)); //내부 값을 비교
		System.out.println();
		
		//-128 ~ 127 범위 안에 있는 경우
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("== : " + (obj3 == obj4)); //번지가 같음
		System.out.println("equals : " + obj3.equals(obj4));
	}

}
