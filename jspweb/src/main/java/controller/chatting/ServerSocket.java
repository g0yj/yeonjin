package controller.chatting;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;

//회원제 채팅 만들면서 사용 할


@ServerEndpoint("/serversocket/{mid}") //서버소켓 url , 아래 주석 2번 방법!!
public class ServerSocket {
	//0. 접속된 클라이언트소켓들의 저장소[식별을 위해 아이디를 보내기로 했었음. 세션과 아이디를 저장하는 새로운 Dto를 생성]
	public static List<ClientDto> clientList= new Vector<>(); //로그인상태랑 아이디를 가져올거라 ClientDto 새로 만들었음. 새로고침할때마다 동일한 아이디가 계속 접속되는 걸 방지하기 위해
	
	//1. 클라이언트소켓으로부터 접속 받았을 때
	@OnOpen	//매개변수: 1.접속된 클라이언소켓(세션) 2.접속된 회원아이디
	public void onOpen(Session session,@PathParam("mid") String mid) {
		System.out.println("클라이언트 소켓이 입장했음: "+session);
		System.out.println("접속한 회원아이디: "+mid);
		//1-1: 접속된 클라이언소켓을 리스트에 저장
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add(clientDto);
		System.out.println("접속된 클라이언트들: "+clientDto);
	}//f()
	
	//2.
	@OnError
	public void onError(Session session , Throwable throwable) {

	}//f()
	
	//3. 클라이언트 소켓과  서버소켓이 연결이 끊겼을 때
	@OnClose
	public void onClose(Session session) {
		//*접속목록에서 제거
		for(ClientDto clientDto:clientList) {
			if(clientDto.getSession()==session) {
				//클라이언트소켓의 세션과 연결이 끊긴 세션과 같은 dto를 제거
				clientList.remove(clientDto);
				break;
			}
		}
	}//f()
	
	
	//4.
	@OnMessage //매개변수: 1. 메시지를 보낸 클라이언트소켓(세션) 2.메시지내용[문자열]
	public void onMessage(Session session ,String msg) throws IOException {
		System.out.println("보낸 클라이언트: "+session+"보낸 메시지: "+msg);
		
		//2-2 메시지를 보낼 내용 구성[보낸사람,보낸내용] : 보낸사람과 받는 사람을 구분해야되니깐. 새로운dto 생성
		MsgDto msgDto =null;
			//-보낸사람찾기[보낸 세션을 이용한 보낸mid 찾기]
			for(ClientDto clientDto:clientList) {
				if(clientDto.getSession()==session) {
					//회원목록 중에 보낸세션과 일치하면 보낸사람 아이디와 내용으로 dto 구성
					msgDto=new MsgDto(clientDto.getMid(),msg);
					break;
				}
			}
				//-msgDto를 json 사용할 수 있도록 형변환
			ObjectMapper objectMapper=new ObjectMapper();
			String jsonMsg=objectMapper.writeValueAsString(msgDto);
			
		//2-1 받은 메시지를 접속된 회원들에게 모두 전송
		for(ClientDto clientDto:clientList) {//회원목록에서 하나씩 회원 꺼내기
			//클라이언트소켓에게 메시지 전송
			clientDto.getSession().getBasicRemote().sendText(jsonMsg); // 예외처리 필수
			
		}
	
		
		
	}
	
	

}

/*
 *		*WebSocket 서버 소켓 라이브러리 제공
 *			1. 서버소켓 클래스 생성 
 * 				- 클래스위에 서버소켓 url 만들기
 * 					@ServerEndpoint("/serversocket")
 * 				- 만약에 서버소켓의 URL 경로상의 매개변수로 전달할 때
 * 					@ServerEndpoint("/serversocket/{매개변수명1}/{매개변수명2}")
 * 			2. 서버소켓 메소드 제공
 * 				- 메소드 매개변수의 규칙이 존재함!!
 * 				
 * 1.
 * 				@OnOpen
 * 					1. 
 * 					public void onOpen(Session session,@PathParam("아무거나")){}
 * 						-Session : 서버소켓의 접속된 클라이언소켓의 정보[8버전 기준으로는 ip 확인은 불가능]
 * 					2.
 * 					public void onError	
 * 					- @PathParam :
 * 
 * 				@onMessage
 * 					public void
 * 
 * 
 */
/*
* WebSocket 서버 소켓 라이브러리 제공
	1. 서버소켓 클래스 생성 
		- 클래스위에 서버소켓의 URL 만들기 
			@ServerEndpoint("/serversokcet")
		- 만약에 서버소켓의 URL 경로상의 매개변수를 받을때. 
			@ServerEndpoint("/serversokcet/{매개변수명1}/{매개변수명2}")
			
	2. 서버소켓 메소드 제공 
			- 메소드 매개변수의 규칙 존재 
			
			1. 클라이언트 소켓이 접속했을때. (자동실행)되는 메소드
			@OnOpen
				1. 
				public void onOpen( Session session ) { }
					- Session : 서버소켓의 접속된 클라이언트소켓 정보
				2. 
				public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
					- @PathParam("매개변수명1") 타입 매개변수명 : 서버소켓(URL)경로상의 매개변수를 호출 
			
			2. 클라이언트 소켓과 오류가 발생했을때 . (자동실행)되는 메소드
			@OnError
				public void onError( Session session , Throwable throwable ) { }
					- Session : 서버소켓과 오류가 발생한 클라이언트소켓 정보 
					- Throwable : 오류 발생한 사유 정보 
			
			3. 클라이언트 소켓과 연결이 끊겼을때. (자동실행)되는 메소드
			@OnClose
				public void OnClose( Session session ) { }
					- Session : 서버소켓과 연결이 끊긴 클라이언트소켓 정보 
			
			4. 클라이언트 소켓으로부터 메시지를 받았을때. (자동실행)되는 메소드
			@OnMessage
				public void onMessage( Session session , String msg ) { } 
					- Session : 서버소켓에게 메시지를 보낸 클라이언트소켓 정보 
					- String 매개변수 : 클라이언트소켓으로 부터 받은 메시지 [문자열타입]
					
			5. 클라이언트소켓에게 메시지 전송 
				클라이언트소켓.getBasicRemote().sendText("내용");
				
				
*/
