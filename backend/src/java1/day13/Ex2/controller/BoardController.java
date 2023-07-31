package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	// 싱글톤 사용 가능 (공유)
	
	//1. 현재 클래스 안에 현재 클래스로 객체 선언(private static )
	private static BoardController boardController = new BoardController();
	//2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수 (get메소드 만들기)
	// getInstance로 보통 이름을. . 
	public static BoardController getInstance() {return boardController;}
	//3. 외부로부터 객체 생성 차단
	private BoardController() {};	
	

	//등록함수[C]-0731 고연진 작업------------------------------------------------
		public boolean writerLogic(String content, String writer) {
			System.out.println("검토용)쓰기 컨트롤러까지 도착");
		
			 //1. 매개변수로부터 전달 받은 content,, writer를 하나의 객체로 선언
			BoardDto boardDto = new BoardDto(writer,content);
			
			//2. 객체를 배열에 저장[빈공간을 찾아서 빈공간 저장]
			BoardDao.getInstance().boardDtoList.add(boardDto);
				
	
			
			// 성공 시 true, 실패시 false 기 때문에 boolean으로 리턴 받음
			return false;
		}//writerLogic()
		
		
		
	// 글 출력 페이지---------------------------------------------------
		public BoardDto printLogic(int index) {
			System.out.println("검토용) 출력 컨트롤러까지 도착");
			
			//1. 리스트 안에 있는 객체 호출 .get(인덱스)
			BoardDto boardDto=BoardDao.getInstance().boardDtoList.get(index);
			//2. 호출된 dto를 리턴
			return boardDto;
			
		}
		
		
	//글 수정 : 수정할 게시물의 인덱스와 수정할 내용, 작성자---------------------------------------------------------
		public boolean updateLogic(int index, String content, String writer) {
			System.out.println("검토용)업데이트 컨트롤러까지 도착");
			//1. 입력받은 인덱스의 게시물을 호출해서 새로운입력받은 값의 대입 set
			BoardDao.getInstance().boardDtoList.get(index).setContent(content);
			BoardDao.getInstance().boardDtoList.get(index).setWriter(writer);
			
			return true;
		}
		
		
		
	//글 삭제 : 삭제할 게시물의 인덱스---------------------------------------------------
		public boolean deleteLogic(int index) {
			System.out.println("검토용)삭제 컨트롤러까지 도착");
			
			//1. 리스트 안에 있는 객체 삭제. get(인덱스) /삭제 여부만 확인하면 되니까 boolean사용
			BoardDao.getInstance().boardDtoList.remove(index);
			//2. 삭제여부 반환
			
			return true;
			
		}	
	
	
	
	
}//class
