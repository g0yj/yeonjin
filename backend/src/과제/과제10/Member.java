package 과제.과제10;

public class Member {
	//순수 원자값만 넣은 설계도 클래스를 만들어줌( 회원에 대한 모델) 
		//ㄴ 함수가 만들어지면 너무 지저분쓰. 기능 설계는 따로 만드는 걸 추천

	
	
	//1. 필드: 객체의 데이터를 저장하는 곳 = 인스턴스vs 정적
									//ㄴ 각각이니까 인스턴스로
	String id;	//  초기값이 없을 땐 기본값으로 들어감. 아직 생긴거 아님. 객체 만들때 생김
						// MemberSys에서 new 해야 객체가 됨.
	String password;
	String name;
	String phone;
	int age;
	
	//2.생성자: 객체의 초기화를 담당 = 인스턴스vs정적
	  //1. 빈생성자
	public Member() {}  // 쓰던 안쓰던 빈 생성자 하나는 넣어줄 걸 추천
	  //2. 모든 필드를 저장하는 풀 생성자 => 클래스 내 빈공간을 오른쪽 클릭 -> source->Generate Copnstructor using Fields-> 모든 필드 체크 후 생성

	public Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	
	
	//3. 메소드 : 객체의 행동의 담담 =인스턴스vs정적  /1.2.는 만들어 두고 시작할 걸 추천쓰

		//1. setter/getter 만들어줌( 만들어 두는 걸 추천) 
		
		//2. toString 만들어줌(추천) : 객체 호출 시 객체의 주소가 아닌 필드의 값을 반환해주는 함수[*개발자가 객체 상태를 검사해보기 위해 사용]
							// source - generate String() -> a모든 필드 체크 후 생성
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
	
	
	/*
	 * JVM : 자바가상(논리적으로 만들어낸) 메모리
	 * 		- 자바(소프트웨어)는 직접적으로 하드웨어 메모리를 관리할 수 없음. 조작할 수 없음
	 * 			(하드웨어는 운영체제가 관리)
	 * 		
	 * 		Member.java-------클래스로더----->Member.class-------->메소드영역                    / 스택영역 / 힙영역
	 * 		(w자바 코드파일)				   (바이트코드파일)				클래스코드, 메소드코드, 					new , this
	 * 																정적멤버(static)의 메모리
	 * 
	 * 			this: 인스턴스멤버 - new 힙 생성시 할당 되고 힙 초기화될때 사라짐(GC)
	 * 						ㄴ static 키워드가 없으면 인스턴스멤버
	 * 						ㄴ 객체를 통해 사용
	 * 
	 * 			static: 정적멤버- 프로그램 시작 할당 되고 프로그램이 종료될 때 (전역/공통/공유/공용) 할당
	 * 						ㄴ static이 있으면
	 * 						ㄴ 클래스를 통해 사용
	 * 
	 * 			final : 수정불가- 초기화할 때 대입만 가능하고 수정은 불가능
	 * 			
	 * 			static final : 상수 - 프로그램 내에서 1개만 저장 (static) 수정 불가능(final)을 합친 키워드
	 */
	
	
	
	
	
}
