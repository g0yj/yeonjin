package 과제.과제5;

import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String 재고관리;
		
		재고관리="3,0,300\n2,0,200\n1,0,100\n";
		
		// \n에 따른 분리
		String 제품 = Arrays.toString(재고관리.split("\n"));
		System.out.println(제품);
		System.out.println(재고관리.split("\n"));
		
		String 콜라 = 재고관리.split("\n")[0];
		String 사이다 = 재고관리.split("\n")[1];
		String 환타 = 재고관리.split("\n")[2];
		
		String 콜라재고= 콜라.split(",")[0];
		
		while(true) {
			
		System.out.println("--------------------------------------------");
		System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
		System.out.println("--------------------------------------------");
		
		System.out.println("ch선택: "); int ch= scanner.nextInt();
//------------		
		if(ch==1) {
			System.out.println("콜라제품상태[0]" + 재고관리.split("\n"));
			System.out.println("콜라재고: " +콜라[0]+"콜라바구니: "+콜라[1]+"콜라가격: "+콜라[2]);
			
		}
		else if(ch==2) {
		}
//-------------------------			
		else if(ch==3) {
			
		}
//--------------------------------
		else if(ch==4) {
			
		}
		
		
		
		}//while

	}

}
