package chapter7.sec10.exam02;

public class AbstractMethodExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.sound();
		
		Cat cat = new Cat();
		cat.sound();
		
		//매개변수의 다형성
		animalSound(new Dog()); // 자동 타입 변환
		animalSound(new Cat()); // 		|
	}							//		|	
								//		V
	public static void animalSound(Animal animal) {
		animal.sound(); //재정의된 메서드 호출
	}

}
