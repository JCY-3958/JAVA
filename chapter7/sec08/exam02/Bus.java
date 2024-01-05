package chapter7.sec08.exam02;

public class Bus extends Vehicle {
	
	@Override
	//차량이 달리는데 누가 달린다? 버스가
	public void run() {
		System.out.println("버스가 부릉부릉");
	}

}
