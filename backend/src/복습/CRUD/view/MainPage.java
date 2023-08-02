package 복습.CRUD.view;


import java.util.Scanner;

import 복습.CRUD.controller.BoardController;

public class MainPage {
	//싱글톤으로 호출메소드 만들기
	private static MainPage mainPage = new MainPage();//1. 자신을 객체명으로
	public static MainPage getinstacne() {return mainPage;}// 간접적으로 객체를 불러올 수 있는 함수 생성
	private MainPage() {};
	
	//입력객체. 프론트에서말 쓸거기 때문에 private 가능
	private Scanner sc= new Scanner(System.in);
	
	// 함수 : 메인페이지 출력, 글등록, 글출력, 글수정, 글삭제	
// 1. 메인 페이지 출력
	public void mainView(){
		while(true) {
			//배열 확인용
			//System.out.println("Dto내용 확인>>>"+BoardDao.getInstance().boardList);
			System.out.println("--------방문록 프로그램------");
			System.out.println("1.글등록 2.글보기 3.글삭제 4.글수정");
			System.out.println("선택: "); int ch = sc.nextInt();
			
			if(ch==1) {writeView();}//글등록함수
			if(ch==2) {printView();}//글보기함수
			if(ch==3) {deleteView();}//글삭제함수
			if(ch==4) {updateView();}//글수정함수
				}//while
	}//mainView()

//글등록함수------------------------------------------------	
	public void writeView() {
		System.out.println("-------글등록페이지----------");
		sc.nextLine(); // nextLine이나 nextInt가 연속으로 나오면 개행문자 어쩌구 때문에 오류 발생함. 이를 방지하기 위한 방법 중 하나
		System.out.println("내용: "); String content = sc.nextLine();
		System.out.println("작성자: "); String writer = sc.next();
		System.out.println("<글내용>: "+content+"  <작성자> : "+writer);
		
		boolean result = BoardController.getInstance().writeLogic(content, writer);
		
		if(result) {System.out.println("글쓰기성공");}
		else {System.out.println("글쓰기 실패");}
		
		}//writerView()
	
//글보기함수---------------------------------------------
	public void printView() {
		System.out.print("볼 게시글에 인덱스: "); int index = sc.nextInt();
	}//f
	
//글삭제함수----------------------------------------
	
//글수정함수-------------------------------------
	
	
}//class
