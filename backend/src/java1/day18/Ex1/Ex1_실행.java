package java1.day18.Ex1;

//2시20분

public class Ex1_실행 {

	
	public static void main(String[] args) {
		//1. 인터페이스타입의 객체 변수 선언
		RemoteControl rc;
				//*인터페이스만으로 객체 생성 불가능[객체 생성하려면 추상메소드를 구현 후 가능]
				// RemoteControl rc2= new RemoteControl() 안됨
		
		//2. 인터페잇 변수에 Television 객체의 대입[주소대입]
		rc = new Television();
		//구현객체: 추상메소드가 존재한 엔터페이스를 구현해준 클래스 객체 생성
		
		//3. 인터페이스로 메소드 실행
		rc.turnOn();

		//4. 리모컨을 오디오 변경
		rc=new Audio();
		
		rc.turnOn();
	
	/*
	 *   인터페이스       			    vs        상속
	 *  implements 							extends
	 *	여러개 구현 가능(*)						1개 상속
	 *	추상메소드								메소드
	 *  다양한메소드 제공[버전에따라]
	 *  목적: 메소드의 통합						목적: 빠른 개발/ 모듈화
	 *	ex. 오락실 게임패드,키보드				ex. 직급별사원
	 *
	 */	
	
		
		//5. 리모콘의 상수 필드 호출
		System.out.println("리모콘의 최대볼륨:" +rc.MAX_VOLUME);
		System.out.println("리모콘의 최저볼륨:" +rc.MIN_VOLUME);
		
	}
	
	
}
