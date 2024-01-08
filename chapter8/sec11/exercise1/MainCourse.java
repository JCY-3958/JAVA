package chapter8.sec11.exercise1;

public class MainCourse {

	public static void main(String[] args) {
		Duck duck = new Duck();
		Cow cow = new Cow();
		Chicken ch = new Chicken();
		
		Cry cry = new Cry();
		
		cry.cry(duck);
		cry.cry(cow);
		cry.cry(ch);
	}

}
