package chapter6.sec15;

public class SingletonExample {

	public static void main(String[] args) {
		//싱글톤으로 생성했기 때문에 다른 객체 생성 불가
		//Singleton obj1 = new Singleton(); //클래스는 public 이라 사용가능한데 생성자가 private 라 불가
		//Singleton obj2 = new Singleton();
		
		//정적 메서드를 호출해서 싱글톤 객체 얻기, 생성자로 생성이 안되어 메서드를 이용해서 생성
		//메서드에서 객체의 값을 리턴 받아서 생성 가능
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		//생성한 싱글톤 객체가 같은지 확인
		if(obj1 == obj2) {
			System.out.println("같은 겁니다.");
		}else {
			System.out.println("다른 겁니다.");
		}
		
	}

}
