package arrangement.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC연동 {
	public static void main(String[] args) {
		try {// 
			//1. p908 : 현재 프로젝트에 jdbc파일을 build path add 하기 (프로젝트마다해야됨)
			//2. p909: db연결하기 위해 jdbc driver 클래스를 찾아서 메모리 로딩하기
				// 오라클-> Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 기준
			
				// 만약에 해당 jdbc 드라이버 클래스 검색이 실패하면 예외가 발생=> 예외처리!
			//3. db연결[DriverManager.getConnection()메소드가 연결 성공하면 db와 연결된 객체 리턴-> 만약 실패하면 예외 발생 -> 예외처리
			//Connection conn = DriverManager.getConnection("DB주소", "계정명","비밀번호");
				/*1. db주소: jdbc:mysql://ip주소:port번호/db명
							1.jdbc:oracle:thin:@localhost:1521/orcl <= 오라클
							2. jdbc:mysql://localhost:3306/orcl
				*/
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web","root","1234");
			System.out.println("연동성공 "+conn);
		}
		catch(Exception e) {
			System.out.println("연동실패 사유: "+e);
		}
	}
}

/*
 *	예외처리: 
 *		- Exception 클래스
 *		- 예외[오류]가 발생했을 때 흐름을 제어하는 것. [*만약에 오류가 발생했을 때 다른 코드로 흐름을 제어.(수정아님!!) 
 *		- try{}catch{}
 *			try{예외[오류]가 발생할 것 같은 코드}
 *			catch(예외 클래스명 객체변수명){예외가 발생했을 때 실행할 코드}
 *				*try{} 안에서 예외가 발생하는 순간 바로 catch{}로 이동하기 때문에 예외발생한 코드 아래로는 실행이 안됨.		
 *	
 *			- 오류가 발생할 것 같은 코드?
 *				- 일반예외: 컴파일 과정에서 발생하는 예외[컴파일러가 체크하기 때문에 미러 처리 가능, 빨간줄]
 *						- 파일처리, db연동, 입출력 등등
 *				- 실행예외: 실행 도중에 발생하는 예외	[개발자의 경험으로 판단] <- 프로그램 안전성을 보장할 수 있다는 장점 있음!
 *						- 실행 중 각종 오류 [타입에러, 인덱스부족 등등]
 *						
 *
 */
