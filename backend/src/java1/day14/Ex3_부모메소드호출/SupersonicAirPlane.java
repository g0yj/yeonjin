package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirPlane extends Airplane{
	
	//1. 필드
	//public static final :상수 필드 만드는 방법
	public static final int NORMAL =1;  // 상수는 보통 대문자로 씀
	public static final int SUPERSONIC =2;
	
	//인스턴스 필드
	public int flyMode = NORMAL;
	
	
	
	//2. 생성자
	public SupersonicAirPlane() {
		super(); // 부모 생성자 호출 -> Airplane
	}
	
	//3. 메소드
			// 부모클래스로부터 오버라이딩 
	@Override //<- 생략 가능
	public void fly() {
		if(flyMode==SUPERSONIC) {
			System.out.println("초음속 비행 ㄱ");
		}else {
			super.fly(); // 부모메소드 호출
		}
	}

	@Override
	public String toString() {
		return "SupersonicAirPlane [flyMode=" + flyMode + "]";
	}
	
	
	
	
	
}

/*		this		vs  		super
 * 		현재클래스     			부모클래스
 * 		this.필드명;				super.필드명;
 * 		this();					super();
 * 		this.메소드();			super.메소드명();
 * 
 * 	오버로딩: 동일한 메소드명일 때 매개변수에 따른 식별 가능
 * 	오버라이딩: 부모클래스로 상속 받은 메소드를 재정의 할 때
 * 
 */
