package java1.day10.Ex2;



public class Ex2_가변길이매개변수 {

	public static void main(String[] args) {
		
		//1. 다른 클래스에 있는 메소드를 호출하기 위한 객체 생성
		Computer myCom=new Computer();
		
		//2. 3개 인수로 전달
		System.out.println(myCom.sum(1,2,3));
		//2. 5개 인수로 전달
		System.out.println(myCom.sum(1,2,3,4,5));
		
		//3. 배열1 자체를 전달 <- 4번과 동일
		int[] values= {1,2,3,4,5};
		System.out.println(myCom.sum(values));  //15 정상 출력
		
		//4. 배열2 전달 <- 3번과 동일
		System.out.println(myCom.sum(new int[] {1,2,3,4,5})); //15정상출력
		
		//5. Computer class 23번 줄
		//System.out.println(myCom.sum("유재석", values));
	}
}


//11시