package chapter12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		double num = 1234567.89;
		
		DecimalFormat df;
		
		df = new DecimalFormat("#,###"); //천 단위마다 , 표시
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#,###.0"); //천 단위마다 , 표시하고 소수점 1자리 까지
		System.out.println(df.format(num));
	}

}
