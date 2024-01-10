package chapter12.sec03.exam04;

public record Member(String id, String name, int age) {
	//DTO를 위한 Member(String id, String name, int age)가 생성자,
	//필드 id, name, age 와
	//getter(), setter() 자동 생성해준다.
}
