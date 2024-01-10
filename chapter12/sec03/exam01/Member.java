package chapter12.sec03.exam01;

public class Member {
	//필드
	public String id;
	
	//생성자
	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member target) { // 타입 비교 : obj가 Member 타입인지
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
