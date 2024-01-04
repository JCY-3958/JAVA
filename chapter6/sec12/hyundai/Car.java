package chapter6.sec12.hyundai;

import chapter6.sec12.hankook.SnowTire;
import chapter6.sec12.kumho.AllSeasonTire;

public class Car {
	//명시적 기입을 통해서 다른 패키지의 클래스를 이용 가능
	//명시적 = (패키지경로.클래스명)으로 객체 생성 가능
	chapter6.sec12.hankook.Tire tire1 = new chapter6.sec12.hankook.Tire();
	chapter6.sec12.kumho.Tire tire2 = new chapter6.sec12.kumho.Tire();
	
	//import된 클래스는 클래스명으로 객체 생성 가능
	SnowTire tire3 = new SnowTire();
	AllSeasonTire tire4 = new AllSeasonTire();
}
