package 복습.part3;

import java.util.Arrays;
import java.util.Scanner;

public class part3 {
	public static void main(String[] args) {
		
	Scanner sc= new Scanner(System.in);
		
	String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		
	
	 while(true) {
		 System.out.println("1.콜라 2. 사이다 3. 환타 4. 결제");
		 System.out.print("메뉴선택: "); int ch = sc.nextInt();
		 
		 String 선택음료 = 재고관리[ch-1];
		 
		 int 재고 = Integer.parseInt(선택음료.split(",")[0]);
		 int 바구니 = Integer.parseInt(선택음료.split(",")[1]);
		 int 가격 = Integer.parseInt(선택음료.split(",")[2]);
		 String 제품명 = 선택음료.split(",")[3];
		 
		 if(ch==1||ch==2||ch==3) {//1~3 음료선택
			 if(재고>0) {//재고 있으면
				 System.out.println("장바구니 담기");
				 바구니++; 재고--;
				 System.out.println("바구니상태: "+바구니 +"재고상태: "+재고);
			 }//재고있으면
			 else {//재고 없으면
				 System.out.println("재고부족");
				 System.out.println("바구니상태: "+바구니 +"재고상태: "+재고);
			 }//재고없
		 }//음료선택
		 else {//ch4
			 System.out.println("-------------------------");
			 System.out.printf("%5s%5s%5s","제품명","수량","가격");
			 
			 if(바구니>0) {//바구니 있
				 System.out.printf("%5s%5d%5d",제품명,바구니,바구니*가격);
			 }//바구니 있다면 출력
		
			 
		 }//ch4

	 }
	 
		
	}//main

}//class
