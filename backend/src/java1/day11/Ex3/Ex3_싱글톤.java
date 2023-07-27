package java1.day11.Ex3;

//1시50분

public class Ex3_싱글톤 {
	
	public static void main(String[] args) {
		
		//1. Member 객체 생성
			// 오류: 생성자를 private로 되어 있는 클래스는 외부에서 객체 생성이 불가능
		//Member member3 = new Member();
		//Member member4= new Member();
			//member3과 member4sms 다름

		
		//2. Member 객체 호출[두 객체는 같음]
		Member member1 = Member.getInstance();
		Member member2 = Member.getInstance();
		
		System.out.println(member1==member2);
		
		
	}

}
/*
 * 객체를 하나 만들어 놓고 쓰겠음.
 * 언제쓰겠 ?  MVC 패턴할 때 많이 쓰니까 추후 다시 다루겠
 */