package 과제.과제4;

import java.util.Scanner;

public class 키오스크복습_변수 {

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
//콜라선택------------------------------------------------------
			if(ch==1) {//콜라선택
				if(콜라재고>0) {//콜라 있으면
					콜라바구니++;
					콜라재고--;
					System.out.println("콜라 장바구니: "+콜라바구니);
					System.out.println("콜라 재고: "+콜라재고);
				}//콜라 있으면
				else {System.out.println("재고부족");}
			}//콜라선택
//환타선택--------------------------------------------------------
			if(ch==2) {//환타선택
				if(환타재고>0) {
					환타바구니++;
					환타재고--;
					System.out.println("환타 장바구니: "+환타바구니);
					System.out.println("환타 재고: "+환타재고);
				}
				else {System.out.println("재고부족");}	
			}//환타선택
//사이다선택---------------------------------------------------------			
			if(ch==3) {
				if(사이다재고>0) {
					사이다바구니++;
					사이다재고--;
					System.out.println("사이다 장바구니: "+사이다바구니);
					System.out.println("사이다 재고: "+사이다재고);
				}
				else {System.out.println("재고부족");}
			}
//결제선택--------------------------------------------------------			
			if(ch==4) {//4.결제 
				System.out.println("현재 장바구니 현황");
				System.out.println("----------------");
				System.out.printf("%5s%5s%5s\n","제품명","수량","가격");
				
				if(콜라바구니!=0) {System.out.printf("%3s%5d%10d\n","콜라",콜라바구니,콜라가격*콜라바구니);}
				if(환타바구니!=0) {System.out.printf("%3s%5d%10d\n","환타",환타바구니,환타가격*환타바구니);}
				if(사이다바구니!=0) {System.out.printf("%3s%5d%10d","사이다",사이다바구니,사이다가격*사이다바구니);}
				
				int 총가격= (콜라가격*콜라바구니)+(환타가격*환타바구니)+(사이다가격*사이다바구니);
				System.out.println("총가격: "+총가격);
				
				System.out.println("------------------");
				System.out.println("1.결제  2.취소");
				System.out.println("------------------");
				
				System.out.println("결제여부: "); int 결제=scanner.nextInt();
//결제선택-결제--------------------------------------------------------------------				
				if(결제==1) {//1. 결제 눌렀을 때. 
					System.out.println("넣을돈: "); int 넣을돈=scanner.nextInt();
					if(넣을돈>=총가격) {// 넣을돈>=총가격 . 결제성공
						System.out.println("잔액: "+(넣을돈-총가격));
						System.out.println("결제성공");
						콜라바구니=0; 환타바구니=0; 사이다바구니=0;
						System.out.println("장바구니상태: " +콜라바구니+환타바구니+사이다바구니);
					}//결제성공
					else {//결제실패
						System.out.println("금액이 부족함");
						콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
						콜라바구니=0; 환타바구니=0; 사이다바구니=0;
						System.out.println("바구니상태: "+콜라바구니+사이다바구니+환타바구니);
						System.out.println("재고상태: "+콜라재고+"   "+사이다재고+"   "+환타재고);
					}//금액부족으로 결제실패
				}//1.결제 눌렀을 때
				
				
//결제선택-취소------------------------------------------------------------------				
				else {//2.취소 눌렀을때. 장바구니 초기화, 재고 되돌리기
					System.out.println("결제취소");
					콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
					콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					System.out.println("바구니상태: "+콜라바구니+사이다바구니+환타바구니);
					System.out.println("재고상태: "+콜라재고+"   "+사이다재고+"   "+환타재고);
					break;
				}//2. 취소 눌렀을때
				
				
			}//4.결제
			
			
			/* ----------- */
			
			
		} // while end 
		
	
	} // main end 
	
} // class end 



