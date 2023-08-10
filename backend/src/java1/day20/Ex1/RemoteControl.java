package java1.day20.Ex1;

public interface RemoteControl {//인터페이스 선언
	//인터페이스: 두 객체를 연결하는 접속기
	// 구성멤버
		
		//1. public 상수 필드	[public static final 이 생략됨]
		int MAX_VOLUME =10;
		public static final int MIN_VOLUME=0;
	
		//2. public 추상 메소드	[public abstract 생략가능]  
								//선언부 => 구현객체 필요
		void turnOn();
		public abstract void turnOff();
		void setVolum(int volume);
		
		//3. public 디폴트 메소드 [public default] : 선언부+샐행부 =>구현객체 필요
		default void setMute(boolean mute) {
			if(mute) {System.out.println("무음처리"); setVolum(MAX_VOLUME);}
			else {System.out.println("무음해제");}
		}//f()
		public default void getMute() {} //public 생략가능
		
		//4. public 정적 메소드 - 정적은 객체 없이 사용하는 거임. 구현 객체 필요 없음.
		static void changeBattery() {System.out.println("리모콘 건전지 교환");}
		public static void checkBattery() {System.out.println("건전지확인");} //public 생략가능한걸 보여줌


	//5,6은 자바 9버전부터 지원 가능. 우리는 8쓰고 있기 때문에 빨간 줄 맞음		
		
		//5. private 메소드 - 외부에서 구현 불가능. 디폴트메소드 안에서만 호출 가능
							// 왜씀? 코드를 줄이기 위함.
		//private void defaultCommon() {System.out.println("디폴트메소드");}
		
		
		//6. private 정적메소드 - 디폴트메소드 ,정적메소드에서 호출 가능
		//private static void staticCommon() {System.out.println("정적메소드");}


}//class

	/*
	 * 	인스턴스멤버: 객체 생성 시 메모리가 할당되는 필드, 메소드 [static이 없는애들]
	 *  정적: 객체가 없어도 메모리가 우선 할당 된 필드, 메소드 [static 있는]
	 *  	  - 정적멤버는 인스턴스멤버에 접근 불가 (P.249)
	 *  	  -
	 * */
	