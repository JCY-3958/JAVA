package chapter12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		//선택 번호 
		int[] selectNumber = new int[6];
		 Random random = new Random();
		 System.out.print("선택 번호 : ");
		 for(int i = 0; i < 6; i++) {
			 selectNumber[i] = random.nextInt(45) + 1;
			 for(int k = 0; k < i; k++) {
				 if(selectNumber[i] == selectNumber[k]) //번호 중복 방지
					 i--;
			 }
			 
		 }
		 
		 for(int i = 0; i < 6; i++) {
			 System.out.print(selectNumber[i] + " ");
		 }
		 
		 
		 System.out.println();
		 
		 //당첨 번호
		 int[] winningNumber = new int[6];
		 random = new Random();
		 System.out.print("당첨번호 : ");
		 for(int i = 0; i < 6; i++) {
			 winningNumber[i] = random.nextInt(45) + 1;
			 for(int k = 0; k < i; k++) {
				 if(winningNumber[i] == winningNumber[k])
					 i--;
			 }
			 
		 }
		 
		 for(int i = 0; i < 6; i++) {
			 System.out.print(winningNumber[i] + " ");
		 }
		 System.out.println();
		 
		 //당첨 여부
		 Arrays.sort(selectNumber);
		 Arrays.sort(winningNumber);
		 boolean result = Arrays.equals(selectNumber, winningNumber);
		 System.out.print("당첨여부 : ");
		 if(result) {
			 System.out.println("1등입니다!");
		 } else {
			 System.out.println("노노 대츠 노노");
		 }
		 
		 //몇개나 맞았나
		 int correct = 0;
		 for(int i = 0; i < 6; i++) {
			 for(int k = 0; k < 6; k++) {
				 if(selectNumber[i] == winningNumber[k]) {
					 correct++;
				 }
			 }
		 }
		 
		 System.out.println("맞은 번호 개수 : " + correct);
		 
	}

}
