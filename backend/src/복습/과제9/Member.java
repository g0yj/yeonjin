package 복습.과제9;
public class Member {

	//1. 필드
	String id ;
	String pw;
	String name;
	String phone;
	int age;
	
	//2. 생성자
	public Member() {
		
	}

	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}



	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
	
	
	
	//3. 메소드
}
