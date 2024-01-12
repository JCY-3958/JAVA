package chapter13.exercise4;

public class Player {
	//필드
	private String name;
	private int score;
	
	//생성자
	public Player(String name) {
		//this.name = name;
		setName(name);
	}
	
	//메서드
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	
	public void roll(PairOfDice dice) {
		int value1, value2;
		
		dice.roll();
		value1 = dice.getFaceValue1();
		value2 = dice.getFaceValue2();
		score = value1 + value2;
		System.out.println("\t 주사위 1: " + value1 + " 주사위 2 : " + value2 + " 총 점수 : " + score);
	}
}
