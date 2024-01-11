package chapter13.sec02.exam02;

//리턴 타입을 Home으로
public class HomeAgency implements Rentable<Home> {

	@Override
	public Home rent() {
		return new Home(); //Home 객체를 반환
	}
}
