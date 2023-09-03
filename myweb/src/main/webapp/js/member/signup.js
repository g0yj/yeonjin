console.log('회원가입페이지js실행')
//myweb

//회원가입 가능 조건
let checkList=[false,false,false]

//==가입 가능 아이디 조건 유효성[1.정규표현식 2.db중복아이디]=================
function idcheck(){
	//1.값 호출
	let mid=document.querySelector(".mid").value;
	let idcheck=document.querySelector(".idcheck")//글자 적을때마다 결과를 보여줄 예정. 반복되는 과정으로 전역변수선언
	console.log(mid);
	//2.유효성검사(정규식사용)-영어+숫자 5~15
		//2-1 정규표현식작성
		
	let midc=/^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		//2-2 정규표현식 검사
		console.log(midc.test(mid))
		if(midc.test(mid)){//입력한 아이디와 패턴 일치하면
	//2. 유효성검사(ajax -유효성검사를 위한 ajax : 동일한 아이디 있는지 없는지.)
			 $.ajax({
		      	url : "/myweb/Memberfind",     
		     	method : "get",   
		     	data : {type:"mid", data:mid}, //속성명:값      
		      	success : r=>{console.log('통신성공');
		      		if(r){idcheck.innerHTML=`사용 중 아이디입니다`;checkList[0]=false}
		      		else{idcheck.innerHTML='사용 가능한 아이디입니다';checkList[0]=true;}
		      		
		      	} ,       
		      	error : e=>{console.log('통신실패');console.log(e)} ,         
		   });
	
			
		}
		else{
			idcheck.innerHTML=`영문+숫자 조합으로 입력해주세요`;checkList[0]=false;
		}
}//f()아이디유효성검사

//== 가입 가능한 비밀번호 유효성 검사[1.정규표현식 2. 비밀번호와 비밀번호확인이 일치]=======================
function pwcheck(){
	let recheck=document.querySelector('.recheck')
		//1.값 호출
	let mpw=document.querySelector('.mpw').value;
	let repw=document.querySelector('.repw').value;
	//let pwcheck=document.querySelector('.pwcheck')//글자 적을때마다 결과를 보여줄 예정. 반복되는 과정으로 전역변수선언

	console.log(mpw);
	//2.유효성검사(정규식사용)-영어+숫자 10~15
		//2-1 정규표현식작성
		let mpwc= /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		//2-2 정규표현식 검사
		console.log(mpwc.test(mpw))
		if(mpwc.test(mpw)){//1. 비밀번호 정규표현식 검사
				//2. 비밀번호 확인 정규표현식 검사
				if(mpwc.test(mpw)){
					//3.비밀번호와 비밀번호 확인 일치 여부
					if(mpw==repw){
						recheck.innerHTML =`사용가능한 비밀번호`;checkList[1]=true;
					}else{
						recheck.innerHTML=`비밀번호가 일치하지 않음`;checkList[1]=false;
					}
				}else{
					recheck.innerHTML=`영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력`;checkList[1]=false;
				}
			}else {
				recheck.innerHTML=`영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력`;checkList[1]=false;
			}
}//f() 비밀번호 유효성검사

//==이메일 보내기[유효성:중복검사]========================================
function mailcheck(){
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
					mailcheck.innerHTML=`다른 이메일을 사용해주세요`;
					document.querySelector('.mbutton').disabled=true}
				else{mailcheck.innerHTML=`사용 가능한 이메일입니다`;
					document.querySelector('.mbutton').disabled=false;
				}
				
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}//f()

let authcode=``;
let timer=0;
let timerInter;//setInterval을 종료시키기 위해 필요한 변수

//==이메일보내기[버튼 누를 시: 이메일 전송, 입력창 출력, 타이머 출력]===================
function mSend(){
	  $.ajax({
         url : "/myweb/Memberemail",     
        method : "get",   
        data : {mmail:document.querySelector('.mmail').value},      
         success : r=>{console.log('통신성공'); console.log(r)
         	let mailbox=document.querySelector('.mailbox');
         	let html=`
				<div class="timer">타이머</div>
				인증번호<input class="checkno" type="text">
				<button onclick="mcheck()"type="button">인증</button>
				<div class="authbox"></div>
				`
        	 mailbox.innerHTML=html;
        	 authcode='1234';
        	 timer=120;
        	 settimer();
        	 
         } ,       
         error : e=>{console.log(e)} ,         
   });
	
}//f()

//==인증성공[버튼 누를시: 인증번호와 입력 번호 일치 여부 확인]=======================
function mcheck(){console.log('인증성공여부확인js실행')
		// 요청
		let checkno=document.querySelector('.checkno').value;
		if(checkno==authcode){
			alert('인증성공');clearInterval(timerInter); checkList[2]=true;
			document.querySelector('.mailbox').innerHTML=``;
		}else{
			document.querySelector('.authbox').innerHTML=`인증번호를 다시 입력해주세요`
			checkList[2]=false;
			}
	
	
}//f()

//==타이머함수===========================================================
function settimer(){
		//setInterval(함수명,실행간격[밀리초] : 특정 시간마다 함수를 실행하는 함수
		
		timerInter=setInterval(()=>{
				// 시간 숫자로 전환
			let m=parseInt(timer/60); //분
			let s=parseInt(timer%60);//초 
				// 두자리수 맞춤
			m=m=m<10?"0"+m:m;
			s=s<10?"0"+s:s;
			
			document.querySelector('.timer').innerHTML=`${m}:${s}`;
			timer--;
			
			if(timer<0){
				//timerInter: setInterval을 종료할 식별자
				clearInterval(timerInter);
				alert('인증 실패했습니다. 메일을 재전송해주세요')
				document.querySelector('.mailbox').innerHTML=``
			}
			
			
			
		},1000);
}//f()

//회원가입 [1.아이디통과 2. 비밀번호 통과 3. 이메일통과]====================================
function signup(){console.log(checkList);
	if(checkList[0]&&checkList[1]&&checkList[2]){console.log('회원가입진행가능');
		let signupform=document.querySelectorAll('.signupform')[0];
		console.log('signupform 제대로 들어감? '+signupform);
		let signupData=new FormData(signupform);
		$.ajax({
		  	url : "/myweb/MemberInfo",     
		   	method : "post",   
	     	data : signupData,
	     	contentType:false,	//form객체 전송 타입
		    processData:false,        
	      	success : r=>{console.log('통신성공'+signupData)
	      		if(r){console.log('회원가입성공');alert('회원가입성공'); location.href='/myweb/member/login.jsp'}
	      		else{alert('회원가입실패')}
	      	} ,       
	      	error : e=>{console.log(e)} ,         
		   });
	}//i
	
}//f()