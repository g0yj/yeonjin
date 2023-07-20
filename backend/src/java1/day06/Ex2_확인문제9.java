package java1.day06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_확인문제9 {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		int count=0;  // 2번을 위해 1번에서 받은 값을 저장해야됨.
		int[] scores= new int[count];// 2번을 위해 1번에서 받은 값을 저장해야됨.
		
//1. 되풀이할 출력문 만들기 [종료조건: 4번을 입력하면]------------------------------------------------------
		while(true) {
		System.out.println("---------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("---------------------------------------------");
		System.out.print("> 선택: ");
			
//2. 경우의 수에 따른 실행 => 5가지.-------------------------------------------------------------------
		
		//2-1 입력 받기
		String ch = scanner.nextLine();
		
		//2-2 입력에 따른 경우의 수  // nextLine으로 받았기 때문에 ==가 아닌 .equals()사용
		if(ch.equals("1")){
			System.out.print("학생수: ");
			//변경 . 바뀐 결과 전역변수에 저장됨! 
			count=Integer.parseInt(scanner.nextLine());
			System.out.println("입력한 학생수: "+count);
			//변경
			scores= new int[count];
				System.out.println(Arrays.toString(scores));
			}
		
		if(ch.equals("2")){
			//1번 기능에서 입력받은 수만큼 ??? -> 1번에서 입력 받은 걸 쓸 수 없음 {} 빠져 나오면 삭제되니까. 1번에서 변수 만들어줘야됨
			
			System.out.println(count); System.out.println(scores);
			//입력 받은 수 만큼 점수
			
			for(int i=0; i<count;i++) {//입력 받은 정수를 배열내 각 인덱스에 저장(변경)
				
				System.out.print(i+" 인덱스의 저장할 학생 점수 입력: ");	
				scores[i]= Integer.parseInt(scanner.nextLine()); //문자열 입력 받아 정수로 변환
				}	
				System.out.println(Arrays.toString(scores));
			}
		
		if(ch.equals("3")){
			for(int i =0; i<scores.length; i++) {
				System.out.println(i+"인덱스의 저장된 학생 점수"+scores[i]);
			}
		}
		if(ch.equals("4")) {
			int sum= 0; //배열 내 데이터를 모두 더한 값을 저장하는 변수
			int max=0; //배열 내 데이터 중에 가장 큰 값을 저장하는 변수
			
			//배열 내 모든 데이터 호출
			for(int i=0; i<scores.length;i++) {
				//1. 평균
				sum+=scores[i]; // i번째 데이터를 sum변수에 추가/누계;
				//2. max
				if(max<scores[i]) //만약 i번째 데이터가 max보다 클때
					{max=scores[i];}
			}
			System.out.println("평균: "+((double)sum/count));
			System.out.println("최고점수: "+max);
			
		}
		if(ch.equals("5")) {
			System.out.println("프로그램 종료"); break;
			}
		}//while끝
		
		
			
/*
 설계조건
- 학생수를 입력 받아 입력 받은 학생 수만큼 정수를 입력 받아 저장
- 현재 점수 출력/통계
 
 1. 학생수
 	- 학생수를 입력 받아 변수에 저장
 	- 그 학생수만큼 배열 선언 [+메모리할당] 타입[] 변수명 = new 타입 [길이]
 
 2. 점수입력
 	- 몇개 점수를 입력? -> 학생 수에 따라 달라짐 - > 배열 사용(효율적)
 	- 1번 기능에서 할당된 배열만큼 점수를 입력받아 각 인덱스에 저장
 		※ 학생수 입력 받지 않고 점수입력하면 오류 발생 
 
 3. 점수리스트
 	- 2번기능에서 저장된 배열 내 모든 인덱스 데이터 호출
 	
 
 4. 분석
 	- 2번 기능에서 저장된 배열 내 모든 인덱스 데이터를 가져와 max
 	- avg
 	
 5. 종료
 	- 무한루프 종료, break;
 */		
		
		
	/*
	 * nextLine() 사용 시 다른 next~() 앞뒤로 존재 했을 때 하나로 인식 (오류는 아닌데 오류같이 보일 수 있음)
	 * 해결 방법
	 * 1. Integer.parseInt(scanner.nextLine()); 사용
	 * 2. 
	 * 	String 문자 = scanner.nextLine();
	 * 	int 정수 = scanner.nextInt();
 		scanner.nextLine(); !! 의미없는 nexLine() 추가해서
	 * 	String 문자 = scanner.nextLine();
	 * 
	 */	
		
	
		
	
		
	}//main

}//class
