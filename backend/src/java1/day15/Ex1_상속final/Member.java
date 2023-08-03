package java1.day15.Ex1_상속final;

public class Member {

	/*
		final 키워드: 수정 불가능한 상태를 사용하는 키워드
		 	- 필드
		 		final int 나이 =30;  : 수정 불가능한 필드[나이필드에 30값은 초기화 이후 변경 불가능]
		 	- 클래스
		 		final class Member{} : 해당 클래스는 상속 불가능 [상속불가 클래스]
		 		
		 	- 메소드
		 		final void stop(){} : 해당 메소드는 자식클래스가 오버라이딩 불가
	 */
	
	public  void stop1() {}
	
	public void stop2() {}
	
	
		/*
		 * 접근 제한자
		 * public 					vs 				protected
		 * - 모든(클래스) 범위							- 현(클래스)범위
		 * - 프로젝트 내 모든곳 호출						- 현재 클래스에서만 호출
		 * 
		 * 
		 * (defualt)					vs 				protected
		 * - 현재 클래스의 패키지 내						- 현재 클래스의 패키지 내
		 * - 무조건 동일패키지내/하위패키지에				- 동일 패키지내/하위패키지
		 *  										- 단, 자식클래스가 다른 패키지에 있는 부모클래스에게 호출 가능
		 * 
		 * */
	
}
