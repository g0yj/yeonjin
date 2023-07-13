package java1.day01;

public class Ex1_변수 {
	
	// main + crlt+ space
	public static void main(String[] args) {
		
		/*
		int value; // int 타입으로 value 이름으로 변수 선언
		int result= value+ 10  // 오류. 변수 선언과 동시에 메모리 저장되는 거 아님. value 변수에 값이 없으므로 연산이 불가능
		*/		
		
		int hour = 3;  //int 타입으로 hour 이름으로 변수 선언
		int minute=5; //
		System.out.println(hour+"시간"+minute+"분");  // 문자열 처리 "" /  연결 +
		
		int totalMinute=(hour*60) + minute;  // 변수에 값이 있으면 연산 가능.
		System.out.println("총"+totalMinute+"분");
		
		
		
	} // main 끝
	
	

}// class 끝
