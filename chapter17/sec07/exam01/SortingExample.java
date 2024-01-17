package chapter17.sec07.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class SortingExample {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("박사장", 30));
		studentList.add(new Student("강대리", 10));
		studentList.add(new Student("권차장", 20));
		
		//점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		studentList.stream()
		.sorted()
		.forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));
		
		System.out.println();
		
		//점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		studentList.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(s -> System.out.println(s.getName() + " : " + s.getScore()));
	}

}
