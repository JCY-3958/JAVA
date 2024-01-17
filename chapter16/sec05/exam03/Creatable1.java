package chapter16.sec05.exam03;

@FunctionalInterface
public interface Creatable1 {
	//추상 메서드가 아니라 추상 생성자
	public Member create(String id);
}
