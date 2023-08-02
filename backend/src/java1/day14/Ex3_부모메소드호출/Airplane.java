package java1.day14.Ex3_부모메소드호출;

public class Airplane {
	
	//1. 필드
	public String color ="red";
	//2. 생성자
	public Airplane() {
		super();
	}
	//3. 메소드
	
	public void land() {
		System.out.println("착륙!!");
	}
	
	public void fly() {
		System.out.println("일반비행");
	}
	
	public void takeOff() {
		System.out.println("이륙!!");
	}

}
