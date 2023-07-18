package 과제.과제3.Level2;

import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		/* -------문제1----- */
//문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]	
/*		System.out.println("정수1입력: ");		int 정수1 = scanner.nextInt();
		System.out.println("정수2입력: ");		int 정수2 = scanner.nextInt();
		
		if(정수1<정수2) {System.out.println("더 큰수는 " + 정수2);}
		else if(정수1>정수2) {System.out.println("더 큰수는 " + 정수1);}
		else {System.out.println("두 정수는 같음");}
*/			
		
		/* -------문제2----- */
// 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
/*
		System.out.println("정수1: ");	int 정수1 = scanner.nextInt();
		System.out.println("정수2: ");	int 정수2 = scanner.nextInt();
		System.out.println("정수3: ");	int 정수3 = scanner.nextInt();
		
		int max = 정수1;
		max= max<정수2?정수2:max;
		max=max<정수3?정수3:max;
		
		System.out.println("가장 큰 수: "+max);
		
		// 수업 중 한 방법-------------
		 1. max 변수를 사용(많은 데이터 처리 시 가장 좋은 방법)
		 
		 int max= 정수1
		 if(max<정수2){max=정수2;}
		 if(max<정수3){max=정수3;}
		 System.out.println("가장 큰 수: "+max);
		 
		 2. 논리를 사용

		if(정수1>정수2){ // 첫번째 값이 두번째 값보다 컸을 때
			if(정수1>정수3){ System.out.println("가장 큰 수: "+정수1);}
			else { System.out.println("가장 큰 수: "+정수3);}
		}else if(정수2>정수3){
			if(
		}
		
		
*/	
		
		/* -------문제3-------------------------*/
// 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ]	
		
		System.out.println("정수1: ");	int 정수1 = scanner.nextInt();
		System.out.println("정수2: ");	int 정수2 = scanner.nextInt();
		System.out.println("정수3: ");	int 정수3 = scanner.nextInt();
		
		if(정수1>정수2) {// 조건이 충족하면 자리를 바꿈 temp사용
			int temp=정수1;
			정수1=정수2;
			정수2=temp;
		}
		
		
		if(정수1>정수3) {
			int temp=정수1;
			정수1=정수3;
			정수3=temp;
			
		}
		if(정수2>정수3) {
			int temp=정수2;
			정수2=정수3;
			정수3=temp;
		}
		
		System.out.printf("문제3: %3d %3d %3d \n ", 정수1, 정수2, 정수3);
 	
		
		/* -------문제4----- */
// 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
/*		System.out.println("정수: ");	int 정수= scanner.nextInt();
		
		if(정수>=90) {System.out.println("합격");}
		else {System.out.println("불합격");}
*/		
		
		
		/* -------문제5----- */
	 	// 문제5 : 
				// 점수를 입력받아 점수가 90점 이상이면 A등급
				//				점수가 80점 이상이면 B등급
				//				점수가 70점 이상이면 C등급
				//				그외 재시험
/*		
		System.out.println("점수: ");   int 점수 = scanner.nextInt();
		
		if(점수>=90) {System.out.println("A등급");}
		else if(점수>=80) {System.out.println("B등급");}
		else if(점수>=70) {System.out.println("C등급");}
		else {System.out.println("재시험");}
*/		
		
		/* -------문제6----- */
/*
		문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
*/	
		System.out.println("국어점수: ");		int 국어=scanner.nextInt();
		System.out.println("영어점수: ");		int 영어=scanner.nextInt();
		System.out.println("수학점수: ");		int 수학=scanner.nextInt();
		
		int 평균= (국어+영어+수학)/3; // 소수점까지 하고 싶다면 (double) 3.0으로 나눠줌
		
		if(평균>=90) {
			if(국어>=100) {System.out.println("국어우수");}
			if(영어>=100) {System.out.println("영어우수");}
			if(수학>=100) {System.out.println("수학우수");}
		}
		else if(평균>=80) { // 평균이 80점 이상이면서 국어는 100점 일 수 있음. 이럴 때는 조건 추가해야됨~!
			if(국어>=90) {System.out.println("국어장려");}
			if(영어>=90) {System.out.println("영어장려");}
			if(수학>=90) {System.out.println("수학장려");}
		}
		else {System.out.println("재시험");}
		
		
		
		
		
		/* -------문제7----- */
/*	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
*/
		System.out.println("아이디: "); String 아이디=scanner.next();
		System.out.println("비밀번호: "); String 비밀번호=scanner.next();
		
		if(아이디.equals("admin")&&비밀번호.equals("비밀번호")) { // 아이디가 틀렸는지 패스워드가 틀렸는지 구별이 어려움. 2번 방법 추천
			System.out.println("로그인 성공");
		} else {System.out.println("로그인 실패");}
		
		// 2. 풀이: 중첩 사용
		if(아이디.equals("admin")) {
			if(비밀번호.equals("1234")) {System.out.println("로그인 성공");}
			else {System.out.println("로그인 실패. 패스워드 다름");}
		}
			else {//admin이 아닐때
				System.out.println("로그인실패. 없는 아이디");}
			
		
		
		
		
	}
	
}


