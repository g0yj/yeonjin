package java1.day15.Ex2_자동타입변환;

public class Child extends Parent{
						//상속 받음
	
	//1. 필드
	//2. 생성자
	//3. 메소드
//----------------------------------------------------------	
	@Override
	public void method1() {
		System.out.println("자식클래스메소드1");
		//super.method1();
	}

//-----------------------------------------
	@Override
	public void method2() {
		System.out.println("자식클래스메소드2");
		//super.method2();
	}
	
//---- 오버라이딩 아니고 자식꺼
	public void method3() {
		System.out.println("자식클래스메소드2");
	}



}
