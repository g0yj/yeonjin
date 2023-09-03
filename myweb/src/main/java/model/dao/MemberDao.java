package model.dao;

import model.dto.MemberDto;

//myweb
public class MemberDao extends Dao {
	private static MemberDao d = new MemberDao();
	public static MemberDao getInstance() {return d;}
	private MemberDao() {}
	
// 아이디 중복 유효성 검사-----------------------------------
	public boolean idcheck(String type, String data) {
		try {
			String sql="select mid from mmember where "+type+" =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, data);
			rs=ps.executeQuery();
			if(rs.next()){return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}

// 이메일 중복 유효성 검사-------------------------------------------
	public boolean mailcheck(String type, String data) {
		try {
			String sql="select mid from mmember where " +type+ " =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, data);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}//f()
	

// 회원가입-----------------------------------
 	public boolean signup(MemberDto dto) {
 		try {
 			String sql ="insert into mmember(mid,mpw,mmail,mimg) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getMid()); System.out.println(dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMmail());
			ps.setString(4, dto.getMimg());
			int count= ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println(e);}
 		
 		return false;
 	}
 	
 	
 	}//c