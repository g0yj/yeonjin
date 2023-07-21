package 과제.과제4;

import java.util.Scanner;

public class 예출금복습 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int balance = 0; String account = "123-1234"; short password = 1234;
		
		while( true ) { // 무한루프 [ 종료조건 : 4 입력시 break; ] 
			System.out.println("\n\n--------------------");
			System.out.println("1.예금 2.출금 3.잔액 4.종료 : ");
			System.out.println("--------------------");
			System.out.print(">> 선택 : ");
			int ch = scanner.nextInt(); //ch == 선택버튼

		
			/* 문제풀이 위치 */
// 1. 예금선택------------------------------------------------------------------------		
		
			if(ch==1) {//예금선택 if문
				System.out.println("계좌번호 입력: "); String account1= scanner.next();
				if(account1.equals(account)) {// 계좌번호 일치 if
					System.out.println("예금액: "); int 예금액= scanner.nextInt();
					balance+=예금액;
					System.out.println("예금성공");
					System.out.println("계좌에 들어있는 금액: "+balance);
				}//계좌번호 일치 끝
				else {//계좌번호불일치
					System.out.println("계좌번호 불일치");
				}//계좌번호불일치끝
			
			}//예끔선택했을 때 if문 종료
// 2. 출금선택------------------------------------------------------------------------			

			if(ch==2) {//출금선택했을 때
				System.out.println("계좌번호 입력: "); String account1=scanner.next();
				if(account1.equals(account)==false) {//계좌번호가 일치X
					System.out.println("계좌번호 미일치");
					continue; // 메뉴로 이동
					}//ㄱㅖ좌번호가 일치X
				
				else{//계좌번호가 일치 , 비밀번호 입력
					System.out.println("비밀번호 입력: "); short pw= scanner.nextShort();
					if(pw!=password) {//비밀번호 일치x
						System.out.println("비밀번호 미일치");
						continue; // 메뉴로 이동
						}//비밀번호 일치x
					else {//비밀번호일치
						System.out.println("출금액: "); int 출금= scanner.nextInt();
						if(balance>=출금) {//계좌금액>=출금 면 출금성공
							balance-=출금;
							System.out.println("출금성공");
							System.out.println("잔고: "+balance);
							}//계좌금액>=출금
						else {System.out.println("잔액부족");continue;}//잔액부족
					}//비밀번호일치
					
				}//계좌번호가 일치
			}//출금선택했을때
// 3. 잔액선택-------------------------------------------------------------	
//현재 예금된 금액을 출력해준다. [ 예금액 : 3000 ]출력
			if(ch==3) {System.out.println("예금액: "+balance);}
// 4. 종료선택	------------------------------------------------------------		
			if(ch==4) {System.out.println("안녕");}
			
			
			
			
			
			
			
			
			
			
			
		
			}//while문 끝
		
	} //main 끝
} //class 끝

	/* ----------- */

/*
	주제 : 예출금 시스템

		입력 조건 
			1. 사용할 기능을 입력받는다. [1 이면 예금기능 2 이면 출금기능 3이면 잔액확인기능 4이면 종료 ]
			
		실행 조건 
			1. 만약에 예금 기능 
				1. 계좌번호를 입력받아 일치하면 예금액을 입력받아 예금액 변수에 누적 더 해준후 [ 예금 성공 ]출력 
								일치하지 않으면 '계좌번호 미일치' 라는 안내출력후 다시 메뉴로 이동 
			2. 만약에 출금 기능 
				1. 계좌번호를 입력받아 일치하면 비밀번호를 입력받고 출금액 받고 예금액에서 누적 차감 해준다.  [ 출금 성공 ]출력 
								계좌번호를 일치하지 않으면 '계좌번호 미일치' 라는 안내출력후 다시 메뉴로 이동 
								비밀번호를 일치하지 않으면 '비밀번호 미일치' 라는 안내출력후 다시 메뉴로 이동 	
								예금액보다 출금액이 더 크면 '잔액 부족' 라는 안내출력후 다시 메뉴로 이동
								
			3. 만약에 잔액 기능 
				1. 현재 예금된 금액을 출력해준다. [ 예금액 : 3000 ]출력
				  
			4. 만약에 종료 기능 
				1. 시스템이 종료된다. [ 안녕히 가세요. ]출력
*/



