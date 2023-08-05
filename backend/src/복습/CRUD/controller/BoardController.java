package 복습.CRUD.controller;


public class BoardController {
	//싱글톤 객체 만들기
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {return boardController;}
	private BoardController() {}

}//class
