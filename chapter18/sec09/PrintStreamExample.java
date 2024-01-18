package chapter18.sec09;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("야미야미");
		ps.println(" 봉림관 가성비 좋은듯");
		ps.println("데이터를 출력합니다.");
		ps.printf("| %6d | %-10s | %10s | \n", 1, "홍홍", "진호진호");
		ps.printf("| %6d | %-10s | %10s | \n", 2, "박사장", "사장");
		
		ps.flush();
		ps.close();
	}

}
