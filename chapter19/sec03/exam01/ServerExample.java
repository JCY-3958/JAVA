package chapter19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//클라이언트는 아직이고 서버만 만들어보자
public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("----------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("----------------------------------------------");
		
		//TCP 서버 시작
		startServer();
		
		//키보드 입력
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		
		//TCP 서버 종료
		stopServer();
	}
	
	public static void startServer() {
		//작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작");
					
					//여기 밑에는 클라이언트가 안들어와서 계속 대기중인 상태이기 때문에 실행은 안됨
					while(true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						//연결 수락
						Socket socket = serverSocket.accept();
						
						//연결된 클라이언트 정보 얻기
						InetSocketAddress isa = 
								(InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함");
						
						//연결 끊기
						socket.close();
						System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
					}
					
				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}
			}
		};
		
		//스레드 시작
		thread.start();
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
		}
		
	}

}
