/* ajax가 응답의 결과를 가지고 오기 전에 아래코드가 실행되는 문제 발생이 있을 수 있음. [loginState 변경되기 전 js가 열리는 경우]
	- 해결방안 : ajax를 동기화 통신!! loginState가 포함된 header의 ajax 바꿔줌 (async)

*/
//1. 비로그인시 입장 불가능
if(loginMid==false){
	alert('로그인 후 입장');location.href='/jspweb/member/login.jsp'}

//2. js 클라이언트[유저] 소켓 만들기=====================================================================
console.log('채팅창에 들어간 입장 아이디: '+loginMid)
let clientSocket = new WebSocket(`ws://192.168.17.131/jspweb/serversocket/${loginMid}`)// ServerSocket.java 의 주소 확인!
	//- 클라이언트소켓이 생성되었을 때 자동으로 서버소켓에 접속 ->seversocket의 @Onopen 이 켜짐.
	//- 서버소켓url에 매개변수 전달하기[-주로 식별자 전달] 서버소켓url/데이터1/데이터2/데이터3 
	//---- 메소드4가지 메소드 자동으로 실행
		
		// 1.(자동실행) 클라이언트소켓이 정상적으로 서버소켓에 접속했을 때
	clientSocket.onopen=e=>{console.log('서버접속성공');
		//1-2: 만약에 접속을 성공하면 알림메시지 전송
		let msg={type: "alarm", content: `${loginMid}님이 입장했습니다.`};
		//clientSocket.send(msg) <- 오류. 해당 메시지를 받는 JAVA는 JSON 타입을 모름. 문자열 타입으로 전송이 필요.
		clientSocket.send(JSON.stringify(msg));
		
		
		};  //기본값은 null임. 안에 커스텀해서 사용하면됨! 열리고 나서 다음 코드(console.log~)~
		
		
		//2. 클라이언트소켓과 연결에서 오류가 발생했을 때
	clientSocket.onerror=e=>{};
		
		//3. 클라이언트소켓이 서버소켓과 연결이 끊겼을때
	clientSocket.onclose=e=>{};
		
		//4. 클라이언트소켓이 메시지를 받았을 때
	clientSocket.onmessage=e=>onMsg(e);
	
//3. 서버에게 메시지 전송==========================================================================
function onSend(){
	//3-1 textarea 입력값 호출
	let msgValue=document.querySelector('.msg').value;
	if(msgValue==''||msgValue=='\n'){//공백이거나 엔터만쳤을때 
		document.querySelector('.msg').value=``; 
		alert('내용을입력해주세요');return;}
	
	let msg={type:'message',content:msgValue}
	
	
	//3-2 메시지 전송 -> 서버 OnMessage
	clientSocket.send(JSON.stringify(msg)) // 클라이언트소켓과 연결된 서버소켓에게 메시지 전송
	//3-3메시지 전송 시 
	document.querySelector('.msg').value=``;
}//f()

