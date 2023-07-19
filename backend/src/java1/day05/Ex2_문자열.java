package java1.day05;

public class Ex2_문자열 {

	public static void main(String[] args) {

		
		//p.153 내용
		String name1= "홍길동";//10번지
		String name2= "홍길동";//10번지
			// ?????? 같은 번지일까 ? ?? : 두 스택영역의 지역변수가 참조하는 주소는 같을까?
		System.out.println(name1==name2); //true
											//왜?! String(문자열)타입은 예외임.
		
		String name3=new String("홍길동");//11번지
		String name4=new String("홍길동");//12번지
		System.out.println(name3==name4); // false
											// " " :문자열 리터럴 아닌 new 연산자를 이용한 객체 생성시에는 다름.
		
		//p.155 
		if(name1==name2) {//" " 문자열리터럴로 생성된 문자열 객체 비교해보자. "두 문자열 같음 " 출력
			System.out.println("두 문자열 같음");
		}
		else {System.out.println("두 문자열 다름");}
		
		//p.156
		if(name3==name4) {
			System.out.println("두 문자열 같음");
		}
		else {System.out.println("두 문자열 다름");}
		
		
		//p.157 문자열 내에서 특정 문자 추출/꺼내기
		String ssn="9308132111111"; // 문자열 객체 선언 . 글자수 13, 인덱스0~12
		char sex = ssn.charAt(6); //2[6]
		
		if(sex=='1'||sex=='3') {
			System.out.println("남자임");
		}
		else {System.out.println("여자임");}
		
		//p.158 .length() 문자열 길이 구하기
		System.out.println("주민등록번호 길이: "+ssn.length());
		
		//p.159 .replace() 문자열 내 특정 문자열 교체/치환/대체
		String oldStr="자바 문자열은 불변입니다. 자바 문자열은 String입니다";
		//문자열 내 '자바'를 'JAVA'로 교체
		String newStr =oldStr.replace("자바", "JAVA"); // 치환된 결과를 새로운 변수에 저장해야됨(newStr). 안하면 syso 찍어도 변화 없음.
		System.out.println(oldStr);
		System.out.println(newStr);
		
		//p.160 .subString() : 문자열 자르기
		String ssn2="930813-2453992";
		String secondNum= ssn2.substring(7); //인덱스7부터 마지막까지 추출
		System.out.println(secondNum); //2453992 반환
		
		String firstNum=ssn2.substring(0,5);
		System.out.println(firstNum);  //9308
		
		
		//p.164 .split()  : 문자열 분리
			// ssn2.split("-"): - 기준으로 분리
				//"880815-1234567" -> 분리{880815,1234567}
		System.out.println(ssn2.split("-")[0]); //880815
		System.out.println(ssn2.split("-")[1]); //1234567
		
		
		//p.163 .indexOf :문자찾기
		String subject ="자바 프로그래밍";
		
		int location =subject.indexOf("자바프로그래밍"); //"자바 프로그래밍" 문자열내 "프로그래밍"문자열 찾기
			//찾은 문자열의 위치[인덱스]반환/ 없으면 -1
		if(location==-1) {//못찾았다
			System.out.println("프로그래밍 책이 아님");
		}else {//찾음
			System.out.println("프로그래밍 책임");			
		}
	}//main

}//class

/*	자바 문자열 사용하는 방법
 * 1. String 변수명="문자열"
 * 2. String 변수명= new String("문자열");
 * 3. 문자열객체.length()  // 주의! 배열의 길이 구할때는 배열명.length임
 * 	자바 문자열에서 제공해주는 라이브러리(미리 만들어진 함수들)
 * 문자열객체.메소드명()
 * 1. 문자열객체1.equals(문자열객체2) : 두 문자열 객체 내 문자열이 동일하면 true 아니면 false 반환 [주소아님]	
 * 2. 문자열객체.charAt(인덱스)  : 문자열 내 해당 인덱스의 문자 1개 추출[첫번째 글자=인덱스0]
 * 3. 문자열객체.length() : 문자열에서 문자의 개수 반환
 * 4. 문자열객체.replace("기존문자열","새로운문자열")  : 문자열 내 기존 문자열이 존재하면 새로운 문자열로 치환해서 반환
 * 5. 문자열객체.subString(인덱스)  : 해당 인덱스부터 마지막까지 추출
 * 	  문자열개겣.subString(시작인덱스, 끝인덱스) : 시작 인덱스부터 마지막인덱스전까지 문자열 추출
 * 	  문자열객체.split("분리기준문자") : 문자열 내 분리 기준 문자로 분리해서 배열로 반환
 * 		문자열객체.split("분리기준문자")[인덱스]  : 분리후 분리된 인덱스 1개 호출
 * 6. 문자열객체.indexOf("찾고시은문자열")  : 문자열 내 찾을 문자열이 존재하면 찾은 문자열 인덱스 반환/ 없다면 -1
 */
