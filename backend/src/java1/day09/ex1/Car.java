package java1.day09.ex1;

public class Car {
	
	//1. 필드: 객체의 데이터 저장하는 곳(힙을 만들때 도와주는 설계도)
	
	//2. 생성자: 객체를 생성할 때 초기화 역할을 담당[필수X]
		//생성자명: 클래스 명과 동일
		// 메소드와 비슷하지만 리턴이 없음. 인수/매개값은 있음
		// 생정자명(매개변수,매개변수,매개변수){} <-매개변수는 모두 stack에 저장
		//{실행코드}
		// 실행조건: 1. 매개변수로 전달된 값을 필드에 저장
				// 2. (안전상)필드에 저장하기 전에 가공/유효성검사
					//필드는 실제 데이터를 저장하는 곳으로 보안이 필요 -> 캡슐화가 필요 
						// ㄴ 객체.필드는 권장하는 방법이 아님. 
	Car(String model, String color, int maxSpeed){
		
	}
	
	
	
	//3. 메소드

}