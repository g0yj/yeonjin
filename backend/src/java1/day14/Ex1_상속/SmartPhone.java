package java1.day14.Ex1_상속;

public class SmartPhone extends Phone {
	//클래스 구성 멤버 //상속 extends (부모클래스명은 다중 안됨. 단 하나!)
		// 자식(하위)클래스 - SmartPhone // 부모 -Phone
		// SmartPhone 클래스에서 Phone 클래스의 구성 멤버 사용 할 수 있다.
		// Phone 클래스에서 SmartPhone 클래스 사용 불가능
	
		// 자바는 100% 객체지향 언어 => 상속 문법을 사용함
	
	/*
	 *	- 모든 클래스는 Object클래스로부터 암묵적으로 상속 받음[코드적으로 작성하지 않음 ]
	 * 				Object 클래스
	 *					| 
	 * 			|		|		|
	 *		Scanner	  String	Phone
	 *							|
	 *						 SmartPhone
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	
	
	
	
	
	//1. 필드
	public boolean wifi;
	
	//2. 생성자
	public SmartPhone(String model, String color) {
		//this.model 안됨 <= 현재 클래스에 없는 필드 (상속 안받으면)
		
		//상속 후
		this.model = model;
		this.color= color;
	}
	
	//3. 메소드
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태 변경");
	}
	
	public void internet() {
		System.out.println("인터넷 연결");
	}
	

}
