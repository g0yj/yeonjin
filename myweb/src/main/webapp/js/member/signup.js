console.log('회원가입페이지js실행')
//myweb

//==가입 가능 아이디 조건 유효성[1.정규표현식 2.db중복아이디]=================
function idcheck(){
	//1.값 호출
	let mid=document.querySelector(".mid").value;
	let idcheck=document.querySelector(".idcheck")//글자 적을때마다 결과를 보여줄 예정. 반복되는 과정으로 전역변수선언
	console.log(mid);
	//2.유효성검사(정규식사용)-영어+숫자 5~15
		//2-1 정규표현식작성
	let midc=/^[a-zA-Z](?=.*[a-zA-Z])(?=.*[0-9]).{5,15}$/
		//2-2 정규표현식 검사
		console.log(midc.test(mid))
		if(midc.test(mid)){//입력한 아이디와 패턴 일치하면
	//2. 유효성검사(ajax -유효성검사를 위한 ajax : 동일한 아이디 있는지 없는지.)
			 $.ajax({
		      	url : "/myweb/Memberfind",     
		     	method : "get",   
		     	data : {type:"mid", data:mid}, //속성명:값      
		      	success : r=>{console.log('통신성공');
		      		if(r){idcheck.innerHTML=`사용 중 아이디입니다`}
		      		else{idcheck.innerHTML='사용 가능한 아이디입니다'}
		      		
		      	} ,       
		      	error : e=>{console.log('통신실패');console.log(e)} ,         
		   });
	
			
		}
		else{
			idcheck.innerHTML=`영문+숫자 조합으로 입력해주세요`
		}
}//f()아이디유효성검사

//== 가입 가능한 비밀번호 유효성 검사[1.정규표현식 2. 비밀번호와 비밀번호확인이 일치]=======================
function pwcheck(){
		//1.값 호출
	let mpw=document.querySelector('.mpw').value;
	let pwcheck=document.querySelector('.pwcheck')//글자 적을때마다 결과를 보여줄 예정. 반복되는 과정으로 전역변수선언
	let recheck=document.querySelector('.recheck')

	console.log(mpw);
	//2.유효성검사(정규식사용)-영어+숫자 10~15
		//2-1 정규표현식작성
	let mpwc= /^[a-zA-Z](?=.*[a-zA-Z])(?=.*[0-9]).{5,15}$/
		//2-2 정규표현식 검사
		console.log(mpwc.test(mpw))
		if(mpwc.test(mpw)){//입력한 아이디와 패턴 일치하면
			pwcheck.innerHTML=`사용가능한 비밀번호입니다`;
			let repw=document.querySelector('.repw').value;
			
			if(mpw==repw){//비밀번호 통과하고 비밀번호 확인까지 일치하면
				recheck.innerHTML=`사용가능한 비밀번호입니다`	
			}else {recheck.innerHTML=`비밀번호가 일치하지 않습니다`}
		
		}//if
		else{pwcheck.innerHTML=`영문+숫자 조합으로 입력해주세요`}

}//f() 비밀번호 유효성검사

//==이메일 보내기[유효성:중복검사]========================================
function mSend(){
	//1.값 호출
	let mmail = document.querySelector('.mmail').value;
	let mailcheck=document.querySelector('.mailcheck');
	//2.유효성검사
	 $.ajax({
      	url : "/myweb/Memberfind",     
     	method : "get",   
     	data : {type:"mmail",data:mmail},      
      	success : r=>{console.log('통신성공'+r)
      		if(r){
				let html=
				`<div class="timer">타이머</div>
				인증번호<input class="checkno" type="text">
				<button onclick="mcheck()"type="button">인증</button> `
				
			  }//if
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}//f()