package java1.day09.Ex2;

// 설계도일뿐 힙이 아님에 유의!!!!!!!!

public class Korea {
	//1. 필드
		//1. 객체마다 동일한 값을 가지고 있다면 객체의 필드값을 미리 초기화
		String nation = "대한민국"; //생성되기 전이니까 heap 아님
		
		//2. 객체마다 다른 값을 가져야 한다면 객체의 필드값을 기본값으로<- 생성자 이용을 권장
		String name;
		String ssn;
	
	//2. 생성자
		// 매개변수가 1개인 생성자
		public Korea(String name) {}
		//1. 매개변수2개인 생성자
		public Korea(String name, String ssn) { //n이나 s는 주소값으로 변수명 중요하지 않음.
			// name=n;	ssn=s; <- 변수명 상관 없으니 위에 name과 ssn을 사용
			
			//this : 현재 클래스를 뜻함[매개변수: 외부로부터 들어온 변수명과 동일하기 때문에 구분이 필요]
				//this.필드명   this.메소드명()  this() : 생성자
				//this : 해당 함수/메소드/생성자 호출 객체임 =주체
				this.name=name; this.ssn=ssn;
			
			
		}
		//2. 기본생성자=깡통 생성자
		public Korea() {}
		
		//3. 매개변수3개인 생성자 [오버로딩 가능1 :  매개변수의 개수가 다를 경우]
		public Korea(String name, String ssn, String nation) {}
		
		//4. 매개변수 2인 생성자[오버로딩 가능2: 매개변수의 타입이 다를 경우]
		public Korea(String name, int ssn) {}
		
		//5. 매개변수2개인 생성자 [오버로딩가능3: 매개변수의 타입순서가 다를 경우]
		public Korea(int ssn, String name) {}
		

}
