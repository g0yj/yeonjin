package java1.day10.Ex1;


//목적: 실행
public class Ex1_메소드선언호출 {
	public static void main(String[] args) {
		
		//powerOn();  안됨. Calculator은 객체가 생성될때 힙 영역에 생김 
		
		//1. 메소드 호출 하기 위한 객체 생성
		Calculator myCalc=new Calculator();
		
		//2. 객체 통한 메소드 호출 , 매개변수 전달 없
		myCalc.powerOn();
		
		//3. 객체 통해 메소드 호출, 매개변수 전달 (2개)
		// myCalc.plus(5,6); //return까지 해주는거지 저장까지 해주는 게 아님에 유의
		int result=myCalc.plus(5,6); //저장이 필수는 아니긴함!!
		
		//4. 객체 통한 메소드 호출/ 매개변수 전달= 2개 '변수값'으로 전달
												//진짜값&주소값
		int x=10;
		int y=4;
		
		double result2 =myCalc.divide(x, y);
		System.out.println("result2: "+result2); //2.5 출력
		
		myCalc.powerOff();
		
		
		
	}//main
}
