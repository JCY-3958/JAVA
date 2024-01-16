package chapter15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		//정렬이 되어 지게 FruitComparator() 실행
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());
		
		//객체 저장 : 자동 정렬
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		for(Fruit fruit : treeSet) {
			System.out.println(fruit.name + " : " + fruit.price);
		}

	}

}
