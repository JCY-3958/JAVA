package chapter13.exercise4;

public class PairOfDice {
	//필드 : 주사위 수
	private int faceValue1;
	private int faceValue2;
	
	//생성자
	public PairOfDice() {
		faceValue1 = 1;
		faceValue2 = 1;
	}
	
	//메서드	
	//주사위 던지기
	public void roll() {
		faceValue1 = (int)(Math.random() * 6) + 1;
		faceValue2 = (int)(Math.random() * 6) + 1;
	}
	
	public int getFaceValue1() { return faceValue1; }

	public void setFaceValue1(int faceValue1) { this.faceValue1 = faceValue1; }

	public int getFaceValue2() { return faceValue2; }

	public void setFaceValue2(int faceValue2) { this.faceValue2 = faceValue2; }
}
