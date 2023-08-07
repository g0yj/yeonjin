package java1.day18.Ex1;


// 인터페이스 선언
public interface RemoteControl {

	// 멤버 구성
		//1. 상수필드[public static final] : 프로그램 내 수정 불가능한 데이터
		
		//int MAX_VOLUME;  //오류
	public static final int MAX_VOLUME=10;
	int MIN_VOLUME=0;
	
	
		//2. 추상메소드 : 선언만 하고 { 구현 }은 하지 않는 함수[구현은 각 클래스가]
			// [public abstract] 리턴타입 메소드명(매개변수1,매개변수2);
	public abstract void turnOn() ;
	void turnOff();		//추상메소드 생략가능한 걸 보여주고 ㅇㅆ음.
	void setVolume(int volume);
			// 추상메소드 두개를 쓴다면 인터페이스 하고 있는 다른 곳들에도 두개 써줘야됨!! 하나만 하면 오류 (밑줄)뜨는 걸 볼 수 있음.
	
	
}
/*
 * 	JVM 실행 메모리
 * 
 *	1. 메소드 영역 				2. 스택 영역 					3. 힙영역
 *	- 클래스 정보 					- 함수 {} 내 변수들			- 객체(인스턴스)
 *	- 메소드					
	- static 정적
	- 인터페이스정보						
*
*	class 사람{					사람 유재석 =102번지			유재석객체(나이 =30) 유재석.밥먹기() =>30
*		int 나이;				사람 강호동 = 103번지			강호동객체(나이=40) 강호동.빕먹기() => 40
*		void 밥먹기(){
*		 print(this.나이)
*	}
*
*
*/