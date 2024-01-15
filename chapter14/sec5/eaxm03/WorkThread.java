package chapter14.sec5.eaxm03;

public class WorkThread extends Thread{
	public boolean work = true;
	
	public WorkThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) { //true 이면 정상적 스레드
				System.out.println(getName() + " 작업 처리");
			} else {
				Thread.yield(); // false면 다른 스레드에게 작업 양보
				//다른 스레드가 더 많이 실행이 되도록 만듦
			}
		}
	}

}
