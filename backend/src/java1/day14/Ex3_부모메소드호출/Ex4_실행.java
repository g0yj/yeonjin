package java1.day14.Ex3_부모메소드호출;

public class Ex4_실행 {
	public static void main(String[] args) {
	
		//1. 자식객체
		SupersonicAirPlane sa = new SupersonicAirPlane();
		
		//2. 
		sa.takeOff(); //부모
		sa.hashCode(); // 부모의 부모
		sa.fly(); // 부모메소드 오버라이딩[본인우선]
		sa.land(); // 부모
		sa.toString(); //부모의 부모의 메소드 오버라이딩[본인우선]
		
		
	}
}
