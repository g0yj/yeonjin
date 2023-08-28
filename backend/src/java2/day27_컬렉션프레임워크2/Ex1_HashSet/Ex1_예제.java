package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {
	public static void main(String[] args) {
		
		//1. Set 컬렉션의 HashSet 객체 선언
		Set<String> set= new HashSet<>();
			//set객체(컬렉션프레임워크) 에 <String> 객체를 여러개 저장 가능
		System.out.println("set상태: "+set);
		
		//2.set 객체에 String 객체 저장
		set.add("Java"); System.out.println("set 상태: "+set);
		set.add("JDBC"); System.out.println("set 상태: "+set);
		set.add("JSP"); System.out.println("set 상태: "+set);
		set.add("Java");	// 중복발생! list는 가능하지만 set은 불가능 
		System.out.println("set 상태: "+set);
		set.add("String"); System.out.println("set 상태: "+set);

		//3. set 객체 내 String 객체 수
		System.out.println("set객체내 객체수: "+set.size());
		
		//4. set/list 와 for문의 관계 [*배열/컬렉션 내 저장된 데이터들을 순회(목적: 검색,출력,유효성 등등) 하려고 ]
			//1.for문 [List는 인덱스를 사용해서 사용 가능하지만 set은 인덱스가 없기 떄문에 불가능.. 
			for(int i=0;i<set.size();i++) { } //사용불가
			
			//2. 향상된 for문[list,set모두 가능]
				//for(반복변수: 컬렉션객체){}
					//1. 반복변수란: 컬렉션 객체에 저장된 타입(제네릭)
			for(String s: set) {System.out.println(s);};
			
			//3. forEach() 함수를 이용한 람다식 표현(화살표함수)
			set.forEach(s->{System.out.println(s);});
		
		//-----------------------------------------------------------------------------//
			
				//객체내 중복여부 체크
					//객체가 String이면 String 기준으로 중복 제거
					//객체[String, int가 2개 이상의 필드를 가지고 있으면 중복 기준이 애매(String으로 할래 int로 할래)
					//hashCode() ,equals() 재정의를 이용한 중복 기준 정하기. Member.java에 추가
			
			//1. set객체 선언 
			Set<Member> set2 =new HashSet<>();
			
			//2. set 객체에 member 객체 저장
			set2.add(new Member("홍길동", 30));
			set2.add(new Member("홍길동", 30)); // 이름, 나이 모두 중복
			set2.add(new Member("강호동", 30)); // 나이만 중복
			set2.add(new Member("홍길동", 40));//이름만 중복
			set2.add(new Member("신동엽", 50));
			
			//3. set 객체 내 member 객체 수
			System.out.println("set 객체 내 member 객체수: "+set2);
			
			//4. iterator() 메소드 제공
				//1. set rorcpdptj iterator() 메소드 객체 얻기
			Iterator<Member> iterator=set2.iterator();
				//2. iterator 객체를 이용한 반복
			while(iterator.hasNext()) {// .hasNext() : 다음 객체가 있으면 true, 없으면 fasle
				Member element = iterator.next(); //.next(): set객체 내 객체 호출
				System.out.println(element);
				if(element.name.equals("강호동")) {
					iterator.remove(); //.remove() : set객체 내 해당 객체 삭제
				}
			}
			System.out.println("set객체내 member 객체수: "+set2 );
			
			//4. 위는 복잡쓰. 향상된 for문사용(iterator 를 사용하는 배열/컬렉션프레임워크의 객체 이면 사용 가능)
			for(Member m: set2) {System.out.println(m);}
			
			//4. forEach(iterator를 사용하는 컬렉션프레임워크의 객체이면 사용 가능)
			set.forEach(m->{System.out.println(m);});
		
	}
}
