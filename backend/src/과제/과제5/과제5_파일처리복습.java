package 과제.과제5;

import java.util.Arrays;
import java.util.Scanner;

public class 과제5_파일처리복습 {

	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		String[] 재고관리 = new String[100];
		
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			if( ch == 1 || ch == 2 || ch==3  ) {
				String product = 재고관리[ch-1];	
					System.out.println( ch+1 + " 번 제품 : " + product );
				
				int stock = Integer.parseInt( product.split(",")[0] );
				int basket = Integer.parseInt( product.split(",")[1] );
				int price = Integer.parseInt( product.split(",")[2] );
				String name =  product.split(",")[3] ;
				
				// 3. 유효성검사를 통한 상태 변경 
				if( stock > 0 ) { 
					stock--; 	basket++; System.out.println( name+ " 바구니 담았습니다.");
				}
				else {System.out.println(" 재고 부족 ");}
				재고관리[ch-1] = stock+","+basket+","+price+","+name;
			}
			else if( ch == 4 ) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for( int i = 0 ; i<재고관리.length ; i++ ) {
					int basket = Integer.parseInt( 재고관리[i].split(",")[1] );
					int price = Integer.parseInt( 재고관리[i].split(",")[2] );
					String name = 재고관리[i].split(",")[3];
					
					if( basket > 0 ) { 
						System.out.printf( "%10s %10s %10s \n" , name ,  basket , basket*price );
					}
				}
			}
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 

/*
 * 
 *이클립스에서 실행 중에 필요한 메모리(변수,객체,배열 등)은 주기억장치 <-휘발성
 *따라서 이를 영구 저장할 수 있는 과정이 필요. (현재 실행 중인 메모리를 c드라이브에 저장/호출)
 *
 * String a= scanner.next(); ---------->c:저장  [파일처리, 데이터베이스]
 * 컴퓨터 종료 후 다음날
 * String b=           <-----------------c: 불러오기[파일처리, 데이터베이스]
 * 
 */
  // 파일처리 라이브러리 사용
  // 1. FileOutputStream: 파일 내보니개/저장 관련 메소드 제공하는 클래스
		//1. 해당 파일과 연동/연결
		//new FileOutputStream("파일경로"); 
		// java 상대경로: 프로젝트 명을 생략 - > ./src/패키지명/파일명
		//여기까지만 하면 무조건 오류. 스트림(자바 외부와 통신할 때 사용되는 통로로 *바이트단위로 이동)
									// 통신 과정에 갑자기 오류 발생할 수 있음(자바 내인지 외부인지 판단 불가. *예외처리필수)
		// FileOutputStream fileOutputStream= new FileOutputStream("./src/과제/과제5/파일처리복습_txt");
		
		FileOutputStream fileOutputStream= new FileOutputStream("./src/과제/과제5/파일처리복습_txt");
		