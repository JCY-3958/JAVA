package chapter15.sec04.exam01;

import java.util.HashMap; //자식
import java.util.Iterator; // set데이터를 하나씩
import java.util.Map; // 부모
import java.util.Map.Entry; // 키와 값으로 이루어진 형태
import java.util.Set; //map 데이터를 set에 넣어서 처리

public class HashMapExample {

	public static void main(String[] args) {
		//map 컬렉션 생성, 키=String, 값=Integer
		Map<String, Integer> map = new HashMap<>();
		
		//객체 저장
		map.put("신용권", 85);
		map.put("박사장", 90);
		map.put("이차장", 80);
		map.put("박사장", 95); //키 중복 : 값을 변경, 기존 박사장, 90 -> 95
		System.out.println("총 entry 수 : " + map.size()); //키가 다른 것은 3가지가 있음
		System.out.println();
		
		//키로 값 얻기
		String key = "박사장";
		int value = map.get(key); //키가 박사장인 엔트리의 값을 가져옴
		System.out.println(key + ": " + value);
		System.out.println();
		
		//키 set 컬렉션을 얻고, 반복해서 키와 값을 얻기
		//키에 해당하는 부분을 Set으로 저장하고
		//Set에 있는 것을 하나씩 map.get(set)를 하나씩 대입해서 해당하는 부분을 iterator로 가져옴.
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String k = keyIterator.next();
			Integer v = map.get(k);
			System.out.println(k + " : " + v);
		}
		System.out.println();
		
		//map의 엔트리(키와 값)을 set으로 가져와서 처리
		//Set 주머니에 담는다
		Set<Entry<String, Integer>> entrySet = map.entrySet(); 
		//주머니에 있는걸 하니씩 꺼내기 위해 Iterator에 다시 담는다
		Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator(); 
		
		while(entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println(k + " : " + v);
		}
		System.out.println();
		
		//키로 엔트리 삭제
		map.remove("박사장");
		System.out.println("총 entry 수 : " + map.size());
		System.out.println();
		
	}

}
