package chapter13.sec02.exam01;

public class GenericExample {

	public static void main(String[] args) {
		//kind는 Tv, model은 String 		제네릭 매개변수 안에 객체를 담을 수 있음.
		Product<Tv, String> product1 = new Product<>();
		
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
		
		Tv tv = product1.getKind();
		String tvmodel = product1.getModel();
		
		//---------------------------------------
		Product<Car, String> product2 = new Product<>();
		
		product2.setKind(new Car());
		product2.setModel("SUV 자동차");
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
	}

}
