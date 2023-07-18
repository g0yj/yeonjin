package java1.day04;

import java.util.Scanner;

public class Ex2_확인문제7 {
	
	public static void main(String[] args) {
		
		//입력 객체

/*-------하다 포기쓰 (예금액 넣는 변수 만드는 거 생각도 못함 ㅋ )----------------------------------------------------------------
		while(true) {
		System.out.println("--------------------------");
		System.out.println("1.예금 |2.출금 |3.잔고|4.종료");
		System.out.println("--------------------------");
		System.out.print("선택> "); String 선택= scanner.nextLine();
		
		if(선택==1) {
			System.out.print("금액> "); int 금액 = scanner.nextInt();
			
			}
		
		}//while 끝
------------------------------------------------------------------------------------
*/	
		Scanner scanner = new Scanner(System.in);
		
		//각 기능별 구현 = > 공통 변수를 생각해야함. 예금 금액 안에 있는 걸 출금할 수 있는거라는 점을 기억
		int 예금액=0; // 누적합계를 위해서는 while 함수 밖에 선언.
		
		
		// 중복된 출력을 반복문으로 출력
		
		while(true) {// 종료할 때까지 무한루프 = 4.종료를 선택할 때까지(종료조건)
			
		System.out.println("--------------------------");
		System.out.println("1.예금 |2.출금 |3.잔고|4.종료");
		System.out.println("--------------------------");
		
		System.out.print("선택> ");
		// 입력 객체를 이용한 next~()메소드로 입력 객체 내 입력 받은 데이터
		int ch = scanner.nextInt(); //입력 받은 번호
		//입력에 따른 서로 다른 코드 실행(각 기능 별 구현)
			if(ch==1) {
				System.out.print("예금액>: ");
				예금액 += scanner.nextInt(); // 입력 받는 정수를 예금액 변수에 누적 더하기				
			}
			else if(ch==2) {
				System.out.println("출금액>: ");
				예금액 -= scanner.nextInt(); //입력 받은 정수를 예금액 변수에 누적 빼기
			}
			else if(ch==3) {
				System.out.println("잔고: "+ 예금액); //예금액 변수 호출하여 출력
				
			}
			else if(ch==4) {
				System.out.println("프로그램 종료 ");  
				break; // 종료를 위한 break
				}
		
		}//while 반복문 끝
	
	
	
	}//main 끝
}//class 끝
