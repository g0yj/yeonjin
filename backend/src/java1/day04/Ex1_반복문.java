package java1.day04;

import java.util.Scanner;

public class Ex1_반복문 {

	public static void main(String[] args) {

		/*		
		int sum = 0;
		sum= sum+1;		// sum+=sum
		
		//for문을 이용
		int sum2 = 0;
		for(int i= 1; i<=10; i++) {
			sum2+=i;
		}
		
		// p.124
		for(int i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		
		//p.126: 초기값 변수는 for에서 선언 시 지역변수임.
		int sum3 = 0 ;
		for(int 반복변수= 1; 반복변수<=10 ; 반복변수++) {
			sum3+=반복변수;
		}
			//System.out.println(반복변수); // 출력 안됨. for()에서 선언된 변수는 for{}  밖에서 사용 불가
			
		int sum4 = 0; int i;
		for(i =1 ; i<=100; i++) {sum4 += i;}
		System.out.println("1~"+(i-1)+"합: "+sum4);
		
		// p.127 실수	 ☆ 소수점 뒤에 f 사용하는 이유: 직접 작성한 리터럴 일땐 double이 기본형이기 때문에 써줘야됨.
		for(float x= 0.1f; x<=1.0f; x+=0.1f) {
			
		}
*/		
		//p.128 : 구구단
		for(int 곱 = 1; 곱 <=9; 곱++)	{System.out.println(2*곱+" ");}
			// 1. 2단~ 9단까지 for
		for(int 단 = 2; 단<=9; 단++) {}
			// 2. 1곱~9까지 for
		for(int 곱= 1; 곱<=9; 곱++) {}
			//3. 1,2 합치기 [단 마다 곱 실행(o) vs 곱 마다 단 실행]
		for(int 단 =2 ; 단<=9; 단++) {
			for(int 곱 = 1; 곱<=9; 곱++) {
				System.out.printf("%2d X %2d=%2d\n", 단, 곱, 단*9);
			}
		}
		
		
		//p.129와 124 비교. 1~10 출력
		
		//for 문
		 //for( int i=1; i<=10;i++){}
		
		//while 문
		int a= 1; 
		while(a<=10) {System.out.println(a+" "); a++;}
		
		//p.126
		int sum5=0;
		int b= 1;
		while(b<=100) {sum5+=b;b++;}
		
/*		
		//p.131 : 무한루트
		while(true) {System.out.println("무한반복");}

*/	
		Scanner scanner = new Scanner(System.in);
		boolean run = true;  // while문 t/f 저장하는 변수 , on/off 역할
		int speed = 0; // 현재 속도 저장하는 변수
		
		//while(run) {System.out.println("무한루프");
		//	}
		
		while(run) {//while 시작
			System.out.println("----------------------------------");
			System.out.println("1. 증속 |  2. 감속 |  3. 중지");
			System.out.println("-----------------------------------");
			// 무한입력
			String strNum = scanner.nextLine();
			
			if(strNum.equals("1")){// 만약에 입력이1이면
				speed++;
				System.out.println("현재속도= "+speed);
				
			}else if(strNum.equals("2")) {//만약 입력이 2이면
				speed--;
				System.out.println("현재속도= "+speed);
			}else if(strNum.equals("3")){// 만약 입력이 3이면
				run = false; //1번 방법 => 위치1
				break; //2번 방법- 가장 가까운 반복문 탈출 => 위치1
			//	return; //3번 방법 - 현재 함수 강제 반환/ 종료 => 위치2
				
			}//while 끝  . 위치1

			
			//p.135 -> for문에 식별이름 정의 => 
			//1. for 이름:for() {}
			//2.break;
				// 가장 가까운 반복문 탈출, continue for 이름
			//2. break for 이름;
				// 해당 for 탈출, 
			
			//3. continue;
				// 가장 가까운 반복문 증감식/ 조건식으로 이동
			//3. continue for 이름;
				// 해당 for 반복문 증감식/ 족ㄴ식 으로 이동;
			
			대문자for: for( char upper='A';upper<='Z';upper++) {
				System.out.print(upper+ " ");
				
				소문자for: for(char lower='a';lower<='z';lower++) {
					System.out.print("\t"+lower);
					// 특정 for break;
						//if(lower == 'g')break;
					if(lower =='g')break 대문자for;
				}//for 2end
			
			}//for 1 end
			
			//p.137
			for(int j=1; j<=10;j++) {
				if(j%2!=0) {//홀수 찾기
					continue; //fo으로 이동 // 아래에 있는 코드는 실행도지 않음
				}//if end
				System.out.println(j+ " ");
			}//continue for end
			
			
		}// main 끝 . 위치 2
	
	
	}//class 끝
	


}

/*
 * 		for문
 * 			for(초기값; 조건식; 증감식){
 * 				실행문;
 * 			}
 * 
 * 		1. 초기값 실행
 * 		2. 조건식 판단 : true일 시 {} 실행  / false이면 {}건너뜀(종료)
 * 		3. true 시 실행 문 실행
 * 		4. 초기값이 들어 있는 변수에 증감식
 * 		5. 조건식 판단해서 반복  ( 2->3->4 의 반복)
 * 
 * 		
 * 		while 문
 * 			1. 초기값 <- 필수 아님.
 * 			while(2.조건식){3. 실행문 4.*증감식 } <- 증감식은 필수 아님
 * 
 * 		- 초기값과 증감식은 필수가 아님
 * 		> 조건식 판단해서 true이면 {} 들어감. false이면 빠짐
 * 		> true이면 실행문 실행
 * 
 * 
 */
