package chapter15.sec06.exam01;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(1000));
		coinBox.push(new Coin(10));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(5000));
		coinBox.push(new Coin(50000));
		
		coinBox.pop();
		coinBox.pop();
		coinBox.pop();
		Coin coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coinBox.push(new Coin(5000));
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coinBox.push(new Coin(50));
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coinBox.push(new Coin(50000));
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		coin = coinBox.pop();
		System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		
		/*
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		}
		*/
		
	}

}
