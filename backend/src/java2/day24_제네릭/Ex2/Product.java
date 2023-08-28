package java2.day24_제네릭.Ex2;

public class Product <K,M> {//제품클래스 안에 자동차 객체도 넣고 싶고 전자 제품도 넣고 싶음.
						// 하나는 Tv고 하나는 Car넴?
			//제네릭: 클래스 안으로 들어오는 파라미터(변수)가 정해져 있지 않는 타입[매개타입]
			// 제네릭 타입의 이름: A~Z 대문자 알파벳 권장
			//제네릭 타입 여러개 이면 <A~Z , A~Z, A~Z> 
			// 장점: 클래스 설계시 필드에 다양한 타입으로 선언
	//필드
	private K kind;
	private M model;
	
	//생성자
	//메소드
	
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	

}
