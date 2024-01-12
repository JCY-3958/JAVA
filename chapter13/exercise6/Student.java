package chapter13.exercise6;

import java.util.Scanner;

public class Student {
	//필드
	private String name;
	private int quizeScore;
	private int middleExamScore;
	private int finalExamScore;
	
	//생성자
	public Student(String name) {
		this.name = name;
	}
	
	//메서드
	//학생의 모든 데이터를 한꺼번에 알려주기
	public String toSting() {
		return "이름 : " + name + " | 퀴즈 점수 : " + quizeScore +
				" | 중간 점수 : " + middleExamScore + " | 기말 점수 : " + finalExamScore;
	}
	
	//사용자에게 학생의 퀴즈 점수, 중간 점수, 기말 점수 받기
	public void inputGrades() {
		Scanner input = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print(getName() + "의 퀴즈 점수를 입력하라 : ");
			quizeScore = Integer.parseInt(input.nextLine());
			if(quizeScore < 0 || quizeScore > 100) {
				System.out.println("오류 : 0 ~ 100사이의 점수를 입력하세요");
			} else {
				break;
			}	
		}
		
		while(run) {
			System.out.print(getName() + "의 중간 점수를 입력하라 : ");
			middleExamScore = Integer.parseInt(input.nextLine());
			if(middleExamScore < 0 || middleExamScore > 100) {
				System.out.println("오류 : 0 ~ 100사이의 점수를 입력하세요");
			} else {
				break;
			}	
		}
		
		while(run) {
			System.out.print(getName() + "의 기말 점수를 입력하라 : ");
			finalExamScore = Integer.parseInt(input.nextLine());
			if(finalExamScore < 0 || finalExamScore > 100) {
				System.out.println("오류 : 0 ~ 100사이의 점수를 입력하세요");
			} else {
				break;
			}	
		}
	}
	
	//학생의 모든 시험 점수들의 총점을 계산
	public double getTotal() {
		return (quizeScore * 0.2) + (middleExamScore * 0.3) + (finalExamScore * 0.5);
	}
	
	//학생의 총점에 기초하여 학점을 부여
	public String getGrades() {
		//double resultGrades = (quizeScore * 0.2) + (middleExamScore * 0.3) + (finalExamScore * 0.5);
		
		if(getTotal() >= 90) {
			return "A";
		} else if(getTotal() >= 80) {
			return "B";
		} else if(getTotal() >= 70) {
			return "C";
		} else if(getTotal() >= 60) {
			return "D";
		} else {
			return "F";
		}		
	}
	
	
	//----------------------getter, setter-----------------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuizeScore() {
		return quizeScore;
	}

	public void setQuizeScore(int quizeScore) {
		this.quizeScore = quizeScore;
	}

	public int getMiddleExamScore() {
		return middleExamScore;
	}

	public void setMiddleExamScore(int middleExamScore) {
		this.middleExamScore = middleExamScore;
	}

	public int getFinalExamScore() {
		return finalExamScore;
	}

	public void setFinalExamScore(int finalExamScore) {
		this.finalExamScore = finalExamScore;
	}
	//-----------------------------------------------------------------------

}
