package 복습.part2;

import java.util.Scanner;

public class part2 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		 String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";	
		 String 콜라= 재고관리.split("\n")[0]; System.out.println("콜라정보: "+콜라);
		 String 환타= 재고관리.split("\n")[1]; System.out.println("환타정보: "+환타);
		 String 사이다= 재고관리.split("\n")[2]; System.out.println("사이다정보: "+사이다);
		 
		 int 콜라재고=Integer.parseInt(콜라.split(",")[0]); System.out.println("콜라재고: "+콜라재고);
		 int 콜라바구니=Integer.parseInt(콜라.split(",")[1]); System.out.println("콜라바구니: "+콜라바구니);
		 int 콜라가격=Integer.parseInt(콜라.split(",")[2]);System.out.println("콜라가격: "+콜라가격);
		 
		 int 환타재고=Integer.parseInt(환타.split(",")[0]);System.out.println("환타재고: "+환타재고);
		 int 환타바구니=Integer.parseInt(환타.split(",")[1]); System.out.println("환타바구니: "+환타바구니);
		 int 환타가격=Integer.parseInt(환타.split(",")[2]);System.out.println("환타가격: "+환타가격);
		 
		 int 사이다재고=Integer.parseInt(사이다.split(",")[0]);
		 int 사이다바구니=Integer.parseInt(사이다.split(",")[1]);
		 int 사이다가격=Integer.parseInt(사이다.split(",")[2]);
//제품은 콜라 -> 환타 -> 사이다 순으로 작성되어 있으며 
//각 제품별 필드는 재고 -> 바구니 -> 가격으로 작성한 문자		
	while(true) {
		System.out.println("1. 콜라 2.환타 3. 사이다 4.결제");
		System.out.println("-----------------------------");
		System.out.println("ch 값: "); int ch= scanner.nextInt();
		

		if(ch==1) {//콜라선택
			if(콜라재고>0) {
				System.out.println("바구니담음");
				콜라재고--; 콜라바구니++;
				
				
			}
			else {
				System.out.println("재고부족");
			}
			
		}//콜라선택
		
//ch2 선택---------------------------------------------		
		else if(ch==2) {
			if(환타재고>0) {
				System.out.println("바구니담음");
				환타재고--; 환타바구니++;
			}
			else {System.out.println("재고부족");}
			
		}//ch2끝
		
//ch3 선택------------------------------------------
		else if(ch==3) {
			if(사이다재고>0) {
				System.out.println("장바구니담음");
				사이다재고--; 사이다바구니++;
			}
			else {
				System.out.println("재고부족");
			}
		}
		
//ch4 선택------------------------------
		else if(ch==4){//ch4 선택
			System.out.println("----------- 바구니 목록---------------");
			System.out.printf("%5s%5s%5s\n","제품명","수량","가격");
			System.out.println(콜라바구니);
				if(콜라바구니>0) {
				System.out.printf("%5s%5d%5d\n","콜라",콜라바구니,콜라바구니*콜라가격);
				}
				if(환타바구니>0) {
				System.out.printf("%5s%5d%5d\n","환타",환타바구니,환타바구니*환타가격);
				}
				if(사이다바구니>0) {
				System.out.printf("%5s%5d%5d\n","사이다",사이다바구니,사이다바구니*사이다가격);
				}
			
			System.out.println("1. 결제 2.취소");
			System.out.println("선택: "); int select = scanner.nextInt();
			
			int 총금액 = 콜라바구니*콜라가격+환타바구니*환타가격+사이다바구니*사이다가격;
// 1.결제선택			
			if(select==1) {
				System.out.println("투입금액: "); int 투입금액=scanner.nextInt();
				if(총금액<=투입금액) {
					System.out.println("결제성공");
				}
				else {
					System.out.println("결제실패");
					콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
					콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					System.out.println("바구니상태"+콜라바구니+환타바구니+사이다바구니);
					System.out.println("재고상태"+콜라재고+환타재고+사이다재고);
				}//결제실패
				
			}//1선택
//2.취소선택			
			else {//취소선택
				System.out.println("결제취소");
				콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
				콜라바구니=0; 환타바구니=0; 사이다바구니=0;
				System.out.println("바구니상태"+콜라바구니+환타바구니+사이다바구니);
				System.out.println("재고상태"+콜라재고+환타재고+사이다재고);
				
			}//취소
			
		}
		
		
		}//while
	} //main

}//class
