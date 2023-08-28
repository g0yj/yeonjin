package java2.day24_제네릭.Ex4;

public class Ex4_제네릭 {
	//제네릭메소드 선언
		//목적: 함수에서 매개변수를 정의할 때, 정해져있지 않는 타입을 받고 싶을 때]
			//public static boolean 메소드(int value){}
			//public static boolean 메소드(int value){}
			//-->통합 // public <T> boolean 메소드 (T value){}
	
	
		//메소드 선언부 <제네릭타입> : 함수내에서도 제네릭타입 사용 가능
	public static <T> Box<T> boxing(T t){
					//매개변수 제네릭타입 사용하기 위한 <T> 선언부에 정의하면 사용가능
					// T t=100  //Object
					//아래 예제1 -> Integer t=100;
					//아래 예제2 -> String t = "홍길동"
		Box<T> box =new Box<>();
					//예제1 - > Box<Integer>box=new Box<>();
					//예제2 - > Box<String>box=new Box<>();
		box.setT(t); //box객체 [t=100]
					//예제1 ->[Integer t=100]
					//예제2 ->[String t="홍길동"]
		return box;
					//예제1 ->[Integer t=100]
					//예제2 ->[String t="홍길동"]
	}//f()
	
		//main함수
	public static void main(String[] args) {
		
	
		//1. Box 객체 t필드를 Integer 타입으로 선정
		Box<Integer>box1=boxing(100); //타입 파라미터에 값 넣으면 (자동으로)값의 클래스 타입(기본타입x,참조타입o)으로 대체
			//box1[Integer t]
		int invalue=box1.getT();
		System.out.println(invalue);
		
		//2. 
		Box<String>box2=boxing("홍길동"); // 함수 파라미터에 값을 넣으면 (자동으로)값의 타입으로 String 대체
		
	}//f()
}
