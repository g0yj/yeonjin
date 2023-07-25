package 복습.part2;

import java.util.Scanner;

public class part2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner ( System.in);
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";

		// 콜라, 환타, 사이다 분리
		String 콜라= 재고관리.split("\n")[0];
		String 환타 = 재고관리.split("\n")[1];
		String 사이다 = 재고관리.split("\n")[2];
		
		int 콜라재고= Integer.parseInt(콜라.split(",")[0]);
		int 콜라바구니= Integer.parseInt(콜라.split(",")[1]);
		int 콜라가격= Integer.parseInt(콜라.split(",")[2]);
		
		int 환타재고= Integer.parseInt(환타.split(",")[0]);
		int 환타바구니= Integer.parseInt(환타.split(",")[1]);
		int 환타가격= Integer.parseInt(환타.split(",")[2]);
		
		int 사이다재고= Integer.parseInt(사이다.split(",")[0]);
		int 사이다바구니= Integer.parseInt(사이다.split(",")[1]);
		int 사이다가격= Integer.parseInt(사이다.split(",")[2]);
		
		while(true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 콜라 2. 환타 3. 사이다 4.결제");
			System.out.println("---------------------------------------------------");
			System.out.println("메뉴선택: "); int ch= scanner.nextInt();
			
			if(ch==1) {
				if(환타바구니>=0) {
					환타바구니++;
					환타재고--;
					System.out.println("바구니 담은: "+ 환타바구니);
					}// 재고있
				else {//재고 없
					System.out.println("재고부족");
				}//제고없
			}
			
//ch3------------------------------------------			
			else if(ch==3) {
				if(사이다바구니>=0) {

					System.out.println("바구니 담음: "+ 사이다바구니);
				}//재고있
				else {//재고 없
					System.out.println("재고 부족");
				}//재고 없
				
			}
//ch4-------------------------------------------		
			else if(ch==4) {
				System.out.println("----------------------------------");
				System.out.println("%10s%5s%5s","제품명","수량","가격");
				System.out.println("----------------------------------");
			// 바구니가 0보다 컸을 때 출력	
				if(콜라바구니>=0)
				
			}
				
			
			
			
			
		}//while
	}

}
