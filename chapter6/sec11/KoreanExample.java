package chapter6.sec11;

public class KoreanExample {

	public static void main(String[] args) {
		Korean k1 = new Korean("980405-1234543", "잉잉잉");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		//final로 된건 불가
		//k1.nation = "미쿸";
		
		k1.name = "shshsh";
	}

}
