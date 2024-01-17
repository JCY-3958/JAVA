package chapter17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	//static이면 int sum은 자동으로 0
	//static boolean이면 false
	public static int sum;

	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(pika -> sum += pika);
		System.out.println("총합 : " + sum);
	}

}
