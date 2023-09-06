package model.dao;
//9월1일 4시 (모든글출력쪽)
import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	private static BoardDao d = new BoardDao();
	public static BoardDao getInstance() {return d;}
	private BoardDao() {};
	
	
//1. 글쓰기-----------------------------------------
	public boolean bwrite(BoardDto boardDto) {
		try {
			String sql= "insert into board(btitle,bcontent,bfile,mno,bcno)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBfile());
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getBcno());
			int count=ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
//게시물 수 출력------------------------------------------------------------
	public int getTotalSize(int bcno , String key, String keyword) {
		try {
			String sql="select count(*)from board b natural join member m "; //natural join을 추가해 준 이유? 여러개 섞이다 보니 없을 시 java쪽에서 오류 발생하는 걸 확인 할 수 있음.
			//만약에 전체보기가 아니면 [카테고리별 개수]
			if(bcno!=0) {sql += " where b.bcno = "+bcno;}
			
			//- 만약에 검색이 있으면
			if(!key.isEmpty()&&!keyword.isEmpty()) {
				if(bcno!=0) {sql+= " and ";}
				else {sql+= " where ";}
				sql+= " "+key+ " like '%"+keyword+"%' ";
			}
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {return rs.getInt(1);}
		} catch (Exception e) {System.out.println(e);}
		
		
		return 0;
	}//f()
	
	
	
	
	
//2. 모든 글 출력-------------------------------
	public ArrayList<BoardDto> getList(int bcno,int listsize , int startrow,String key, String keyword){
		//*게시물 레코드 정보의 DTO를 여러개 저장하는 리스트
		ArrayList<BoardDto> list=new ArrayList<>();
		try {
			String sql = "select b.*, m.mid, m.mimg, bc.bcname from board b natural join bcategory bc natural join member m ";
			
			// 만약에 카테고리를 선택했으면 [전체보기가 아니면]
			if(bcno!=0) {
				sql+=" where b.bcno= "+bcno;}
			// 검색이 있으면[key와 keyword 모두 빈문자열이 아니면]
				//문자열.isEmpty() : 문자열이 비어있으면 [''] null  vs '' 다름!
			if(!key.isEmpty()&&!keyword.isEmpty()) { //key와 keyword 두개 다 있어야됨!!
				
				//- 만약에 카테고리 내 검색이면 [이미 where구문이 존재하기 때문에 and 조건을 추가]
				if(bcno!=0) {sql+=" and ";}
				else {	sql+= " where ";}
					sql+= " "+key+ " like '%" +keyword+ "%' ";  //띄어쓰기 주의!
					
			}
			
			//뒷부분 공통 sql
			sql+= " order by b.bdate desc limit ? , ?";
				
			ps=conn.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs=ps.executeQuery();
				while(rs.next()) {
					BoardDto boardDto= new BoardDto(
							rs.getInt("bno"), 
							rs.getString("btitle"), rs.getString("bcontent"), 
							rs.getString("bfile"), rs.getString("bdate"), 
							rs.getInt("bview"), rs.getInt("mno"), 
							rs.getInt("bcno"), rs.getString("mid"), 
							rs.getString("bcname"), rs.getString("mimg") 
							);
							list.add(boardDto);
				}
			
		}catch (Exception e) {System.out.println(e);}
		return list;
	}//f()
	
//3. 개별 글 출력------------------------------------
	public BoardDto getBoard(int bno) {
		System.out.println("dao 연결됨");
		viewIncre(bno);//조회수 증가(클릭할때마다오름. 컨트롤러에서 (제어)막아야됨)
		try {
			String sql= " select b.*, m.mid , m.mimg , bc.bcname from board b natural join member m natural join bcategory bc where b.bno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs= ps.executeQuery();
			if(rs.next()) {
				BoardDto boardDto= new BoardDto(
					rs.getInt("bno"), 
					rs.getString("btitle"), rs.getString("bcontent"), 
					rs.getString("bfile"), rs.getString("bdate"), 
					rs.getInt("bview"), rs.getInt("mno"), 
					rs.getInt("bcno"), rs.getString("mid"), 
					rs.getString("bcname"), rs.getString("mimg") 
					); 
				System.out.println("sql에서 boardDto 잘 들어갔니: "+ boardDto);
				return boardDto;
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}//f()
	
//4. 게시물 수정-----------------------------------------
	public boolean onUpdate(BoardDto dto) {
		try {
			String sql = "update board set btitle=? ,bcontent=?, bcno=? , bfile=? where bno=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setInt(3, dto.getBcno());
			ps.setString(4, dto.getBfile());
			ps.setInt(5, dto.getBno());
			int count=ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
//5. 게시물삭제----------------------------------------------
	public boolean ondelete(int bno) {
		try {
			String sql=" delete from board where bno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count =ps.executeUpdate();
			if(count==1) {return true;}
			
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
//6. 조회수 증가------------------------------------------
	
	public boolean viewIncre(int bno) {
		try {
			String sql = "update board set bview =bview+1 where bno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int count=ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
}
