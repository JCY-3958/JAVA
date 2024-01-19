package chapter19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer extends Thread {
	private static DatagramSocket datagramSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws Exception {
		System.out.println("----------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("----------------------------------------------");

		// UDP 서버 시작
		startServer();

		// 키보드 입력
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		// UDP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			public void run() {
				try {
					// 데이터그램 소켓 객체 생성 : 포트
					datagramSocket = new DatagramSocket(50001);
					System.out.println("[서버] 시작됨");

					// 패킷 주고 받기
					while (true) {
						// 데이터그램 수신 패킷 (byte[], 크기 지정)
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);

						executorService.execute(() -> {
							try {
								String newsKind = new String(receivePacket.getData(),
										0, receivePacket.getLength(), "UTF-8");

								// 패킷을 보낸측의 IP와 Port 얻기
								SocketAddress socketAddress = receivePacket.getSocketAddress();

								// 데이터그램 발신(송신) 패킷
								for (int i = 0; i <= 10; i++) {
									String data = newsKind + ": poe" + i;
									byte[] bytes = data.getBytes("UTF-8");
									DatagramPacket sendPacket = new DatagramPacket(bytes,
											0, bytes.length, socketAddress);
									datagramSocket.send(sendPacket);
								}
							} catch (Exception e) {
							}
						});
					}
				} catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public static void stopServer() {
		executorService.shutdownNow();
		datagramSocket.close();
		System.out.println("[서버] 종료됨");
	}

}
