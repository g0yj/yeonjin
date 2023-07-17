package 과제.과제2;

import java.awt.SystemColor;
import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		//------ 문제1 여기에 풀이-------//
/*
		System.err.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
*/		
		
		//------ 문제2 여기에 풀이-------//
		
//문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
/*
		Scanner sc= new Scanner(System.in);
		String 작성자 =sc.next();
		
		Scanner sc1= new Scanner(System.in);
		String 내용=sc1.next();
		
		Scanner sc2= new Scanner(System.in);
		String 날짜= sc2.next();
		
		System.out.println("--------------방문록--------------------");
		System.out.println("|  1   | 작성자 |   내용  |  날짜    | ");
		System.out.println("| 순번  |"+ 작성자+" |  "+내용+"   |"+날짜+"  |");
		System.out.println("--------------------------------------");

 		※ 위 문제에서 모양을 맞추는게 쉽지 않음. 자리수를 맞춤으로써 깔끔한 정리 가능 (printf)
*/	
		
		
		//------ 문제3 여기에 풀이-------//
/*
 * 		※Scanner sc = new Scanner(System.in) 을 반복해서 쓸 수 없고 변수명이 겹치는 불편함이 있음.
 * 			전역변수에 부여함으로써 편하게 사용 가능
 *  		
		Scanner sc= new Scanner(System.in);
		int 기본급= sc.nextInt();
		
		Scanner sc1= new Scanner(System.in);
		int 수당=sc1.nextInt();
		
		int 실수령액=(int) (기본급+수당-(기본급*0.1));
		
		System.out.println("실수령액은 "+실수령액);
		
*/		
	
		//------ 문제4 여기에 풀이-------//
/*	
		Scanner sc= new Scanner(System.in);
		
		int 금액= sc.nextInt();
		
		int 십만원권= (int)(금액/100000);
		int 만원권=(int)((금액-100000*(십만원권))/10000);
		int 천원=(int)((금액-100000*(십만원권)-10000*(만원권))/1000);
		int 백원=(int)((금액-100000*(십만원권)-10000*(만원권)-1000*(천원))/100);
		System.out.println("십만원 :"+십만원권);
		System.out.println("만원권 :"+만원권);
		System.out.println("천원 :"+천원);
		System.out.println("백원: "+백원);
		
		※
		1번
		금액-= (금액/100000)*100000;  <- 원금에서 3십만원 제외
		System.out.println("만원권: "+(금액/10000));
		
		2번
		String.valueOf(금액).cahrAt(1);  <-추후 배울 예정
		
		3. 나머지로 구하는 방법
		
		
		
*/	
		
		//------ 문제5 여기에 풀이-------//

/*
		Scanner sc= new Scanner(System.in);
		int 정수= sc.nextInt();
		
		
		System.out.println((정수%7==0)?"o":"x" );

		
		※
		char 결과 = (정수%7==0)?"o":"x"
		System.out.println(결과);
	
*/
		
		
		//------ 문제6 여기에 풀이-------//
/*
		Scanner sc= new Scanner(System.in);
		int 정수= sc.nextInt();
		
		char 결과 = (정수%2==0)?'o':'x';
		
		System.out.print("결과: ");
		System.out.println(결과);
*/		
		

		


       //------ 문제7 여기에 풀이-------//
		
/*		 
		 문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

		Scanner sc= new Scanner(System.in);
		
		System.out.print("정수 입력:");	int 정수= sc.nextInt();
 		
 		System.out.println((정수%7==0&&정수%2==0)?"o":"x");
*/
		
		
		//------ 문제8 여기에 풀이-------//

/*
 문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]
	
		System.out.print("정수8 : "); 	int 정수8 = scanner.nextInt();
		System.out.println("문제8 결과 : " + ( 정수8 % 7 == 0 || 정수8 % 2 == 1 ? "O" : "X" ) );
*/
	
		
		
		
		//------ 문제9 여기에 풀이-------//
/*
 문제9 : 두개의 정수를 입력받아 더 큰수 출력 
	
		Scanner sc1= new Scanner(System.in);
		int 정수1 = sc1.nextInt();
		Scanner sc2= new Scanner(System.in);
		int 정수2 = sc2.nextInt();
		
		System.out.println("더 큰수 :"+ (정수1>정수2?정수1:정수1<정수2?정수2:"같다"));

 */			
		
		//------ 문제10 여기에 풀이-------//
/*문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
	
		Scanner sc= new Scanner(System.in);
		float 반지름= sc.nextFloat();
		System.out.println(반지름*반지름*3.14);
*/			
		
		
		//------ 문제11 여기에 풀이-------//

