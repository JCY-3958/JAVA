package chapter15.sec03.exam02;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30)); //인스턴스는 다르지만 객체는 동일하여 객체 1개만 저장
		
		System.out.println("총 객체 수 : " + set.size());
	}

}
