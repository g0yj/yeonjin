package java1.day09.ex1;

public class Ex1_생성자 {
	public static void main(String[] args) {
		//1. 객체생성: 클래스명 객체변수명=new 생성자명();
		//Car myCar =new Car();  //오류. 1개 이상의 생성자의 선언했을 때 (왼쪽에) 기본생성자는 자동 생성이 안됨.
				
		Car myCar = new Car("그랜저","검정",20);
	
		//왼쪽에 생성자가 없다면 자동 생성돼서 오류 X
		//Car myCar = new Car(); 
		
	}//main

}
