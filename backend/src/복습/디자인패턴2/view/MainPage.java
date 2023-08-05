package 복습.디자인패턴2.view;

import java.util.Scanner;

import 복습.디자인패턴2.controller.MemberController;
import 복습.디자인패턴2.model.dto.MemberDto;

public class MainPage {
	Scanner sc= new Scanner(System.in);
	
	//싱글톤
	private static MainPage mainPage=new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	

	public void mainPage() {
		while(true) {
			System.out.println("1.회원가입 2.로그인");
			System.out.println("선택: "); int ch = sc.nextInt();
				if(ch==1) {mainPage.JoinView();}
				else if(ch==2){mainPage.LoginView();}
			}//while
	}// mainPage()
	
	public void JoinView() {//회원가입함수
		System.out.println("아이디: "); 	String id = sc.next();
		System.out.println("비번: "); 	String pw = sc.next();
		System.out.println("이름: "); 	String name = sc.next();
		System.out.println("번호: "); 	String phone = sc.next();
		System.out.println("나이: "); 	int age = sc.nextInt();
	
		MemberDto member = new MemberDto(id, pw, name, phone, age);
		
		boolean result= MemberController.getInstance().JoinLogic(id, pw, name, phone, age);
	}//회원가입함수
	
	
	
}//class
