package 복습.CRUD.controller;

import 복습.CRUD.model.dao.BoardDao;
import 복습.CRUD.model.dto.BoardDto;

public class BoardController {
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {return boardController;}
	private BoardController() {};
	
	
	public boolean writeLogic(String content, String writer) {
		System.out.println("쓰기컨트롤러 도착~");
		BoardDto boardDto = new BoardDto(writer,content);
		BoardDao.getInstance().boardList.add(boardDto);
		
		return true;
		}//writeLogic()


	public void printLogic(int index) {
		BoardDto boardDto = BoardDao.getInstance().boardList.get(index);
		
			
	
	}// printLogic()


}//class
