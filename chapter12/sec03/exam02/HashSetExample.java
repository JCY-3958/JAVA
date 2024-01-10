package chapter12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet hashSet = new HashSet(); //HashSet 컬렉션(데이터 모음 : 객체)
		
		Student s1 = new Student(1, "홍박사");
		hashSet.add(s1);
		System.out.println("저장된 객체 수 : " + hashSet.size());
		
		Student s2 = new Student(1, "홍박사");
		hashSet.add(s2);
		System.out.println("저장된 객체 수 : " + hashSet.size());
		
		//여기까지는(s1과 s2가) 동등한 객체이기 때문에 객체 수가 중복으로 저장이 안되어 1
		//but Student에서 hashCode() 재정의 안하면 다른 객체로 인식
		
		Student s3 = new Student(2, "홍박사");
		hashSet.add(s3);
		System.out.println("저장된 객체 수 : " + hashSet.size());
	}

}
