/*
	onchange: 포커스(커서)가 변경될때 값이 다르면
	onkeyup: 키보드에서 키를 누르고 떼었을때 실행
	onkeydown: 키보드에서 키를 눌렀을때
*/

/*
	정규 표현식: 문자열에 특정 규칙/패턴 집합을 표현할 때 사용되는 언어
		<문법>
			/^ : 정규표현식 시작 알림.
			$/ : 정규표현식 끝 알림
			[a-z] : 소문자 a-z 패턴 검색(소문자 있는지 없는지)
			[A-Z] : 대문자 A-Z 패턴 검색
			[0-9] : 숫자 0~9 패턴 검색
			[가-힣] : 한글 패턴
			{최소길이, 최대길이} : 문자열 길이 패턴
		
		<예시>
			1.[a-z] : 소문자 패턴
			2.[a-zA-Z] : 영문(대,소)패턴
			3.[a-zA-Z0-9] : 영문+숫자 조합 패턴
			4.[a-zA-Z0-9가-힣] : 영문+숫자+한글 조합 패턴 
			5.[abcde] : abcde 중 하나를 가지는
			
			-> /^[a-z0-9]{5,30}$/ : 영문(소)+숫자 조합 5~30글자 패턴
		
		<패턴검사>
			"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
 */

//1. 아이디 유효성검사

function idcheck(){/*실행조건: 아이디 입력창에 입력할때마다*/
	
	//1.값 호출
	let mid =document.querySelector('.mid').value;
	let idcheck=document.querySelector('.idcheckbox') //반복되니까 지역변수로 선언해서 쓰기!
	//2. 유효성검사
		//제어문을 이용한 유효성검사-> if(mid.length<5&&~ ) : mysql 연결
		//정규표현식을 사용한 유효성검사
		//1. 아이디는 영문(소문자)+숫자 조합의 5~30글자 사이이면
			//1. 정규표현식 작성
		let midj=/^[a-z0-9]{5,30}$/
			//2. 정규표현식 검사
		console.log(midj.test(mid));
		if(midj.test(mid)){//입력한 값이 패턴과 일치하면
		
			//---[아이디 중복검사] 입력한 아이디가 패턴과 일치하면
			   $.ajax({
			      url : "/jspweb/MemberFindController",     
			     method : "get",   
			     data : {mid:mid},      
			      success : r=>{console.log('통신성공')
			      	if(r){idcheck.innerHTML='사용중인 아이디'}
			      	else{idcheck.innerHTML='사용가능'}
			      } ,       
			      error : e=>{} ,         
			   });

		}else{
			idcheck.innerHTML='영문(소문자)+숫자 조합의 5~30글자 가능함'
		}
	//3. 결과 출력
}//f()


//2. 회원가입 메소드
function signup(){
	
	//1. html에 가져올 데이터의 tag객체 호출[dom객체:html태그를 객체화]
	let midInput =document.querySelector('.mid');
	let mpwdInput =document.querySelector('.mpwd');
	let mpwdconfirmInput =document.querySelector('.mpwdconfirm');
	let memailInput =document.querySelector('.memail');
	let mimgInput =document.querySelector('.mimg');
	
	//2.(객체화)
	let info={//인증코드(유효성검사를 위한), 패스워드확인(유효성검사를 위한) <= db에 넣을 필요가 없음
		mid:midInput.value,
		mpwd:mpwdInput.value,
		memail:memailInput.value,
		mimg:memailInput.value,
		
		
	}
	
	//3. 유효성검사
	
	//4. ajax 메소드를 이용한 servelet와 통신
	 $.ajax({
      	url : "/jspweb/MemberinfoController",     
     	method : "post",   
     	data : info,      
      	success : r=>{console.log('통신성공')
      		if(r==true){console.log('회원가입성공')}
      		else{console.log('가입실패')}
      	} ,       
      	error : e=>{console.log('통신실패')} ,         
   });

		//5. servlet의 응답에 따른 제어
	
	
}