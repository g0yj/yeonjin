package java1.day10.Ex4;

public class Member {
	
	//1. 필드
	
	//2. 생성자
	
	//3. 메소드
//---------------메소드 선언----------------------------------	
		//1. 리턴x 매개변수x 함수 선언
		void signup() {}
		
		//2. 리턴x 인수o
		void login(String id, int pw) {}
		
		//3. 리턴o 매개변수x
		String findId() {return "찾은 아이다:";} // String이기 때문에 return 반드시!
		
		//4. 리턴o 매개변수o 함수
		String[] findPw(String s1, String s2) {
			String[]array= {"djl","dfjl"}; return array;
			}
			
		//5. 매개변수가 가변길이일 때 함수
			//[...]여러 매개변수들을 하나의 힙에 저장해서 힙주소로 반환
			void delete(String...strArray) {}
			
			void delete(int num, String...strArray) {}

		//6. 오버로딩: 메소드명이 같되 매개변수의 이름[x] 타입,순서,개수[o]	구분 식별
			
		
}

/*
 * 메소드: 객체의 동작 , 객체의 상호작용, 서로 다른 객체간의 데이터이동[mvc패턴에서다룸]
 * 		선언: 리턴타입 메소드명(매개변수1, 매겨변수2~){실행 return;}
 */