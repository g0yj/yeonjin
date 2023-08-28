package java2.day23_멀티스레드2.Ex2;

public class WorkThread extends Thread{
	
	//필드
	public boolean work =true; // 스레드 상태의 사용되는 스위치 변수[on/off]
	//생성자
	public WorkThread(String name) {
		super.setName(name); //스레드의이름 변경 (부모에서 상속받은)
	
	}
	//메소드
	@Override
	public void run() {
		while(true) {
			if(work) {			//스레드 이름 호출 함수
				System.out.println(super.getName()); //super 이나 this 생략해도 상관 없음
			}//if
			else {
				Thread.yield();//현재스레드의 양보(=현재스레드를대기상태로만드는)
			}//else
		}// w 해당 스레드는 무한루프[절대 종료되지 않는 스레드]
	}
	
	

}
