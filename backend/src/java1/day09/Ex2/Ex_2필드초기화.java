package java1.day09.Ex2;

public class Ex_2필드초기화 {
	public static void main(String[] args) {
		//1. 필드초기화
			//1. 객체 생성
				//1. 기본생성자 : 객체 생성시 초기화x
			Korea k=new Korea();
			System.out.println(k.nation); //대한민국
			System.out.println(k.name); //  기본값 null
			
				// Korea k=new Korea();  <-오류
			
				//2. 정의한 생성자: 객체 생성 시 해당 매개변수를 초기화
			Korea k1= new Korea("박자바","011225-1234567");
			System.out.println(k1.nation);//대한민국
			System.out.println(k1.name); //박자바
	
				//3. 정의한 생성자2:
			Korea k2= new Korea("김자바","93901923-23123");
			System.out.println(k2.nation);
			System.out.println(k2.name);
			
			
		//2. 생성자 오버로딩
			
			Korea k3= new Korea(null, 0);  // new Korea() 열면 왼쪽에서 만든 여러개의 생성자들이 나오는 걸 확인
			
		}// main

}

/*오버로딩: 동일한 메소드명으로 여러개 선언 불가능<- 식별이 불가능 하기 때문에
 *	//해결책-> 매개변수의 개수/타입/순서 이용한 메소드 식별 사용-> 동일한 메소드명도 여러개 선언
 * 
 */


//3시30분
//3시 59분
