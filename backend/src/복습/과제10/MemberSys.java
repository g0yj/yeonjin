package 복습.과제10;

import java.security.PublicKey;
import java.util.Scanner;

public class MemberSys {
	
	static Scanner sc = new Scanner(System.in);
	
	static Member[]memberList= new Member[100];
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("1.회원가입2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.println("선택: "); int ch= sc.nextInt();
			
			if(ch==1) {MemberSys.회원가입();}
			else if(ch==2) {MemberSys.로그인();}
			else if(ch==3) {MemberSys.아이디찾기();}
			else if(ch==4) {MemberSys.비밀번호찾기();}
		}//while
	}//main
	

static void 회원가입() {
	System.out.println("아이디: "); String id = sc.next();
	System.out.println("비번: "); String pw = sc.next();
	System.out.println("이름: "); String name = sc.next();
	System.out.println("번호: "); String phone = sc.next();
	System.out.println("나이: "); int age = sc.nextInt();
	
	Member member = new Member(id, pw, name, phone, age);
	
	for(int i=0; i<memberList.length;i++) {
		if(memberList[i]==null) {
			memberList[i]=member;
		}
	}//for
}//회원가입

static void 로그인() {
	System.out.println("아이디: "); String id =sc.next();
	System.out.println("비번: "); String pw =sc.next();
	
	int login=-1;
	for(int i =0; i<memberList.length;i++) {
		if(memberList[i]!=null&&memberList[i].id.equals(id)&&memberList[i].pw.equals(pw)) {
			login=i;
			break;
		}
	}//for
	if(login>=0) {System.out.println("로그인성공");}
	else {System.out.println("로그인실패");}
	
}//로그인()
	
public static void 아이디찾기() {
	System.out.println("이름: "); String name=sc.next();
	System.out.println("번호: "); String phone=sc.next();

	for(int i =0;i<memberList.length;i++) {
		if(memberList[i]!=null&&memberList[i].name.equals(name)&&memberList[i].phone.equals(phone)) {
			System.out.println("아이디: "+memberList[i].id);
			break;
		}//if
		else {System.out.println("일치아이디없음"); break;}
	}//for

}//아이디찾기()

public static void 비밀번호찾기() {
	System.out.println("아이디: "); String id=sc.next();
	System.out.println("번호: "); String phone=sc.next();

	for(int i =0;i<memberList.length;i++) {
		if(memberList[i]!=null&&memberList[i].id.equals(id)&&memberList[i].phone.equals(phone)) {
			System.out.println("비밀번호: "+memberList[i].pw);
			break;
		}//if
		else {System.out.println("일치아이디없음");break;}
	}//for

	
}//비밀번호찾기
	
}//class
