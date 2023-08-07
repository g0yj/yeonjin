package java1.day18.Ex1;

//클래스에서 인터페이스를 구현하기 implements
public class Television implements RemoteControl{
		// 클래스명 implements 인터페이스명
		// 인터페이스가 선언한 추상메소드를 해당 클래스가 구현 하기
		// 해당 추상메소드를 구현하기 전까지 오류 발생
	
		//!!!: implements 키워드 사용햇다면 추상메소드 구현 필수!
	
	
@Override
public void turnOn() {System.out.println("tv 켬");
	
}
public void turnOff() {
	System.out.println("tv끔");
}

@Override
public void setVolume(int volume) {
	if (volume>RemoteControl.MAX_VOLUME) {
		//만약에 볼륨이 최대볼륨보다 크면 해당 객체는 최대볼륨으로 대입
		this.volume= RemoteControl.MAX_VOLUME;
	}
	else if(volume<RemoteControl.MIN_VOLUME) {
		this.volume=RemoteControl.MIN_VOLUME;
	}
}

}
