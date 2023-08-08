package 복습.mvc_member.controller;

import 복습.mvc_member.model.dao.M_dao;
import 복습.mvc_member.model.dto.M_dto;

public class M_controller {
	//싱글톤
	private static M_controller c = new M_controller();
	public static M_controller getInstance() {return c;}
	private M_controller() {}
	
//회원가입---------------------------------------------------
	public int signupLogic( String mid, String mpw, String mname, String mphone) {
		// 반환타입 유의!
		//6유효성검사: 아이디 , 전화번호 중복 체크  
			//유효성 검사가 없었다면, 가입성공/실패 두가지라 반환타입이 boolean이었는데
			//유효성 검사를 함으로써 경우의 수가 증가함. (가입성공/실패/아이디중복/전화번호중복)
			// boolean-> int로 바꿔줌
		if(M_dao.getIntance().infoCheck("mid", mid))return 3;//아이디중복
		if(M_dao.getIntance().infoCheck("mphone", mphone))return 4;//비밀번호중복
		//view에서 받은 값을 dto객체로 만들어줌(묶어줌)
		M_dto dto = new M_dto(mid, mpw, mname, mphone); // 인스턴스화
		
		boolean result=
				M_dao.getIntance().signupSQL(dto); 
		if(result) {return 1;}
		else {return 2;}
		
		
	}//signupLogic
	
//--------------------------------------------------------	
	// 7번-2. 로그인된 회원의 번호를 저장하는 필드= 웹세션
				// 필드로만든이유: 데이터베이스에 저장할 필요까지 없기 때문에. 추후 라이브러리 있음
	private int loginSession=0; //0: 로그인 안한상태, 1이상: 로그인된 회원의 번호
	
	//getter/setter 만들어줌. 지금은 getter만 필요하긴함
	public int getLoginSession() {
		return loginSession;
	}
	public void setLoginSession(int loginSession) {
		this.loginSession = loginSession;
	}
	
//3.로그인--------------------------------------------------------------------	
	public boolean loginLogic(String mid, String mpw) {
		//7번-3 loginSQL() 의 반환타입을 바꿔줘야됨. d로 이동!
		//7번-4 loginSql에 변환값에 따라 반환타입은 int
		int result=M_dao.getIntance().loginSQL(mid, mpw);
		
		//7번-1 로그인성공했을때 기록 남기기: 로그인 이후의 로그인된 정보로 활동 해야됨.
		if(result>=1) {//회원번호는 1번 이상!!
			this.loginSession=result; return true;}
		else {return false;}
	
	}//loginLogic()
		
//8번 로그아웃------------------------------------------------------
		public void logOut() {this.loginSession=0;}
		
		

//4. 아이디 찾기 -------------------------------------------------------------------
	public String findById(String mname, String mphone) {
			// 1-1 v 에서 받은 매개 변수 String mname~
			// 1-2 우리가 찾을 건 아이디임 . 반환타입을 void->String으로 바꿈
		System.out.println("view value: "+mname+mphone); // 테스트: v에서 제대로 값이 왔는지 확인 
			//2-1 Dao에 매개변수 전달하고 찾은 아이디 반환 받기
		String result=
				M_dao.getIntance().findById(mname, mphone);
		return result; // return null로 넣어놓고 작업하기. 1-3 작업의 편의를 위해 (빨간줄 없애기) String의 기본 값인 null을 리턴값으로 넣어주고 작업-> 후에 return으로 바꿈
		
		}
			
//5. 비밀번호 찾기 ------------------------------------------------------------------
	public String findByPw(String mid, String mphone) {
			System.out.println("view value"+mid+mphone);
			String result =
					M_dao.getIntance().findByPw(mid, mphone);
			return result;
		
		}	
	
}//class
