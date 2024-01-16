package chapter15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail", "Park"));
		messageQueue.offer(new Message("sendSMS", "Lee"));
		messageQueue.offer(new Message("sendKakaotalk", "Jeon"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail" : 
				System.out.println(message.to + "님에게 메일 보내기.");
				break;
			case "sendSMS" : 
				System.out.println(message.to + "님에게 문자(SMS) 보내기.");
				break;
			case "sendKakaotalk" : 
				System.out.println(message.to + "님에게 카카오톡 보내기.");
				break;
			}
		}
	}

}
