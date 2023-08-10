package 과제.과제11.model.dao;
//12시

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;

public class BoardDao extends Dao{

	private static BoardDao boardDao=new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	
	
//9. boardWrite : 게시물쓰기---------------------
	public boolean boardWrite(BoardDto dto) {
		try {
			String sql="insert into board(btitle,bcontent,mno) values (?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setInt(3, dto.getMno());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("dao오류:"+e);}
		return false;
	}//f()
	
	
//10. boardPrint : 모든 게시물 출력---------------------------
		//반환타입: 
	public ArrayList<BoardDto> boardPrint() {
		ArrayList<BoardDto>list=new ArrayList<>();
		try {//1. 최신순으로 모든 게시물 호출
			
			//1-1경우 : String sql = "select*from board order by bdate desc"; 
			//1-2일경우
			String sql = "select b.* , m.mid from member m natural join board b order by b.bdate desc";
			ps=conn.prepareStatement(sql);
			//3. sql의 매개변수가 없으니 set~ 는 쓸게 없음
			//4. 검색결과의 레코드를 여러개 조작하기 위해 resultSet 반환
			rs= ps.executeQuery(); 
			//5. 여러개 레코드 조회 
			while(rs.next()) {//마지막 레코드까지 하나씩 레코드 이동(다음레코드가 존재하지 않을 때까지 무한반복)
				//레코드 1개마다 1개의 dto 반환
				//1-1 경우: BoardDto dto=new BoardDto(
									//rs.getInt(1), rs.getString(2), rs.getString(3), 
									//rs.getString(4),rs.getInt(5), rs.getInt(6), null);
				//1-2 경우
				BoardDto dto = new BoardDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7) );
				
				
				//변환된 Dto를 리스트객체에 담기
				list.add(dto);
			}//w
		}catch (Exception e) {System.out.println("dao문제: "+e);}
		return list;
		
	}
/*
 *	테이블
 *		1. 레코드/행/가로 -> 레코드 하나당 DTO 하나
 *		2. 레코드/행/가로  여러개 DTO를 하나의 객체로 만들어줘야 (LIST)
 *		3. 레코드/행/가로 
 *
 *		1. 제목  2. 내용 3. 날짜 조회수 -->boardDTO
 *		2. 제목  2. 내용 3. 날짜 조회수 -->boardDTO
 *		3. 제목  2. 내용 3. 날짜 조회수 -->boardDTO
 *		// ArrayList<boardDTO> vs boardDTO[]
 *
 *		예) 로그인한 회원 정보 조회 =DTO
 *			관리자가 고든 회원정보 여러개 조회 =ArrayList<>
 */
	
//11. boardView : 개별 게시물 출력(게시물한개만출력)-------------------------------------------------------
	public BoardDto boardView(int bno) {
		try {
			String sql ="select b.* , m.mid from board b natural join member m where b.bno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1) , rs.getString(2) , rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7) );
				boardViewCount();
				return dto;
			}
		}catch (Exception e) {System.out.println("dao오류이유: "+e);}
		return null;
	}
	
//11-2조회수 증가함수---------------------------------------------------------------
	public boolean boardViewCount() {return false;}
	
	
	
//12. boardUpdate:  게시물 수정---------------------------------------------------------
	public void boardUpdate() {}
	

	//13. boardDelete: 게시물 삭제----------------------------------------------
	public void boardDelete() {}
	
	
	
	
	
}
