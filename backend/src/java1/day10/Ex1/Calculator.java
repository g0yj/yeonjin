package java1.day10.Ex1;


//목적: 설계도
public class Calculator {//class
	
	//1. 필드
	
	
	//2. 생성자
	
	
	
	//3. 메소드: 객체의 동작[*객체간의 상호작용]
		//1. 리턴타입: 메소드 실행 한 후 호출했던 곳으로 전달하는 값의 타입
		//2. 메소드명: 소문자 시작, 카메류ㅛ기법
		//3. 매개변수: 메소드 호출 시 전달한 매개값
		//4. { } : 메소드 호출 시 실행되는 구역/부분
	
			//1. 리턴이 없는 메소드 => 리턴도 없고 매개변수도 없는 (단순 실행만)
	void powerOn() {
		System.out.println("전원김");
		}

		//2. 리턴값이 없는 메소드 (단순 실행만)
	void powerOff() {
		System.out.println("전원끔");
		}
	
		//3. 리턴값/ 매개변수가 있는 메소드
	int plus(int x, int y) {
		powerOn();
		int result= x+y; //매개변수로부터 전달 받은 2개의 변수를 더함
		return result; //void를 제외한 리턴타입이 있을 경우 return은 반드시 써 줘야함.
				//호출했던 곳으로 더하기 한 결과를 전달
	}
	
	
	 double divide (int x,int y) {
		 double result=(double)x/(double)y;
		 return result;
	 }
	
	
}//class
