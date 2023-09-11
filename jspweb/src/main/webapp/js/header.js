console.log('js실행')

let loginState=false; /*로그인 상태 true:로그인 중 상태를 유지할 수 있는 방법 중 하나. 헤더에 스위치 넣어둚*/

let loginMid=''; /* 아이디 기준으로 갈 변수.  loginState(상태)랑 같은건데 추가로 배운 내용을 적용하기 위해서새로만들어준거임. 팀플때는 하나로 사용하면됨 */

//1. 현재 로그인된 회원정보 요청
getMemberInfo();

function getMemberInfo(){
	//1.ajax 이용한 서블릿 세션 정보 가져오기
	 $.ajax({
      	url : "/jspweb/MemberinfoController",     
     	method : "get",   
     	async:false, /*비동기화(기본값=true),동기화(false) 설정하는 속성  <--채팅 기능 하면서 배움*/
     	data : {type:"info"},      
      	success : r=>{console.log(r);
      	/* 응답 받은 r 상태는 키:값 키:값 타입으로 들어와있을거임 (console 확인)*/
      		let submenu = document.querySelector('.submenu');
      		let html=``;
      		if(r==null){//비로그인
      			loginState=false; //전역변수에 선언해둔거 확인!!
      			loginMid =''
				  html+=`
				 	<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
					<li><a href="/jspweb/member/login.jsp">로그인</a></li>
				  `
				  
			  }else{//로그인
			  	loginState=true;
			  	loginMid = r.mid
			  	html+=`
				  	<li>${r.mid}님</li>
					<li><a href="/jspweb/member/info.jsp">마이페이지</a></li>
				  	<li><a onclick="logout()" href="#" >로그아웃</a></li>
					<li><img class="hmimg" src="/jspweb/member/img/${r.mimg}"></li>
				  	`
				  if(r.mid=="admin"){}//로그인 했는데 관리자 메뉴
				  
			  }
      		submenu.innerHTML=html;
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()

//2.로그아웃-------------------------------------------------------
function logout(){//서블릿에 세션을 삭ㅈ. 로그아웃 성공시 메인페이지 이동
	
	$.ajax({
      	url : "/jspweb/MemberinfoController",     
     	method : "get",   
     	data : {type:"logout"},      
      	success : r=>{
			  alert('로그아웃됨');
			  location.href="/jspweb/index.jsp"
			  
		  } ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()