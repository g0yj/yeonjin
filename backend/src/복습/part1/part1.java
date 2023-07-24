package 복습.part1;

import java.util.Scanner;

public class part1 {

public static void main(String[] args) {
	
	
	
	
/*	   1. 콜라 2.사이다 3.환타 4.결제
       [ 1~3 선택시 ]
           - 재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력
 */   	
	Scanner scanner= new Scanner(System.in);
	
	  int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	  int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	  int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
    	
	  while(true) {//while
		  System.out.println("1. 콜라 2. 사이다 3. 환타 4.결제");
	
		  
		 System.out.print("ch 선택:  "); int ch= scanner.nextInt();
//ch 선택		  
		  if(ch==1) {//콜라선택
			  if(콜라재고<=0) {
				  System.out.println("재고부족");
				  
			  }//콜라재고없을때
			  else {//콜라재고있을때
				  System.out.println("장바구니 담음");
				  콜라바구니++;
				  콜라재고--;
				  System.out.println("바구니상태: "+콜라바구니+"재고상태: "+콜라재고);
				  
			  }//콜라재고 있을때
			  
		  }//콜라선택
//-ch2-------------------------------------------------		  
		  else if(ch==2) {//사이다선택
			  if(사이다재고<=0) {
				  System.out.println("재고부족");
				  
			  }//사이다재고없을때
			  else {//사이다재고있을때
				  System.out.println("장바구니 담음");
				  사이다바구니++;
				  사이다재고--;
				  
			  }//사이다 있을때
			  
		  }//사이다선택

//- ch3-------------------------------------------
		  
		  else if(ch==3) {
			  if(환타재고<=0) {
				  System.out.println("재고부족");
				  
			  }//환타재고없을
			  else { 
			  System.out.println("장바구니 담음");
				  환타바구니++;
				  환타재고--;
				  
			  }//환타재고 있을때
			  
		  }//환타선택
//ch-4-------------------------------------------------		  
		  else if(ch==4) {
			  System.out.println("-----------------------");
			  System.out.printf("%5s%10s%10s\n", "제품명","수량","가격");
			
		//장바구니 있을때만 출력-----------------------------------------
				  if(콜라바구니!=0) {//바구니 있을때
					  System.out.printf("%5s%10s%10s\n","콜라",콜라바구니,(콜라가격*콜라바구니));
				  }//바구니 있을때
				  if(사이다바구니!=0) {
					  System.out.printf("%5s%10s%10s\n","사이다",사이다바구니,사이다가격*사이다바구니);
				  }
				  if(환타바구니!=0) {
					  System.out.printf("%5s%10s%10s\n","환타",환타바구니,환타가격*환타바구니); 
				  }
			  System.out.println("---------------------------------");
			  System.out.println("1. 결제  2. 취소");
			  System.out.print("결제 /취소 선택: "); int select = scanner.nextInt();
		//결제 선택-----------------  
			  int 총금액= 콜라가격*콜라바구니+사이다가격*사이다바구니+환타가격*환타바구니;
			  System.out.println("넣은금액: "); int 넣은금액 =scanner.nextInt();
			  
			  if(select==1) {
				  if(총금액<=넣은금액) {// 결제성공
					  System.out.println("결제성공");
					  콜라바구니=0; 사이다바구니=0; 환타바구니=0;
					  System.out.println("콜라바구니상태: "+콜라바구니);
				  }//결제성공
				  else {//결제실패
					  System.out.println("금액부족");
					  콜라재고+=콜라바구니; 환타재고+=환타바구니; 환타재고+=환타바구니;
					  콜라바구니=0; 사이다바구니=0; 환타바구니=0;
				  }//결제실패
				 
			  }
		//취소 선택------------	  
			  else { //취소선택
				  System.out.println("결제 취소");
				  콜라바구니=0; 사이다바구니=0; 환타바구니=0;
			  }//취소선택
			  
		  }//ch4선택
		  
		  
		  
		  
		  
	  }//while
	
	
	}//main
}//class
