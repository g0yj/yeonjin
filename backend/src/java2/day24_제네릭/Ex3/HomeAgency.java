package java2.day24_제네릭.Ex3;
//HomeAgency :  렌탈 해 주는 대리점
public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {return new Home();}

}
