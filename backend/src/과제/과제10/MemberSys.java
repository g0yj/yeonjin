package 과제.과제10;
//10시 30분
//10시 56분
//11시 25분
import java.util.Arrays;  // 현재 클래스에서 다른 패키지에 있는 클래스 호출 =import
import java.util.Scanner;
import 과제.과제10.Member;

//import-----------------------------------------
// 현재 클래스에서 캍은 패키지에 있는 클래스 호출은 생략
//java.lang 기본 패키지이므로 생략 (ex. String , System 등)
// 해당 패키지내 모든 클래스 호출 하고 싶을 땐 *사용

public class MemberSys {
	
	
	// main함수에 넣으면 회원가입() 등에서 사용 불가!!  따라서 main() 밖에서 써줘야됨
	static Member[] memberList = new Member[100];//1. 정적멤버 = 메소드영역= 프로그램전체1개
	// Member[] memberList=new Member[100]; //2. 인스턴스멤버 = 힙영역= new 마다
	
	//프로그램내 전역구역에서 공유 사용되는 메모리(정적멤버) /24번째줄 참고
	static Scanner sc = new Scanner(System.in);
	
	static int LoginIndex =-1;  // 로그인 여부를 저장하는 변수. -1은 인덱스 불가능한 숫자기 때문에 쓴거. 
	//로그인 여부를 왜 ? -> 로그인 실패 시와 같은 경우에 사용하기 위해
	// 로그인 했다 안했다를 판단하기 위해 전역변수로 빼둬야함. 로그아웃 하기 전까지 페이지 바꿔도 유지되기 위해
	public static void main(String[] args) {
	// 메인함수는 가장 먼저 실행됨. static으로 정적멤버임. static은 우선 할당!
		
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			//1. 입력객체의 위치를 어디에 둘까 ?! 입력객체의 사용 구역 범위를 생각해
				// Scanner sc = new Scanner(System.in); 여기에 선언하면 안됨! {}에만 사용하는거니까. 써도 되지만 효율이 떨어지지
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { MemberSys.회원가입 (); }//main함수 밖에 있는 다른 함수 호출
			//1. 인스턴스멤버(static없는) 함수는 객체를 통해 호출
			//2. 정적멤버(static있는) 함수는 객체 없이 클래스를 통해 호출
			else if( ch == 2 ) {  MemberSys.로그인 (); } 
			else if( ch == 3 ) {  MemberSys.아이디찾기 (); } 
			else if( ch == 4 ) {  MemberSys.비밀번호찾기 (); } 
			
		} // w e 
	}//main
	
/*
 				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
  */
	//입력 받아 저장 [creat]
	static void 회원가입 () { // static이 없으면 인스턴스 멤버임. main에서 사용 시에 오류뜸.
									//인스턴스멤버는 객체 할당 후 사용
										//만약 static 없이 사용하고 싶다면, 
											// main 함수 내 회원가입() 선언이 달라짐. (25번줄)// if(ch==1){MemberSys sys =new MemberSys(); sys.회원가입();}
		System.out.println("-------회원가입------------------------------");
		//회원가입 {}안에 스캐너가 없지만 사용할 수 있는 이유 = static에서 선언됨
		//1. 입력받기 => 각각 5개 입력받기 
		// 받은값 변수 이름명 다시 생각해보기! 매개변수로 전달 받으니까 id 이런식 가넝
		System.out.println(" 아이디 입력: "); String inputId=sc.next();
		System.out.println(" 비번 입력: "); String inputPassword=sc.next();
		System.out.println(" 이름 입력: "); String inputName=sc.next();
		System.out.println(" 핸드폰 입력: "); String inputPhone=sc.next();
		System.out.println(" 나이 입력: "); int inputAge=sc.nextInt();
		//2. 5개의 변수를 하나로 묶음 (동일한거니깐)
				// 방법1: String ", , , " 이런 식으로 객체가 아닌 것들이 들어와 가공이 필요한 경우
				// 방법2: 객체로 묶음
		
		//2안. member 변수는 힙 주소를 저장하는거임! memberList 출력 시 주소로 나옴.
		Member member=new Member(inputId, inputPassword, inputName, inputPhone, inputAge); 
		
		//빈 생성자를 이용 1안. 
		//Member m = new Member(); // 빈/깡통 생성자
		// 1. m = { id = null , pw = null , name = null , phone = null , age = 0 }
		//	m.id = id ; m.pw = pw; m.name = name; m.phone = phone; m.age = age;
		// 2. m = { id = "입력받은값" , pw = "입력받은값" , name = "입력받은값" , phone = "입력받은값" , age = "입력받은값" }
		
		
		//3. 회원의 1개의 객체를 배열에 저장 
			//1. 배열 내 빈공간 찾기(=null찾기)
		for(int i=0; i<memberList.length;i++) {//만약 i인덱스에 null이면 해당 i번째 인덱스에 입력받아 만든 객체 대입
			if(memberList[i]==null) {//빈공간찾음
				memberList[i]=member;
				System.out.println("회원가입 성공");
				break;
			}//if
		}//for
		// 확인용
		System.out.println("회원리스트 상태: "+Arrays.toString(memberList));
		
	}//회원가입()
	
/*
 *  로그인 메소드--------------------------
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패	
 */
	
	
	static void 로그인 () {// 입력받아 기존 데이터와 비교 [reading] , 저장 아님
		System.out.println(" 아이디 입력: "); String inputId=sc.next();
		System.out.println(" 비번 입력: "); String inputPassword=sc.next();
		
		
		// 입력 받은 값이 배열 내 존재하는가?
		for(int i=0; i<memberList.length;i++) {
			if(memberList[i]!=null&&(memberList[i].id).equals(inputId)&&(memberList[i].password).equals(inputPassword)) {
				//memberList[i]!=null 을 하는 이유??? -> NullPointerException 오류 발생. 
						// 참조타입 변수는 아직 번지를 저장하고 있지 않다는 뜻의 null 값을 가질 수 있음. 이건 스택이 아직 주소를 가지고 있지 않다는 뜻	
						// 굳이 비어있는 곳을 비교할 필요는 없으니까
				
				LoginIndex=i; // 정적 멤버 변수에 로그인 성공한 인덱스 넣어두기 - 추후에 사용할 목적(20번 줄에서 확인)
				System.out.println(memberList[i]);
				break;
			}//if
		}//for
		if(LoginIndex>=0) {
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
	
	
	
	static void 아이디찾기 () { // 비교하는거지 저장하는 거 X
		System.out.println("이름: "); String inputName= sc.next();
		System.out.println("전화번호: "); String inputPhone= sc.next();
		for(int i=0; i<memberList.length;i++) {
			if(memberList[i]!=null&&memberList[i].name.equals(inputName)&&memberList[i].phone.equals(inputPhone)) {
			System.out.println("찾은아이디:" +memberList[i].id);	
			return; // 일치한 회원이 존재하면 아이디함수 강제 종료. 아이디찾기에서 한 결과를 다른데서 쓸 일이 없으니까 강제 종료 시켜도 됨.
			}
			// else {System.out.println("아이디없음");} return 썼으니까 여기서  for문 밖에서 찍어봄.
		}//for
		System.out.println("아이디없음");
		
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
			
		2. 조건 기능  (MemberSys에 만들꺼냐 Member에 만들꺼냐. 둘다 상관 없음. 관례적으로는 여기에 만듦)
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














