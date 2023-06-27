/*- 파일명 : 과제2.html / 과제2.js / 과제2.css
-------------------------------------------------------------------
요구사항1 : 아이디와 비밀번호를 입력받아 회원가입을 진행하고 싶어요.
	[조건1] 
		입력 <input> 사용 해서 아이디 입력받기 
		입력 <input> 사용 해서 비밀번호 입력받기 
	[조건2]
		* 1차원배열만 사용 [ 배열 변수 여러개 사용 가능 ]
	[조건3]
		<input type="button"> 사용해서 회원가입 이벤트 실행 [ 회원가입함수 구현하기 ]

-------------------------------------------------------------------
요구사항2 : 아이디와 비밀번호를 입력받아 로그인 을 진행하고 싶어요.
	[조건1]
		입력 <input> 사용 해서 아이디 입력받기 
		입력 <input> 사용 해서 비밀번호 입력받기 
	[조건2] 
		만약에 배열에 존재하는 아이디,비밀번호가 일치한 데이터가 있을경우
		[ 로그인 성공 ] 아니면  [ 로그인 실패 ] alert 로 출력해주세요.
	[조건3]
		<input type="button"> 사용해서 로그인 이벤트 실행 	[ 로그인함수 구현하기 ]
------------------------------------------------------------------------
요구사항3 : 유효성검사 진행해주세요.  
	1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~ 		[ if( sno2Value == '' ) ]
	2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.	[ sno2.value = '' ]
	3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.	[ sno2Value.length !=8  ]

요구사항4 : 기본적인 css 작업해주세요
	1. (필수) div 2개를 만들어서 [ 왼쪽은 회원가입 구역 ] [ 오른쪽은 로그인 구역 ]
	2. 그외 이쁘게 꾸며주세요. */
	
//--------요구사항1------------------------------------
let id리스트=[]
let pw리스트=[]
function 회원가입함수(){
	let id=document.querySelector('.inputId').value
	let pw=document.querySelector('.inputPw').value
	console.log('id출력: '+id)
	console.log('비밀번호: '+pw)
	id리스트.push(id)
	pw리스트.push(pw)
	console.log(id리스트)
	console.log(pw리스트)
}


//--------요구사항2-------------------------------------
function 로그인함수(){
	let id=document.querySelector('.loginId').value
	let pw=document.querySelector('.loginPw').value
	
	if(id리스트==id&&pw리스트==pw){
		alert('로그인 성공')
		}
	else{alert('로그인 실패')}	
	
	}
	
	
//-----------요구사항3--------------------------------
/*1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~ 		[ if( sno2Value == '' ) ]
  2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.	[ sno2.value = '' ]
  3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.	[ sno2Value.length !=8  ]
*/
let id리스트1=[]
let pw리스트1=[]

function 로그인함수1(){
	let id1=document.querySelector('.loginId').value
	let pw1=document.querySelector('.loginPw').value
	
	if(id1==''){alert('학번입력해주셈')}
	
	id1=``
	pw1=``
}

/*
1. 아이디,비밀번호 입력창 / 회원가입,로그인 버튼 만들기
2. 
*/