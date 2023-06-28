
//-----------요구사항3--------------------------------
/*1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~ 		[ if( sno2Value == '' ) ]
  2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.	[ sno2.value = '' ]
  3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.	[ sno2Value.length !=8  ]
*/

/*
1. 아이디,비밀번호 입력창 / 회원가입,로그인 버튼 만들기
2. 로그인 함수 만들기
- queryselector로 value값 받기
- input박스가 공백이면 학번 입력 alert띄움
- id리스트 배열 내 있는지 확인 indexOf = -1 , pw리스트 배열 내 있는지 확인
 	ㄴ??????????? 같은 인덱스 끼리 묶는 방법?!?!?
- if문으로 각 배열의 인덱스의 값이 같으면 로그인성공으로 alert창 띄움
- 초기화 `` 해서 input의 value 제거

3. 회원가입 함수 만들기
-queryselctor value 값 받기
-id리스트에 없는 값일 때 실행
-아이디 길이 8이상 && 비밀번호길이 8이상일때 실행
-초기화
*/

let id리스트3=[]
let pw리스트3=[]

function 로그인함수1(){
	let id3= document.querySelector('.loginId3').value
	let pw3= document.querySelector('.loginPw3').value
	console.log('로그인함수 아이디 받음: '+id3)
	console.log('로그인함수 비밀번호 받음: '+pw3)
	//아이디 공백이면 학번 입력
	if(id3==''){alert('학번 입력 해주셈')
					return;} 
	for(let i=0; i<id리스트3.length;i++){
		if(id리스트3[i]==id3&&pw리스트3[i]==pw3){alert('로그인성공')}
	}
	//초기화
	document.querySelector('.loginId3').value=``
	document.querySelector('.loginPw3').value=``
}

function 회원가입함수1(){
	id3= document.querySelector('.loginId3').value
	pw3= document.querySelector('.loginPw3').value
	if(id리스트3.indexOf(id3)!=-1){
		alert('가입 불가능')
		return;
	}
	if(id3.length>=8||pw3.length>=8){id리스트3.push(id3)
						pw리스트3.push(pw3);
						alert('성공')}
	console.log(id리스트3)					
	console.log(pw리스트3)					

	
	document.querySelector('.loginId3').value=``
	document.querySelector('.loginPw3').value=``
}
