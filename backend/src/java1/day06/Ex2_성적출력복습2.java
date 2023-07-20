package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_성적출력복습2 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
			int 학생수=0; // 1번에서 사용
			int[] 점수리스트= new int[1]; // 배열선언-> 타입[] 변수명= new 타입[길이]
			
			
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("1.학생수 |2.점수입력 |3.점수리스트 |4.분석 |5.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택> ");

			// 문자로 받기
			String 입력번호 = scanner.nextLine();
			
			
			
			
// 1번 학생수-------------------------------------------------
			if(입력번호.equals("1")) {// 학생수 입력 받기. 
				
				//학생수로 처리하니 while문 밖으로 변수 빼줘야됨. 초기값 0
				System.out.print("학생수: " );
				학생수 = Integer.parseInt(scanner.nextLine());
				System.out.println("입력받은 학생수: "+ 학생수);
				점수리스트=new int[학생수];
					
			}

//2번 점수 입력-------------------------------------------------
			if(입력번호.equals("2")) {//점수입력 받기
				
				for(int i=0; i<학생수; i++) {
					System.out.print("입력받은점수: ");int 점수=Integer.parseInt(scanner.nextLine());
					점수리스트[i]=점수;
					
				}//for끝
				
			}
			
			
//3번 점수리스트 ---------------------------------------
			if(입력번호.equals("3")) {
				System.out.println("<<배열에 담긴 점수리스트>>");
				
				System.out.println( Arrays.toString(점수리스트));
			
			}
			
//4번 분석-------------------------------------------
			if(입력번호.equals("4")) {//최고점수, 평균점수 출력
				int sum=0;
				int max=0;
				for(int i=0;i<학생수;i++) {
					sum+=점수리스트[i];
					if(max<점수리스트[i]) {max=점수리스트[i];}
				}
					System.out.println("평균: "+(sum/학생수));
					System.out.println("최고점: "+max);
			}//if끝
		
//5번 종료-----------------------------------------
			if(입력번호.equals("5")) {
				System.out.println("프로그램종료");
				break;
			}
//-------------------------------------------------------		
		}//while
		
	}//main

}//class
