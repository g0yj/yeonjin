package 복습.과제9;

import java.util.Scanner;

public class MemberSys_1 {
	public static void main(String[] args) {
			
		Scanner sc= new Scanner(System.in);
		
		Member_1 memberList=new Member_1[100];
		
		while(true) {
			System.out.println("배열상태확인 >>\n " +memberList);
			
			System.out.println("1.회원가입2.로그인");
			
			System.out.println("선택: "); int ch=sc.nextInt();
			
			if(ch==1) {
				System.out.println("아이디: "); String id = sc.next();
				System.out.println("비밀번호: "); String pw = sc.next();
				System.out.println("이름: "); String name = sc.next();
				System.out.println("전화번호: "); String phone = sc.next();
				System.out.println("나이: "); int age = sc.nextInt();
				
				Member_1 member = new Member_1(id, pw, name, phone, age);
				
				for(int i =0; i<memberList.leng)
				
			}// 회원가입
			
			else if(ch==2){
				System.out.println("아이디: "); String id = sc.next();
				System.out.println("비밀번호: "); String pw = sc.next();
				
				for(int i =0; i<memberList.length;i++) {
					if(memberList[i]!=null && Member_1.id.equals(id)&&Member_1.id.equals(id)) {
						
					}//if
				}//for
			}//로그인
			
			
			
		}//while
	}//main

}//class
