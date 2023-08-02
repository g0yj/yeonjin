package 복습.과제9;

public class Member_1 {
	//1. 필드
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	//2. 생성자
	public Member_1() {
	}


	public Member_1(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}


	public Member_1(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	
	
}
