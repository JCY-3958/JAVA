package chapter15.sec02.exam02;

import java.util.Vector;
import java.util.List;
import chapter15.sec02.exam01.Board;
import java.util.ArrayList;

public class VectorExample {

	public static void main(String[] args) {
		//List<Board> list = new Vector<>();
		List<Board> list = new ArrayList<>(); //결과가 2000으로 안나옴.
		//ArrayList로 멀티 스레드 작업을 할땐 경합이 발생,
		// 어떤 스레드에서 저장이 되지 않는 문제가 발생하여 Loss가 생길 수 있다.

		// 스레드 작업 객체 생성
		Thread threadA = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i = 1; i <= 1000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};

		// 스레드 작업 객체 생성
		Thread threadB = new Thread() {
			@Override
			public void run() {
				// 객체 1000개 추가
				for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};
		
		//작업 스레드 실행
		threadA.start();
		threadB.start();
		
		//작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
		try {
			threadA.join();
			threadB.join();
		} catch (Exception e) {
		}
		
		//저장된 총 객체 수 얻기
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
	}

}
