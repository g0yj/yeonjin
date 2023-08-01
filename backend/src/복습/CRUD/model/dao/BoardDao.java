package 복습.CRUD.model.dao;

import java.util.ArrayList;

import 복습.CRUD.model.dto.BoardDto;

public class BoardDao {
	//싱글톤객체
	private static BoardDao boardDao = new BoardDao();
	
	// BoardDao가 왜 나오는지?
		// 반환타입을 적어준거임. public void 함수명() 이런거 처럼. 
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	
	public ArrayList<BoardDto>boardList=new ArrayList<>();
}