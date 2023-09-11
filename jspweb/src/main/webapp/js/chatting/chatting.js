/* ajax가 응답의 결과를 가지고 오기 전에 아래코드가 실행되는 문제 발생이 있을 수 있음. [loginState 변경되기 전 js가 열리는 경우]
	- 해결방안 : ajax를 동기화 통신!! loginState가 포함된 header의 ajax 바꿔줌 (async)

*/
//1. 비로그인시 입장 불가능
if(loginMid==false){
	alert('로그인 후 입장');location.href='/jspweb/member/login.jsp'}

//2. js 클라이언트[유저] 소켓 만들기
console.log('채팅창에 들어간 입장 아이디: '+loginMid)
let clientSocket = new WebSocket(`ws://192.168.17.131/jspweb/serversocket/${loginMid}`)// ServerSocket.java 의 주소 확인!
	//- 클라이언트소켓이 생성되었을 때 자동으로 서버소켓에 접속 ->seversocket의 @Onopen 이 켜짐.
	//- 서버소켓url에 매개변수 전달하기[-주로 식별자 전달] 서버소켓url/데이터1/데이터2/데이터3 
	//---- 메소드4가지 메소드 자동으로 실행
		// 1.(자동실행) 클라이언트소켓이 정상적으로 서버소켓에 접속했을 때
	clientSocket.onopen=e=>{console.log('서버접속성공');}  //기본값은 null임. 안에 커스텀해서 사용하면됨! 열리고 나서 다음 코드(console.log~)~
		//2. 클라이언트소켓과 연결에서 오류가 발생했을 때
	clientSocket.onerror;
		//3. 클라이언트소켓이 서버소켓과 연결이 끊겼을때
	clientSocket.onclose;
		//4. 클라이언트소켓이 메시지를 받았을 때
	clientSocket.onmessage=e=>onMsg(e);
	
//3. 서버에게 메시지 전송
function onSend(){
	//3-1 textarea 입력값 호출
	let msg=document.querySelector('.msg').value;
	if(msg==''){alert('내용을입력해주세요');return;}
	//3-2 메시지 전송 -> 서버 OnMessage
	clientSocket.send(msg) // 클라이언트소켓과 연결된 서버소켓에게 메시지 전송
}//f()

//4. 메시지를 받았을 때 추후 행동(메소드)선언
function onMsg(e){
	console.log(e);//e: 메세지 받을 때 발생한 이벤트 정보가 들어있는 객체
	console.log(e.data); //.data 속성에 전달 받은 메시지 내용 (위에 console찍은걸로 객체 내용 확인할 수 있음. 거기서 속성명 확인)
	
	let msg=JSON.parse(e.data);
		//JSON.parse(): 문자열타입의 JSON 형식을 JSON 타입으로 반환
		//JSON.stringify(): JSON타입을 문자열 타입(JSON형식 유지)으로 반환
	
	//1. 어디에
	let chatcont= document.querySelector('.chatcont')
	//2. 무엇을
	let html=``;
		//2-2 만약에 내가 보냈으면,[보낸사람아이디와 로그인된사람의 아이디가 같으면]
		if(msg.frommid==loginMid){
		 html=`
				<div class="rcont">
					<div class="subcont">
						<div class="date">오전 10:20</div>
						<div class="content">${msg.msg}</div>
					</div>
				</div>`;
			
		}else{//2-2 내가 안 보냇으면
			html = `
					<div class="lcont"> 
						<img class="pimg" src="/jspweb/member/img/default.webp" />
						<div class="tocont">
							<div class="name">${ msg.frommid }</div>
							<div class="subcont">
								<div class="content"> ${ msg.msg } </div>
								<div class="date"> 오전 10:10 </div>
							</div>
						</div>
					</div>`
		}
	
	
	//3. 누적대입[기존채팅에 이어추가]
	chatcont.innerHTML+=html;
	
	
	
}	//f()



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
