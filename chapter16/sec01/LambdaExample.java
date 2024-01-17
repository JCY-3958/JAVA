package chapter16.sec01;

public class LambdaExample {

	public static void main(String[] args) {
		//여기가 1번
		action((x, y) -> { //action 메서드 실행(x ,y) 매개변수 : 하나의 추상 메서드
			int result = x + y;
			System.out.println("result : " + result);
		});
		
		action((x, y) -> {
			int result = x - y;
			System.out.println("result : " + result);
		});
	}
	
	public static void action(Calculable calculable) {
		//여기가 2번
		int x = 10;
		int y = 4;
		calculable.calculate(x, y); //추상 메서드
	}
	
	//Calculable 안의 추상 메서드가 3번 
	//거기는 추상 메서드 아무것도 없으니 다시 메인의 action이 구체화 된 것이니 action을 실행하게 되는 것인가

}
