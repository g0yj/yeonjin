package 과제.과제4;

import java.util.Scanner;

public class 과제4_3_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
		
		int 콜라바구니 = 0 ; 	int 환타바구니 = 0 ; 	int 사이다바구니 = 0;
		
		int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
/*			[ 1~3 선택시 ]
			- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력			
*/			
			if(ch==1) {	
				if(콜라재고>0) {//콜라 재고가 있다면 !!!!!!!!!!!!!!!! 콜라재고!= 이렇게 했는데 > 이게 맞음. 재고가 -가 되면 어캄.
					콜라재고--; //재고 --
					콜라바구니++; //콜라 장바구니 넣음  ++ , 갯수임
					//장바구니 확인
					System.out.println("콜라 장바구니 확인:"+콜라바구니+"    콜라재고: "+콜라재고);
				}
				else {//콜라 재고가 없음
					System.out.println("재고부족");
					}
			}// 콜라 선택	
	//-----------------------------------------------------------	
			else if(ch==2) {
				if(환타재고!=0) {//환타 재고가 있다면
					환타재고--;//환타재고 줄어들고 --
					환타바구니++;//환타장바구니 넣음  ++ , 갯수임
					//장바구니 확인
					System.out.println("환타 장바구니 확인: "+환타바구니+"     환타재고: "+환타재고);
				}
				else {//환타 재고가 없음
					System.out.println("재고부족");
				}
			}// 환타선택
	//------------------------------------------------------------			
			else if(ch==3) {	
				if(사이다재고!=0) {//사이다 재고가 있다면
					사이다재고--;//사이다재고 줄어들고 --
					사이다바구니++;//사이다장바구니 넣음  ++ , 갯수임
					//장바구니 확인
					System.out.println("사이다 장바구니 확인:"+사이다바구니+"    사이다재고: "+사이다재고);
					
				}
				else {//사이다 재고가 없음
					System.out.println("재고부족");
				}
			}//사이다 선택
	//---------------------------------------------------------------
			else if(ch==4) {//결제
				
				int 총가격 = (사이다바구니*사이다가격)+(콜라바구니*콜라가격)+(환타바구니*환타가격);
				
				
				// %d    이런식 말고 %4d 이런식으로 써보셈
				System.out.println("--------------------------");
				System.out.printf("%s   %s   %s   \n","제품명","수량","가격");
				System.out.printf("%s   %d     %d    \n","사이다",사이다바구니,(사이다바구니*사이다가격));
				System.out.printf("%s    %d     %d    \n","콜라",콜라바구니,(콜라바구니*콜라가격));
				System.out.printf("%s    %d     %d    \n","환타",환타바구니,(환타바구니*환타가격));
				System.out.printf("%s    %d  \n","총가격", 총가격);
/*- 현재 장바구니 현황 표시 목록 
------------------------------
제품명	수량	가격
사이다	1	400
환타		2	1000
총가격 : 1400
!!!! 콜라 한번도 안 산 경우 출력 안됨. if를 추가로 해줄 필요가 있음.
	if(콜라바구니>0){(System.out.printf("%s   %d     %d    \n","사이다",사이다바구니,(사이다바구니*사이다가격));}
*/				
				System.out.println("1. 결제  2.취소");
				System.out.println("선택: "); int 선택 = scanner.nextInt();
				
					if(선택==1) {//결제 선택
/*
 						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기						
 */
						System.out.println("넣은 금액: ");	int 넣은금액=scanner.nextInt();
						
							if(넣은금액>=총가격) {
						
							System.out.println("잔액: "+(넣은금액-총가격));
							System.out.println("결제성공");
							
							//장바구니 초기화 된지 확인용 ????초기화 굳이 필요?????
							//!!!!!!!!!!!! 내가 작성한 코든데 완전 잘못 생각함 ㅋ.. 꼭 필요함니다.
							// 콜라바구니 = 0 ; 	 환타바구니 = 0 ; 	 사이다바구니 = 0;
							
							// 구매성공 했으니 장바구니 초기화 필요. 재고 원상복귀 필요 없음
							콜라바구니=0; 사이다바구니=0; 환타바구니=0;
							
							}// 결제 가능한 경우
							
							else {//돈 부족한경우 장바구니 초기화, 재고 원상복귀
								콜라재고+=콜라바구니; 콜라바구니=0;
								환타재고+=환타바구니; 환타바구니=0;
								사이다재고+=사이다바구니; 사이다바구니=0;
								// 금액이 부족해서 취소될 경우 앞에 담은 거 싹 다 사라짐. while과 break를 이용해서 해결 가능. 
								// 금액 입력 받는 곳에서 while하고 금액 맞게 되면 break 함.
							}//돈부족
					} //선택==1 끝
					
					
					else if(선택==2) {
						// 구매 취소를 했기 때문에 바구니를 원상복귀함. 
						콜라재고+=콜라바구니; 콜라바구니=0;
						환타재고+=환타바구니; 환타바구니=0;
						사이다재고+=사이다바구니; 사이다바구니=0;
						System.out.println("바구니 초기화함");
						
					}
					
				
			}//결제끝
				

			
			
			
			/* ----------- */
			
			
		} // while end 
		
	
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격
			int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		2. 제품 초기 재고
			콜라 10개	, 사이다 10개 , 환타 10개      * 판매시 재고 차감되고 다시 채우기 안됩니다.
			int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
			
		3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
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







