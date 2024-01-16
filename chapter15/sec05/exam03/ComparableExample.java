package chapter15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		treeSet.add(new Person("박사장", 45));
		treeSet.add(new Person("이차장", 25));
		treeSet.add(new Person("정대리", 31));
		
		for(Person person : treeSet) {
			System.out.println(person.name + " : " + person.age);
		}

	}

}
