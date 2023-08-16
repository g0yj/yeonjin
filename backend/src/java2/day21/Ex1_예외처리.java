package java2.day21;

public class Ex1_예외처리 {
	
//---------------------------------------------------------------------------------------------	
/*****	예외처리 안한 코드 
  public static void printLength(String data) {
		int result = data.length();	//1.ThisIsJava -> String 객체의 주소값이 없음 , 2.null->객체의 주소값 없음
		System.out.println("문자수: "+result);
	}   
*/	
	
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자수: "+result);
			
		}catch (NullPointerException e) {// 예외 발생하면 이곳으로 이동하고 *예외 정보를 객체 내 저장
				//NullPointerException : 이유는 처음에는 모르지만 .. 실행한 결과 (경험) NullPointerException 예외 발생했다는 경험을 바탕으로
			
			System.out.println(e.getMessage());
			System.out.println(e);// 오류 정보를 파일처리해서 추후에 문제 발생한 것들을 개발자가 유지보수 해줘야됨.
		}finally {//예외가 발생 하던 안하던 무조건 실행되는 코드
			System.out.println("finally 실행");
		}
	}
	
	
//------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) {
		
		//p.466: 실행예외[실행 후 예외가 발생하기 때문에 예외처리는 경험/테스트 후에 예외처리 가능]
		//일부로 오류를 발생시키는 코드를 만들고 해결할거임
		System.out.println("프로그램시작");
		printLength("ThisIsJava");
		printLength(null);	
				// NullPointerException 발생주소가 없기 때문에 함수 사용 불가
					//종료되면서 아래 코드 실행 안됨.
		System.out.println("프로그램종료");
	
		//p.468 : 일반예외[실행 전부터 컴파일러가 예외 검사 하기 때문에 예외처리가 필수로 들어감]
		try {
			Class.forName("java.lang.String"); //Class.forName : 클래스 찾기 - java.lang.String
												//예외발생!! : ClassNotFoundException - 만약 클래스를 못 찾았을 때는 예외처리해줘라
			System.out.println("java.lang.String 클래스 존재");
		}catch (Exception e) {e.printStackTrace();}
		
		
		try {
			Class.forName("java.lang.String2"); //java.lang.String2 클래스는 존재하지 않으므로 예외발생. catch로 이동
			System.out.println("java.lang.String2 클래스 존재");
		}catch (Exception e) {e.printStackTrace();}
		
		
	}//m
	
//-------------------------------------------------------------------------------------------------	
}//c

/*
 *	에러: 컴퓨터의 하드웨어 고장으로 인해 실행 오류가 발생
 *	예외: 에러 이외의 모든 것 (소프트웨어적인)
 *			* 프로그램에 예외가 발생했을 때 정상적인 실행 유지할 수 있도록
 *
 *		1. 일반예외 - 컴파일러가 예외 처리 코드 여부를 검사하는 예외
 *				  - 외부입출력 관련:  파일처리, JDBC(DAO) , 네트워크, 입출력
 *		2. 실행예외 - 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
 * 				  - 실행 도중에 오류가 발생하는 것: 개발자의 경험에 의존 
 * 				  - 타입오류, 배열인덱스, NULL(객체가없음.메소드사용X)
 * 	예외처리 
 * 		try{예외가 발생할 것 같은 코드}
 * 		catch(예외클래스 변수객체){예외가 발생했을 때 코드}
 * 		finally{예외와 상관 없이 항상 실행되는 코드}
 * 
 */
