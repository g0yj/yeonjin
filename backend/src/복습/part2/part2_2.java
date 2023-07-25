package 복습.part2;

import java.util.Scanner;

public class part2_2 {

	public static void main(String[] args) {

		Scanner scanner= new Scanner(System.in);
		
		  String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		  
		  String 콜라= 재고관리.split("\n")[0];
		  String 환타= 재고관리.split("\n")[1];
		  String 사이다= 재고관리.split("\n")[2];
		  
		  int 콜라재고 = Integer.parseInt(콜라.split(",")[0]);
		  int 콜라바구니 = Integer.parseInt(콜라.split(",")[1]);
		  int 콜라가격 = Integer.parseInt(콜라.split(",")[2]);
		  
		  
		  int 환타재고 = Integer.parseInt(환타.split(",")[0]);
		  int 환타바구니 = Integer.parseInt(환타.split(",")[1]);
		  int 환타가격 = Integer.parseInt(환타.split(",")[2]);
		  
		  
		  int 사이다재고 = Integer.parseInt(사이다.split(",")[0]);
		  int 사이다바구니 = Integer.parseInt(사이다.split(",")[1]);
		  int 사이다가격 = Integer.parseInt(사이다.split(",")[2]);
		  
		 while(true) {
			 System.out.println("1.콜라 2.환타 3. 사이다 4.결제");
			 System.out.println("ch받기: "); int ch=scanner.nextInt();
			 
			 if(ch==1) {
				 if(콜라재고>0) {//재고 있음
					 System.out.println("장바구니담기");
					 콜라바구니++; 콜라재고--;
				 }
				 else {System.out.println("재고부족");
				 
				 }
				 
			 }//ch1

//------------------------------------------			 
			 else if(ch==2) {
				 if(환타재고>0) {//재고 있음
					 System.out.println("장바구니담기");
					 환타바구니++; 환타재고--;
				 }
				 else {System.out.println("재고부족");
				 
				 }
				 	 
			 }//ch2
//-------------------------------------------	
			 else if(ch==3) {
				 if(사이다재고>0) {//재고 있음
					 System.out.println("장바구니담기");
					 사이다바구니++; 사이다재고--;
				 }
				 else {System.out.println("재고부족");
				 
				 }
				 	 
			 }//ch3
			 else {//ch4선택
//----------------------------------------------	
				 System.out.println("-------출력-----------");
				 System.out.printf("%3s%3s%5s\n","제품명","수량","가격");
				
				 if(콜라바구니>0) {
					 System.out.printf("%3s%3d%5d\n","콜라",콜라바구니,콜라바구니*콜라가격);
				 }
				 if(환타바구니>0) {
					 System.out.printf("%3s%3d%5d\n","환타",환타바구니,환타바구니*환타가격);
				 }
				 if(사이다바구니>0) {
					 System.out.printf("%3s%3d%5d\n","사이다",사이다바구니,사이다바구니*사이다가격);
				 }
				 int 총금액= 콜라바구니*콜라가격+환타바구니*환타가격+사이다바구니*사이다가격;
				 System.out.println("총금액"+총금액);
		// 출력 유효성 끝---------------------------------
				 System.out.println("---------------------");
				 System.out.println("1. 결제 2.취소");
				 System.out.println("선택: "); int select=scanner.nextInt();
		// 결제선택		
				 if(select==1) {
					  System.out.println("받은돈: "); int 받은돈= scanner.nextInt();
					 if(받은돈>=총금액) {
						 System.out.println("결제성공");
					 }
					 else {
						 System.out.println("결제실패");
						 콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다재고;
						 콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					 }
					 
				 }
		//취소선택		 
				 else {//  취소선택
					 System.out.println("결제취소");
					 콜라재고+=콜라바구니; 환타재고+=환타바구니; 사이다재고+=사이다재고;
					 콜라바구니=0; 환타바구니=0; 사이다바구니=0;
					 
				 }
				 
			 }//ch4
			 
			 재고관리=콜라재고+","+콜라바구니+","+콜라가격+","+"\n"
					+환타재고+","+환타바구니+","+환타가격+","+"\n"
					+사이다재고+","+사이다바구니+","+사이다가격+","+"\n";
			 System.out.println(콜라재고);
		 }//while
		  
		  

	}

}
