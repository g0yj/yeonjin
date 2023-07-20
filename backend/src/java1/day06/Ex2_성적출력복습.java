package java1.day06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2_성적출력복습 {

	public static void main(String[] args) {
		// 학생수, 점수를 입력 받기 위한 Scanner 생성
		Scanner scanner = new Scanner(System.in);
		
			int 학생수 = 0;
			int[] 점수리스트= new int[학생수];
			
		while(true) {
			
			System.out.println("---------------------------------------------");
			System.out.println(" 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print(">선택: ");
			
			
			String 입력번호 = scanner.nextLine();
			
//------------누른 숫자에 따라 다른 실행 - 5가지-------------------------------------------------------------
	//1번 (학생수) 선택--------------------------------------------------	
			if(입력번호.equals("1")){ // 입력 받은 숫자가 1일때. 학생수. 
				System.out.print("학생수: "); 학생수 = Integer.parseInt(scanner.nextLine());
				System.out.println("입력 받은 학생수: "+ 학생수);
				점수리스트=new int[학생수];
		}
			
	//2번(점수입력)선택----------------------------------------------------------		
			if(입력번호.equals("2")) {// 학생 수에 따라 입력 받을 점수 갯수가 다름
				
				for(int i =0; i<학생수 ; i++) {
					System.out.println("점수입력: ");int 점수= Integer.parseInt(scanner.nextLine()); 
					점수리스트[i]=점수;		
					
				}//for 종료
				
			}//if 종료
	//3번(점수리스트)----------------------------------------------------------
			if(입력번호.equals("3")) {// 입력된 모든 점수를 출력
				System.out.println("<점수리스트>"); 
				System.out.println(Arrays.toString(점수리스트));
				//System.out.println(점수리스트[0]);
				
			}
	//4번(분석)------------------------------------------------------------
			if(입력번호.equals("4")) {// 최고점수, 평균점수 출력
				// 배열에 있는 모든 점수를 더하고 학생수로 나눔
				// 배열에 있는 값들 숫자로 가져오기
				 
				int 총점=0;
				int max=0;
				
				for(int i=0; i<학생수;i++) {
					총점+=점수리스트[i];
					
					if(max<점수리스트[i]){max=점수리스트[i];}
				}
				
				System.out.println("총점: "+총점);
				System.out.println("최고점: "+max);
			}
	//5번(종료)----------------------------------------------------------
			if(입력번호.equals("5")) {
				System.out.println("프로그램 종료");break;
				
			}
		
		
		
		
		
		
		}//while
	}//main

}//class
