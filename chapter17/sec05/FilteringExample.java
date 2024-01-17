package chapter17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {

	public static void main(String[] args) {
		//List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("목캔디");
		list.add("혀캔디");
		list.add("목캔디");
		list.add("눈캔디");
		list.add("코캔디");
		list.add("귀캔디");
		list.add("목눈캔디");
		
		//중복 요소 제거
		//스트림으로 만들고 중복 제거하고 하나씩 가져와서 출력
		list.stream().distinct().forEach(n -> System.out.println(n));
		System.out.println();
		
		//'목'으로 시작하는 요소만 필터링(true인 것만)
		list.stream().filter(n -> n.startsWith("목")).forEach(n -> System.out.println(n));
		System.out.println();
		
		//중복 요소를 먼저 제거하고, '목'으로 시작하는 요소만 필터링
		list.stream().distinct().filter(n -> n.startsWith("목")).forEach(n -> System.out.println(n));
		
	}

}
