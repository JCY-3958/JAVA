package chapter6.sec07;

public class KoreanExample {

	public static void main(String[] args) {
		Korean k1 = new Korean("ㅇㅇㅇ", "996644-1234234");
		Korean k2 = new Korean("ㄴㄴㄴ","889966-3456543");
		
		System.out.println("k1의 국적 = " + k1.nation);
		System.out.println("k1의 이름 = " + k1.name);
		System.out.println("k1의 주민번호 = " + k1.ssn + "\n");
		
		System.out.println("k2의 국적 = " + k2.nation);
		System.out.println("k2의 이름 = " + k2.name);
		System.out.println("k2의 주민번호 = " + k2.ssn);
	}

}
