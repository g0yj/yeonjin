package 과제.과제3.Level2.ex1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level2_1 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level2_1 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		
		while( true ) {
			System.out.print(" 음악 재생 중 종료버튼[x] : ");
			char btn = scanner.next().charAt(0);
			
			
		
			 
		/* 문제풀이 위치 */
			
		/* ----------- */

		} //while 끝
	}// main 끝
}// class 끝
/* 
	[문제] 음악 재생이 반복적으로 재생되고 있습니다. x 입력하면 종료되도록 하세요
	[조건] 1. 문제풀이 위치 외 코드는 수정 불가 합니다.

*/

/*
기본형 변수인 char는 단 한 글자만 저장할 수 있는 변수임.

Scanner로 입력을 받을 때는 String 타입으로 밖에 받을 수 없음.

그래서 등장한 것이 바로 charAt()로 해결.

String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환.
 */