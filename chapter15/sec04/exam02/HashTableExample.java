package chapter15.sec04.exam02;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {

	public static void main(String[] args) {
		//create Hashtable collection
		Map<String, Integer> map = new Hashtable<>();
		//Map<String, Integer> map = new HashMap<>();

		// create task thread
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					map.put(String.valueOf(i), i);// key = i, value = i
				}
			}
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 1001; i <= 2000; i++) {
					map.put(String.valueOf(i), i);// key = i, value = i
				}
			}
		};

		// task thread execute
		threadA.start();
		threadB.start();

		// waitig untill all task thread end 
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}

		// get total entry number stored in Hashtable
		int size = map.size();
		System.out.println("total entry number : " + size);
		System.out.println();
	}

}
