package arrangement.Pattern.signup_board.model.dao;

//1시 20분 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 만드는 이유 ?! 각 Dao마다 새롭게 만들 필요 없이 하나 만들어두고 나머지 클래스들에 상속시키기

public class Dao {//각종Dao 클래스를 대표하는 부모클래스 ! <-상속의 특징을 사용해 클린코딩~!
	//1. 필드
	public Connection conn;	//DB연동 객체 (연동만!)
	public PreparedStatement ps; //연동된 DB에서 SQL조작(SQL매개변수대입,SQL실행취소)하는 객체
	public ResultSet rs; // SQL 조작 결과를 가져온 객체
	
	//2. 생성자: 객체 생성 시 초기화 담당
		// 기본생성자에 DB연동 코드 작성 *DAO객체 생성시 바로 DB연동
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			//여기에 Connection conn 이라고 적어서 오류떴었음. JDBC연동 파일 무작정 복붙하면 안됨! 
			//연동하는 코드를 필드에 대입해야되는거임 .. 안에다 넣으면 지역변수가 되는거라 null이 뜸. this.conn 해도 ㄱㅊ~!
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web","root","1234");
		System.out.println("DB연동성공");	
		}
		catch(Exception e) {System.out.println("DB연동실패: "+e);}
		
	}//Dao()

	
}//class
