package java1.day10.Ex4;

public class Ex4_메소드 {
	
	public static void main(String[] args) {
		
		//------------메소드 사용.호출--------------------
		
		//1. 객체 필요
		Member m =new Member();
		
		//2. 객체내. 이용한 필드/메소드 호출
			//1. 리턴x 매개변수x
			m.signup();
			
			//2. 리턴x 매개변수 o
			// m.login("dfa", "1234"); <- 오류발생
			m.login("dfa", 1234); // String 과 int로 받기고 했었음.
			
			//3. 리턴o, 매개변수x
			m.findId();//리턴된 값을 받았지만 추후에 그 값을 사용할 목적이 없어 저장x
			//int result1=m.findId(); // 오류 . 리턴된 값을 받았지만 저장하는데 있어 타입이 일치하지 않음
			String result2=m.findId();//리턴된 값을 받아서 추후에 그 값을 사용할 목적이 있어 변수에 저장
	
			//4. 리턴o 매개변수o 함수 호출
			String[]result3=m.findPw("dfa", "dfaa");
			
			//5. 가변길이
			m.delete("안녕","하세요");
			m.delete("안녕","하세요","!");
			
			//6. 오버로딩
			m.delete(1,"안녕","하세요","!");  // 1 <- 숫자도 가능
	
	}

}
