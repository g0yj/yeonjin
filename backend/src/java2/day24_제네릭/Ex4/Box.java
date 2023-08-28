package java2.day24_제네릭.Ex4;

public class Box<T> {
			//제네릭 <T>
	
	//필드
	private T t;

	//메소드
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	

}
