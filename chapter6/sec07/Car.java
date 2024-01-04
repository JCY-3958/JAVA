package chapter6.sec07;

public class Car {
	// 필드 선언
	String company = "횬다이";
	String model;
	String color;
	int maxspeed;
	
	//기본 생성자는 다른 생성자가 없으면 자동 생성
	Car() {};
	
	Car(String company) { //오버로딩
		this.company = company;
	};
	
	Car(String company, String model, String color){
		this.company = company;
		//this(model, color, 240)
	};
	
	Car(String model, String color) {
		//this.model = model;
		//this.color = color;
		this(model, color, 250);
	}
	
	Car(String model, String color, int maxspeed){
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;
	};
	
}
