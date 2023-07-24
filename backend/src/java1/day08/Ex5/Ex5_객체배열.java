package java1.day08.Ex5;

import java.util.Scanner;

/*
  Ex5의 내용.
  - 배열을 사용할 때 ,로 구분해서 저장할지
  - 새로운 클래스를 사용하고 연산자를 통해 호출할지 비교
 */


public class Ex5_객체배열 {
	public static void main(String[] args) {
		
		Member[] memberList= new Member[100];
		
		while(true) {
			System.out.println("1.회원가입: ");
			Scanner scanner= new Scanner(System.in);
			int ch=scanner.nextInt();
			
			if(ch==1) {
				System.out.println("아이디: "); String id= scanner.next();
				System.out.println("비밀번호: "); String pw=scanner.next();
				
				 //1. 객체화=클래스명 객체변수명=new 생성자명();
				
						//1. 객체생성
				Member m = new Member();
						//2. 생성된 객체로부터 접근연산자를 이용한 필드 수정
				m.id=id; m.pw=pw; 
				
				//2. 배열에 저장
				for(int i=0; i<memberList.length;i++) {
					if(memberList[i]==null) {
						memberList[i]=m;
						break;
					}//if
				}//for
			
				
			}//if
		}//while
	}//main

}

/*
  배열: 같은 타입의 여러 데이터 저장
  객체:
 */