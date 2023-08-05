package 복습.mvc_member.controller;

import 복습.mvc_member.model.dao.M_dao;
import 복습.mvc_member.model.dto.M_dto;

public class M_controller {
	//싱글톤
	private static M_controller c = new M_controller();
	public static M_controller getInstance() {return c;}
	private M_controller() {}
	
//메소드-------------------------------------------------
	public boolean signupLogic( String mid, String mpw, String mname, String mphone) {
		// 반환타입 유의!
		
		//view에서 받은 값을 dto객체로 만들어줌(묶어줌)
		M_dto dto = new M_dto(mid, mpw, mname, mphone); // 인스턴스화
		
		boolean result=
				M_dao.getIntance().signupSQL(dto); 
		
		return result;
		
	}//signupLogic
	
	
	public boolean loginLogic(String mid, String mpw) {
				M_dao.getIntance().loginSQL(mid,mpw);
		boolean result=M_dao.getIntance().loginSQL(mid, mpw);
		return result;
		
	}//loginLogic()

	
	
}//class
