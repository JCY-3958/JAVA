package chapter16.sec02.exam01;

public class LambdaExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		//실행문이 2개 이상, 중괄호 필요
		person.action(() -> {
			System.out.println("부릉부릉");
			System.out.println("학교 도착~");
		});
		
		//실행문이 1개, 중괄호 생략 가능
		person.action(() -> System.out.println("금요일 5시였으면 좋겠다"));
	}

}
