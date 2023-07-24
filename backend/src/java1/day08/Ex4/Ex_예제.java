package java1.day08.Ex4;


//실행목적
public class Ex_예제 {

	public static void main(String[] args) {
		//1.Car객체 선언: 클래스명 변수명= new 생성자명();
		Car myCar= new Car();
		
		//2. 객체를 이용한 필드 호출[.접근연산자]
		System.out.println("myCar.company");
		//3. 필드의 값 변경
		myCar.speed=60;
		System.out.println("수정된 속도: " +myCar.speed);
		
		
		
	}//main끝
}
