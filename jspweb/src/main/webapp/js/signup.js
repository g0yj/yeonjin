//2시30분
console.log('js연결');

/*
	onchange: 포커스(커서)가 변경될때 값이 다르면(변화감지)
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
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴 0개 반복
		
		<예시>
			1.[a-z] : 소문자 패턴
			2.[a-zA-Z] : 영문(대,소)패턴
			3.[a-zA-Z0-9] : 영문+숫자 조합 패턴
			4.[a-zA-Z0-9가-힣] : 영문+숫자+한글 조합 패턴 
			5.[abcde] : abcde 중 하나를 가지는
			6.(?=.*[패턴문자]) : 해당 패턴문자가 한개 이상 포함 패턴
				(?=.*[a-z]): 소문자 한개 이상 필수
				(?=.*[A-Z]): 대문자 한개 이상 필수
				(?=.*[0-9]): 숫자 한개 이상 필수
				(?=.*[\d]): 숫자 한개 이상 필수
				(?=.*[!@#$%^&]): 패턴문자 내 특수문자 한개 이상 필수
				
			-> /^[a-z0-9]{5,30}$/ : 영문(소)+숫자 조합 5~30글자 패턴
			-> /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-z0-9]{5,30}$/ : 영대문자1개+영소문자1개+숫자 1개 이상 필수로 갖는
			->/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/ : 패턴@패
		
		<패턴검사>
			"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
 */

//1. 아이디 유효성검사

function idcheck(){/*실행조건: 아이디 입력창에 입력할때마다*/
	
	//1.값 호출
	let mid =document.querySelector('.mid').value;
	let idcheck=document.querySelector('.idcheckbox') //반복되니까 지역변수로 선언해서 쓰기!
	
	//2. 유효성검사(아이디)
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
			     data : {type: "mid", data:mid},      
			      success : r=>{console.log('통신성공')
			      	if(r){idcheck.innerHTML='사용중인 아이디';checkList[0]=false}
			      	else{idcheck.innerHTML='사용가능';checkList[0]=true}
			      } ,       
			      error : e=>{console.log('통신실패')} ,         
			   });

		}else{
			idcheck.innerHTML='영문(소문자)+숫자 조합의 5~30글자 가능함'
		}
	//3. 결과 출력
}//f()


//1.유효성검사(비밀번호) [1.정규표현식 검사 2.비밀번호와 비밀번호 확인 일치여부]
function pwcheck(){console.log('패스워드 입력중')
	
	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	//1.입력값 호출
	let mpwd= document.querySelector('.mpwd').value; console.log('mpwd' +mpwd);
	let mpwdconfirm=document.querySelector('.mpwdconfirm').value; 
	
	//2. 유효성검사
		//1. 정규표현식[영대소문자+숫자조합 5~20글자 사이]
		let mpwdj=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{5,30}$/
			
			if(mpwdj.test(mpwd)){//1. 비밀번호 정규표현식 검사
				//2. 비밀번호 확인 정규표현식 검사
				if(mpwdj.test(mpwdconfirm)){
					//3.비밀번호와 비밀번호 확인 일치 여부
					if(mpwd==mpwdconfirm){
						pwcheckbox.innerHTML =`사용가능한 비밀번호`;checkList[1]=true;
					}else{
						pwcheckbox.innerHTML=`비밀번호가 일치하지 않음`;checkList[1]=false;
					}
				}else{
					pwcheckbox.innerHTML=`영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력`;checkList[1]=false;
				}
			}else {
				pwcheckbox.innerHTML=`영대소문자1개이상 숫자1개이상 조합 5~20글자 사이로 입력`;checkList[1]=false;
			}
				
		
		
}//f()






