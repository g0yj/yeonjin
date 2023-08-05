package 복습.디자인패턴2.model.dao;

public class MemberDao {
	
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	MemberDao[] memberList= new MemberDao[100];
	
}
