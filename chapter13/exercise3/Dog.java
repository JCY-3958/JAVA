package chapter13.exercise3;

public class Dog extends Pet{
	private String seed;
	private boolean vaccine;
	
	//주어진 값으로 초기화
	public Dog(String name, int age, String seed) {
		super(name, age);
		this.seed = seed;
		vaccine = false;
	}
	
	//기본 값으로 초기화
	public Dog() {
		super();
		seed = "";
		vaccine = false;
	}

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public boolean isVaccine() {
		return vaccine;
	}

	public void setVaccine(boolean vaccine) {
		this.vaccine = vaccine;
	}
	
	public String toString() {
		return super.toString();
	}

}
