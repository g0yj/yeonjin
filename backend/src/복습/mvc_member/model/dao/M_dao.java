package 복습.mvc_member.model.dao;

import 복습.mvc_member.model.dto.M_dto;
		

		// 별도로 dao부모 클래스를 만들어서 상속 받도록 해서 db연동 코드를 따로 만들어 함수 호출함으로써 코드를 줄임
public class M_dao extends Dao_M{

	//싱글톤
	private static M_dao d =new M_dao();
	public static M_dao getIntance() {return d;}
	private M_dao() {}
	

//회원가입----------------------------------------------------
	public boolean signupSQL(M_dto dto){
			//1. 필요한 정보를 sql 문자열에 작성하고 저장		
					// sql에서 레코드 추가하는 코드
		String sql="insert into member(mid,mpw,mname,mphone)values(?,?,?,?)";
		try {// 외부와 연결할 때 발생할 수있는 문제를 예외처리함
			
			//2. 위에서 작성된 SQL를 DB연동객체에 대입 
			//3.대입된 SQL 조작하기 위해 반환된 prepareStatement를 ps에 대입	
			
			//★DB연동객체.prepareStatement(조작할SQL문자열)
			ps=conn.prepareStatement(sql); 	//여기 있는 conn은 부모 클래스에 있는 conn임!
			
			//4. sql에서 작성한 매개변수(?)에 대해 값을 대입
			//★ .setString(?순서번호,값)
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4 , dto.getMphone());
			//5. 조작 결과를 받아오는 객체. 
			//★ps.executeUpdate()
			ps.executeUpdate();
			//6. 리턴 [성공 t / 실패 f]
			return true;
		}catch (Exception e) {System.out.println("실패사유: "+e);}
		return false;
	}//signupSQL()
	
//로그인----------------------------------------------------------	
	public int loginSQL(String mid,String mpw) {
		// c 47번째줄에서 여기로 이동해옴.
		// 반환타입을 int로 바꿔줌. 로그인한 회원의 번호를 받을 거기 때문에!!

		String sql = "select*from member where mid=? and mpw=?";
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,mid);
			ps.setString(2, mpw);
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				//1인이유: sql에서 mno은 1번째임!! 검색된 회원번호를 반환 . 64번째줄 retur false였던게 0으로 바꿈
				return rs.getInt(1);// 로그인 상태 저장 필드를 만들기 전까지는 간단하게 true/false로 받아도 됏지만 이젠 로그인한 회원의 번호로 받기로했음
			}
		}catch (Exception e) {
			System.out.println("실패이유: "+e); }
		return 0;
	}//logicSQL()
	
	
	
//4. 아이디 찾기 -------------------------------------------------------------------
	public String findById(String mname, String mphone) {
					// 1-1 c에서 받은 매개변수 String
					// 1-2 우리가 찾을 건 아이디임 . 반환타입을 void->String으로 바꿈
		try {
			//2-1 아이디 찾기를 위한 sql. try-catch 필수니까 하고 시작
			//ㄴ 예외가 발생할 것 같은거. 일반예외: jdbc, 파일처리 시 필수
			//1단계
			String sql = "select mid from member where mname=? and mphone=?";
			// String sql= "select*from member where mname= ? and mphone=? "
			//2단계: 작성된 sql을 조작할 pre~ 객체를 연동객체로부터 반환
			ps= conn.prepareStatement(sql);
			//3단계 : sql조작[매개변수대입]
			ps.setString(1, mname);
			ps.setString(2, mphone);
			//4단계:  sql 실행: 실행결과를 볼 거면 (select) => executeQuery()
							//insert,update,delete=> executeUpdate()
			//5단계: sql 결과를 조작할 Resu~ 객체를
			rs= ps.executeQuery();
			//6단계: sql 결과조작 
				//rs.next() : 검색된 레코드 중 다음레코드 이동]
				//rs.get타입 (검색필드순서번호) : 현재 위치한 레코드의 필드값 호출. 검색필드순서=검색된 레코드의 필드 중의 순서
					//73번째 줄을 기준으로 하면 아이디는 첫번째 필드임. (1) 써줌.
			if(rs.next()) {return rs.getString(1);}
					//만약 74번째 줄을 기준으로 하면 아이디는 두번째 필드임
					//if(rs.next()) {return rs.getString(2);}
				
		}
		catch (Exception e) {System.out.println("dao오류이유: "+e);}
		
		
		return null; // 1-3 작업의 편의를 위해 (빨간줄 없애기) String의 기본 값인 null을 리턴값으로 넣어주고 작업	
	}
			
//5. 비밀번호 찾기 ------------------------------------------------------------------
	public  String findByPw(String mid, String mphone) {
		try {
			String sql = "select mpw from member where mid=? and mphone=?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mphone);
			rs= ps.executeQuery();
			if(rs.next()) {return rs.getString(1);} // 1번인 이유: 조건절에 의해 걸러지는건 mpw 하나임. 
		}catch (Exception e) {System.out.println("dao오류이유: "+e);}
		return null;
		}	
	
//6. 회원정보 중복체크 함수. c 회원가입 과정에서 유효성검사를 위한 함수--------------------
	public boolean infoCheck(String 검색할필드명, String 검색할값) {//c 16번째줄 확인
		try {//try-catch 하는 이유: 회원가입 과정에서 catch 반드시 필요. 관련 함수인 여기도 필수
			String sql = "select*from member where "+검색할필드명+" = ?";
			System.out.println(sql);
			ps=conn.prepareStatement(sql);
			ps.setString(1, 검색할값);
			rs=ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) { System.out.println("dao 실패이유: " + e);		}
		return false; 
	}
	
	
	
	
}//class
