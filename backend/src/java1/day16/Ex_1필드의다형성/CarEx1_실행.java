package java1.day16.Ex_1필드의다형성;

public class CarEx1_실행 {

	public static void main(String[] args) {
		
		//1.Car객체 생성
		Car myCar = new Car();	// tire필드에 객체가 없는 상태
		System.out.println(myCar.tire); // null 출력. 참조타입은 필드에 초기화가 없으면 기본값[null]이 들어감.
	
		//2. Car 객체의 타이어 장착 = Car객체의 타이어 필드에 초기화
		myCar.tire=new Tire(); //기본타이어 객체를 대입
		System.out.println(myCar.tire); // 주소값
		
		//3. 타이어(객체)가 장착된 Car객체가 전진
		myCar.run();
		
		//4. 타이어교체 (=객체교체) 하기 위해 카센터에서 한국타이어로 교체
		myCar.tire=new HankookTire();
		System.out.println("myCar.tire"); // 한국타이어 주소값 출력
		
		//5. 타이어 교체 장착된 Car객체 전진
		myCar.run(); // 한국타이어 회전 출력됨 . 한국타이어 객체가 roll메소드 실행
		
		//6. 타이어 교체 카센터에서 금호 타이터로 교체
		myCar.tire = new KumhoTire();// 기존에 있던 한국타이어객체는 자동 삭제 가비지컬렡ㄱ터
		System.out.println(myCar.tire); // 금호타이어 주소값 출력
		
		//7. 타이어(객체) 교체장착된 Car객체가 전진
		myCar.run();
	}//main
}
