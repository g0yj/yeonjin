package java2.day21_예외처리;

public class Ex3_예외던지기 {

	
	public static void main(String[] args) {
		//p.478 : 예외던지기 - 메소드 안에서 예외가 발생하면 해당 메소드를 호출했던 곳으로 예외가 이동
		
		try {
			findClass(); //해당 클래스가 예외던지기 하기 전에는 예외x 15번째줄 
		}catch (Exception e) {}
	}
	
//---------------------------------------
	public static void findClass() {
		Class.forName("java.lang.String2");
	}
	// Class.forName 클래스 안에 들어가보면 예외처리를 throw로 해뒀음. 호출된 곳에서 오류 처리해야하기 때문에 이 클래스에서 try{}catch를 해줘야됨
	
	
//-----------------------------------
	
	public static void findClass1() throws ClassNotFoundException{

			Class.forName("java.lang.String3");
		
	}
	
	
}//c

/*
 *	예외발생 처리 방법2가지
 *	1. try{}catch{}
 *	2. throw  :메인함수 뒤에 넣음
 *		// 웹에서는 자동 예외처리가 가능 [서블릿 클래스]
 */
 