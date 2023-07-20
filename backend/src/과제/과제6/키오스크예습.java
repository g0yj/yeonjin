package 과제.과제6;

import java.util.Scanner;

public class 키오스크예습 {

	public static void main(String[] args) {

		Scanner scanner= new Scanner(System.in);
		
		String[]제품명= {"콜라","사이다","환타"};
		int[]가격= {300,200,100};
		int[]재고= {10,10,10};
		int[]장바구니= {0,0,0};
		
		
	while(true) {
		System.out.println("---------------------------");
		System.out.println("1.콜라 2.사이다 3.환타 4.결제");
		System.out.println("---------------------------");
		
		//메뉴 고르기. scanner로 받음 - 경우의 수 1,2,3,4
		System.out.println("메뉴선택: ");int menu= scanner.nextInt();

//콜라선택-----------------------------------------------------------
		if(menu==1) {
			if(재고[0]>0) {//콜라 재고가 0보다 클 경우. 재고가 있을 경우 
				재고[0]--;
				장바구니[0]++;
				System.out.print("재고: "+재고[0]);
				System.out.println("장바구니: "+장바구니[0]);
			}
			else {System.out.println("재고부족");}
		}//콜라 if 끝
		
//사이다선택------------------------------------
		if(menu==2) {
			if(재고[1]>0) {//콜라 재고가 0보다 클 경우. 재고가 있을 경우 
				재고[1]--;
				장바구니[1]++;
				System.out.print("재고: "+재고[1]);
				System.out.println("장바구니: "+장바구니[1]);
			}
			else {System.out.println("재고부족");}
		}//사이다 if 끝
		
		
//환타선택---------------------------------------------------
		if(menu==3) {
			if(재고[2]>0) {//콜라 재고가 0보다 클 경우. 재고가 있을 경우 
				재고[2]--;
				장바구니[2]++;
				System.out.print("재고: "+재고[2]);
				System.out.println("장바구니: "+장바구니[2]);
			}
			else {System.out.println("재고부족");}
		}//환타 if 
		
//결제 선택---------------------------------------------
		if(menu==4) {//결제 선택 시
			System.out.println("현재 장바구니 현황 목록");
			System.out.println("-----------------");
			System.out.printf("%s%5s%4s\n","제품명","수량","가격");
			
			int 총가격=가격[0]*장바구니[0]+가격[1]*장바구니[1]+가격[2]*장바구니[2];
			
			for(int i=0;i<3;i++) {
				
				if(장바구니[i]!=0) {
					System.out.printf("%s%5d%4d\n",제품명[i],장바구니[i],가격[i]*장바구니[i]);
				}//if끝
				else {break;}
			}//for끝
			System.out.println("총가격: "+총가격);
	//-------------------------------------------------------------------------------------------------	
			System.out.println("--------------");
			System.out.println("1.결제  2.취소");
			System.out.println("--------------");
			int 선택= scanner.nextInt();
			
			if(선택==1) {//결제(1) 눌렀을 때
				
					System.out.println("넣은금액: "); int 금액=scanner.nextInt();
	
					if(총가격<=금액) {//적절한 금액 넣어서 결제 성공
						System.out.println("결제성공");
							for(int i=0;i<3;i++) {//장바구니 초기화		
								장바구니[i]=0;
								System.out.println("장바구니 상태: "+장바구니[i]);
								System.out.println("재고: "+재고[i]);
								 }// 장바구니 초기화 for문
							break;}//적적금액 넣어서 결제 성공
					
					else { //결제를 눌렀지만 금액이 부족해서결제 취소됨
							System.out.println("금액부족");
							for(int i =0; i<3;i++) {
								재고[i]+=장바구니[i];
								장바구니[i]=0;
								System.out.println("장바구니 상태: "+장바구니[i]);
								System.out.println("재고 상태: "+재고[i]);
								}//장바구니 상태 for문
							}//결제눌렀지만 ㄱㅁ액 부족으로 취소됨
			} // 결제 누른 상황 빠져나가는 IF문
			
				
			if(선택==2) {//취소 눌렀을때
						System.out.println("결제가 취소됨");
						for(int i =0; i<3;i++) {//장바구니 초기화, 재고 초기화 FOR문
							재고[i]+=장바구니[i];
							장바구니[i]=0;
					
							System.out.println("재고상태: "+재고[i]); //초기화 한 뒤 재고 상태 확인
							System.out.println("장바구니상태: "+장바구니[i]); //초기화 한 뒤 장바구니상태 확인
						}//장바구니 초기화 for문
				}//취소 눌렀을때 IF문 나감
				
			
		}//결제if끝
		
		
		
		
		
		
		
		
		}//while
		
		
	}//main

}//class



/*

주제 : 키오스크(배열버전)
	- 실행예시 사진은 없습니다.
	조건 
	1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
		// 샘플 : 
				이름 : 콜라 , 환타 , 사이다
				가격 : 300 , 200 , 100
				바구니 : 0 , 0 , 0
		
	2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
		1. 콜라 2.사이다 3.환타 4.결제
		[ 1~3 선택시 ]
			- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
			 
		[ 4 선택시 ] 
			- 현재 장바구니 현황 표시 목록 
			----------------------------------
			제품명	수량	가격
			사이다	1	400
			환타		2	1000
			총가격 : 1400
			- 결제메뉴 표시
				1. 결제 2.취소 
				[결제]
					- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
					- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
				[취소]
					- [ 장바구니 초기화 / 재고 다시 되돌리기 ]

*/

