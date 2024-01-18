package chapter18.sec03.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");
			
			byte[] data = new byte[100];
			
			while(true) {
				int num = is.read(data); //is에 있는 파일을 읽어 data 배열에 저장하여 읽은 값을 num에게 리턴
				if(num == -1) break;
				
				for(int i = 0; i < num; i++) {
					System.out.println(data[i]);
				}
			}
			
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
