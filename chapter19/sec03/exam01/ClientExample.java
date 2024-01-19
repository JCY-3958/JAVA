package chapter19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("172.20.21.97", 50001);
			
			System.out.println("[클라이언트] 연결 성공");
			
			//Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
			
		} catch (UnknownHostException e) {
			// IP 표기 방법이 잘못되었을 경우
			e.printStackTrace();
		} catch (IOException e) {
			// IP와 Port로 서버에 연결할 수 없는 경우
			e.printStackTrace();
		}
	}

}
