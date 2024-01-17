package chapter17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("this is sparta");
		list1.add("i am a best warrior");
		
		list1.stream().
		flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(word -> System.out.println(word));
		
		System.out.println();
		
		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
		list2.stream()
		.flatMapToInt(data -> {
			String[] strArr = data.split(","); //list2를 10, 20, 30, 40, 50으로 분해
			int[] intArr = new int[strArr.length]; //intArr 크기는 5개
			for(int i = 0; i < strArr.length; i++) { // 10, 20 ,30, 40 ,50을 intArr에 넣어줌
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr); //다시 stream으로 변환
		})
		.forEach(number -> System.out.println(number));
	}

}
