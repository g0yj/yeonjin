package 과제.과제10;

import java.util.Arrays;
import java.util.Scanner;

import 과제.과제10.Member;

public class MemberSys {
	
	
	
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}
/*
 				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
  */	
	
	static void 회원가입 () {
		System.out.println(" 아이디 입력: "); String inputId=sc.next();
		System.out.println(" 비번 입력: "); String inputPassword=sc.next();
		System.out.println(" 이름 입력: "); String inputName=sc.next();
		System.out.println(" 핸드폰 입력: "); String inputPhone=sc.next();
		System.out.println(" 나이 입력: "); int inputAge=sc.nextInt();
		
		Member member=new Member(inputId, inputPassword, inputName, inputPhone, inputAge);
		
		for(int i=0; i<memberList.length;i++) {//만약 i인덱스에 null이면 해당 i번째 인덱스에 입력받아 만든 객체 대입
			if(memberList[i]==null) {//빈공간찾음
				memberList[i]=member;
				
				break;
			}//if
		}//for
		
	}//회원가입()
	
/*
 *  로그인 메소드--------------------------
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패	
 */
	
	
	static void 로그인 () {
		System.out.println(" 아이디 입력: "); String inputId=sc.next();
		System.out.println(" 비번 입력: "); String inputPassword=sc.next();
		
		int login =-1;  // 로그인 여부를 저장하는 변수. -1은 인덱스 불가능한 숫자기 때문에 쓴거. 
							//로그인 여부를 왜 ? -> 로그인 실패 시와 같은 경우에 사용하기 위해
		for(int i=0; i<memberList.length;i++) {
			if(memberList[i]!=null&&(memberList[i].id).equals(inputId)&&(memberList[i].password).equals(inputPassword)) {
				//memberList[i]!=null 을 하는 이유??? -> NullPointerException 오류 발생. 
						// 참조타입 변수는 아직 번지를 저장하고 있지 않다는 뜻의 null 값을 가질 수 있음. 이건 스택이 아직 주소를 가지고 있지 않다는 뜻	
				login=i;
				System.out.println(memberList[i]);
				break;
			}//if
		}//for
		if(login>=0) {
			System.out.println("로그인성공");
		}
		else {System.out.println("로그인실패");}
		
	}//로그인()
	
/*
 아이디찾기 메소드-----------------------------------------------
	1. 이름 , 전화번호 입력받아 저장
	2. 입력받은 값과 배열내 동일한 값 찾기
			- 만약에 동일한 값 있으면 찾은 아이디 출력 
			- 아니면 없다.
  */
	
	
	
	static void 아이디찾기 () { 
		System.out.println("이름: "); String inputName= sc.next();
		System.out.println("전화번호: "); String inputPhone= sc.next();
		for(int i=0; i<memberList.length;i++) {
			if(memberList[i]!=null&&memberList[i].name.equals(inputName)&&memberList[i].phone.equals(inputPhone)) {
			System.out.println("찾은아이디:" +memberList[i].id);	
			}
			else {System.out.println("아이디없음");}
		}//for
		
	}//아이디찾기()
/*
 *비밀번호찾기 메소드 ---------------------------------------------
		1. 아이디 , 전화번호 입력받아 저장
		2. 입력받은 값과 배열내 동일한 값 찾기
			- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
			- 아니면 없다.
 * */	
	
	
	static void 비밀번호찾기 () { 
		System.out.println("아이디: "); String inputId=sc.next();
		System.out.println("전화번호: "); String inputPhone=sc.next();
		
		for(int i=0; i<memberList.length;i++) {
			if(memberList[i]!=null&&memberList[i].name.equals(inputId)&&memberList[i].phone.equals(inputPhone)) {
			System.out.println("임시비밀번호 발급");
			//?????????????????????????????????????????????????????????
			}
			else {System.out.println("없음");}
		}//for
	}
	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














