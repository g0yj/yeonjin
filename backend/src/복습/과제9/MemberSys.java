package 복습.과제9;

import java.util.Arrays;
import java.util.Scanner;

//실행 클래스
public class MemberSys {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Member[]memberList = new Member[100];
		
		while(true) {
			System.out.println("배열확인용");
			System.out.println(Arrays.toString(memberList));
			
			System.out.println("1.회원가입 2. 로그인");
			System.out.println("선택: "); int ch = sc.nextInt();
			
			if(ch==1) {
				System.out.println("아이디: "); String id=sc.next();
				System.out.println("비번: "); String pw=sc.next();
				System.out.println("이름: "); String name=sc.next();
				System.out.println("전화번호: "); String phone=sc.next();
				System.out.println("나이: "); int age=sc.nextInt();
				
				Member member = new Member(id, pw, name, phone, age);
				
				for(int i=0; i<memberList.length;i++) {
					if(memberList[i]==null) {
						memberList[i]=member;
						System.out.println("회원가입성공");
						System.out.println("배열 추가 확인:  \n"+memberList);
						break;
					}//if
				}//for
				
			}//ch if
			
			else if(ch==2) {
				System.out.println("아이디: "); String id= sc.next();
				System.out.println("비번: ");	String pw =sc.next();
				
				int login = -1;
				for(int i=0; i<memberList.length;i++) {
					
					
					if(memberList[i]!=null&&memberList[i].id.equals(id)&&memberList[i].pw.equals(pw)) {
						Member member = new Member(id, pw);
						memberList[i]=member;
						login=i;
						break;
					}//if
				}//for
				
				if(login>=0) {
					System.out.println("로그인성공");
				}//if
				else {System.out.println("로그인실패");}
			}//ch2 if
			
		}//while
		
		
		
		
	}//main







}//class

