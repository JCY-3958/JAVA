package chapter13.exercise3;

public abstract class Pet {
	private String name;
	private int age;
	
	//주어진 값으로 초기화
	public Pet(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//기본 값으로 초기화
	public Pet() {
		this.name = "";
		this.age = 0;
	}

	//이름과 나이 각각
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//이름과 나이 한꺼번에 알려주기
	public String toString() {
		System.out.println("이름: " + name);
		//return "이름 : " + name + "\n" + "나이 : " + age;
		return "나이 : " + age;
	}
	
	
	
}
