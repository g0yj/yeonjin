package 과제.과제5;

import java.lang.reflect.Array;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
/*		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
		// 샘플 : 
				이름 : 콜라 , 환타 , 사이다
				가격 : 300 , 200 , 100
				재고 : 10 , 10 , 10
				바구니 : 0 , 0 , 0
*/
		
		

		
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		
		
//1. 임의의 구분에 따른 여러 데이터를 하나의 문자열로 저장----------------------------------------------------------------		
		//1. 필드(상태,속성) 간의 구분을 ','을 선택 <-본인 마음임
		// 재고관리 = "10,0,300~ \n200,10,0\n100,10,0";
		
		//2. 필드의 단위별 묶음 \n을 채택 
		재고관리="10,0,300\n10,0,200\n10,0,100\n"; // 별도로 문서화 해줘야 보는 사람이 구별할 수 있음.
		System.out.println(재고관리);
//2. 임의의 구분에 따른 하나의 데이터를 여러 데이터로 변환(파싱)------------------------------------------------------------		
		//3.임의의 구분(문자)을 기준으로 분리= .split() 을 사용
		//"10,0,300\n,10,0,200\n,~"-> \n으로 하면 4조각
			//1조각:10,0,300  2조각:10,0,200   3조각:10,0,100  4조각:
		System.out.println ( Arrays.toString(재고관리.split("\n")));		//[10,0,300,10,0,200,10,0,100]
		System.out.println("1조각: "+재고관리.split("\n")[0]); //10,0,300
		System.out.println("2조각: "+재고관리.split("\n")[1]); //10,0,300
		System.out.println("3조각: "+재고관리.split("\n")[2]); //10,0,300
		
		String 콜라정보=재고관리.split("\n")[0];
		String 환타정보=재고관리.split("\n")[1];
		String 사이다정보=재고관리.split("\n")[2];
		
		
		int 콜라재고 =Integer.parseInt( 콜라정보.split(",")[0]);  // 콜라는 문자고 콜라정보는 숫자를 원함. 변환을 위한 형변환 필요 , Integer.parseInt 사용
		int 환타재고 =Integer.parseInt( 환타정보.split(",")[1]);  
		int 사이다재고 =Integer.parseInt( 사이다정보.split(",")[2]);  
		
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
			// 재고관리 콜라/환타/사이다로 분리 
			String 콜라 = 재고관리.split("/")[0];
			String 환타 = 재고관리.split("/")[1];
			String 사이다 = 재고관리.split("/")[2];

//콜라선택----------------------------------------------------------			
			if(ch==1) {
				String 콜라1=콜라.split(",")[0];
			}
//환타선택-------------------------------------------------------------			
			else if(ch==2) {
				
			}
//사이다선택----------------------------------------------------
			else if(ch==3) {
				
			}
//결제------------------------------------------------------------------
			else if(ch==4) {
				
			}
			
			
			
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







