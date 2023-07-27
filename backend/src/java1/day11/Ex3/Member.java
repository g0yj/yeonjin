package java1.day11.Ex3;

public class Member {

	//싱글톤: 프로그램 내 1개 존재하는 객체
	 //ㄴ 객체를 쓰기 위한 목적이 여러개 찍기 위해서인데 굳이 .. ? (뒤에서 배우겠음) 
	
	
	//1. 자신의 타입으로 객체를 생성함 -> private로 제한
	private static Member member = new Member();
	
	//2. 싱글톤객체를 반환하는 함수생성
	public static Member getInstance() {return member;}
	
	//3. 외부에서 사용 못하게 생성자를 잠금
	private Member() { }
	
	
	
}//class

/*
 * 객체를 하나 만들어 놓고 쓰겠음.
 * 언제쓰겠 ?  MVC 패턴할 때 많이 쓰니까 추후 다시 다루겠
 */