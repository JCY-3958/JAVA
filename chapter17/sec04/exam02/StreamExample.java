package chapter17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		//배열 생성
		String[] strArray = {"레인저", "저거넛", "패파"};
		
		//배열을 스트림으로 String은 객체, 타입 아님 -> Stream<String>
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.print(item + ","));
		System.out.println();
		
		//int는 객체 아님, 타입 -> IntStream
		int[] intArray = {1, 2, 3, 4, 5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(pikachu -> System.out.print(pikachu + ","));
		System.out.println();
	}

}
