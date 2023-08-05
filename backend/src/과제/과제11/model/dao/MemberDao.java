package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	
	//1. 회원가임 sql
	public boolean signupSQL(MemberDto dto) {
		System.out.println("-----signupSQL 다오 도착");
		System.out.println(dto);
			//1. 회원가입 필요한 SQL을 문자열에 작성해서 저장
				// 테이블에 레코드 삽입: insert into 테이블명(필드명, 필드명) values (매개변수1,매개변수2)
		String sql = "insert into member(mid,mpw,mname,mphone)values(?,?,?,?)";
		
		try {
			//2. 위에서 작성된 SQL를 DB연동객체에 대입 
			//3.대입된 SQL 조작하기 위해 반환된 prepareStatement를 ps에 대입
			ps= conn.prepareStatement(sql);// DB연동객체.prepareStatement(조작할SQL문자열)
				//conn은 Doa라는 부모 클래스에서 물려 받은거 (연동객체)
			//4. sql에서 작성한 매개변수(?)에 대해 값 대입 [.setString(?순서번호,값)]
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			//5. SQL실행(sql프로그램에서는 실행을 위해 ctrl+enter을 눌렀어야했음. 이걸 실행하는 메소드)
			ps.executeUpdate();  //[ps.executeUpdate(); :SQL 실행]
			//6/ 리턴[성공=true/실패=false]
			return true;
		}catch(Exception e) {System.out.println("회원가입실패사유: "+e);}
		return false;
	}
	//2. 로그인sql
	public boolean loginSQL(String id, String pw) {
		System.out.println("-----loginSQL 다오 도착");
		System.out.println(id+pw);
		try {
			
		//1단계 : SQL작성 (추천: 워크벤치에서 임의값으로 작성한다음 복붙) 하나의 문자로 인식되지 않도록 띄어쓰기 주의!
		String sql="select*from member where mid = ? and mpw = ?";
		//2단계: SQL 조작할 수 있는 객체 필요함으로 PreparedStatement 반환받기
		ps= conn.prepareStatement(sql);
		//3단계: SQL 조작[SQL안에 있는 매개변수[?]에 값 대입
		ps.setString(1, id);
		ps.setString(2, pw);
		//4단계: SQL 실행[insert/update/delete:ps.executeUpdate();/select :ps.executeQuery();]
				//실행하고 결과를 rs객체에 대입 <- ps는 결과를 조작할 수 없음
		rs=ps.executeQuery();
		//5단계: sql 실행 결과 조작 [rs.next(): 결과 중에서 다음 레코드 객체 호출]
			//만약 결과의 레코드 3개 가정 [rs=null->레코드1->레코드2->레코드3]
			// null 값을 제거하기 위해 다음 객체를 호출해주는 함수
		
		if(rs.next()) {// 로그인 결과 레코드는 1개거나 0개이기 때문에 if를 사용해 .next()를 한번만 하면됨
			return true;//로그인성공
		}//if
		}catch (Exception e) {System.out.println(e);}
		
		return false; //로그인실패
	}

}