//2. 회원가입 메소드(유효성검사하지 않은 회원가입)-----------------------------------------------------------------------------
function signup2(){
	
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

//3. 이메일 유효성검사[1.정규표현식 2.중복검사]-------------------
function mailcheck(){
		let emailcheckbox=document.querySelector('.emailcheckbox');
		
		//1. 입력된 값 호출
		let memail=document.querySelector('.memail').value 
		//2. 이메일 정규표현식[  영대소문자,숫자,_,- @]
			//itdanja@kakao.com
			//1.ktdanja: 이메일 아이디부분은 영대소문자, 숫자, _- 패턴
			//2.@ :+@  @앞에 패턴 1개이상 필수
			//3. 도메인
				//회사명 :@ 뒤에 그리고. 앞에 패턴은 a-zA-Z0-9_-
				//. :+\.  :. 앞에 패턴이 1개이상 필수
				//도메인 : .뒤에 패턴은 a-zA-Z 
		let memailj=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
		if(memailj.test(memail)){console.log('이메일 통과')
			   $.ajax({
    			  url : "/jspweb/MemberFindController",     
     			  method : "get",   
     			  //type 사용하는 이유: 서로 다른 ajax가 동일한 서블릿과 동일한 get메소드를 제공할때
     			  data : {type: "memail", data:memail },      
    			  success : function f(r){console.log('통신성공');
    			  	if(r){
						emailcheckbox.innerHTML=`사용중인 이메일`;
    			  		document.querySelector('.authReqBtn').disabled=false;
    			  		checkList[2]=false
    			  	}
    			  	else { 
						emailcheckbox.innerHTML=`사용가능한 이메일`;
    			  		document.querySelector('.authReqBtn').disabled=false;
    			  		checkList[2]=false
					  }
    			  } ,       
    			  error : function f(r){console.log(r);} ,         
   });

		
		
		}else{
			console.log('이메일실패')
		}
}//f()

//4. 인증요청 버튼을 눌렀을때----------------------------------------------------
function authReq(){console.log('인증요청') 

	//---- 인증 요청 시 서블릿통신[인증코드 생성, 이메일 전송]
	  $.ajax({
      	url : "/jspweb/AuthSendEmailController",     
     	method : "get",   
     	data : {memail:document.querySelector('.memail').value},      
      	success : r=>{console.log(r)
 	//1. 'aythbvox' div 호출
	let authbox = document.querySelector('.authbox')
	//2. auth html 구성
	let html=`<span class="timebox">02:00</span>
		<input class="ecode" type="text">
		<button onclick="auth()" type="button">인증</button><br>`
	//3. auth html 대입
	authbox.innerHTML=html;
	//4. 타이머 실행
	authcode='1234'; // [controller 전달 받음]
	timer=120; //
	settimer();//타이머 실행
      	
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

/*
이메일 인증할때 
			//1. 'aythbvox' div 호출
			let authbox = document.querySelector('.authbox')
			//2. auth html 구성
			let html=`<span class="timebox">02:00</span>
				<input class="ecode" type="text">
				<button onclick="auth()" type="button">인증</button><br>`
			//3. auth html 대입
			authbox.innerHTML=html;
			//4. 타이머 실행
			authcode=r; // [controller 전달 받은 값이 인증코드]
			timer=120; 
			settimer();//타이머 실행
      	
 */


/*
	테스트용
	//1. 'aythbvox' div 호출
	let authbox = document.querySelector('.authbox')
	//2. auth html 구성
	let html=`<span class="timebox">02:00</span>
		<input class="ecode" type="text">
		<button onclick="auth()" type="button">인증</button><br>`
	//3. auth html 대입
	authbox.innerHTML=html;
	//4. 타이머 실행
	authcode='1234'; // [controller 전달 받음]
	timer=120; //
	settimer();//타이머 실행
*/	
}//f()


	/*
		setInterval(): 특정 시간마다 함수를 실행하는 함수
			1. 정의
				let 변수명= setInterval(fuction 함수명(){} ,밀리초)
				let 변수명= setInterval(fuction (){} ,밀리초)
				let 변수명= setInterval(함수명(),밀리초)
				let 변수명= setInterval(()=>{} ,밀리초)
	
			2. 종료
			clearInterval(setInterval변수명)
	
	 */
// 4번,5번,6번 함수에서 공통적으로 사용할 변수[전역변수]
let authcode='';
let timer=0; //인증시간변수
let timerInter; //setInterval()함수를 가지고 있는 변후[setInterval 종료 시 필요]
//5. 타이머함수만들기---------------------------------------
function settimer(){
	// setInterval(함수명,실행간격[밀리초단위]) : 특정시간마다 함수를 실행하는 함수
	
	timerInter= setInterval(()=>{
		
		//시간 형식 만들기
			//1.분 만들기
			let m=parseInt(timer/60); //분 계산
			let s=parseInt(timer%60); // 초 계산
			//2. 두자리수 맞춤  3이면 03으로 보이게 하기 위해
			m=m<10?"0"+m:m; //만약에 분이 10보다 작으면 한 자리수이면 0을 붙이고 아니면 그냥
			s=s<10?"0"+s:s;
		document.querySelector('.timebox').innerHTML=`${m}:${s}`;
		timer--; //1씩차감
		
		//만약에 타이머가 0이면[시간끝]
		if(timer<0){
			//1. setInterval을 종료[누구를 종료할지 식별자 필요. 변수 선언= timerInter]
			clearInterval(timerInter);
			//2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML=`인증실패`;
			checkList[2]=false
			//3. authbox 숨김 (authbox구역 html 초기화)
			document.querySelector('.authbox').innerHTML=``
		}
		},1000)
}//f()

//6. 인증요청 후 인증코드를 입력하고 인증하는 함수-----------------------------------
function auth(){console.log('auth()실행')
	//1. 입력받은 인증코드
	let ecode=document.querySelector('.ecode').value;
	
	//2. 비교[인증코드와 입력받은 인증코드]
	if(authcode==ecode){
		console.log('인증코드일치');
		//1. setInterval 종료
		clearInterval(timerInter); 
		//2.인증 성공을 알림
			document.querySelector('.emailcheckbox').innerHTML=`인증성공`;
		//3. authbox 구역 html 초기화
			document.querySelector('.authbox').innerHTML=``
			; checkList[2]=true;
	}else{
		console.log('인증코드 불일치')
		//1. 인증코드 불일치 알림
			document.querySelector('.emailcheckbox').innerHTML=`인증코드 불일치`;checkList[2]=false;
	}
}//f()

//7. 첨부파일에 사진 등록시 등록 사진을 html 표시하기(등록 사진 미리보기 기능) --------------------------------
function preimg(object){console.log('onchange() 실행: 사진 선택 변경')
	console.log(object); // 이벤트 발생시킨 태그의 dom객체를 인수로 받음(this)
	console.log(document.querySelector('.mimg'));
	//1. input태그의 속성[type, class,onchage,name 등등]
	//1. input태그이면서 type="file"이면 추가적인 속성=> files
		//.files: input type="file"에 선택한 파일 정보를 리스트로 받음
	console.log(object.files);
	console.log(object.files[0]); //리스트 중에서 하나의 파일만 가져오기
	
	//----해당 파일을 바이트코드로 변환
	//2.js 파일클래스 선언
	let file = new FileReader(); //파일 읽기 클래스 이용한 파일 읽기 객체 선언
	//3. 파일 읽어오기 함수 제공
	file.readAsDataURL(object.files[0]); //input에 등록된 파일 리스트 중 1개를 파일 개체로 읽어오기
	console.log(file)
	//4. 읽어온 파일을 해당 html img태그에 load
	file.onload= e=>{//onload():읽어온 파일의 바이트코드를 불러오기
		console.log(e);//e:이벤트 정보
		console.log(e.target);//onload()실행한 FileReader객체
		console.log(e.target.result)//읽어온 파일의 바이트코드
		document.querySelector('.preimg').src=e.target.result;}//img src속성에 대입
}//f()

let checkList=[false,false,false] //0번째 인덱스: 아이디 통과(아이디유효성검사함수) / 1번: 비밀번호 통과(비밀번호유효성검사) / 2번: 이메일인증성공
				//true=통과 
//8. 회원가입 메소드------------------------------------------------------------------
function signup(){
	//1. 아이디,비번,이메일 유효성검사 통과 여부 체크
	console.log(checkList)
	if(checkList[0]&&checkList[1]&&checkList[2]){//모두 true이면 회원가입 성공
	console.log('회원가입진행가능')
	//2. d입력받은 데이터를 한번에 가져오기 form태그 이용
		//<form> 각종 input/button</form>
		//1. form 객체 호출 document.querySelectorAll(폼태그식별자명);
		let signupForm =document.querySelectorAll('.signupForm')[0];
		console.log(signupForm);
		//2. form 데이터 객체화 =>ajax는 json형식으로 전송해야되니까
				//일반객체로 첨부파일 전송 불가 -> FormData객체 이용시 첨부파일 전송 가능
		let signupData=new FormData(signupForm);// 대용량데이터[첨부파일] 시 필수...!! 
		console.log(signupData);
		//3. ajax에게 대용량 전송
	/*		
			//1.첨부파일이 없을때 
			  $.ajax({
		      	url : "",     
		     	method : "",   
		     	data : {},      
		      	success : r=>{console.log('통신성공')} ,       
		      	error : e=>{console.log(e)} ,         
		   });
	*/	   
			//2.첨부파일이 있을때 [기존 json형식의 전송이 아님. form객체 전송 타입으로 변환]
			$.ajax({
		      	url : "/jspweb/MemberinfoController",     
		     	method : "post",   //첨부파일 form전송은 무조건 post
		     	data : signupData,   
		     	contentType:false,	//form객체 전송 타입
		     	processData:false,    
		      	success : r=>{console.log('통신성공')
		     
		      		if(r){ //회원가입성공[1.알린다 2. 페이지전환]
						  alert('회원가입성공')
						  location.href='/jspweb/member/login.jsp';
					  }
		      		else{//회원가입실패
		      			alert('회원가입실패[관리자문의]')
		      		}
		      	
		      	} ,       
		      	error : e=>{console.log(e)} ,         
		   });

	}//if
	else{console.log('회원가입진행불가능')}
	
}				
				