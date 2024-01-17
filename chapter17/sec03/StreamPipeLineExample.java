package chapter17.sec03;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;

public class StreamPipeLineExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("레인저", 10),
				new Student("버서커", 20),
				new Student("저거넛", 30)
		);
		
		//방법 1
		/*
		Stream<Student> studentStream = list.stream();
		//중간 처리(학생 객체를 점수로 매핑)
		IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
		//최종 처리(평균 점수)
		double avg = scoreStream.average().getAsDouble();
		*/
		
		//방법 2 : 스트림 파이프라인 처리 : 중간 저장 과정 필요없이 한번에 처리 가능
		double avg = list.stream()
				.mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		
		System.out.println("평균 점수 : " + avg);
	}

}
