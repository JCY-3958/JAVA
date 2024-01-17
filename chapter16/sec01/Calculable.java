package chapter16.sec01;

@FunctionalInterface //컴파일 과정에서 추상 메서드가 하나인지 검사
public interface Calculable { //추상 메서드가 1개만 있으면 함수형 인터페이스 : 람다식으로 표현 가능
	//추상 메서드
	void calculate(int x, int y);
}
