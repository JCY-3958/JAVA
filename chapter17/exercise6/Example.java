package chapter17.exercise6;

import java.util.*;

public class Example {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", 30),
				new Member("신용권", 40),
				new Member("김자바", 26)
				);
		
		double avg = list.stream()
				//.mapToInt(n -> n.getAge())
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		System.out.println("평균 나이 : " + avg);
	}

}
