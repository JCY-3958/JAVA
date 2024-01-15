package chapter14.sec6.exam02;

public class WorkObject {
	public synchronized void methodA() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodA 작업 실행");
		notify(); // 다른 스레드를 실행 대기 상태로 만듦
		try {
			wait(); // 자신은 일시 정지 상태로 만듦
		} catch (InterruptedException e) {
		}
		//notify로 다른 스레드를 먼저 실행 대기 만든 다음에 자신이 wait 해야함 
	}
	
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + ": methodB 작업 실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
