package java1.day13.Ex2.view;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	// 싱글톤 사용 가능 (공유)

	//1. 현재 클래스 안에 현재 클래스로 객체 선언(private static )
	private static MainPage mainPage = new MainPage();
	//2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수 (get메소드 만들기)
			// getInstance로 보통 이름을. . 
	public static MainPage getInstance() {return mainPage;}
	//3. 외부로부터 객체 생성 차단
	private MainPage() {};
//--------------------------------------------------------------------
	
	private Scanner sc= new Scanner(System.in);
	
	
	//메인 페이지 입출력 함수
	public void mainView() {
		while(true){
			System.out.println("안내) "+BoardDao.getInstance().boardDtoList);
			System.out.println("\n\n>>>>방문록 프로그램>>>>>");
			System.out.println("1.글등록 2.글보기 3.글삭제 4.글수정 선택>>>>>");
			int ch=sc.nextInt();
			if(ch==1) {writerView();} //각 번호별 페이지 함수 호출
			if(ch==2) { printView();}
			if(ch==3) {updateView();}
			if(ch==4) {deleteView();}
		}//while
		
	}//mainPage()
	
//등록함수------------------------------------------------
	public void writerView() {
		//V->C - 3가지 중 싱글톤
		
		System.out.println("----방문록 등록 페이지------");
			//1. 내용(띄어쓰기O)과 작성자(띄어쓰기X)를 입력 받아 변수에 저장
		sc.nextLine(); // nextLine()함수 실행 전 nextInt() 실행되므로 오류 발생 방지를 위해 사용
		System.out.print("방문록: "); String content= sc.next(); //nextLine() 앞뒤로 다른 
		System.out.print("작성자: "); String writer=sc.next();
		
			//2. 입력 받은 변수를 컨트롤에 전달
			//현재 위치도 java , 컽ㄴ트롤도 java<- 메소드 사용
				// 전달 보내기 = 매개변수 / 전달 받기 =리턴
		
			//view에서 Controller 함수 호출 , 
			//인수 전달하기 때문에 controller 내 writerLogic(){ return 함수} 넣어줘야됨
			boolean result = BoardController.getInstance().writerLogic(content,writer);
		
			//3. 컨트롤에게 전달 받은 내용 제어
			if(result) {
				System.out.println("글 등록 성공");
			}//if
			else {// 실패
				System.out.println("글 등록 실패");
			}//else
			
			
	}//writerView()
	
	
// 글 출력 페이지-----------------------------------------
	public void printView() {
		//1.보고자하는 게시물의 인덱스 입력 받아 저장
		System.out.print("출력할 방문록의 인덱스: ");	int index = sc.nextInt();
		//2. view에서 컨트롤에게 입력 받은 인덱스 전달 
		BoardDto result= BoardController.getInstance().printLogic(index);
		//3. 전달 받은 결과를 출력
		System.out.println("검색한 방문록 정보");
		System.out.println("작성자: "+result.getWriter()+"내용: "+result.getContent());
	
	
	
	}//printView
	
	
//글 수정-------------------------------------------------
	public void updateView() {
		System.out.println("수정할 게시물 수정 페이지: "); 
		System.out.print("수정할 방문록 인덱스 번호: "); int index=sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 내용: ");	String content = sc.nextLine();
		System.out.print("작성자: "); String writer =sc.nextLine();
		
		//2. 입력받은 변수를 view에서 Controller 함수 호출
		boolean result= BoardController.getInstance().updateLogic(index, content, writer);
		//3. 결과에 따른 제어
		if(result) {
			System.out.println("수정성공");
		}
		else {
			System.out.println("수정실패");
		}
	
	
	}//updateView
	
//글 삭제-------------------------------------------------
	public void deleteView() {
		//1.삭제할 게시물의 인덱스 입력 받아 저장
		System.out.print("출력할 방문록의 인덱스: ");	int index = sc.nextInt();
		
		//view에서 컨트롤에서 입력받은 인덱스 전달 보내고 삭제 결과 여부를 리턴 받음.
		boolean result =BoardController.getInstance().deleteLogic(index);
		
		//3. 리턴 결과 제어
		if(result) {System.out.println("삭제성공");}
		else {System.out.println("삭제실패");}
	
	
	}//deleteView
	

	  
}//class
