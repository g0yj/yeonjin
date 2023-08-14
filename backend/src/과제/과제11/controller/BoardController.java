package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.letterDto;

public class BoardController {

	private static BoardController boardController =new BoardController();
	public static BoardController getInstance() {return boardController;}
	private BoardController() {}
	
	
//9. boardWrite : 게시물쓰기--------------------------
	public boolean boardWrite(String btitle,String bcontent) {
		//1. 유효성검사(spl과 연동하기때문)
		if(btitle.length()==0||btitle.length()>=50) {return false;}
		//2. Dto(제목, 내용,회원번호=MemberController의 loginSession)
		BoardDto dto =new BoardDto(btitle, bcontent, MemberController.getInstance().getLoginSession());
		//3. DAO에 전달 후 결과 받기
		return BoardDao.getInstance().boardWrite(dto);
		
		
		
	}//f()

	
//10. boardPrint : 모든 게시물 출력---------------------------------------------
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	
//11. boardView : 개별 게시물 출력--------------------------------------------------
	public BoardDto boardView(int bno) {
		return BoardDao.getInstance().boardView(bno);
	}
	
	
	
//12. boardUpdate:  게시물 수정----------------------------------------------------------
	 // 준비물: bno 수정할 게시물의 식별[누구를 수정할건지] // mno=작성자가 일치한 경우에만 삭제 가능하도록[유효성검사]
	public int boardUpdate(int bno, int mno, String title, String content) {
		//1. 유효성검사 
			//1-1 제목 글자 수 검사
		if(title.length()<1||title.length()>50) {return 4;}
			//1-2 작성자 회원번호와 로그인된 회원과 일치하지 않으면
		if(mno!=MemberController.getInstance().getLoginSession()) {return 3;}
		
		//2. 
		BoardDto boardDto = new BoardDto(title, content, bno);
		boolean result=BoardDao.getInstance().boardUpdate(boardDto);
		if(result) {return 1;}
		else return 2;
		
	}
	
	
//13. boardDelete: 게시물 삭제-----------------------------------------------------
	public int boardDelete(int bno, int mno) {
		//1. 유효성검사
		if(mno!=MemberController.getInstance().getLoginSession()) {return 3;}
		//2. 
		boolean result=BoardDao.getInstance().boardDelete(bno);
		if(result) {return 1;}
		else return 2;
		}
	
	//14. 쪽지보내기---------------------------------------------------	
		public boolean letterSend(String pcontent){
			letterDto dto = new letterDto(0, 0, pcontent);
			System.out.println("c에서 문제");
			return  BoardDao.getInstance().letterSend(dto);
			
			
			
			
			
			
		}

	//15. 쪽지확인-----------------------------------------------------
		public void letterCheck() {}
		
	
	
	
	
	
}
