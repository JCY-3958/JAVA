package chapter14.sec7.exam03;

public class PrintThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("실행 중");
			if(Thread.interrupted()) { //인터럽트 유무 확인
				break;
			}
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}

}
