package chapter13.exercise6;

public class StudentDriver {

	public static void main(String[] args) {
		//두 학생의 성적 기록을 나타내는 객체 생성
		Student student1 = new Student("박사장");
		Student student2 = new Student("정마담");
		
		//1번 학생의 점수들을 읽어 들임
		student1.inputGrades();
		
		//1번 학생의 시험 점수들의 총점
		double studentTotal1 = student1.getTotal();
		
		//1번 학생의 학점 계산
		String studentGrades1 = student1.getGrades();
		
		//1번 학생의 이름, 총점, 학점 출력
		System.out.println(student1.getName() + "의 총점은 : " + studentTotal1 + "이고" + " 학점은 : " + studentGrades1);
		//--------------------------------------------------------------------
		//2번 학생의 점수들을 읽어 들임
		student2.inputGrades();
		
		//2번 학생의 시험 점수들의 총점
		double studentTotal2 = student2.getTotal();
		
		//2번 학생의 학점 계산
		String studentGrades2 = student2.getGrades();
		
		//2번 학생의 이름, 총점, 학점 출력
		System.out.println(student2.getName() + "의 총점은 : " + studentTotal2 + "이고" + " 학점은 : " + studentGrades2);

	}

}
