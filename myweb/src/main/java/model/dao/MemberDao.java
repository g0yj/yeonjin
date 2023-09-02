package model.dao;

//myweb
public class MemberDao extends Dao {
	private static MemberDao d = new MemberDao();
	public static MemberDao getInstance() {return d;}
	private MemberDao() {}
	
// 아이디 중복 유효성 검사-----------------------------------
	public boolean idcheck(String type, String data) {
		try {
			String sql="select mid from member where "+type+" =?";
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
			String sql="select mid from member where " +type+ " =?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, data);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}//f()
	

}
