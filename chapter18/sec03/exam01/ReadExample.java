package chapter18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.db");
			
			while(true) {
				int data = is.read();
				
				if(data == -1) break; //-1 은 파일의 끝에 도달하면 나오는 값. 파일의 끝
				System.out.println(data);
			}
			
			is.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
