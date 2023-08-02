package 복습.과제9;

public class Member {

	//1. 필드
	String id;
	String pw;
	String name;
	String mum;
	int age;
	
	//2. 생성자
	public Member() {
	}

	/**
	 * @param id
	 * @param pw
	 * @param name
	 * @param mum
	 * @param age
	 */
	public Member(String id, String pw, String name, String mum, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mum = mum;
		this.age = age;
	}

	/**
	 * @param id
	 * @param pw
	 */
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	
	
}
