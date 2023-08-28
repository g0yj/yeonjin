package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		
		//1. Product 객체 만드는데.. Tv객체를 가지고
			//1. Product 객체를 만들때. 필드에 사용할 타입을 구체적으로 대입
		Product<Tv, String> product1 = new Product<>();
			//2. product 객체 [Tv kind =null ; String model =null;] *필드의 초기값 = class는 null
		product1.setKind(new Tv());
		product1.setModel("스마트폰Tv");
		
			//3.product 객체[Tv kind=new Tv(); String model = "스마트Tv";]
		Tv tv=product1.getKind();
		String tvModel = product1.getModel();
			
	//-------product객체<Tv,String > --->product객체<Car,String > 하고 싶다면?
		//제네릭 변경하고 싶다면(다른 제네릭 타입의 객체를 생성하고 싶다면), 새로운 객체 생성
		
		
		//2. Product 객체를 만드는데 .. Car 객체를 가지고
			//1.
		Product<Car,String> product2= new Product<>();
			//2. product 객체 [Car kind =null ; String model =null;] *필드의 초기값 = class는 null
			product2.setKind(new Car());
			product2.setModel("SUV 자동차");
			
				//3.product 객체[Car kind=new Tv(); String model = "스마트Tv";]
			Car car =product2.getKind();
			String carModel = product2.getModel();
			
	}//m
}
