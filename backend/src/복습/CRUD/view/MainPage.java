package 복습.CRUD.view;

public class MainPage {
	//싱글톤 객체 생성- 메소드 간접 호출을 위한 방법
		//1. private static을 이용해 클래스명으로 객체 생성 
	private static MainPage mainPage= new MainPage();
		//2. 간접 호출이 가능하도록 하는 함수 생성
			//public static으로 본인을 호출하는 함수 생성
	public static MainPage getInstance() {return mainPage;}
		//3. private로 잠그기 = 외부로부터 객체 생성을 막음
	private MainPage() {}
	
	
}//class
