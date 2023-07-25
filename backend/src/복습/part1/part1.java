package 복습.part1;

import java.util.Scanner;

public class part1 {

public static void main(String[] args) {
	
Scanner scanner= new Scanner(System.in);
int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
	
	while(true) {
		System.out.println("------------------------");
		System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
		System.out.println("------------------------");
		System.out.print("ch:   "); int ch= scanner.nextInt();
		
		if(ch==1) {
			if(콜라바구니>0) {//재고 있음
				System.out.println("재고있음");
				콜라바구니++; 콜라재고--;
			}//재고있음
			else {System.out.println("재고없음");}
		}
//ch2-------------------------------------
		else if(ch==2) {
			if(환타바구니>0) {
				System.out.println("재고있음");
				환타바구니++; 환타재고--;
			}
			else {System.out.println("재고부족");}
		}	
//ch3-----------------------------------		
		else if(ch==3) {
			if(사이다바구니>0) {
				System.out.println("재고있음");
				사이다바구니++; 사이다재고--;
			}
			else {System.out.println("재고부족");}
			
		}
//ch4------------------------------------------------		
		else if(ch==4) {
			System.out.println("장바구니 목록");
			System.out.println("------------------");
			System.out.printf("%10s%5s%5s", "제품명","수량","가격");
			
			
// ch4----유효성검사		
			if(콜라바구니>0) {// 바구니에 있을
				System.out.printf("%10s%5d%5d\n","콜라",콜라바구니,콜라바구니*콜라가격);
			}
			else if(환타바구니>0) {
				System.out.printf("%10s%5d%5d\n","환타", 환타바구니, 환타바구니*환타가격);
			}
			else if(사이다바구니>0) {
				System.out.printf("%10s%5d%5d\n","환타", 환타바구니, 환타바구니*환타가격);
			}
			
			int 총가격= 콜라바구니*콜라가격+환타바구니*환타가격+환타바구니*환타가격;
			System.out.printf("%10s%10d","총가격",총가격);
		
		System.out.println("---------------------------");
		System.out.println("1.결제  2. 취소");
		System.out.println("---------------------------");
		System.out.println("결제/취소선택: "); int select2= scanner.nextInt();
// ch4--결제 눌렀을 때
		if(select2==1) {
			if(총가격>=select2) {//넣은금액이 더 클때 결제 성공
				System.out.println("결제성공");
				콜라바구니=0; 환타바구니=0; 사이다바구니=0;
			}//결제성공
			else {//결제실패
				System.out.println("결제실패");
				콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
				
			}//결제실패
			
		}//결제 눌렀을때
		
// ch4--취소눌렀을때	------------------	
		else {//취소 눌렀을때
			System.out.println("결제취소");
			콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니;
			
		}
		
		
		}//ch4끝
		
		
		
		
	}//while
	
	}//main
}//class
