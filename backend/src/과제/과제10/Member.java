package 과제.과제10;

public class Member {

	
	
	//1. 필드
	String id;	//  초기값이 없을 땐 기본값으로 들어감. 아직 생긴거 아님. 객체 만들때 생김
						// MemberSys에서 new 해야 객체가 됨.
	String password;
	String name;
	String phone;
	int age;
	
	//2.생성자
	


	public Member(String id, String password, String name, String phone, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	
	
	
	
	
	
	
	
}
