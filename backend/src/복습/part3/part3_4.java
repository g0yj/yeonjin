package 복습.part3;

import java.util.Scanner;

public class part3_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
		
		while(true) {
			System.out.println("1.콜라 2.사이다 3. 환타 4. 결제");
			System.out.println("메뉴선택: "); int ch=sc.nextInt();
			
			if(ch==1||ch==2||ch==3) {
				String 제품 = 재고관리[ch-1];
				
				int 재고 = Integer.parseInt(제품.split(",")[0]);
				int 바구니 = Integer.parseInt(제품.split(",")[1]);
				int 가격 = Integer.parseInt(제품.split(",")[2]);
				String 제품명 = 제품.split(",")[3];
				
				if(재고>0) {
					System.out.println("바구니담기");
					바구니++; 재고--;
				}//if
				else {
					System.out.println("재고부족");
					
				}//else
				재고관리[ch-1]=재고+","+바구니+","+가격+","+제품명;
			}//ch3
			else {
				System.out.println("바구니상태");
				System.out.printf("%5s%5s%5s\n","제품명","수량","가격");
				
				for(int i=0; i<재고관리.length;i++) {
					String 제품 = 재고관리[i];
					int 바구니 = Integer.parseInt(제품.split(",")[1]);
					int 가격 = Integer.parseInt(제품.split(",")[2]);
					String 제품명 = 제품.split(",")[3];
					
					if(바구니>0) {//바구니 있으면 출력
					System.out.printf("%5s%5d%5d\n",제품명,바구니,바구니*가격);
					}
				}//for
			}//ch4
				
		}
	}//main
}
