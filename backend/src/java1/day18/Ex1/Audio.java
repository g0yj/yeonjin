package java1.day18.Ex1;

public class Audio implements RemoteControl{
	
	// 필드
	private int volume;
	
	
	@Override
	public void turnOn() {
		System.out.println("오디오켬");
	}
	@Override
	public void turnOff() {
		System.out.println("오디오끔");
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
