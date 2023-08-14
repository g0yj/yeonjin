package arrangement.Pattern.signup_board.controller;

//1시20분
import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {
	
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}

	//1. 회원가임
	public int signupLogic(String id, String pw, String name, String phone) {
		System.out.println("--------signupController 도착------");
		System.out.println(id+pw+name+phone);
		
		//유효성 검사 추천!
		//1. 아이디 중복체크
		if(MemberDao.getInstance().infoCheck("mid",id))return 3;
		if(MemberDao.getInstance().infoCheck("mphone",phone))return 4;
		
		//1. 객체화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			//1. 회원가입 시 회원번호는 자동[auto_increment]이기 때문에 필요 없긴 한데 생성자 굳이 더 만들 필요 없으니 기본값 0
		//2. Dao에 전달	하고 sql 결과 받기
		boolean result=
				MemberDao.getInstance().signupSQL(dto);
		//3. 결과를 view에 전달
		if(result)return 1;
		else return 2;
	}//signupLogic()
	
	
	
	
	
	// 로그인된 회원의 번호를 저장하는 필드 = 웹세션
	private int loginSession=0; //0: f로그인 안한 상태 1이상: 로그인된 회원의 번호
	public int getLoginSession() {return loginSession;}
	
	//2. 로그인
	public boolean loginLogic(String id, String pw) {
		System.out.println("--------loginController 도착------");
		System.out.println(id+pw);
		//유효성검사
		
		//1. 매개변수가 2개라서 객체화 해도되고 안해도됨
		//2.Dao에게 전달
		int result = MemberDao.getInstance().loginSQL(id, pw);
		
		//로그인 성공햇을 때 기록하기 [로그인 이후 로그인된 정보로 활동]
		if(result>=1) {this.loginSession =result; return true;}
		else {return false;}
	}//loginLogic()
	
	//로그아웃
	public void logOut() {this.loginSession=0;}
	
	
	//4.
	public String findById(String mname, String mphone) {
		//테스트: view에서 전달받은 매개변수를 중간중간에 확인해줘야됨
		System.out.println("view value: "+mname+mphone);
		
		//Dao에 매개변수 전달하고 찾은 아이디 반환 받기
		String result=
				MemberDao.getInstance().findById(mname, mphone);
		//변수로 담으면 좋은 이유: 추후 행동이 있다면 
		//if(result!=){핸드폰문자전송함수}
		return result;
	}//findById()
	
	
	//5.
	public String findByPw(String mid, String mphone) {
		String result=
				MemberDao.getInstance().findById(mid, mphone);
		
		return result;
	}
	
	
	//6.회원정보페이지(로그인된 회원정보보기)
public MemberDto info() {
		// 현재 로그인된 회원번호는 view에서 전달 받지 않고 컨트롤안에 저장되어 있어 바로 전달 가능
		//현재 로그인된 회원번호로 회원정보 요청
		return MemberDao.getInstance().info(this.loginSession);
	}
	
public boolean infoUpdate(String newPw) {
	return MemberDao.getInstance().infoUpdate(newPw, loginSession);
	
}



public boolean infoDelete() {
	return MemberDao.getInstance().infoDelete(loginSession);
	
}
	
	
	
}//class
