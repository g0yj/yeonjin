package java2.day27_컬렉션프레임워크2.Ex2_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex2_예제 {
	public static void main(String[] args) {
		
		//1. map 컬렉션객체 내 <String , Integer> 2개 객체를 저장할 컬렉션 객체 선언
		Map<String, Integer> map =new HashMap<>();
		
		//2. 객체 저장 .put(key,value) :<key,value> 로 구성된 엔트리 객체 1개 저장
		map.put("신용권", 85);//key:"신용권", value:85
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);//key가 중복이 불가능하므로 새로운 값ㅇ로 대체
		System.out.println("map상태: "+map);
		
		//3. 객체 호출 .get(key) : key 넣으면 key와 같이 저장된 value 호출
		System.out.println("홍길동 value : "+map.get("홍길동"));
		
		//4. map객체 내 모든 key 호출 , value 호출 
			//.keySet() : map객체내 모든 키 key를 호출
			//.keyVlues() : map객체 내 모든 값 value를 호출
		System.out.println("map 객체 내 모든 key: "+map.keySet());
		System.out.println("map 객체 내 모든 values: "+map.values());
		
		//5. 향상된 for문 [map.keySet() : 모든 key 호출]   -> 3개 중 하나. forEach 권장
		for(String key:map.keySet()) {
			System.out.printf("key:%s values :%d  \n",key, map.get(key));
		}
		//5.
		map.keySet().forEach(key->{
			System.out.printf("key:%s values :%d  \n",key, map.get(key));
		});
		//5.
		for(Entry<String, Integer> entry:map.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		map.entrySet().forEach(entry->{
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		});
		
	}//m

}//c
