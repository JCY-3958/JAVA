package chapter16.sec02.exam01;

public class Person {
	public void action(Workable workable) {
		workable.work(); // work()는 추상메서드, 실행시에 람다식으로 구체적인 실행문 작성
	}
}
