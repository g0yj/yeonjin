package model.dao;

import java.time.LocalDateTime;

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
	
	//2. 로그인
	public boolean login(String mid, String mpwd) {
		try {
			String sql ="select*from member where mid=? and mpwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
			else {return false;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	//5. 내정보 호출----------------------------------
	public MemberDto info(String mid) {
		try {
			String sql = "select mno, mid, memail, mimg from member where mid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs= ps.executeQuery();
			if(rs.next()) {
				MemberDto memberDto = new MemberDto(LocalDateTime.now().toString(), //LocalDateTime.now().toString() :
										rs.getInt(1),
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4));
				return memberDto;
			}
		} catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	
	//6. 아이디 중복검사-----------------------------------
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

//7. 회원수정
	public boolean mupdate(int mno, String mimg) {
		try {
			String sql="update member set mimg=? where mno=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mimg);
			ps.setInt(2, mno);
			int count= ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	
	
	
//8.회원탈퇴[삭제할회원번호,검증할패스워드]----------------------------------------
	public boolean mdelete(int mno, String mpwd) {
		try {
			String sql="delete from member where mno=? and mpwd=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			int count = ps.executeUpdate();
			if(count==1) {System.out.println("회원삭제");return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}//f()
	
	
}
