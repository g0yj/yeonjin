package 복습.mvc_member.view;

import java.util.Scanner;

import 복습.mvc_member.controller.M_controller;

//로그인 했다는 가정 하에 관리를 하기 위한 페이지
// 44일차 3시간36분 강의 시작
public class M_loginPage {

	//0.싱글톤
	private static M_loginPage log = new M_loginPage();
	public static M_loginPage getInstance() {return log;}
	private M_loginPage() {}
	
	
	//0. 입력객체
	private Scanner sc = new Scanner(System.in);
	
	
	//1. loginMenu : 로그인 했을 때
	public void loginMenu() {
		// mainview클래스에서 로그인함수 안에 사용
		while(M_controller.getInstance().getLoginSession()!=0) {//c로그인함수에서 세션으로 저정했던 내용
			// 무한루프끝나면 다시 메인 페이지로 돌아감!
			System.out.println("1. 로그아웃 2. 회원정보 3.글쓰기  >>선택: ");
			try {
				
				int ch= sc.nextInt();//만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if (ch==1) {M_controller.getInstance().logOut();}
				else if(ch==2) {info();}
				else if(ch==3) {boardWrite();}
			}
			catch(Exception e) {
				System.out.println("경고 ] 잘못 입력했음");
				sc = new Scanner(System.in);  // **입력객체의 메모리를 새롭게 만들어주기. 
			}//catch
			
			
		}//while
		
	}
	//2. info: 회원정보페이지
	public void info() {}

	//3. infoUpdate: 회원정보수정페이지
	public void infoUpdate() {}
	
	//4. infoDelete: 회원탈퇴 페이지
	public void infoDelete() {}
	
	//5. boardWrite: 게시물쓰기 페이지
	public void boardWrite() {}
	
	//6. boardPrint: 모든 게시물 출력
	public void boardPrint() {}
	
	
	//7. boardView: 개별 게시물 출력
	public void boardView() {}
	
	
	//8. boardUupdate: 게시물 수정
	public void boardUupdate() {}
	
	//9.boardDelete: 게시물삭제
	public void boardDelete() {}
	
}//class
