package 복습.과제9;

import java.util.Scanner;

//실행 클래스
public class MemberSys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member[] memberList = new Member[100];

		while(true){
			System.out.println("1.회원가입 2.로그인");
			System.out.println("선택: "); int ch = sc.nextInt();
			System.out.println("배열상태>>>> "+memberList);
			
			if(ch==1) {//회원가입
				System.out.println("아이디: "); String id= sc.next();
				System.out.println("비밀번호: "); String pw = sc.next();
				System.out.println("이름: "); String name = sc.next();
				System.out.println("전화번호: "); String mum = sc.next();
				System.out.println("나이: "); int age = sc.nextInt();
				
				Member m = new Member(id, pw, name, mum, age);
					
				for(int i = 0; i<memberList.length; i++) {
					if(memberList[i]==null) {
						memberList[i]=m;
						System.out.println("회원가입성공");
						break;
						}//if
					else {System.out.println("회원가입실패");break;}
					}//for
			}//if
		
// 로그인-----------------------------------------------------
			else if(ch==2) {
			System.out.println("아이디: "); String id= sc.next();
			System.out.println("비밀번호: "); String pw =sc.next();
			
			int login= -1;
			
			// 찾을거니까 굳이 필요없
			//Member member = new Member(id, pw);
			
			for(int i=0; i< memberList.length;i++) {
				if(memberList[i]!=null&&memberList[i].id.equals(id)&&memberList[i].pw.equals(pw)) {
					System.out.println("로그인성공");
					login=i;
					break;
					
				}//if
				if(login<0) {
					System.out.println("로그인실패"); break;
				}//if
			}//for
		}//if
		
		
	}//main
	}}
