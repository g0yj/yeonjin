package 복습.part2;

import java.util.Scanner;

public class part2_3 {
	public static void main(String[] args) {
		
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		//- 제품은 콜라 -> 환타 -> 사이다 순으로 작성되어 있으며 
		//각 제품별 필드는 재고 -> 바구니 -> 가격으로 작성한 문자열 입니다.
	
	String 콜라= 재고관리.split("\n")[0];
	String 환타= 재고관리.split("\n")[1];
	String 사이다= 재고관리.split("\n")[2];
	System.out.println(콜라+환타+사이다);
	
	int 콜라재고= Integer.parseInt(콜라.split(",")[0]);
	int 콜라바구니= Integer.parseInt(콜라.split(",")[1]);
	int 콜라가격= Integer.parseInt(콜라.split(",")[2]);
	System.out.println( 콜라재고+","+콜라바구니+","+콜라가격);
	
	int 환타재고= Integer.parseInt(환타.split(",")[0]);
	int 환타바구니= Integer.parseInt(환타.split(",")[1]);
	int 환타가격= Integer.parseInt(환타.split(",")[2]);
	
	int 사이다재고= Integer.parseInt(사이다.split(",")[0]);
	int 사이다바구니= Integer.parseInt(사이다.split(",")[1]);
	int 사이다가격= Integer.parseInt(사이다.split(",")[2]);
	
	Scanner scanner= new Scanner(System.in);
	
	while(true) {
		System.out.println(재고관리);
		System.out.println("1.콜라 2.환타 3.사이다 4.결제");
		System.out.print("ch입력: "); int ch= scanner.nextInt();
//ch-1------------------------		
		if(ch==1) {
			if(콜라재고>0) {//콜라재고있
				System.out.println("바구니담음");
				콜라바구니++;
				콜라재고--;
			}///콜라재고있
			else {//콜라재고 없
				System.out.println("재고부족");
				
			}// 콜라재고없
			
		}
//ch2--------------------------		
		else if(ch==2) {
			if(환타재고>0) {//환타재고있
				System.out.println("바구니담음");
				환타바구니++;
				환타재고--;
			}///콜라재고있
			else {//환타재고 없
				System.out.println("재고부족");
				
			}// 환타재고없
		}
//ch3-------------------------		
		else if(ch==3) {
			if(사이다재고>0) {//사이다재고있
				System.out.println("바구니담음");
				사이다바구니++;
				사이다재고--;
			}///사이다재고있
			else {//사이다재고 없
				System.out.println("재고부족");
				
			}// 사이다재고없
		}
//ch4-------------------		
		else if(ch==4) {
			System.out.println("-------------------------------");
			System.out.printf("%5s%5s%5s","제품명","수량","가격");
			if(콜라바구니>0) {
				System.out.printf("%5s%5d%5d","콜라",콜라바구니,콜라바구니*콜라가격);
			}
			if(환타바구니>0) {
				System.out.printf("%5s%5d%5d","환타",환타바구니,환타바구니*환타가격);
				
			}
			if(사이다바구니>0) {
				System.out.printf("%5s%5d%5d","사이다",사이다바구니,사이다바구니*사이다가격);
				
			}
			System.out.println("1. 결제 2.취소");
			System.out.println("결제/취소: "); int select = scanner.nextInt();
			int 총금액= 콜라바구니*콜라가격+환타바구니*환타가격+사이다바구니*사이다가격;
			if(select==1) {
				System.out.println("투입금액: "); int input=scanner.nextInt();
				
				if(총금액<=input) {//결제성공
					System.out.println("잔액: "+(input-총금액));
					System.out.println("결제성공");
				}//결제성공
				else {//결제실패
					System.out.println("결제실패");
					콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니; 
					
				}//결제실패
			}
//결제취소			
			else{// 결제 취소 누름
				System.out.println("결제취소");
				콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다바구니; 
				콜라바구니=0; 환타바구니=0; 사이다바구니=0;
				
				
				
			}//결제취소
			
			
		
		
		}//ch4
		
		
		 재고관리=콜라재고+","+콜라바구니+","+콜라가격+","+"\n"
					+환타재고+","+환타바구니+","+환타가격+","+"\n"
					+사이다재고+","+사이다바구니+","+사이다가격+","+"\n";
		
	}//while
	
	
	}//main

}//class
