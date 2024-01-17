package chapter17.sec02;

import java.util.*;
import java.util.stream.Stream;

public class ParalleStreamExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("레인저");
		list.add("치프틴");
		list.add("어쌔신");
		list.add("사이온");
		list.add("버서커");
		
		Stream<String> paralleStream = list.parallelStream(); //병렬 스트림 만들기
		paralleStream.forEach(name -> {
			System.out.println(name + ": " + Thread.currentThread().getName());
		});
	}

}
