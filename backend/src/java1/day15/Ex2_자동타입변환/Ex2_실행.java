package java1.day15.Ex2_자동타입변환;

public class Ex2_실행 { // 총3개의 객체 생성됨

	//1. 부모객체 생성
	Parent parent = new Parent(); //-> 힙: 객체1개(본인)
	
	//2. 자식객체 생성[자식객체는 힙 생성 시 부모 객체 힙도 생성]
	Child child = new Child();// -> 힙: parent와 child 2개
	
	//3. (자동타입변환)자식 객체를 부모 객체에 대입 가능?!
	Parent parent2= child; 	// 가능: Child는 Parent를 가지고 있
								// 자식객체는 부모객체가 될 수 있
	
	
	//!! : 자식객체가 부모객체로 대입 후에 변환된 부모객체는 자식개게의 멤버 사용할 수 없다.
	parent2.method1(); // 단 오버라이딩 된 자식 메소드는 사용이 가능
	parent2.method2();
	
	parnet2.method3(); // 오류. 부모객체가 자식객체의 오버라이딩 아닌 메소드는 사용 불가능
	
	//4. 부모객체를 자식 객체에 대입 ?!
	Child child2= parent; //불가능: 부모 객체는 자식 객체가 될 수 없
	
	//!! : (강제타입변환): 캐스팅
	// Child child2 = parent;  오류
	Child child2=(Child)parent; // 강제 캐스팅을 이용한 형변환 가능
	//!! : 부모객체가 자식객체로 대입 후에 변환된 자식객체는 부모객체의 멤버를 사용할 수 있?!
	
}