//4. 메시지를 받았을 때 추후 행동(메소드)선언==========================================================
function onMsg(e){
	console.log(e);//문자, e: 메세지 받을 때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data); //문자, .data 속성에 전달 받은 메시지 내용 (위에 console찍은걸로 객체 내용 확인할 수 있음. 거기서 속성명 확인)
//4-1 전달받은 내용물을 JSON타입으로 형변환	
	let msgBox=JSON.parse(e.data); //e.data: 서버로부터 전달받은 내용물 e.data 속성에 있는 상태
		//JSON.parse(): 문자열타입의 JSON 형식을 JSON 타입으로 반환
		//JSON.stringify(): JSON타입을 문자열 타입(JSON형식 유지)으로 반환
	console.log(msgBox.msg); //java,js console내 출력시 줄바꿈은 \n ! but html은 <br>임
	
	msgBox.msg=JSON.parse(msgBox.msg);

//4-2
//java, js에서 모두 가능함. js는 두번 과정 거쳐야되는데 자바는 한번에 할 수 있으니 자바단에서 하는 걸 추천
	// 특정 문자열 찾아서 1개 치환/바꾸기/교체
		//let content=msgBox.msg.content.replace('\n','<br>')
		//console.log('1번'+ content);
	// 입력시 줄바꿈했지만 출력할때는 줄바꿈 처리 안된 상태로 출력됨. 치환해줘야됨!!
	//치환 [replace('변경할문자열|정규표현식','새로운문자')]
	// 특정 문자열 찾아서 찾은 문자열 모두 치환/바꾸기/교체=> java: .replaceAll(); js:정규표현식
	msgBox.msg.content =msgBox.msg.content.replace(/\n/g,'<br>'); // /g: 동일한 패턴의 모든 문자찾기[전체]

	
	//1. 어디에
	let chatcont= document.querySelector('.chatcont')
	//2. 무엇을
	let html=``;
		//만약에 알림 메시지이면
		if(msgBox.msg.type=='alarm'){
			html=`${typeHTML(msgBox.msg)}`
		}
		//만약에 일반메시지이면 [메시지, 이모티콘]]
		//2-2 만약에 내가 보냈으면,[보낸사람아이디와 로그인된사람의 아이디가 같으면]
		else if(msgBox.frommid==loginMid){
		 html=`
				<div class="rcont">
					<div class="subcont">
						<div class="date">${msgBox.date}</div>
						${typeHTML(msgBox.msg)}
					</div>
				</div>`;
			
		}else{//2-2 내가 안 보냇으면
			html = `
					<div class="lcont"> 
						<img class="pimg" src="/jspweb/member/img/${msgBox.frommimg}" />
						<div class="tocont">
							<div class="name">${ msgBox.frommid }</div>
							<div class="subcont">
								${typeHTML(msgBox.msg)}
								<div class="date"> ${msgBox.date} </div>
							</div>
						</div>
					</div>`
		}
	
	
	//3. 누적대입[기존채팅에 이어추가]
	chatcont.innerHTML+=html;
	
	//---------스크롤 최하단으로 내리기(스크롤이벤트)-----------------------//
	//1. 현재 스크롤의 상단 위치 좌표.
	let topHeight=chatcont.scrollTop; //dom객체.scrollTop: 해당 div의 스크롤 상단위치
	console.log(topHeight);
	//2. 현재 dom객체의 전체 높이
	let scrollHeight=chatcont.scrollHeight; //dom객체.scrollHeight : 해당 div의 스크롤 전체 높이
	console.log(scrollHeight);
	//3. 전체 높이 값을 현재 스크롤 상단 위치에 대입(=자동으로 스크롤 내리기)
	chatcont.scrollTop=chatcont.scrollHeight;

	
}	//f()

//5.textarea 입력창에서 입력할 때마다 이벤트 발생 함수=======================================================
function onEnterKey(){
	
	//2. 만약에 ctrl+enter이면 줄바꿈 처리 (위로 올린 이유: 1번이 위에 있으면 enter키가 먼저 시행되니까 제대로된 작동x)
	if(window.event.keyCode==13&&window.event.ctrlKey){//조합키 : 한번에 두개 이상 입력 가능한 키
		document.querySelector('.msg').value+=`\n`; return;}//리턴해줘야 아래 코드 실해 안됨!
	
	//1. 만약에 입력한 키가 [엔터]이면 메시지 전송
	if(window.event.keyCode==13){//내장된거라 문법 지켜줘야. 13은 enter의 키번호
		onSend();
	}
}//f()


//6.이모티콘출력하기=============================================================================
getEmo()
function getEmo(){
	
	//-
	for(let i=1;i<43;i++){
		document.querySelector('.emolistbox').innerHTML
			+=`<img onclick="onEmoSend(${i})" src="/jspweb/img/imoji/emo${i}.gif">`
	}
	
}//f()

//7.클릭한 이모티콘 서버로 전송하기===============================================================
function onEmoSend(i){
	
	//1.msg구성
	let msg={type:'emo',content:i+"" } // ""을 하는 이유? replace는 문자열만 취급함. i는 숫자니까 문자로 바꿔줌(replace를 통합하여 쓰기 위해)
		//type: msg[메시지] , emo[이모티콘] , img[사진]
		//content:내용물
		
	//2.보내기 (여기까지하면 이미지도 문자로 출력됨. type을 사용하여 제어 필요.)
	clientSocket.send(JSON.stringify(msg)); //형변환: JSON타입을 문자열 타입(JSON형식 유지)으로 변환	 [모양/형식/포맷은 JSON]
		
		
}//f()


