package java2.day23.Ex1;


/*
 *		멀티스레드 구현하는 방법 2가지(run메소드 재정의)
 *			1. Thread 클래스로부터 extends
 *				-  메소드 뿐 아니라 필드까지 받아야 한다면 상속 추천
 * 			2. Runnable 인터페이스로부터 implements
 * 				- 메소드만 오버라이드 하려면 인터페이스 추천(인터페이스는 필드 상속? 안됨)
 * 			
 * 	 	- 상태
 * 		1. new 이용한 스레드 객체 생성[스레드생성]
 * 		2. start()메소드 이용한 run()작업코드 실행
 * 			-start()  한다고 해서 바로 실행되는 거 아님
 * 				
 * 			실행대기(runnable) : 대기표 받고 기다리는 중 (운영체제가 하드웨어를 사용할 수 있는 권한을 줄 때까지)=cpu스케줄링

 * 			-반복-
 * 			
 * 			
 * 			실행(running) : 해당 스레드의 순서가 되면 cpu사용할 수 있는 권한 [명령어 전달 실행]
 * 			
 * 			일시정지: 스레드가 실행대기가 아닌 정지된 상태
 * 
 * 			종료(terminated): 스레드 종료
 * 				-main메소드, run메소드가 종료
 * 
 * 
 * 	병렬처리(여러 단위의 흐름) vs 직렬처리(관리가 편함, 메인스레드로만 진행될 때)
 * 		- 단일(직렬)스레드: main 함수만 있는 경우
 * 		- 멀티(병렬)스레드: main 에서 thread 추가하는 경우
 *		- 컴퓨터의 병렬 처리 방법
 *			- 소프트웨어(논리)[자바]는 직접적인 하드웨어(물리적)[cpu,메모리] 조작 불가
 *			 
 */





public class SumThread extends Thread {
	
	// 필드
	private long sum;
	//생성자
	//메소드
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for(int i = 1; i<=100; i++) {sum+=i;}//f
	}//f()
	
	
	
	
	
	

}
