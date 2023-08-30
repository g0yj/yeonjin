package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

public class Person implements Comparable<Person>{
	
	//메소드 [정렬 기준 만들기]  - db에서 정렬할 수 있으면 거기서 하는 걸 추천
		// 1. Comparable 구현
		// 2. compareTo 메소드 구현
	@Override
	public int compareTo(Person o) {
		//나이 기준으로 오름차순
		if(age<o.age) {return -1;}
		else if(age==o.age) {return 0;}
		else {return 1;}
	}
				// 이름 기준으로 하고 싶다?! 바이트로 바꿔서 해야됨 ㅋ
	/*
	 * 	@Override
	public int compareTo(Person o) {
		//내림차순
		if(age<o.age) {return 1;}
		else if(age==o.age) {return 0;}
		else {return -1;}
	}
	 * */
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}




	//필드
	public String name;
	public int age;
	
	//생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	

}
