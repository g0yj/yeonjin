package 복습.mvc_member.view;

import java.util.Scanner;

import 복습.mvc_member.controller.M_controller;

public class M_main {
	//싱글톤 생성
	private static M_main m =new M_main();
	public static M_main getInstance() {return m;}
	private M_main() {}
	
	//출력 클래스로 Scanner 클래스는 여기에만!
	Scanner sc = new Scanner(System.in);
	
//메소드---------------------------------------------------------------------------	
	//메인 출력 함수
	public void mainView() {
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.회원가입 2. 로그인");
			System.out.println("------------------------");
			System.out.print(">>선택: "); int ch = sc.nextInt();
			
			if(ch==1) {signupView();}
			else if(ch==2) {loginView();}
			//else if(ch==3) {}
			//else if(ch==4) {}
			
		}//while
	}//mainView()
	
		// 회원가입함수
	public void signupView() { 
			//1. 입력받기
		System.out.println("아이디: "); String mid = sc.next();
		System.out.println("비밀번호: ");	String mpw= sc.next();
		System.out.println("이름: ");	String mname= sc.next();
		System.out.println("핸드폰번호: ");	String mphone= sc.next();
		
		//?????결과에 따라 입/출력이 되는거기 때문에 항상 boolean으로 받게됨?!??
		boolean result=
				M_controller.getInstance().signupLogic(mid,mpw,mname,mphone);
		
		if(result=true) {
			System.out.println("회원가입성공");
		}
		
		
	}
	
		//로그인함수
	public void loginView() {
		System.out.println("아이디: " ); String mid = sc.next();
		System.out.println("비밀번호: " ); String mpw = sc.next();
		
		boolean result =
				M_controller.getInstance().loginLogic(mid,mpw);
		if(result) {System.out.println("로그인성공");}
		else {System.out.println("로그인실패");}
				
		
	}
}//class
