package java1.day11.Ex1;

public class B {
	
	A a =new A(); //가능. A와B클래스는 같은 패키지


	
	public B() {}//B클래스 생성자
	
	
	
	//C c=new C();
	// 오류: C클래스는 호출이 가능하지만 생성자(private)는 호출이 불가능
}
