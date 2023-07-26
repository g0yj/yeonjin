package java1.day10.Ex2;



public class Computer {
	
	//1. 필드
	
	//2. 생성자
	
	//3. 메소드
		//1. 가변길이 매개변수를 갖는 메소드 선언 방법 <- '... ' 키워드를 이용한
												// 타입...배열변수명
	
		int sum(int...values) {
			int sum =0; // 매개변수로 들어온 여러개의 변수를 더한 변수
			
			for(int i=0; i<values.length;i++) {
				sum+=values[i];
			}//for
			return sum;
			
			
		
		//2. 가변길이와 일반매개변수가 있을 경우 가변길이 매개변수는 가장 뒤에 선언
										//	...은 길이를 알 수 없응께
		//int sum(String str, int ...values) {
			
			
		//3. 여러개 리터럴/변수와 하나의 배열을 가변길이 매개변수로 전달 받을 수 있음.
		
		}
		
		int sum2(String str,int[]values) {
			int sum =0;
			for(int i=0;i < values.length;i++) {
				sum+=values[i];
			}
			return sum;
		}

}
