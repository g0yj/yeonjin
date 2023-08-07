package java1.day18.Ex2;

import java.util.Scanner;

public class 닌텐도 {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		//1. 게임패드 생성
		게임패드 유재석패드=null;
		while(true) {
			System.out.println("1.동물의 숲 2. 커비");
			int ch = sc.nextInt();
			
			if(ch==1) {
				유재석패드= new 동물의숲칩();
				System.out.println("동물의 숲 시작: ");
			}//if
			else if(ch==2) {
				유재석패드 = new 커비칩();
				System.out.println("커비칩 시작: ");
			}
		
			
			while(true) {
				String btn = sc.next();
				if(btn.equals("A")){유재석패드.A버튼();}//if
				if(btn.equals("B")){유재석패드.B버튼();}//if
				if(btn.equals("X")){유재석패드.X버튼();}//if
				if(btn.equals("Y")){유재석패드.Y버튼();}//if
				if(btn.equals("Q")){break;}//if
			
			}
			
		}//while
	}//main()
}//

