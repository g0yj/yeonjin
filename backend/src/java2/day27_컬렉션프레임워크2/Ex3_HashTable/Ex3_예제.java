package java2.day27_컬렉션프레임워크2.Ex3_HashTable;

import java.util.Hashtable;
import java.util.Map;

public class Ex3_예제 {

	public static void main(String[] args) {
	
		//1. HashTable 객체에 String, Integer 2개 객체를 저장하는 map 객체 ㅅㄴ언
		Map<String, Integer> map = new Hashtable<>();//2000개 안전하게 저장[동기=여러 스레드가 동시에 한 메소드에 요청할 때 대기상태]
		//Map<String, Integer> map = new HashMap<>(); // 2000개 저장이 안되거나 오류 발생[비동기=여러스레드가 동시에 한 메소드에게 요청할 때 대기 없으면]
		
		//2. //--------멀티스레드를 이용한 각 1000개씩 2000개를 동시에 저장
		Thread threadA =new Thread() {//1. 스레드1 선언
			public void run() {
				for(int i = 1;i<1000;i++) {
					map.put(String.valueOf(i),i);
				}
			};
		};
		
		Thread threadB =new Thread() { //2. 스레드2 선언
			public void run() {
				for(int i = 1;i<1000;i++) {
					map.put(String.valueOf(i),i);
				}
			};
		};
		threadA.start(); threadB.start(); // 두 스레드 실행
		//main 스레드는 다른 두 스레드가 작업(저장)이 끝날때까지 main스레드는 잠시 대기
		try {threadA.join();threadB.join();} catch (Exception e) {}
		System.out.println("map 객체수: "+map.size());
		System.out.println("map 상태: "+map); // join() 안하면 두 스레드가 저장하기 전에 main스레드 출력 먼저하기 때문에 깡통
		
	
		
		
	}//m
}//c
