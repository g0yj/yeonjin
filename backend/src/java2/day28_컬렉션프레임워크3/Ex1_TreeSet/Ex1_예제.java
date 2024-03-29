package java2.day28_컬렉션프레임워크3.Ex1_TreeSet;

import java.util.TreeSet;

/*
	 	검색 기능을 강화시킨 컬렉션
	 *	- 컬렉션 안에 있는 데이터를 검색할 때 효율성 제공 [필수X]
	 *	- 이진트리 : 각 노드는 최대 2개의 노드를 연결
	 *			  부모 노드보다 작으면 왼쪽 노드, 크면 오른쪽 노드
	 *			- 6,8,10 이진트리 표현
	 *				  부모노드(8)
	 *				/		  \
	 *			자식로드(6)  자식노드(10)
	 */

public class Ex1_예제 {

		public static void main(String[] args) {
			//1. TreeSet 객체 생성
			TreeSet<Integer> scores = new TreeSet<>();
			
			//2. 무작위로 숫자 저장
					// 자동으로 정렬 (오름차순)
			scores.add(87);
			scores.add(98);
			scores.add(75);
			scores.add(95);
			scores.add(80);
			System.out.println("이진트리 상태: "+scores); //이진트리 상태: [75, 80, 87, 95, 98]
			
			//3. 
			System.out.println("가장 왼쪽 노드: "+ scores.first()); //75
			System.out.println("가장 오른쪽 노드: "+ scores.last()); //98
			System.out.println("95점 아래 노드: "+scores.lower(95));//87
			System.out.println("95점 위에 노드: "+scores.higher(95));//98
			System.out.println("95점이거나 바로 아래 노드: "+scores.floor(95));//95
			System.out.println("95점이거나 바로 위 노드: "+scores.ceiling(95));//95
			
			//4. 내림차순
			System.out.println("이진트리 내림차순: "+scores.descendingSet());//이진트리 내림차순: [98, 95, 87, 80, 75]
			
			//5. 범위검색
				//tailSet(숫자, true(이상)/false(초과))
			System.out.println("이진트리 80이상"+scores.tailSet(80,true));//[80, 87, 95, 98]
				//subSet(시작숫자, 옵션, 끝숫자, 옵션)
			System.out.println("이진트리 80이상 90미만 : "+scores.subSet(80, true,90,false));//[80, 87]
		}
}
