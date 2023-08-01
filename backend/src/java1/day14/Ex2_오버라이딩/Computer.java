package java1.day14.Ex2_오버라이딩;

public class Computer extends Calculator{
			//자식클래스명  extends 부모클래스명
			// 자식클래스에서 부모클래스의 멤버(필,생,메)를 사용 가능
	
	//1. 필드
	
	//2. 생성자
	
	//3. 메소드
		// 부모클래스[Calculator]에게 상속받은 메소드를 재정의
		//- ctrl+space - 오버라이드 자동완성 가능
		// 오버라이딩: 자식 클래스는 부모클래스로부터 메소드를 물려 받았기 때문에 
			//자식 클래스에서 부모클래스와 동일한 이름으로 메소드를 선언하는 건 불가능함.
			// 동일한 이름으로 선언하고 매개변수[개수,타입,순서] 다르게 하는 건 오버로딩![새로운선언]
			// 동일한 이름으로 선언하고 매개변수까지 모두 동일하면 = > 오버라이딩이 먹힘[재정의]
	
	//@Override <- 이건 생랙해도 됨
	public double areaCircle(double r) {
		System.out.println("Computer areaCircle 메소드 실행: ");
		return Math.PI*r*r;
	}
	
}
