package java2.day21_예외처리;

//예외클래스만들기
	// 표준 라이브러리(미리 만들어서 제공된 클래스)에서 제공하지 않는 예외클래스 만들기 가능
	

	//1. Exception 클래스 상속
	//2. 생성자에 예외가 발생한 이유를 매개 변수로 받아 상속받은 Exception객체에게 전달
		//this: 현객체  /.super: 현객체의 부모객체
	//3. 예외발생: throw new 예외클래스명(예외사유);

public class 잔고부족예외 extends Exception{//Exception 나 RuntimeException)
	
	
	
	// 기본 생성자
	public 잔고부족예외() {	};
	// 매개변수 1개 생성자 : 예외 정보를 받기 위한 매개변수
	public 잔고부족예외(String message) {super(message);}

}
