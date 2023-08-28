package java2.day22_멀티스레드1;

//10시40분


import java.awt.Toolkit;

public class Ex1_멀티스레드 {
	
	
	public static void main(String[] args) {//메인스레드가 main메소드를 호출하면 코드 시작
		
		//p.596 예1
		Toolkit toolkit = Toolkit.getDefaultToolkit();	//java.awt :javaui 제공
			//5번의 비프음을 발생시켰지만 비프음은 한번 밖에 들리지 않음 <- 비프음보다 for문이 더 빠름
		for(int i=0; i<5; i++) {toolkit.beep();} //toolkit.beep(); 비프음을 내는 함수
		
//=========================싱글스레드================================//		
		for(int i=0; i<5; i++){
			
			toolkit.beep();
			//*0.5초간 딜레이[메인스레드 잠깐 멈춤] - 밀리초(1/1000)초
			try {
				Thread.sleep(500);//예외처리 발생. try{}catch{}				
			}catch (Exception e) {System.out.println(e);}
		}//f
		
		for(int i = 0; i<5;i++) {
			System.out.println("띵"); // 비프음 5번 들리고 5번의 문자 출력
			try {
				Thread.sleep(500);
			}catch (Exception e) {System.out.println(e);}
			
		}//f

//================================================================//		
		
		
//======================멀티스레드[입력구현체]===============================//
		//1. main스레드 외 작업 스레드 객체 만들기
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {// Runnable인터페이스 추상메소드 구현
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5;i++) {
					toolkit.beep();
					try {Thread.sleep(500);}catch(Exception e) {System.out.println(e);}
					
				}//추상메소드 구현 e
				
			}//run()
		}); //생성자e
	
		//2. [main 스레드가 작업스레드 실행] 작업스레드시작
		thread.start();
	
		//3. main 스레드 작업
		for(int i=0; i<5;i++) {
			toolkit.beep();
			try {Thread.sleep(500);}catch(Exception e) {System.out.println(e);}
		}
	
//=======================================================================//
		System.out.println("멀티스레드 시작[구현체]");
	
		비프음2 비프음3 = new 비프음2() {public void run() {}};
	
		
	}//m()
	
	
	
	
	
	}//c
	/*
	 * 프로그램: 명령문의 집합
	  		- 프로세스: 실행중인 프로그램
	  		- 멀티태스킹: 두 가지 이상의 작업을 동시에 처리
	   		- 멀티프로세스: 운영체제는 동시에 여러 개의 프로세스 생성해서 처리
	   		
	   
	 *멀티프로세스가 프로그램 단위의 멀티태스킹이라면
	 		 멀티스레드는 프로그램 *내부에서의 멀티태스킹  
	   
	   		- 멀티프로세스는 서로 독립
	   			- 한글프로그램(프로세스), 엑셀프로그램(프로세스) 동시에 사용 시 한글에서 오류가 발생하더라도 엑셀은 정상
	   		- 멀티스레드는 하나의 스레드가 오류를 발생하면 프로세스가 종료되므로 영향을 미침.
	   			- 카카오톡(프로세스[채팅기능(스레드),첨부파일전송(스레드)]) 파일전송 스레드에서 오류가 발생하면 카카오톡 프로세스 자체가 종료되므로 채팅도 같이 종료됨
	   
	   멀티스레드 : 병렬로 데이터를 처리하는 곳에서 사용
	   		1. 사용처: 앱, 웹 등등
			2. 메인스레드: *모든 자바 프로그램은 메인스레드가 main메소드를 실행하면서 시작
			3. 
				싱글스레드: main메소드만 사용하는 경우[*메인스레드(메인함수)가 종료되면 프로세스 종료]
				멀티스레드: main메소드에 새로운 작업 스레드를 생성하는 경우[*모든 스레드가 종료되면 프로세스 종료]
			
			4. 작업 스레드 생성
				1. Thread 클래스로 직접 생성
					1. Thread 변수명 = new Thread(Runnable구현객체);
					- start() : run메소드 호출
					
			5.
				Runnable: 스레드가 작업을 실행할 때 사용하는 인터페이스
					- run추상메소드 : [추상메서드] 작업스레드 실행 코드 정의
					
			6. 익명객체
				익명객체
					클래스명 클래스 = new 클래스명(){오버라이딩메소드}
				익명구현체
					클래스명 클래스 = new 클래스명( new 인터페이스명(){오버라이딩메소드})
				
	   
	   
	   
	   
	   프로세스				프로세스
	   		스레드				스레드1
	   							스레드2
	   
	   
	 */

