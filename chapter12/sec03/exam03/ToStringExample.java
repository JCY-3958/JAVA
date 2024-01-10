package chapter12.sec03.exam03;

public class ToStringExample {
	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("샘숭", "안드로이드");
		
		String strobj = myPhone.toString(); //결과 : 샘숭, 안드로이드
		System.out.println(strobj);
		
		System.out.println(myPhone); //결과 : 샘숭, 안드로이드
	}
}
