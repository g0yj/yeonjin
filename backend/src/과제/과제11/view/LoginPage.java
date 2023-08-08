package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	private static LoginPage loginPage=new LoginPage();
	public static LoginPage getInstance() {return loginPage;}
	private LoginPage() {}
	
	//0. 입력객체
	
	private Scanner sc= new Scanner(System.in);
	
	//1. loginMenu : 로그인햇을 때 메뉴
	public void loginMenu() {
		while(MemberController.getInstance().getLoginSession()!=0) {// 로그인이 되어 있는 경우에만 반복문
			System.out.println("1. 로그아웃 2. 회원정보 3.글쓰기  >>선택: ");
			try {
				
				int ch= sc.nextInt();//만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if (ch==1) {MemberController.getInstance().logOut();}
				else if(ch==2) {info();}
				else if(ch==3) {boardWrite();}
			}
			catch(Exception e) {
				System.out.println("경고 ] 잘못 입력했음");
				sc = new Scanner(System.in);  // **입력객체의 메모리를 새롭게 만들어주기. 
			}//catch
			
		}//while
		
	}
	//2. info : 회원정보 페이지
	public void info() {
		//1. controller에게 회원정보 요청해서 반환받기(1명의 회원정보 반환)
		MemberDto result = MemberController.getInstance().info();
		
		//2. 반환받을 회원정보객체[memberDto]의 각 필드 출력
		System.out.println("> 아이디: "+result.getMid());// 필드를 private로 만들어 놨기 때문에 get으로 가져옴
		System.out.println("> 이름: "+result.getMname());
		System.out.println(">번호: "+result.getMphone());
		
		
		
		
		//2. 서브메뉴
		System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택>");
		int ch = sc.nextInt();
		if(ch==1) {infoUpdate();}
		if(ch==2) {infoDelete();}
		if(ch==3) {return;}

	}
	//3. infoUpdate: 비밀번호수정 페이지
	public void infoUpdate() {
		System.out.println("새로운 비밀번호: "); String newPw=sc.next();
		boolean result=
		MemberController.getInstance().infoUpdate(newPw);
		if(result) {
			System.out.println("비밀번호 수정완료: 로그아웃됩니다");
			MemberController.getInstance().logOut();}
		else {System.out.println("비밀번호수정실패: 관리자문의");}
	}
	//4. inforDelete : 회원 탈퇴 페이지
	public void infoDelete() {
		System.out.println("정말탈퇴? 1.예 2.아니요: ");
		int ch= sc.nextInt();
		if(ch==1) {
			boolean result=
			MemberController.getInstance().infoDelete();
			if(result) {
				System.out.println("회원탈퇴성공 . 로그아웃됨");
				MemberController.getInstance().logOut();
			}else {System.out.println("회원탈퇴실패");}
		}
		
	}
	//5. boardWrite : 게시물쓰기
	public void boardWrite() {
		
	}
	//6. boardPrint : 모든 게시물 출력
	
	//7. boardView : 개별 게시물 출력
	
	//8. boardUpdate:  게시물 수정
	
	//9. boardDelete: 게시물 삭제
	
}
