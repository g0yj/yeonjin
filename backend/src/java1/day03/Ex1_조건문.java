package java1.day03;

import java.util.Random;

public class Ex1_조건문 {

	public static void main(String[] args) { //메인 시작
		
		int score=93;

		//1. 
		if(score>=90) {System.out.println("합격1");}
		
		//2.
		if(score>=90) {
			System.out.println("점수가 90보다 큼");
			System.out.println("등급은 A등급");
		} //2번 끝
		
		//3. 
		//if - else if
		
		if(score>=90) {
			System.out.println("점수가 100~90임");
			System.out.println("등급 A");
		}else if(score>=80) {
			System.out.println("점수가 80~90임");
			System.out.println("등급 B");
		}else if(score>=70) {
			System.out.println("점수가 70~80임");
			System.out.println("등급 C");
		}else {
			System.out.println("점수가 60~70임");
			System.out.println("등급 D");
		}
		
		//4. 3번과의 차이 기억!!
		if(score>=90) {
			System.out.println("2점수가 100~90임");
			System.out.println("등급 1");
		}
		if(score>=80) {
			System.out.println("2점수가 80~90임");
			System.out.println("등급 2");
		}
		if(score>=70) {
			System.out.println("2점수가 70~80임");
			System.out.println("등급 3");
		}else {
			System.out.println("2점수가 60~70임");
			System.out.println("등급 4");
		}
		
		
		// 5. 난수 만들기
		System.out.println(Math.random()); // 0.0 <=~<1.0
		System.out.println(Math.random()*6); // 0.0~ <6.0
		System.out.println((int)(Math.random())*6);
		System.out.println((int)(Math.random())*6+1); 
		// 정수 난수 공식: (int0(Math.random()*n)+s
			// s: s난수 시작 번호    n: 난수 개수
		
		// 난수 생성 클래스를 이용.
		Random random = new Random();
		
		System.out.println(random.nextInt());		
		
		//random.nextInt(개수)+시작번호
		System.out.println(random.nextInt(3));		//0~2
		
		// 문자 출력 ex. a~z <- 임시 번호 전송 등에 사용 할 예정
		System.out.println((char)(random.nextInt(26)+97)); // 97~122 <- char로 형변환
		
		
		//주사위 예제 p.116
		int num=(int)(Math.random()*6)+1;  // 주사위 번호 하나 뽑기
		
		if(num==1) {
			System.out.println("1번");
		}else if(num==2) {
			System.out.println("2번");
		}else if(num==3) {
			System.out.println("3번");
		}else if(num==4) {
			System.out.println("4번");
		}else System.out.println("5번");
		
		//if 중첩
		
		
		
		// p.117

		int score3=(int)(Math.random()*20)+81;
		String grade; // 등급을 저장하는 변수
		
		if(score3>=90) {// 90점 이상이면
			if(score3>=95) {grade="A+";} // 100~90 이면서 95점 이사이면 A+
			else {grade="A";}//94~90이면서 95점 미만이면 A
		}else {//점수가 90점 미만이면
			if(score3>=85) {
				grade="B+";
			}else {
				grade="B";
		}
			System.out.println("학점: "+grade);
		
		
		//p.121
		char grade2= 'B';
		switch(grade2) {// 값을 제어할 변수
			case 'A' :
			case 'a' : System.out.println("A등급 우수회원"); break;
			case 'B' :
			case 'b' : System.out.println("B등급 우수회원"); break;
			default :
			}
		
		}
		
	}//main끝
	
}//class끝


