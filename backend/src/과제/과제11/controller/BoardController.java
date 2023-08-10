package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

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

	
//10. boardPrint : 모든 게시물 출력------------------------------
	public ArrayList<BoardDto> boardPrint() {
		return BoardDao.getInstance().boardPrint();
	}
	
//11. boardView : 개별 게시물 출력-------------------------------------------------
	public BoardDto boardView(int bno) {
		return BoardDao.getInstance().boardView(bno);
	}
	
	
	
	//12. boardUpdate:  게시물 수정
	public void boardUpdate() {}
	//13. boardDelete: 게시물 삭제
	public void boardDelete() {}
	
	
	
	
	
}
