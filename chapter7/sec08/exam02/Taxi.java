package chapter7.sec08.exam02;

public class Taxi extends Vehicle{
	
	@Override
	//차량이 달리는데 누가 달린다? 택시가
	public void run() {
		System.out.println("택시가 부릉부릉");
	}
}
