package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

/*
Ex5의 내용.
- 배열을 사용할 때 ,로 구분해서 저장할지
- 새로운 클래스를 사용하고 연산자를 통해 호출할지 비교
*/


public class Ex5_배열 {
	public static void main(String[] args) {
		
		String[]memberList= new String[100];
		
		
		while(true) {//무한루프
			System.out.println(Arrays.toString(memberList)); //확인용: 배열 내 데이터
			//1. 무한출력
			System.out.println("1.회원가입: ");
			//2. 무한입력
				//1. scanner 객체: Scanner 객체변수명=new Scanner(System.in);
			Scanner scanner= new Scanner(System.in);
				//2. 객체를 통한 메소드 호출해서 변수에 저장
			int ch=scanner.nextInt();
			
			if(ch==1) {//만약 ch==1이면
				System.out.println("아이디: "); String id=scanner.next();
				System.out.println("비밀번호: ");String pw=scanner.next();
				//여러개를 저장하고 싶..!! => 배열사용. while문 밖에 선언
				//1. 하나의 문자열로 합치기
				String member= id+","+pw; //쉼표로(CSV)로 필드 구분
				//2. 배열 내 비어있는 (=null)인덱스를 찾아 대입[p.172. 기본값]
				for(int i= 0;i<memberList.length; i++) {
					if(memberList[0]==null) {// 해당 인덱스가 비어있으면
						memberList[i]=member;// i번째 인덱스에 입력받은 문자열 대입
						break;// 하나의 회운만 추가할 예정이르모 대입했다면 반복문 종료
					}
				}//for문
			}
			
			
		}//while
		
		
		
	}//main

}
