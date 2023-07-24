package java1.day08;

public class Ex2_선언 {
	
	private void msin() {

			//1. 객체 만들기(선언) : 클래스명 변수명 = new 생성자명();
			Student s1 = new Student();
				//1. Student: Student 클래스를 가져와 설계도로 사용
					//2. s1: Student 객체의 주소값을 저장할 스택영역의 지역변수
						//3. new: 객체 생성하고 생성된 주소값을 스택영역의 지역변수에 반환
							//4. Student(); : 객체 생성 시 초기(처음)값을 넣어 필드에 저장할 수 있는 메소드.
			
			System.out.println("s1 변수가 Student 객체의 주소를 가지고 있다.");
				// .(도트연산자) : 변수명.메소드() /변수명.필드명 ==> 변수가 가지고 있는 주소로 이동
				// int 정수=10;  정수.메소드() (x) ==> 변수가 주소를 가지고 있지않기 때문에 사용 불가능
			
				Integer 정수객체 =10; // 정수객체.메소드() (o)  ==> 기능을 사용하기 위해 객체로 만듦.
				
			//2. 하나 더 객체 만들기
				Student s2= new Student();
				
			//3. Student 설계도(클래스)는 같지만 서로 다른 객체가 생성[* new 연산자는 항상 새로운 (힙영역의)주소를 할당함]
			System.out.println("s2 변수가 또 다른 Student 객체의 주소를 가지고 있다");
			
	}//main

}
