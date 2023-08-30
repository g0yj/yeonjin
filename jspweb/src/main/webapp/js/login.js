console.log('js실행')
//1. 로그인 함수
function login(){
	console.log('login() open')
	//1. 입력 받은 아이디, 비밀번호 가져옴
	let mid=document.querySelector('.mid').value;
	let mpwd=document.querySelector('.mpwd').value;
	
	//2. ajax에게 전달해서 회원이 존재하는지 반환 받음
		//2-1 :로그인 성공 시 index.jsp 이동
			//실패 시 'logincheckbox' 실패 알림
	$.ajax({
      	url : "/jspweb/MemberFindController",     
     	method : "post", //get메소드는 전송하는 데이터가 노출됨(보안취약) post메소드는 전송하는 데이터 노출을 감춤  
     	data : {mid:mid , mpwd:mpwd},      
      	success : r=>{console.log('통신성공')
      		if(r){
				  location.href="/jspweb/index.jsp";}
			else {
				document.querySelector('.logincheckbox').innerHTML='동일한 회원정보 없음';}
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()

//mid:mid , mpwd:mpwd

/* 
	get vs post
	
	get: 
	- 캐시에 기록을 남김. 
	- 추후에 다시 전송 시 속도가 빠름. 
	- 보안x .
	- 매개변수 노출
	- 개인정보 없는 데이터 정보 (권장) : 사이트 속도 향상 가능
	
	post: 
	- 캐시에 기록을 남기지 않음. 
	- 추후에 다시 전송 시 속도 동일. 
	- 보안 가능. 
	- 매개변수노출x
	- 로그인, 회원가입(권장)


*/