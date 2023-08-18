package java2.day23.Ex3;

public class Calculator { //계산기
	
	private int memory;
	
	public int getMemory() {return memory;}

// 1. 메소드 동기화 하는 방법 : 메소드 선언부 키워드 synchronized 사용(전체동기화)----------------------------------------------------------
		// 동기화 메소드 : 해당 메소드를 여러 스레드가 호출 시 대기상태
	public synchronized void setMemory1(int memory) {
		//1. 매개변수를 들어온 값을 필드에 저장[setter]
		this.memory=memory;
		//2. 현재 스레드를 2초간 일시정지
		try {Thread.sleep(2000);
		}catch (Exception e) {System.out.println(e);}
		//3. 2초 후 필드 값 확인
		System.out.println(Thread.currentThread().getName()+"요청한 2초 후 저장된 메모리 : "+this.memory);;
	}
	
//2. 메소드 내 특정 블록에만 동기화 하는 방법:synchronized(this){}------------------------------------------------
	public void setMemory2(int memory) {
		
		System.out.println(Thread.currentThread().getName()+" : 비동기화 구역");
		
		synchronized (this) {//객체잠금
			System.out.println(Thread.currentThread().getName()+" : 동기화 구역");
			this.memory =memory;
			try {
				Thread.sleep(2000);
			}catch (Exception e) {System.out.println(e);}
		System.out.println(Thread.currentThread().getName() +"요청한 2초 후 저장된 메모리: "+this.memory);
		}
		
	}
	

}//c
