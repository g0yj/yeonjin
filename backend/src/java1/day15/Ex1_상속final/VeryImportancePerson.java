package java1.day15.Ex1_상속final;

public class VeryImportancePerson extends Member{
	
	// 자식클래스 extends 부모클래스

		//부모인 Member 클래슨느 final class로 상속 불가능

	
	// 클래스에 final 없고 메소드에 final 없음 - > 오버라이딩 가능
@Override
public void stop2() {
	// TODO Auto-generated method stub
	super.stop2();
}

// 클래스에 final 없어서 상속은 가능하나 함수에 final로 오버라이딩 불가능
public void stop1() {}


}
