package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

		public Connection conn;
		public PreparedStatement ps;
		public ResultSet rs;
		
		//2. 생성자
		public Dao() {//자식객체가 생성되면 부모도 같이 생성![*객체생성된다는 건 생성자가 호출되는 걸 의미, 자식을 켜면 부모가 호출돼서 부모도 실행됨]
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				this.conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb","root","1234");
				System.out.println("DB연결성공");
			} catch (Exception e) {System.out.println("연동실패: "+e);}
		}
	
	
	
	

}
