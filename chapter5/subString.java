package chapter5;

public class subString {

	public static void main(String[] args) {
		String ssn = "998877-1234123";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
		String year = ssn.substring(0, 2);
		System.out.println("년 : " + year);
		
		String month = ssn.substring(2, 4);
		System.out.println("월 : " + month);
		
		String day = ssn.substring(4, 6);
		System.out.println("일 : " + day);
	}

}
