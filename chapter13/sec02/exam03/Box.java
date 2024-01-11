package chapter13.sec02.exam03;

public class Box <T>{
	public T content;
	
	public boolean compare(Box<T> other) {
		//제네릭은 object 타입이라 object가 가지고 있는 메서드 equals 사용 가능
		boolean result = content.equals(other.content);
		return result;
	}
}
