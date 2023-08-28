package java2.day23_멀티스레드2.Ex2;

public class Ex2_멀티스레드yield {

	public static void main(String[] args) {
		//1. [main스레드]가 작업스레드A 생성
		WorkThread workThreadA =new WorkThread("workThreadA");
		//1. [main스레드]가 작업스레드B 생성
		WorkThread workThreadB =new WorkThread("workThreadB");
	
		//2. [main스레드] 작업A실행
		workThreadA.start();
		//2. [main스레드] 작업B실행
		workThreadB.start();
		
		//3. 5초 후 A스레드를 잠시 일시정지[A스레드가 다른 스레드 양보. 꺼진건 x]
		try {
			Thread.sleep(5000);
		}catch (Exception e) {System.out.println(e);}
		workThreadA.work=false; 
		
		//4.[main스레드] 10초 후 A스레드 실행
		try {
			Thread.sleep(10000);
		}catch (Exception e) {System.out.println(e);}
		workThreadA.work = true;
	
	}//m
	
	
}//c
