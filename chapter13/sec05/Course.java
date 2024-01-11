package chapter13.sec05;

public class Course {
	//모든 사람이면 등록 가능 : 모든 타입 입력 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
	}
	
	//학색만 등록 가능 : Student 아래에 있는 객체만 입력 가능
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함");
	}
	
	//직장인 및 일반인만 등록 가능 : Worker와 그 상위만 입력 가능
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함");
	}
}
