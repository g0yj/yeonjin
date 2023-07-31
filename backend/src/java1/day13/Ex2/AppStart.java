package java1.day13.Ex2;

import java1.day13.Ex2.view.MainPage;

public class AppStart {
	
	public static void main(String[] args) {
		//다른 클래스/객체에 있는 메소드 호출 방법 - 3가지 중 싱글톤 사용
		MainPage.getInstance().mainView();
		//MainPage : 클래스명
			//MainPage.getInstance() : 클래스 안에 있는 정적멤버 호출 후 반환
			// 반환: 싱글톤을 반환 받음
				//MainPage
	}//main
	

}//class
