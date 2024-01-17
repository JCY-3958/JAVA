package chapter17.sec01.exam01;

import java.util.*;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("김사장");
		set.add("박재정");
		set.add("박진호");
		
		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
	}

}