/* 문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

		Scanner sc1= new Scanner(System.in);
		System.out.print("실수1: ");
		double 실수1 = sc1.nextFloat();
		
		Scanner sc2= new Scanner (System.in);
		System.out.println("실수2: ");
		double 실수2 = sc2.nextFloat();
		
		System.out.println((실수1/실수2)*100.0+"%");
				//※ 소수점 자르고 싶다면
		
수업시간에 한 거------------------------------------------------------------
		System.out.printf("비율계산: %.6%f\n",(실수1/실수2)*100.0);	
			//%f: 실수 형식  %.6f: 실수 소수점 6자리 형식

		System.out.println(" ----------- 문제11 ------------- ");
		System.out.print("실수1 : ");		double 실수1 = scanner.nextDouble();
		System.out.print("실수2 : ");		double 실수2 = scanner.nextDouble();
		System.out.printf("실수2 에서 실수1 비율 계산 : %.6f %%\n" , ( 실수1/실수2  )*100.0  );
*/		
		
		//------ 문제12 여기에 풀이-------//
/*
 문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2		

		Scanner sc1 = new Scanner(System.in);
		float 윗변 = sc1.nextFloat();
		
		Scanner sc2 = new Scanner(System.in);
		float 밑변 = sc2.nextFloat();
		
		Scanner sc3 = new Scanner(System.in);
		float 높이 = sc3.nextFloat();
		
		System.out.println((윗변+밑변)*높이/2);
 */		
		
		
		//------ 문제13 여기에 풀이-------//
/*	
		Scanner sc = new Scanner(System.in);
		int 키 = sc.nextInt();
		
		System.out.println((키-100)*0.9);
 */		
		
		//------ 문제14 여기에 풀이-------//
/*
 	문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))		

		Scanner sc1= new Scanner(System.in);
		float 키 = sc1.nextFloat();
		
		Scanner sc2= new Scanner(System.in);
		float 몸무게 = sc2.nextFloat();
		
		System.out.println(몸무게/(키/100)*(키/100));
 */		
		
		
		//------ 문제15 여기에 풀이-------//
/*
  	문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm		

		Scanner sc = new Scanner(System.in);
		float inch = sc.nextFloat();
		
		System.out.println((inch*2.54)+"cm");
 */		
		
		//------ 문제16 여기에 풀이-------//
/*
 * 문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %		

			Scanner sc1 = new Scanner(System.in);
			float 중간= sc1.nextFloat();
			System.out.printf("%.2f",(중간*0.3));
			
			Scanner sc2 = new Scanner(System.in);
			float 기말= sc2.nextFloat();
			System.out.printf("%.2f",(기말*0.3));			
			
			Scanner sc3 = new Scanner(System.in);
			float 수행= sc3.nextFloat();
			System.out.printf("%.2f",(수행*0.4));			
 */			
		
		//------ 문제17 여기에 풀이-------//
/*
 * 문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)		

		// x=10 -> 9 -> 8
		// y = 10+5+9->24->24-1 ->23
		
		int x = 10;
		int y = x-- + 5 + --x;
		
		System.out.printf("x의 값 : %d , y의 값:  %d" ,x, y);
 */
		
		
		//------ 문제18 여기에 풀이-------//
/*
 // 문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기		

 		// 객체 생성 : 위에서 Scanner scanner = new scanner(System.in) 했기 때문에 생략
		System.out.print("나이 입력: ");
		int 나이 = scanner.nextInt();
		
		//삼항연산자 할 때 범위 잘 생각하기! 여기서는 거꾸로 함으로써 중복 제거 할 수 있
		System.out.println(나이>=40?"중년":나이>=20?"성인":나이>=10?"학생":"이 외");
*/		
			
		
		
		//------ 문제19 여기에 풀이-------//
	/*	문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 
	 * 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력		
	 
		System.out.print("국어 점수 입력");
		double 국어 = scanner.nextDouble();
		
		System.out.print("영어 점수 입력");
		double 영어 = scanner.nextDouble();
		
		System.out.print("수학 점수 입력");
		double 수학 = scanner.nextDouble();
		
		System.out.printf("총점: %.0f\n",(국어+영어+수학));
		System.out.printf("평균: %.2f\n",((국어+영어+수학))/3);
*/		

/*		
		//------ 문제20 여기에 풀이-------//
		문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

		System.out.print("아이디 입력: ");
		String 아이디= scanner.next();
		
		System.out.print("비밀번호 입력: ");
		String 비밀번호 = scanner.next();
		
		//js에서는 가능하나 자바에서는 불가능. 객체에선 비교,산술 연산자 사용이 불가능함.
		// 기본타입과 객체는 메모리 구조가 다름!! 문자열은 ==으로 비교할 수 없음.
		//String result = (아이디=="admin"&&비밀번호=="1234"?"로그인성공":"로그인실패"); (x)
		
		System.out.println(아이디.equals("admin")&&비밀번호.equals("1234")?"로그인성공":"로그인 실패");
		
*/		
		//------ 문제21 여기에 풀이-------//
/*		문제21 : 세 정수를 입력받아 가장 큰수 출력 				

		System.out.println("정수1: "); int 정수1 = scanner.nextInt();
		System.out.println("정수2: "); int 정수2 = scanner.nextInt();
		System.out.println("정수3: "); int 정수3 = scanner.nextInt();
	
		int max = 정수1;		//임의의 가장 큰 수를 저장
		max= max<정수2?정수2:max;
		max=max<정수3?정수3:max;
		
		System.out.println("max: "+max);
*/
	}

}



