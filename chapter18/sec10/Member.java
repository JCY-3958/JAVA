package chapter18.sec10;

import java.io.Serializable;

//직렬화에 대한 Serializable 구현해야함
public class Member implements Serializable{
	//직렬화 UID 코드 : 역직렬화할 때 사용
	private static final long serialVersionUID = -622284561026719240L;
	
	//필드 
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {return id + " : " + name;}
}
