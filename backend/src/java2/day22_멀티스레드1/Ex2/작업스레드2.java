package java2.day22_멀티스레드1.Ex2;

public class 작업스레드2 implements Runnable{

	try {
		int count=1;
		while(true) {
			System.out.println("작업1 스레드 output: "+count);
			Thread.sleep(2000);	// 1초간 일시정지 [예외처리필수]
			count++;
		}//w
	}catch (Exception e) {System.out.println(e);}
	
	
	
	
	
}

}

