package chapter5;

public class Split {

	public static void main(String[] args) {
		String board = "1ㅋ자바 학습ㅋ참조 타입 String을 학습합니다.ㅋ홍길동";
		
		String[] tokens = board.split("ㅋ");
		
		System.out.println("번호 : " + tokens[0]);
		System.out.println("제목 : " + tokens[1]);
		System.out.println("내용 : " + tokens[2]);
		System.out.println("성명 : " + tokens[3]);
		System.out.println();
		
		for(int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
	}

}
