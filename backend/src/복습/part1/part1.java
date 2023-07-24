package 복습.part1;

import java.util.Scanner;

public class part1 {

public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	
    int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
     
    		
    while(true) {
    	System.out.println("1.콜라 2.사이다 3.환타 4.결제");
    	System.out.println("--------------------------");
  
    	int ch= scanner.nextInt();
  //재고가 있을경우 바구니 담기 / 없으면 '재고부족' 출력
    	
  //콜라-------------------------------------------------  	
    	if(ch==1) {//콜라 if
    		if(콜라재고>0) {//재고가 있을 경우
    			System.out.println("장바구니 담음");
    			콜라바구니++;
    			콜라재고--;
    			System.out.println("콜라바구니: " +콜라바구니+ "  "+"콜라재고: "+콜라재고);
    		}//콜라재고가 있을 때
    		else {//콜라재고없을때
    			System.out.println("재고부족");
    		}
    		
    	}//콜라if
    	
  // 환타-----------------------------------------------  	
    	else if(ch==2) {//환타 if
    		if(환타재고>0) {//환타 재고가 있을 경우
			System.out.println("장바구니 담음");
			환타바구니++;
			환타재고--;
			System.out.println("환타바구니: " +환타바구니+ "  "+"환타재고: "+환타재고);
		}//환타재고가 있을 때
		else {//환타재고없을때
			System.out.println("재고부족");
		}//환타재고 없을때
    		
    	}//환타if
    	
   //사이다---------------------------------------------- 	
    	else if(ch==3) {
    		if(사이다재고>0) {//재고가 있을 경우
    			System.out.println("장바구니 담음");
    			사이다바구니++;
    			사이다재고--;
    			System.out.println("사이다바구니: " +사이다바구니+ "  "+"사이다재고: "+사이다재고);
    		}//사이다재고가 있을 때
    		else {//사이다재고없을때
    			System.out.println("재고부족");
    		}
    	}//사이다if
    	
  //결제------------------------------------------------------  	
    	else if(ch==4) {//결제 선택 if
    		System.out.println("---------------현재 바구니 현황 표시 목록--------- ");
    		System.out.printf("%5s%5s%5s", "제품명","수량","가격");
    		
    		if(콜라바구니>0) {// 콜라가 장바구니에 있을때 출력
    		System.out.printf("%5s%5d%5d\n","콜라" ,콜라바구니, 콜라바구니*콜라가격);
    		}// 콜라가 장바구니에 있을때 출력
    		if(환타바구니>0) {// 환타가 장바구니에 있을때 출력
    			System.out.printf("%5s%5d%5d\n","환타" ,환타바구니, 환타바구니*환타가격);
    		}// 환타가 장바구니에 있을때 출력
    		if(사이다바구니>0) {//사이다 장바구니 있을 때
    			System.out.printf("%5s%5d%5d\n","사이다" ,사이다바구니, 사이다바구니*사이다가격);
    		}//사이다 장바구니 없을 때
    	
    		System.out.println("--------------------------");
    		System.out.println("1. 결제  2. 취소");
    		
    		System.out.println("결제/취소 선택: "); int select= scanner.nextInt();
    		System.out.println("받은 금액: "); int input= scanner.nextInt();
    		int totalPrice= 콜라바구니*콜라가격+환타바구니*환타가격+사이다바구니*사이다가격;
  
    		// 결제- 결제성공-----------------------------------------------
    		
    		if(totalPrice>=input) {
    			System.out.println("잔액:  "+ (input-totalPrice));
    			콜라바구니=0; 사이다바구니 = 0; 환타바구니=0;
    			
    		}// 결제성공
    		//결제 실페-----------------------------------------------
    		else {//결제실패
    			콜라재고+=콜라바구니;
    			환타재고+=환타바구니;
    			사이다재고+=사이다바구니;
    			콜라바구니=0; 사이다바구니 = 0; 환타바구니=0;
    				}//결제실패
    		
    	}//결제 if
    	else {//취소선택
    		콜라재고+=콜라바구니;
    		환타재고+=환타바구니;
    		사이다재고+=사이다바구니;
    		콜라바구니=0; 사이다바구니 = 0; 환타바구니=0;
    		
    	}	//취소선택
    	
    	
    }//while
	
	
	}//main
}//class
