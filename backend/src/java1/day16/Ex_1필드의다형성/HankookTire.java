package java1.day16.Ex_1필드의다형성;

public class HankookTire extends Tire {
			//상속 : 자식 클래스에서 부모클래스의 멤버(필,생,메)를 사용할 수 있음
	
	//오버라이딩: 부모클래스의 메소드를 물려 받았지만 리모델링(재정의)
	
	@Override
	public void roll() {//메소드 선언부 그대로 사용
		super.roll(); //super.메소드() : 부모 클래스의 메소드 호출
		//새로운코드: 재정의 => 오버라이딩
		System.out.println("한국 타이어가 회전");
		
	}//f



}//c
