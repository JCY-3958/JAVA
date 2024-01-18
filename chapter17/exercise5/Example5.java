package chapter17.exercise5;

import java.util.*;

public class Example5 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"this is a java book",
				"Lambda Expressions",
				"i am a best Java developer"
				);
		
		list.stream()
		.filter(n -> n.toLowerCase().contains("java"))
		.forEach(n -> System.out.println(n));
	}

}
