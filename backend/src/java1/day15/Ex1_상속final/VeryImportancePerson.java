package java1.day15.Ex1_상속final;

public class VeryImportancePerson extends Member{
	
	// 자식클래스 extends 부모클래스

		//부모인 Member 클래슨느 final class로 상속 불가능

	
	// 클래스에 final 없고 메소드에 final 없음 - > 오버라이딩 가능
	@Override
	public void stop1() {	// stop1메소드는 final 키워드가 있으면 오버로딩 불가

		super.stop1();
	}
	@Override
	public void stop2() {	// stop2메소드는 final 키워드가 있으므로 오버라이딩 불가능 [ 오류발생 ]
		super.stop2();
	}
	

}
