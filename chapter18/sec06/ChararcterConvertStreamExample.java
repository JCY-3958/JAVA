package chapter18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ChararcterConvertStreamExample {

	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림 사용");
		String data = read();
		System.out.println(data);
	}
	
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");// 출력 -> byte -> char
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is, "UTF-8"); //인코딩 형식은 같아야함
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0 ,num);
		
		return str;
	}

}
