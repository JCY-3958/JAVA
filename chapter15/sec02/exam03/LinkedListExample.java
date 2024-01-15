package chapter15.sec02.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		// ArrayList
		List<String> list1 = new ArrayList<String>();

		// LinkedList
		List<String> list2 = new LinkedList<String>();

		long startTime;
		long endTime;

		// ArrayList 컬렉션 저장되는 시간 측정
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i)); // 인덱스 0에 값을 삽입, 데이터를 뒤로 밀면서 삽입
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime - startTime));
		
		//LinkedList 컬렉션 저장되는 시간 측정
		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간:", (endTime - startTime));
	}

}
