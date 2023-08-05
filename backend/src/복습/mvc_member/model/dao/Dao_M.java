package 복습.mvc_member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao_M {
	
	//1. 필드
	public Connection conn;  //db연동 하는 객체
	public PreparedStatement ps; // 연동된 db의 sql 조작 객체 (prepared:준비된)
	public ResultSet rs; // sql 조작 결과를 가져오는 객체
	
	//2. 생성자 : 기본생성자로 DB연동 코드를 작성 (= DAO객체 생성 시 바로 DB가 연동되도록)
	public Dao_M() {
		try {
			
			//1. 현재 프로젝트에 jdbc파일을 build path add! 
				//프로젝트마다 해야되는 불편함을 해결하기 위해 지금 클래스 만듦.-> 다른 Dao 클래스에 상속시킴
			
			//2. db연결하기 위해 jdbc driver 클래스를 찾아서 메모리 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//3. db연결[DriverManager.getConnection()
				//성공하면 db와 연결된 객체 리턴
				//만약 실패하면 예외 발생 -> 예외처리 필수로 해줘야
				//Connection conn = DriverManager.getConnection("DB주소", "계정명","비밀번호");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/review","root","1234");
		}catch (Exception e) {System.out.println("DB연동실패: "+e);}
	}//Doa()

	
	/*
	 *	생성자: 객체를 생성할 때 초기화 역할을 담당[필수X]
		생성자명: 클래스 명과 동일 (메소드와 비슷하지만 리턴이 없음. 인수/매개값은 있음)
		생정자명(매개변수,매개변수,매개변수){ } <-매개변수는 모두 stack에 저장
		실행조건: 1. 매개변수로 전달된 값을 필드에 저장
				2. (안전상)필드에 저장하기 전에 가공/유효성검사

	 */
	
	
}//class
