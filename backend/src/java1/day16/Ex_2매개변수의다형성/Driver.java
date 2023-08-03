package java1.day16.Ex_2매개변수의다형성;
// 2시40분. 유효성 어쩌구
public class Driver {

	// 매개변수의 다형성 ㅁ예제의 메소드 선언
	public void drive( int value, Vehicle vehicle) {//매개변수 타입과 자식타입 포함
		
		// 매개변수에 부모객체와 다양한 자식객체들이 자동타입변환해서 매개변수로 들어온 상태
			//*타입확인: 객체명 instanceof 클래스명: 해당 객체가 해당 클래스의 타입이면 true, 아니면 false
		System.out.println("vehicle 타입환ㄱ인: "+(vehicle instanceof Bus)); //false 출력
		System.out.println("vehicle 타입확인: "+(vehicle instanceof Taxi));//true 출력
			//강제타입변환: 1. 태생이 자식객체 , 2.캐스팅
			if(vehicle instanceof Bus) {System.out.println("버스전진"); Bus bus=(Bus)vehicle;}
			if(vehicle instanceof Taxi) {System.out.println("택시전진"); Taxi taxi=(Taxi)vehicle;}
		vehicle.run();
	}
	
}
