package 복습.디자인패턴2.controller;

import 복습.디자인패턴2.model.dao.MemberDao;

public class MemberController {
	
	private static MemberController memberController= new MemberController();
	public static MemberController getInstance () {return memberController;}
	private MemberController() {}
	
	public boolean JoinLogic(String id,String pw,String phone,String name,int age) {
		for(int i=0; i<MemberDao.getInstance().memberList.length;i++) {
			if(memberList[i]==null)
		}
	}//JoinLogic
	
	
	

}
