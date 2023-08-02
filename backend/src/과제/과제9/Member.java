package 과제.과제9;

//과제9 함수의 오버로딩

//목적 : 설계도, 객체의 모델
public class Member {
	
	//1. 필드: 객체의 데이터를 저장하는 곳
			//(설계하는거지 아직 객체 아님. 이걸 기반으로 객체를 만들게됨)
	
	String id;	//  초기값이 없을 땐 기본값으로 들어감. 아직 생긴거 아님. 객체 만들때 생김
					// MemberSys에서 new 해야 객체가 됨.
	String password;
	String name;
	String phone;
	int age;	

	//2. 생성자
		//0. 매개변수 없는 빈 생성자
		public Member() {}
	
		//1. 매개변수 5개 정의
		public Member(String id, String password, String name, String phone, int age){
			this.id = id;
			this.password = password;
			this.name = name;
			this.phone = phone;
			this.age = age;
		}
		//2. 매개변수4
		public Member(String id, String password, String name, String phone) {}
		//3. 매개변수3
		public Member(String id, String password, String name) {}
		//4. 매개변수4
		public Member(String id, String password) {}
		
		// public Member(String password)  //오류
		public Member(int password) {}
	//3. 메소드

}
