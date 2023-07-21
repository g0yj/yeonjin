package 과제.과제6;

import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_배열 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] 재고관리 = { "10,0,300,콜라","100,0,200,사이다","10,0,100,환타"  };
		
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
		
			if(ch==1||ch==2||ch==3) {// 코드 줄이기. 1~3까지 인덱스만 다를 뿐 코드는 동일
				
				//배열호출
				//1. 배열변수명 호출
				System.out.println("배열의 변수명 호출" +재고관리);
				System.out.println("배열내 데이터 호출: "+Arrays.toString(재고관리)); 
				System.out.println("배열내 특정 데이터 개수: "+재고관리.length);
				System.out.println("배열내 특정(인덱스)호출: "+재고관리[0]);
				//놀라 메뉴 선택=1 , 콜라가 저장된 배열의 인덱스 0 (1-1)
				String 선택된제품정보= 재고관리[ch-1];	System.out.println((ch-1)+"선택된제품정보정보: "+선택된제품정보);
				//2. 배열내 데이터 분리
				int 선택된제품재고= Integer.parseInt(선택된제품정보.split(",")[0]);
				int 선택된제품바구니= Integer.parseInt(선택된제품정보.split(",")[1]);
				int 선택된제품가격= Integer.parseInt(선택된제품정보.split(",")[2]);
				// 3. 유효성검사를 통한 상태 변경
				if(선택된제품재고>0) {
					선택된제품재고--; 선택된제품바구니++;
					System.out.println(ch-1+"바구니에 담았음");
				}
				else {System.out.println("재고부족");}
				
				//4. 재고관리 업데이트
				재고관리[ch-1]= 선택된제품재고+","+선택된제품바구니+","+선택된제품가격;
			}//if(ch==1)끝
				
			
			if(ch==4) {
				System.out.println(Arrays.toString(재고관리));
				System.out.printf("%10s %10s \n","선택된제품바구니","선택된제품가격");
				for(int i = 0; i<재고관리.length;i++) {
					int 선택된제품바구니= Integer.parseInt(재고관리[i].split(",")[1]);
					int 선택된제품가격= Integer.parseInt(재고관리[i].split(",")[2]);
					
					
					
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 

/*

	 주제 : 키오스크(배열)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					재고 : 10 , 10 , 10
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







