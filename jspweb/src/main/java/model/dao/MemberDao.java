package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao d= new MemberDao();
	public static MemberDao getInstance() {return d;}
	private MemberDao() {};
	
	//1. 회원가입
	public boolean signup(MemberDto dto) {
		try {
			String sql="insert into member(mid,mpwd,memail,mimg)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			int row = ps.executeUpdate();
			if(row==1) {return true;}
		} catch (Exception e) {System.out.println("dao오류"+e);}
		return false;
	}
	
	//6. 아이디 중복검사
	public boolean findIdOrEmail(String type,String data) {
		try {
			String sql ="select*from member where "+type+" =?";//띄어쓰기 주의!!! where 뒤랑 = 앞에.
			ps=conn.prepareStatement(sql);
			ps.setString(1, data);
			rs=ps.executeQuery();
			//while: 결과 레코드 여러개 검사 vs if: 결과 레코드 한개 검사
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("dao:오류" +e);}
		return false;
	}//f()
	
	
	
	
}
