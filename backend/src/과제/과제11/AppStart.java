package 과제.과제11;


import 과제.과제11.view.MainPage;

public class AppStart {
	public static void main(String[] args) {
		
		// MainPage 싱글톤객체 호출(해당 객체의 메소드 호출) <- 두번의 과정을 거친거임
			//1. MainPage.getInstance(): MainPage 싱글톤객체 호출
				// 반환=> mainPage객체가 반환
				//2. mainPage.mainView()
				//getIstance()에서 반환된 객체(싱글톤객체)가 mainView()함수를 호출
		MainPage.getInstance().mainView();
		
	}//main
	
	
	
	
	
}//class
