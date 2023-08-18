package java2.day22.Ex3;

import java.time.LocalTime;

public class Ex3_전자시계 {
	public static void main(String[] args) {
	
		
		
		
		
		
		while(true) {
			//LocanlTime.now() : 현재시간 반환 함수
			System.out.println(LocalTime.now());
			
			try {
				Thread.sleep(1000);	//1초 일시정지
			}catch (Exception e) {System.out.println(e);}
		}//w
	}//m
	
	
}//c
