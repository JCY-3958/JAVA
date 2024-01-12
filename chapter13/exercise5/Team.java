package chapter13.exercise5;

//실습 8.2 : Team.java
//비디오 게임에서 한 팀을 모델한다.
public class Team {
	// 필드
	// 누구나 팀의 이름을 변경할 수 있어야 한다.
	public String teamName;

	// 이 객체 밖에서 누구도 이 팀의 점수를 바꿀 수 없다.
	private int score;

	// 생성자 메소드
	// 목적: 팀의 이름과 점수를 각각 주어진 값으로 초기화한다.
	// @입력 매개변수
	// newTeamName - 팀의 새 이름
	// newScore - 팀의 새 점수
	public Team(String newTeamName, int newScore) {
		teamName = newTeamName;
		score = newScore;
	}

	public Team() {

	}

	// 접근자 메소드

	// 메소드: getTeam
	// 목적: 팀의 이름을 반환한다.
	// @입력 매개변수 - 없음
	// @반환값: 팀의 이름
	public String getTeam() {
		return teamName;
	}

	// 메소드: getScore
	// 목적: 팀의 점수를 반환한다.
	// @입력 매개변수 - 없음
	// @반환값: 팀의 점수
	public int getScore() {
		return score;
	}

	// 변경자 메소드들

	// 메소드: setTeam
	// 목적: 팀의 이름을 주어진 값으로 변경한다.
	// @입력 매개변수
	// name - 팀의 새 이름
	// @반환값: 없음
	public void setTeam(String name) {
		teamName = name;
	}

	// 메소드: setScore
	// 목적: 팀의 점수를 주어진 값으로 변경한다.
	// @입력 매개변수
	// points - 팀의 새 점수
	// @반환값: 없음
	public void setScore(int points) {
		score = points;
	}

	// 메소드 : toString
	// 목적 : 팀의 현재 상태를 나타내는 문자열을 반환한다.
	// @반환값 : 현 객체의 변수들과 대응하는 값들을 포함하는 문자열
	public String toString() {
		String strToReturn = new String();
		strToReturn += "이름 : " + teamName + "\n";
		strToReturn += "점수 : " + score + "\n";
		return (strToReturn);
	}

//  main 메소드
	public static void main(String argv[]) {
		// 두 개의 팀 객체들을 만든다
		Team home = new Team();
		Team visitor = new Team();
		//Team a, b;

		// 팀들의 이름들을 기록한다
		home.setTeam("엘지");
		visitor.setTeam("삼성");

		// 첫 경기의 결과를 기록한다(홈팀이 5대7의 점수로 진다)
		home.setScore(5);
		visitor.setScore(7);

		// 이긴 팀을 찾는다
		if (home.getScore() > visitor.getScore())
			System.out.println(home.getTeam() + "팀이 이긴다.");
		else
			System.out.println(visitor.getTeam() + "팀이 이긴다.");
		
		System.out.println(home.toString());
		System.out.println(visitor.toString());

		// 두번째 경기의 결과를 기록한다(홈팀이 9대3의 점수로 이긴다)
		home.setScore(9);
		visitor.setScore(3);

		// 이긴 팀을 찾는다
		if(home.getScore() > visitor.getScore()) {
			System.out.println(home.getTeam() + "팀이 이긴다.");
		} else {
			System.out.println(visitor.getTeam() + "팀이 이긴다.");
		}
		
		System.out.println(home.toString());
		System.out.println(visitor.toString());

	}
}