/*
1. 로그인
- 회원가입을 통해 회원 배열에 push
- 배열 안에 있는 회원 정보와 일치하는 아이디, 비밀번호인지 확인하고 로그인

2. 글 작성(내용 입력) 

3. 총 게시물 (전체보기)

4. 글 내용 확인(게시글 들어가서 보기)








 */

//----------------회원가입---------------
let joinlist=[]

//회원가입 onclick
function join(){ console.log('join()함수실행')
	let id= document.querySelector('.id').value
	let pw= document.querySelector('.pw').value
	console.log('아이디: '+id+'비밀번호: '+pw)
	
	//id와 pw를 객체로 묶음
	let join={아이디:id, 비밀번호:pw}
	console.log(join)
	console.log(joinlist)
	
	// 유효성 검사: 배열 안에 이미 있나 없나 확인
	if(joinlist.indexOf(join)!=-1){	
		
		}
	}	
	else{	
		joinlist.push(join); alert('회원가입성공');return}
	 
}	

//----------로그인---------------------
//로그인 onclick
function login(){console.log('login() 함수 실행')
	let id= document.querySelector('.login_id').value
	let pw= document.querySelector('.login_pw').value
	
	let login={아이디:id, 비밀번호:pw}
	
	for(let i=0; i<joinlist.length;i++){
		if(joinlist[i]==login){alert('로그인성공');return}
		else{alert('로그인실패') ; console.log('로그인실패')}
		}
}

//--------------------글 등록


