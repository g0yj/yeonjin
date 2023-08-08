package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;


//11시 48분
public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	
	// 회원정보 checkSQL(유효성검사를 위해)
		// 첫번째 방법: type을 쓰는 이유 : type=1 아이디 중복체크, type=2 비밀번호중복체크로 굳이 똑같은 걸 두번 만들 필요 없으니깐
		//public boolean infoCheck(int type, String[]values) {
		//두번째방법:
	public boolean infoCheck(String 검색할필드명, String 검색할값)	{
	try {	//오류: You have an error in your SQL syntax // SQL 문법 오류 발생
			String sql="select*from member where "+검색할필드명+"=?"; System.out.println(sql);
			ps= conn.prepareStatement(sql);
			ps.setString(1, 검색할값);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}// 레코드 존재 -> 이미 있는 데이터 - > 중복
		} catch (Exception e) {System.out.println(e);}

	
		
		return false;
		
	}
	
	
	
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
	public int loginSQL(String id, String pw) {
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
			return rs.getInt(1);//로그인성공 , 검색된 회원번호 반환
		}//if
		}catch (Exception e) {System.out.println(e);}
		
		return 0; //로그인실패
	}

	
	//4. 아이디찾기
			//String으로 받는 이유: 맞는 아이디를 찾아와 return해줄거임
	public String findById(String mname, String mphone) {
		
	
		try {
			
			//1. sql 작성
			String sql = "select*from member where mname=? and mphone=?";
			//2. 작성된 sql 조작할 Pr~ 객체를 연동객체로부터 반환
			ps= conn.prepareStatement(sql);
			//3. sql 조작 
			ps.setString(1, mname);
			ps.setString(2, mphone);
			//4. sql 실행
			//5. sql 결과를 조작할 ResultSet 객체를 메소드로부터 반환 받음
			rs= ps.executeQuery();
				// rs.next() : 검색된 여러 레코드 중 다음 레코드 위치 이동
				//rs.getString(검색필드순서번호):현재 위치한 레코드 필드값 호출. 문자열로
			if(rs.next()) {return rs.getString(2);} //sql에 따라 필드 순서가 달라질 수 있음에 유의!
			
		
		} catch (Exception e) {System.out.println("Dao실패이유: "+e);}
		
		return null;// 빨간줄 생기니까 String의 기본값인 null을 미리 넣어놓고 큰 틀 잡아 넣고 알맹이 채워넣기
		
	}
	
	//5. 
	public String findByPw(String mid, String mphone) {

		try {
			
		String sql = "select mpw from member where mid=? and mphone=?";
		ps= conn.prepareStatement(sql);
		ps.setString(1, mid);
		ps.setString(2, mphone);
		rs=ps.executeQuery();
		if(rs.next()) {return rs.getString(3);} 
		
		} catch (Exception e) {System.out.println("Dao실패이유: "+e);}
		
		return null;// 빨간줄 생기니까 String의 기본값인 null을 미리 넣어놓고 큰 틀 잡아 넣고 알맹이 채워넣기
	}
	
	//6.회원정보페이지 : 회원번호를 가지고 회원정보 찾기. 회원번호가 존재하는 레코드 찾기
public MemberDto info(int mno) {
	try {
		//1. sql작성
		String sql ="select*from member where mno=?";
		//2. sql조작 객체를 가져옴
		ps=conn.prepareStatement(sql);
		//3. SQL 조작
		ps.setInt(1, mno);
		//4. SQL 실행, 5.sQL결과 조잦객체
		rs = ps.executeQuery();
		//6. sql결과 조작 , 만약에 다음 레코드가 존재한다면
		if(rs.next()) {
			//*현재 레코드를 dto로만들기
			// 3번이 null인 이유. 비번은 들고다니지 않음. null로 하는 걸 추천
			MemberDto dto=new MemberDto(
					rs.getInt(1),rs.getString(2),
					null,rs.getString(4),
					rs.getString(5));
			return dto;
			
		}
	} catch (Exception e) {System.out.println(e);}
	
	
	return null;
		
	}
	
public boolean infoUpdate(String newPw, int mno) {
	try {
		String sql="update member set mpw= ? where mno = ? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, newPw);
		ps.setInt(2, mno);
		int row= ps.executeUpdate(); //row에 대입해주는 이유는 업데이트한 레코드 개수를 반환해주고 있음. 유효성 검사임.
		if(row==1) return true;
		
	}
	catch (Exception e) {
	}
	
	return false;
	
}



public boolean infoDelete(int mno) {
	try {
		String sql = "delete from member where mno= ? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, mno);
		int row =ps.executeUpdate();
		if(row==1) {return true;}
	} catch (Exception e) {System.out.println(e);}
	
	return false;
	
}


	
	
	
}
