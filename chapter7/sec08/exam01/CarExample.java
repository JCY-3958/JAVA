package chapter7.sec08.exam01;

public class CarExample {

	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();
		
		//Car 객체 내에 Tire객체에 어떤 타이어 객체(Tire, HankookTire, KumhoTire)를 넣는가에 따라
		//동작이 달라진다.
		
		//Tire 객체 장착
		//내 차(myCar) 타이어(.tire)에 일반 타이어(Tire)를 추가
		myCar.tire = new Tire();
		myCar.run();
		
		//한국 타이어 추가
		myCar.tire = new HankookTire();
		myCar.run();
		
		//금호 타이어 추가
		myCar.tire = new KumhoTire();
		myCar.run();
	}
	
	/*타이어라는 놈이 있는데
	 * 그 타이어는 종류가 있다(한국, 금호)
	 * 그 타이어를 차라는 애가 쓴다
	 * 근데 그 차라는 애도 현대차, 기아차, 테슬라 여러 종류가 있으니 객체가 되고
	 * 그 차라는 놈들도 다른 타이어를 쓰니 한국, 금호 타이어 등 다른 타이어를 장착해주는 것*/

}
