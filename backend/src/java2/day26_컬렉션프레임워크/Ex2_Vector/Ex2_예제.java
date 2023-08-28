package java2.day26_컬렉션프레임워크.Ex2_Vector;
//1시간32분

import java.util.List;
import java.util.Vector;

import java2.day26_컬렉션프레임워크.Board;

public class Ex2_예제 {
	public static void main(String[] args) {
		
	//1. Vector 리스트 객체 생성
		//ArrayList와 내부 구조가 동일함. 인터페이스가 똑같기 때문에 함수도 동일
		//동기화 지원
	List<Board>list=new Vector<>();//두 스레드가 안전하게 2000개 모두 저장(동기화)[synchronized]
	//List<Board>list=new ArrayList<>(); // 두 스레드가 2000개 모두 저장 못함(동기화x)
	
	//2. 작업스레드 추가
	Thread threadA = new Thread() {
		@Override
		public void run() {
			for(int i=1;i<=1000;i++) {
				list.add(new Board("제목", "내용", "글쓴이"));
			}
		}
		
	};//t
	Thread threadB = new Thread() {
		@Override
		public void run() {
			for(int i=1001;i<=2000;i++) {
				list.add(new Board("제목", "내용", "글쓴이"));
			}
		}
		
	};//t
	//3. 스레드 실행
	threadA.start();
	threadB.start();
	
	//4. main 스레드를 대기상태 만들기 [두 스레드의 작업이 모두 끝날때까지 main 스레드 기다림=>작업결과를 확인하려고
	try {threadA.join();threadB.join();}catch (Exception e) {}
	
	//5. 
	System.out.println("두 스레드가 추가한 리스트에 추가한 객체수: "+list.size()); //2000 . 동기화 가능함을 알 수 있음.
	}//m
}//c
