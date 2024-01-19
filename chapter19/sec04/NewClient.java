package chapter19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewClient {

	public static void main(String[] args) {
		try {
			//DatagramSocket 생성, 포트 번호는 자동 할당
			DatagramSocket datagramSocket = new DatagramSocket();
			
			//구독하고 싶은 뉴스 주제 보내기
			String data = "게임";
			byte[] bytes = data.getBytes("UTF-8");
			DatagramPacket sendPacket = new DatagramPacket(
					bytes, bytes.length, new InetSocketAddress("172.20.21.97", 50001)
					);
			datagramSocket.send(sendPacket);
			
			//뉴스 받기
			while(true) {
				//받는 것에 대한 패킷 생성
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024],
						1024);
				datagramSocket.receive(receivePacket);
				
				//문자열로 변환
				String news = new String(receivePacket.getData(), 0,
						receivePacket.getLength(), "UTF-8");
				System.out.println(news);
				
				//10번째 뉴스 받으면 while문 종료
				if(news.contains("poe10")) {
					break;
				}
			}
			//DatagramSocket 닫기
			datagramSocket.close();
		}catch (Exception e) {
		}
	}

}
