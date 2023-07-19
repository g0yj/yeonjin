package java1.day05;

public class Ex1_참조타입 {

	public static void main(String[] args) {

	/*
	 * 자바 데이터 타입: 변수 선언할 때 사용되는 타입
	 * - 기본타입: boolean,byte,short, char, int, long , float , double
	 * 	1. 변수의 값 자체를 저장.(=리터럴)
	 * 	2. 8가지 존재/ 소문자 시작
	 * 
	 * 
	 * 
	 * - 참조타입: 배열, 열거, 클래스[String, Scanner, Random, System 등],인터페이스
	 * 	1. 변수에 값 자체를 저장하지 않음.
	 * 	2. 변수에 힙메모리 생성된 메모리를 주소/번지 참조
	 * 	3. 첫글자가 대문자 시작하는 것이 보통
	 * 
	 * ※JVM 메모리
	 *  스택(stack) 
	 *  1. 스레드마다 별도 구역을 가짐
	 *  2. 함수(프레임)마다 별도 구역 : 지역변수, 함수 호출 시 프레임이 생성되고  함수(프레임)종료되면 제거됨
	 *  3. 모든 변수는 스택에 선언됨
	 * 
	 * 힙(heap)
	 * 	1. 객체가 생성되는 영역 : 다른 영역(스택/메소드) 영역에 참조 할 수 있음
	 * 	2. 객체,배열,인터페이스 메모리 생성
	 * 	3. new 연산자: 타입/클래스 기반으로 새로운 메모리 생성 후 주소/번지 반환
	 * 	
	 */
		
		
		int[]arr1; //int형 타입으로 배열 변수 선언[스택영역에 메모리 할당]
		int[]arr2; //int형 타입으로 배열 변수 선언
		int[]arr3; //int형 타입으로 배열 변수 선언
		
		arr1 = new int[] {1,2,3}; // 배열{1,2,3}에 생성 [힙영역에 메모리할당]하고 스택영역변수(arr1)에 대입
		arr2 = new int[] {1,2,3}; //101번번지를 arr2 스택변수에 저장함
		arr3 = arr2; //arr2 스택 변수가 가지고 있던 101번지를 arr3 스택 변수에 대입
		
		System.out.println(arr1==arr2); // false
		System.out.println(arr2==arr3);// true
		
		
		//p.151 - 객체 주소를 참조하고 있지 않은 상태인 null= 객체(필드,메소드) 사용 할 수 없는 상태
		int[] intArray=null;
		//int[]intArray 스택영역에 배ㅕㄴ수가 메모리 할당! 힙 영역이 아님 => 참조 중인 객체 번지가 없다
		// intArray[0]=10;  // 오류. 배열은 힙에서 생성되는데 아직 배열이 선언되지 않음. nullPointerException 오류
		
		String str=null;
		//System.out.println(str.length()); //NullPointerException 오류 발생
		
		//p.153
		String hobby ="여행";
			//1. 스택영역에 hobby라는 지역변수 선언
			//2. 힙영역에 "여행"이라는 문자열객체가 생성
			//3. 생성된 힙영역에 "여행"객체의 주소/번지를 스택영역에 hobby 지역변수에게 대입
		hobby=null;
			//4. 스택영역에 bobby 지역변수에 null이 대입 [대입은 새로운 값으로 대체되는 걸 의미]
			//5. 아무도 힙 영역에 있는 "여행"문자열 객체를 참고하지 않으면 가비지컬렉터가 자동으로 객체를 삭제함.
		
		String kind1="자동차"; //스택영역: kind1[32번지]		힙영역:"자동차"객체[32번지]
		String kind2 = kind1; //스택영역:kind2[32번지]
		
		kind1=null; //스택영역: kind1[null]
					//kind2는 아직 사용하고 있음. 하나라도 참조 중이라면 객체는 삭제되지 않음.
		
	}

}
