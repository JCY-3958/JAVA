package chapter12.sec03.exam02;

public class Student {
	private int no;
	private String name;
	
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}

	/*
	//object에 있는 해시코드, 이퀄스
	//hashCode()를 재정의하지 않으면 객체 번지로 해시코드를 생성하여 객체가 다를 경우 해시코드도 달라짐, HashSet 클래스 참고
	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	*/

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {
			if(no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
}
