package chapter13.sec05;

//지원자 : 어떤 사람이 들어올지 몰라서 제네릭
public class Applicant<T> {
	public T kind;
	
	public Applicant(T kind) {
		this.kind = kind;
	}
}
