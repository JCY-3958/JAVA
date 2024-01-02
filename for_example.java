package chapter4;

public class for_example {

	public static void main(String[] args) throws InterruptedException {
		for(int i = 10; i > 0; i--) {
			System.out.println(i + "초 남았습니다.");
			Thread.sleep(1000);
		}
		System.out.println("발사~");

	}

}
