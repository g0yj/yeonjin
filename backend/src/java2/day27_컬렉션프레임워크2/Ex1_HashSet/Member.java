package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	public String name;
	public int age;

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	//---------해당 객체의 중복 기준을 만들기---------------------------------------------
		//예제1.java 40번째줄
	
	@Override //Object(모든 클래스는 Object로부터 자동으로 상속 받음)의 재정의
	public int hashCode() {
		return name.hashCode()+age;
	}
	
	@Override //Object(모든 클래스는 Object로부터 자동으로 상속 받음)의 재정의
	public boolean equals(Object obj) {
		if(obj instanceof Member target ) { //버전이 달라서 오류 뜸 (버전 16이상), 16버전 안쓸거면 강제형변환
			//만약에 해당 객체가 이름과 나이가 일치하면[중복==true]
			return target.name.equals(name)&&(target.age==age);
		} else { return false;}
	}


	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
