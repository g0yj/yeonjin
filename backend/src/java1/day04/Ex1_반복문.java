package java1.day04;

public class Ex1_반복문 {

	public static void main(String[] args) {
		
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
	}

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
 * 
 */
