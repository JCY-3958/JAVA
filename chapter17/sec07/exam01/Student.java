package chapter17.sec07.exam01;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() { return name;}
	public int getScore() {return score;}
	
	//객체 정렬 : Comparable 재정의
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score); //score는 기준, o.score는 대입되는 값
	}
}
