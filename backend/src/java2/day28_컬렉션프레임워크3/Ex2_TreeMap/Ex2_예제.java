package java2.day28_컬렉션프레임워크3.Ex2_TreeMap;

import java.util.TreeMap;

public class Ex2_예제 {
	public static void main(String[] args) {
		
		//1. TreeMap 객체 생성
			//key 기준으로 자동 오름차순 정렬
		TreeMap<String, Integer> treeMap= new TreeMap<>();
		
		//2. 무작위 엔트리<키,값> 저장
		treeMap.put("apple", 100);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);
		System.out.println("이진트리 map 상태: "+treeMap);
			//이진트리 map 상태: {apple=100, base=20, cherry=30, description=40, ever=50, forever=60, guess=70, zoo=80}
		//오름차순: 낮은것->큰것 (123 / abc / ㄱㄴㄷ)
		
		//3. 
		System.out.println("가장 왼쪽 노드/엔트리: "+treeMap.firstEntry());//가장 왼쪽 노드/엔트리: apple=100
		System.out.println("가장 오른쪽 노드/엔트리: "+treeMap.lastEntry());//가장 오른쪽 노드/엔트리: zoo=80
		System.out.println("ever 노드 왼쪽 노드/엔트리"+treeMap.lowerEntry("ever"));//ever 노드 왼쪽 노드/엔트리description
		System.out.println("ever 노드 오른쪽 노드/엔트리"+treeMap.higherEntry("ever"));//ever 노드 왼쪽 노드/엔트리description=40
		System.out.println("ever 노드 이거나 왼쪽 노드"+treeMap.floorEntry("ever"));//ever 노드 이거나 왼쪽 노드ever=50
		System.out.println("ever 노드 이거나 오른쪽 노드"+treeMap.ceilingEntry("ever"));//ever 노드 이거나 오른쪽 노드ever=50
		
		//4. 내림차순
		System.out.println("이진트리 map 내림차순: "+treeMap.descendingMap());
			//이진트리 map 내림차순: {zoo=80, guess=70, forever=60, ever=50, description=40, cherry=30, base=20, apple=100}
		
		System.out.println("시작(a)~c까지 단어 검색: "+treeMap.headMap("c",true));
			//시작(a)~c까지 단어 검색: {apple=100, base=20}
		
		System.out.println("c~끝(z)까지 단어 검색: "+treeMap.tailMap("c",true));
			//c~끝(z)까지 단어 검색: {cherry=30, description=40, ever=50, forever=60, guess=70, zoo=80}
		
		System.out.println("c~h 사이의 단어 검색: "+treeMap.subMap("c", true,"h",false));
			//c~h 사이의 단어 검색: {cherry=30, description=40, ever=50, forever=60, guess=70}
		
	}

}
