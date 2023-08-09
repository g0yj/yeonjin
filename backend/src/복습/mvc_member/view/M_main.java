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
	

//1.메인 출력 함수-----------------------------------------------------------------------
	public void mainView() {
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.회원가입 2. 로그인 3.아이디 찾기 4.비밀번호찾기");
			System.out.println("------------------------");
			System.out.print(">>선택: "); int ch = sc.nextInt();
			
			if(ch==1) {signupView();}
			else if(ch==2) {loginView();}
			else if(ch==3) {findById();}
			else if(ch==4) {findByPw();}
			
		}//while
	}//mainView()
	
// 2.회원가입함수------------------------------------------------------------------
	public void signupView() { 
			//1. 입력받기
		System.out.println("아이디: "); String mid = sc.next();
		System.out.println("비밀번호: ");	String mpw= sc.next();
		System.out.println("이름: ");	String mname= sc.next();
		System.out.println("핸드폰번호: ");	String mphone= sc.next();
		
		//아이디 ,비밀번호 중복체크(c 13번째줄)로 인해 경우의 수가 늘어났기 때문에 boolean->int로 변경
		int result=
				M_controller.getInstance().signupLogic(mid,mpw,mname,mphone);
		
		if(result==1) {System.out.println("회원가입성공");}
		else if(result==2) {System.out.println("회원가입실패: 관리자문의");}
		else if(result==3) {System.out.println("회원가입실패: 아이디 중복");}
		else if(result==4) {System.out.println("회원가입실패: 전화번호 중복");}
	}
	
//3.로그인함수-----------------------------------------------------------------------
	public void loginView() {
		System.out.println("아이디: " ); String mid = sc.next();
		System.out.println("비밀번호: " ); String mpw = sc.next();
		
		boolean result =
				M_controller.getInstance().loginLogic(mid,mpw);
		if(result) {
			System.out.println("로그인성공");
			//만약 로그인에 성공하면 다른 클래스의 함수로
			M_loginPage.getInstance().loginMenu();	
		
		}//if
		else {System.out.println("로그인실패");}
	}//loginView()
	
	
//4. 아이디 찾기 -------------------------------------------------------------------
		public void findById() {
			System.out.println("이름: " ); String mname = sc.next();
			System.out.println("전화번호: " ); String mphone = sc.next();
			
			String result = //controller에서 받아올 반환 값이 아이디. 따라서 타입은 String
					M_controller.getInstance().findById(mname,mphone);
			if(result!=null) {System.out.println("아이디: " +result);	}
			else {System.out.println("아이디가 없음");}
		}
		
//5. 비밀번호 찾기 ------------------------------------------------------------------
		public void findByPw() {
			System.out.println("아이디: " ); String mid = sc.next();
			System.out.println("핸드폰번호: " ); String mphone = sc.next();
			
			String result =
					M_controller.getInstance().findByPw(mid, mphone);
			if(result!=null) {System.out.println("비밀번호: "+result);} //나중에는 난수로 받아 임시비번 줄 수 있음
			else {System.out.println("일치하는 비밀번호 정보 없음");}
		}//f()
}//class
