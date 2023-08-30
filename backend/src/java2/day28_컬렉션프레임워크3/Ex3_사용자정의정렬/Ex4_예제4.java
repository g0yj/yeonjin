package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.TreeSet;

public class Ex4_예제4 {

	//1. 정렬 구현객체 생성 : Fruit객체를
	FruitComparator fruitComparator = new FruitComparator();
	//2. TreeSet 객체 생성
	TreeSet<Fruit> treeSet=new TreeSet<>(fruitComparator);
	
	//3. 무작위 Fruit 객체 대입
}
