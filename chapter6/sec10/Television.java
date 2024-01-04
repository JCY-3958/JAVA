package chapter6.sec10;

public class Television {
	static String company = "샘숭";
	static String model = "LCD";
	static String info; // 값을 company-model 합성해서 값을 넣겠다.
	
	static {
		info = company + "-" + model;
	}
	
}
