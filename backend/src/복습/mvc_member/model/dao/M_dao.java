package 복습.mvc_member.model.dao;

import 복습.mvc_member.model.dto.M_dto;
		

		// 별도로 dao부모 클래스를 만들어서 상속 받도록 해서 db연동 코드를 따로 만들어 함수 호출함으로써 코드를 줄임
public class M_dao extends Dao_M{

	//싱글톤
	private static M_dao d =new M_dao();
	public static M_dao getIntance() {return d;}
	private M_dao() {}
	

//메소드----------------------------------------------------
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
	
	
	public boolean loginSQL(String mid,String mpw) {
		String sql = "select*from member where mid=? and mpw=?";
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,mid);
			ps.setString(2, mpw);
			
			rs= ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println("실패이유: "+e); }
		return false;
	}//logicSQL()
	
}//class
