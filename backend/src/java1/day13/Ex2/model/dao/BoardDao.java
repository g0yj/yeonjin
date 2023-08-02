package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {

	// 싱글톤 사용 가능 (공유)
	private static BoardDao boardDao= new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {};	
	
	// 게시물 여러개 저장하는 곳
	
		//1. 배열
		//public BoardDao[]boardDtoArray= new BoardDto[100];
		
		//2. 리스트 : 배열을 쉽게 사용할 수 있도록 다양한 함수를 제공
		public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
			// ArrayList : 배열처럼 사용 가능한 클래스 선언
				//<클래스> : 리스트객체 안에 여러개 객체를 저장할 저장 객체의 타입
					//boardList: 리스트 객체 변수명
	
}

/*
 * 
 * 
 	- 배열 :boardDtoArray
 			[] [] [] [] []
 	
 		- 배열에 값을 저장하는 방법
 		for(int i==0; i<배열명.length; i++){
 			if(배열명[i]==null){배열명[i]=객체명;}
 		}
 		
 		- 배열에서 값 호출하는 방법
 			배열명[인덱스]
 			
 		- 배열에서 값 삭제하는 방법 
 			삭제 불가능. 대신 초기값 대입해서 삭제처럼 표현
 			배열명[index]=null;
 			-> 중간에 삭제되니까 한칸씩 당기기해서 null을 가장 뒤로 보냄. 
 				반복문 돌려서 할 수 있었는데 까먹음 ㅋ(DAY06 EX1 예제 참고).. 리스트쓰면 이 과정 없어도 ㄱㅊ
 			
 	- 리스트: ArrayDtoList
 			-----------
 			|		  |
 			|boafdDto |	
 			|boafdDto |	
 *			|		  |
 *			-----------
 *			-리스트 선언하는 방법 
 *				ArrayList<타입명>리스트객체변수명=new ArrayList<>();			
 *
 *
 *			- 리스트객체명.add(객체명) : 해당 객체 리스트에 저장,마지막인덱스로 뒤에 객체 추가
 *			
 *			- 리스트에 값 호출하는 방법 
 *				리스트객체명.get(인덱스)
 *
 *			- 리스트에 값 삭제하는 방법
 *				리스트객체명.remove(인덱스); : 해당 인덱스의 객체 삭제[한칸씩 당기기도 해줌, 중간 객체 삭제해도 자동채움]
 *
 *
 */
 