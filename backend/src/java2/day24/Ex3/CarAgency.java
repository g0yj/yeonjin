package java2.day24.Ex3;
//CarAgency : 자동차 렌탈 해 주는 대리점
public class CarAgency implements Rentable<Car>{
					// implements : 인터페이스의 추상메소드를 구현(정의)
	@Override
	public Car rent() {return new Car();}
}
