package java1.day08.Ex3;


//현 클래스의 사용목적: 실행
public class Ex3_예제 {

	//실행 목적의 클래스 이므로 클래스 멤버(필드,생성자,메소드) 구성이 생략 가능
	public static void main(String[] args) {//main
		
		//1. 객체의 선언: 클래스명 변수명=new 생성자명();
				//만약 생성자를 정의하지 않았다면 기본생성자();
		Car myCar = new Car();  // Car myCar: 스택 , new Car(): 힙
			//Car은 우리가 정의한 클래스(설계도) 		
			 	//myCar: 반환된 객체의 주소를 가지고 있는 지역변수
					//= new : 힙영역에 객체 생성 후 힙 주소를 자역변수에게 반환
						//Car(): 생성자명==클래스명 동일하고 생성자를 1개도 선언하지 않았으면 기본생성자가 들어감.
		
		//2. 객체의 필드 호출
			//. 도트연산자: 변수명.필드명; 	 <- 해당 변수가 가지고 있는 객체의 주소로 이동해 필드 호출
		System.out.println("모델명: "+myCar.model);
		System.out.println("시동여부: "+myCar.start);
		System.out.println("현재속도: "+myCar.speed);
		
		
	}//main
	
}
