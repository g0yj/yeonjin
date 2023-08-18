package java2.day23.Ex1;

public class Ex1_멀티스레드join {

	public static void main(String[] args) {
			// main스레드가 main 함수를 호출
				//?? 함수는 누군가가 호출하는데.. 
							
		System.out.println("현재스레드 이름: "+ Thread.currentThread().getName());
											//스레드 이름 알려주는 함수
		//1.[main스레드] 작업 스레드객체 생성[main 외 추가적으로 작업스레드생성]
		SumThread sumThread = new SumThread();
		//2. [main스레드]작업 스레드 실행 - 바로 실행되는거 아님(대기) => cpu스케줄링 => 실행=> 대기=> 실행 (종료가 될 때까지 반복)
		sumThread.start();
		
		//3. [main스레드]작업 스레드의 필드 확인
		System.out.println("1~100까지 합: "+sumThread.getSum()); // sum값 안나옴. 왜지?! 
																	//100번 도는 것 보다 메인스레드 처리가 더 빠름
																		//해결 방법 try-catch
		
		try {
			sumThread.join(); // 합침 <= 작업스레드를 호출한 스레드는 일시정지 상태
			//main스레드가 sumThread스레드의 join 메소드를 호출했기 때문에 main 스레드 일시정지
			//sumThread 스레드가 종료되면 main스레드 일시정지가 풀림
		}catch (Exception e) {System.out.println(e);}
		System.out.println("[join 했을 때 ]1~100까지 합: "+sumThread.getSum());
		
	}//main()
	
	
	
	
	
}//c
