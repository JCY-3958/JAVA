package chapter17.sec10_1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		/*
		//예외 발생
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.getAsDouble();
		*/
		
		//방법1
		OptionalDouble optional = list.stream()
				.mapToInt(Integer :: intValue)
				.average();
		if(optional.isPresent()) {
			System.out.println("방법1 평균 : " + optional.getAsDouble());
		} else {
			System.out.println("방법1 평균 : 0.0");
		}
		
		//방법2
		double avg = list.stream()
				.mapToInt(Integer :: intValue)
				.average()
				.orElse(0.0); //값이 없을 경우 : 디폴트 값 0.0 대입
		System.out.println("방법2 평균 : " + avg);
		
		//방법3
		list.stream()
		.mapToInt(Integer :: intValue)
		.average()
		.ifPresent(a -> System.out.println("방법3 평균 : " + a));
		
		
		
	}

}