//8.msg 타입에 따른 html 반환 함수============================================================================
function typeHTML(msg){
	let html=``;
	//1. 메시지 타입 : <div>반환
	if(msg.type=='message'){
		html+=`	<div class="content"> ${msg.content } </div>`;
		
	}
	//2. 이모티콘타입 : <img>반환
	else if(msg.type=='emo'){
		html+=`<img src="/jspweb/img/imoji/emo${msg.content}.gif"`;
	}
	//3. 알림 타입일 때 div반환
	else if(msg.type=='alarm'){
		html+=`<div class="alarm">${msg.content} </div>`
	}
	return html;
}//f()




//----------------------------------------------------------//
/* 
	JS[HTML파일 종속된 파일 - HTML 안에서 실행되는 구조] - HTML 두번 켜면 JS 두개 켜지는 거임
								-> 추후 node.js라는 프레임워크로 html로 벗어날 수 있어짐... 우린 안 배울 예정
								
	*url[주소]상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수1=데이터1&매개변수2=데이터2
		2. 경로매개변수: URL/데이터1/데이터2/데이터3
	
	* 소켓
		- 통신의 종착점[데이터가 전달되는 위치(받는사람, 보내는사람)]
		
			 
	* WebSocket 웹소켓 라이브러리 -소켓 관련된 함수들을 제공하는 클래스
	 1. 웹 소켓 객체 생성
	 	new new WebSocket('ws://ip주소:포틉번호/프로젝트명/서버소켓경로') 
	 	
	 2. 메소드 제공
	 	.send() : 클라이언트소켓이 연결된 서버소켓에게 메시지를 전송 메소	
	 	
	* 동기화 vs 비동기화 	
		-동기화								-비동기화
		Client			Server			Client			Server	
 		  ------요청------->				 		  ------요청------->
		<------응답------- 
		<------응답------- 							<------응답------- 
 */





/* 비회원제 채팅---------------------------------------------------------------------

// 1. 클라이언트 소켓 만들기 
	// 1. JS웹소켓 객체 [ WebSocket클래스 ] / 객체가 생성되면 서버소켓에 자동으로 접속됨.
		// new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓URL');  [ 객체생성 =====> 서버소켓 @OnOpen ]
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log( 클라이언트소켓 );
		// 2. opopen , onclose , send , onmessage 등등 메소드 제공 
	
		// 내가 만든 함수를 클라이언소켓 속성에 대입
	클라이언트소켓.onmessage = ( event ) => onmsg(event);
	
// 2. 연결된 서버소켓에게 메시지 보내기 
function msgsend(){
	// 1. input 입력된 값 가져오기 
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send( msg ); // input에서 입력받은 데이터를 보내기  [ 클라이언트소켓.send() =====> 서버소켓 @OnMessage ]
	
	// 3. 
	document.querySelector('.inputcontent').value = '';
}// f end 

// 3. 연결된 서버소켓으로 부터 메시지를 받았을떄.
function onmsg(event){ 
	console.log(event) ;
	console.log(event.data);
	
	document.querySelector('.contentbox')
				.innerHTML += `<div> ${event.data}</div>`
	
}


/*개념--------------------------------------------------------
	1. AJAX [ 단방향 ]
		발신자(보내는사람) 	: AJAX		
		수신자(받는사람) 	: 서블릿		
	
		JS					JAVA[서블릿]
							
		AJAX	
				rest		get
							post	
							put
							delete
	2. (웹)소켓 [ 양방향 ]
		소켓 : 통신의 종착점[도착위치]
		- 전체조건 : 서버가 클라이언트소켓의 정보를 가지고 있어야한다.
		
		JS					JAVA
		[클라이언트소켓]		[서버소켓]
		websocket
		1. 서버소켓 접속		2. 서버소켓 24시간 상시 클라이언트 소켓 명단 저장
		3. 데이터 전송			4. 데이터 받는다.
*/
/*

				클라언트[사용자]						서버[서비스회사]
			
		강호동카카오톡		
						'안녕'
				-------------------------------->
				1. 강호동 메시지(안녕) 보낸다.
				
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
				
		유재석카카오톡 
													카카오서버[제주도]
													- 전제조건 : 클라이언트의 정보들 보관
													접속된명단 : [ 강호동,유재석,신동엽,하하 ]
													2. '안녕' 메시지 받는다.
				<--------------------------------		
				3. 서버가 '안녕' 메시지 보낸다.			
		신동엽카카오톡 
		
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		하하카카오톡 
				<--------------------------------
				3. 서버가 '안녕' 메시지 보낸다.
		
*/
