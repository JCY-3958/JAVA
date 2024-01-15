package chapter14.sec9.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	public static void main(String[] agrs) {
		//최대 스레드 풀 = 5
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//작업 생성과 처리 요청
		
		//스레드풀 종료
		executorService.shutdownNow();
	}
	
}
