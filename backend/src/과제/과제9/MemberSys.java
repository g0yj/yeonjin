package 과제.과제9;


// 과제9 함수의 오버로딩  -> 4시 40분 오버로딩 인수 관련 내용 체크

import java.util.Arrays;
import java.util.Scanner;

//목적: 실행
public class MemberSys {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		//0. 여러개 Member객체를 저장 예정인 객체 100개를 저장하는 배열 선언
			//배열 선언: 타입명[]배열명=new 타입[길이];
					//타입: 기본타입, 참조(String,직접만든class등 )타입
		Member[] memberList =new Member[100]; // 100명의 회원을 저장
		
		while(true) {//무한루프
			// 배열상태 확인용
			System.out.println(Arrays.toString(memberList));
		//1.무한출력
			System.out.println("------------- -회원시스템-----------------");
			System.out.println("1. 회원가입 |  2. 로그인 |  선택>  ");
		
		//2. 무한입력 (지금은 console진행으로 키보드로 밖에 받을 수 없음)
			int ch= scanner.nextInt();
		
		//3. 선택의 경우의 수 [ ch==1, ch==2]
			if(ch==1) {//회원가입
				System.out.println("------------회원가입-----------------");
				//1. 각 입력받아 저장
				System.out.print("아이디: "); String inputId=scanner.next();
				System.out.print("비밀번호: "); String inputPw=scanner.next();
				System.out.print("이름: "); String inputName=scanner.next();
				System.out.print("전화번호: "); String inputPhone=scanner.next();
				System.out.print("나이: "); int inputAge=scanner.nextInt();
				
				//2. 5가지를 하나로 묶음 = 문자열vs 객체 (객체선택)
				Member member=new Member(inputId, inputPw, inputName, inputPhone, inputAge) {
				};
				
				
				//3. 여러개의 객체를 저장하기 위해 배열에 저장
					//*비어 있는 인덱스(=기본값이 들어있는)를 찾아 해당 인덱스에 객체 저장
				for(int i=0; i<memberList.length;i++) {//만약 i인덱스에 null이면 해당 i번째 인덱스에 입력받아 만든 객체 대입
					if(memberList[i]==null) {//빈공간찾음
						memberList[i]=member;
						
						break;
					}//if
				}//for
				
			}//ch1
//-------------------------------------------------------------------------------------------------------			
			else if(ch==2){
				System.out.println("------------로그인------------------");
				//1. 각 입력 받기
				System.out.print("아이디: "); String inputId=scanner.next();
				System.out.print("비밀번호: "); String inputPw=scanner.next();
				//2. 저장 목적이 아니기 때문에 객체 생성 필요 없음. 시켜도 되긴함
				// 입력 받은 데이터를 배열 내 찾기
				
				int login=-1; //로그인 여부를 저장하는 변수 -1: 못찾음.
								//만든이유? : 로그인 실패 시
				
				for(int i=0; i<memberList.length;i++) {
					// 만약 i번째 객체의 id 필드와 력받은 아이디와 같고 ;i번째 pw필드와 입력 받은 비밀번호와 같으면
					//memberList[i]!=null 을 하는 이유??? -> NullPointerException 오류 발생. 
														// 참조타입 변수는 아직 번지를 저장하고 있지 않다는 뜻의 null 값을 가질 수 있음. 이건 스택이 아직 주소를 가지고 있지 않다는 뜻
					if(memberList[i]!=null&&memberList[i].id.equals(inputId)&&memberList[i].password.equals(inputPw)) {//로그인성공
						login = i; //로그인 성공 후 변수에 성공한 인덱스에 저장= 추후 로그인 상태 활용
						break;
					}
					
				}//for end
				//3. 로그인 성공여부 변수에 따른 흐름 제어
				// 로그인 실패[모든 배열 확인 후 성공 못할 시 로그인 실패]
				if(login>=0) {//로그인 성공
					System.out.println("로그인성공"); //추후에 로그인 새로운 메뉴 메소드 호출
				}//if종료
				else {
					System.out.println("로그인실패");
				}
				
				
			}//ch2
			
			
			
			
			
			
		}//while
		
	
	
	
	}//main
}//class


/*
	주제: 회원제 시스템
		
		0. 저장
			아이디, 비밀번호, 이름, 전화번호,나이
			*5가지의 필드/변수/데이터를 하나로 묶는 방법
			--> 문자열이용한 필드 구분: "아이디,비밀번호,이름,전화번호,나이" <- ,를 이용한 필드 구분
			--> 클래스 필드 이용:
					1. 클래스 설계 = 새로운 클래스.java 파일 생성
					2. 클래스 멤버 구성: 필드, 생성자, 메소드
				* 하나로 묶인 (기준이 동일(=타입이동일)) 여러개 저장???
					--> 문자열 배열: String[]문자열배열=new String[100];
					--> 클래스 배열: Member[] 객체배열= new Member[100];
			
			
		1. 초기메뉴
			1.회원가입 2.로그인
		2. 조건기능
			1. 회원가입
				1 : 아이디, 비밀번호, 이름, 전화번호, 나이 각 입력 받아 저장
				2 : Member 객체화
				3 : 객체를 배열에 저장
				
			2. 로그인
				1. 아이디, 비밀번호 입력받아 
				2. 배열 내 입력받은 아이디 값과 동일한 값 찾기
					- 만약 동일값이 있으면 로그인 성공
					- 없으면 실패
			
			
	*	11시30분, 12시
*/
