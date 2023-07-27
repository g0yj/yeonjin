package 복습.part2;

import java.util.Scanner;

public class part2_5 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		
		String 콜라 = 재고관리.split("\n")[0];
		String 환타 = 재고관리.split("\n")[1];
		String 사이다 = 재고관리.split("\n")[2];
		
		int 콜라재고=Integer.parseInt(콜라.split(",")[0]);
		int 콜라바구니=Integer.parseInt(콜라.split(",")[1]);
		int 콜라가격=Integer.parseInt(콜라.split(",")[2]);

		int 환타재고=Integer.parseInt(환타.split(",")[0]);
		int 환타바구니=Integer.parseInt(환타.split(",")[1]);
		int 환타가격=Integer.parseInt(환타.split(",")[2]);
		
		int 사이다재고=Integer.parseInt(사이다.split(",")[0]);
		int 사이다바구니=Integer.parseInt(사이다.split(",")[1]);
		int 사이다가격=Integer.parseInt(사이다.split(",")[2]);
		
		while(true) {
			System.out.println("1. 콜라 2. 사이다 3.환타 4.결제");
			System.out.println("제품선택: "); int ch= sc.nextInt();
			
			if(ch==1) {
				if(콜라재고>0) {
					System.out.println("바구니 담기");
					콜라재고--; 콜라바구니++;
					
				}//재고있
				else {
					System.out.println("재고부족");
					
				}//재고없
				
			}//ch1
			else if(ch==2){
				if(환타재고>0) {
					System.out.println("바구니 담기");
					환타재고--; 환타바구니++;
					
				}//재고있
				else {
					System.out.println("재고부족");
					
				}//재고없
				
			}//ch2
			else if(ch==3) {
				if(사이다재고>0) {
					System.out.println("바구니 담기");
					사이다재고--; 사이다바구니++;
					
				}//재고있
				else {
					System.out.println("재고부족");
					
				}//재고없
				
			}//ch3
			else {
				int 총가격= 콜라바구니*콜라가격+환타바구니*환타가격+사이다바구니*사이다가격;
				System.out.println("-----------------");
				System.out.printf("%5s%5s%5s","제품명","수량","가격");
				if(콜라바구니>0) {
					System.out.printf("%5s%5d%5d","콜라",콜라바구니,콜라가격*콜라바구니);
					
				}
				if(환타바구니>0) {
					System.out.printf("%5s%5d%5d","환타",환타바구니,환타가격*환타바구니);
				}
				if(사이다바구니>0) {
					System.out.printf("%5s%5d%5d","사이다",사이다바구니,사이다가격*사이다바구니);
				}
				
				System.out.println("총가격: "+총가격);
				
				System.out.println("1.결제 2.취소");
				
				System.out.println("투입금액: "); int input=sc.nextInt();
				if(input==1) {
					
				
					if(총가격<=input) {
						System.out.println("결제성공");
						System.out.println("잔액: "+(input-총가격));
						콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					}//결제성공
					else {//결제실패
						System.out.println("결제실패");
						콜라재고+=콜라바구니; 사이다재고+=사이다바구니; 환타재고+=환타바구니;
						콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					}
				}
				else if(input==2) {//결제취소
					System.out.println("결제취소");
					콜라재고+=콜라바구니; 사이다재고+=사이다바구니; 환타재고+=환타바구니;
					콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					
					}
				
					
				
			}//ch4
			재고관리 = 
		}
		
	}//main

}
