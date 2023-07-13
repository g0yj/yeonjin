package java1.day01;

import java.util.Scanner;

public class Ex4_입출력 {

	public static void main(String[] args) {
		
		//System.out.print("출력하고싶은말" 또는 변수명 ); -> 출력만
		//System.out.println("출력하고 싶은 말 " 또는 변수명); -> 출력 후 줄바꿈
		//System.out.printlnf("형식/포맷 문자" , 값/변수); -> 형식 문자열에 맞추어 값 출력
		
		System.out.print("출력문구1");
		System.out.print("출력문구2");
		System.out.println("출력문구3");
		System.out.println("출력문구4");
		/* 출력문구1출력문구2출력문구3
			출력문구4*/ 
		
		int value=123;
		System.out.printf("상품의 가격: %d원 \n",value);  //상품의 가격: 123원
		System.out.printf("상품의 가격: %6d원 \n",value);  //상품의 가격:     123원  , 6칸 정수 자리에 value 변수 출력 (자릿수가 비어있다면 공백)
		System.out.printf("상품의 가격: %-6d원 \n",value);  //상품의 가격:123     원
		System.out.printf("상품의 가격: %06d원 \n",value);  //상품의 가격: 000123원
		
		System.out.printf("반지름 파이 %f\n",3.14); //3.140000
		System.out.printf("반지름 파이 %.1f\n",3.14); //3.1
		
		System.out.printf("회원아이디: %s\n","어ㅣ라멀");  //회원아이디: 어ㅣ라멀
		
		
		//입력-> 객체생성
		//Scanner+컨트롤+스페이스바=> Scanner: 클래스(설계도)
		//띄어쓰기 +컨트롤+스페이스바 => scanner: 객체명
		//new 연산자: 객체에 ㅔㅁ모리 할당/생성
		//Scanner(): 클래스 생성자(객체 생성시 초기값 대입하는 메소드)= 클래스명과 무조건 동일해야함.
		
		Scanner scanner= new Scanner(System.in);
		
		// 입력 객체를 이용한 입력값 호출/ 가져오기
		  //1. 입력 받은 문자열 가져오기  scanner.next();
	      //2. 변수에 저장
		String 문자열=scanner.next();  //string이 기본값 (문자열O , 문자X)
			// 3. 변수에 출력 확인
		System.out.println("입력된 문자열은: "+문자열);
		
		boolean 논리= scanner.nextBoolean();
		System.out.println("입력된 논리: "+논리);
		
		int 인트=scanner.nextInt();
		System.out.println("입력된 인트: " +인트);
	}

}
