package 복습.part3;

import java.util.Scanner;

public class part3_1 {
  public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
	
	while(true) {
		System.out.println("1.콜라 2.환타 3.사이다 4.결제");
		System.out.println("메뉴선택: "); int ch = sc.nextInt();
		
		
	
		if(ch==1||ch==2||ch==3) {//음료선택
			String 선택음료=재고관리[ch-1];
			
			int 재고 = Integer.parseInt(선택음료.split(",")[0]);
			int 바구니 = Integer.parseInt(선택음료.split(",")[1]);
			int 가격 = Integer.parseInt(선택음료.split(",")[2]);
			String 제품명=선택음료.split(",")[3];
			System.out.println(재고+","+바구니+","+가격+","+제품명);
			if(재고>0) {
				System.out.println("바구니 담기");
				바구니++; 재고--;
				System.out.println("바구니상태: "+바구니 +"재고상태: "+재고);
			}//재고 있으면
			else {
				System.out.println("재고 없음");
			}//재고없으면
			재고관리[ch-1]=재고+","+바구니+","+가격+","+제품명;
		}//음료선택
		else {//ch4 선택
			System.out.println("----------바구니 상태 ----------");
			System.out.printf("%5s%5s%5s\n","제품명","수량","가격");
			
			for(int i=0; i<재고관리.length;i++) {
				
				String 선택음료=재고관리[i];
				int 바구니 = Integer.parseInt(선택음료.split(",")[1]);
				int 가격 = Integer.parseInt(선택음료.split(",")[2]);
				String 제품명=선택음료.split(",")[3];
				
				
				
				if(바구니>0) {//바구니에 있으면 출력
					System.out.printf("%5s%5d%5d\n",제품명,바구니,바구니*가격);
				}//바구니에 있으면 출력
			}//for 끝
			
		}//ch4선택
		
	}//while
  }//main
}//clss
