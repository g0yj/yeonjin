package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}

	//1. 회원가임
	public boolean signupLogic(String id, String pw, String name, String phone) {
		System.out.println("--------signupController 도착------");
		System.out.println(id+pw+name+phone);
		
		//유효성 검사 추천!
		
		//1. 객체화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			//1. 회원가입 시 회원번호는 자동[auto_increment]이기 때문에 필요 없긴 한데 생성자 굳이 더 만들 필요 없으니 기본값 0
		//2. Dao에 전달	하고 sql 결과 받기
		boolean result=
				MemberDao.getInstance().signupSQL(dto);
		//3. 결과를 view에 전달
		return result;
	}//signupLogic()
	
	
	
	
	
	//2. 로그인
	public boolean loginLogic(String id, String pw) {
		System.out.println("--------loginController 도착------");
		System.out.println(id+pw);
		//유효성검사 했다치고
		//1. 매개변수가 2개라서 객체화 해도되고 안해도됨
		//2.Dao에게 전달
		boolean result = MemberDao.getInstance().loginSQL(id, pw);
		return result;
	}//loginLogic()
	
	
	
	
	
}//class
