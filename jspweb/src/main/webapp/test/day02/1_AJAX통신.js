console.log('1_AJAX통신 시작');

//1. 예제1
function 예제1(){console.log('예제1()실행');
	//ajax 메소드 이용한 서블릿과 통신
	$.ajax({
		url : "/jspweb/Test02",
		method:"get",
		success: function 함수명(result){console.log(result);}
		
	});
}


//2. 예제2
function 예제2(){console.log('예제2()실행');
	//ajax 메소드 이용한 서블릿과 통신
	$.ajax({
		url : "/jspweb/Test03",
		method:"get",
		success: function 함수명(result){console.log(result);}
		
	});
}


//3. 예제3
function 예제3(){console.log('예제3()실행');
	//ajax 메소드 이용한 서블릿과 통신
	$.ajax({
		url : "/jspweb/Test04",
		method:"get",
		success: function 함수명(result){console.log(result);}
		
	});
}

//4. 예제4
function 예제4(){console.log('예제4()실행');
	//ajax 메소드 이용한 서블릿과 통신
	$.ajax({
		url : "/jspweb/Test05",
		method:"get",
		success: function 함수명(result){console.log(result);}
		
	});
}


/*
	$.ajax({ 
		url : "통신경로/서블릿주소",
		method : "통신방법:get,post,put,delete 선택",
		success : function 함수명(통신반환변수){ 통신성공 시 실행코드}
		
	})
	-1. success/error 속성에서 통신 결과의 반환값 받는 함수 작성시
		1. success : function 함수명(통신반환변수){통신성공했을 때 실행코드}
		2. success : function (통신반환변수){통신성공했을 때 실행코드}
		3. success : (통신반환함수) =>{통신성공했을 때 실행코드}
	

	------------------------------------------
	서블릿 내장객체 사용 (기존 MVC에서는 C->V로 리턴할 때 boolean 같이 타입을 써줬었는데 외부와 통신하는 건 (java와 js 통신) 불가능. 서블릿 자체가 내장객체를 가지고 있음)
		- request : 요청 객체
		- response : 응답 객체 
			- response.getWriter().print(데이터)  	
				웹 출력=응답 데이터 
			- response.setContentType("전송할데이터타입명;인코딩타입") 			
				출력할 데이터의 타입 혹은 인코딩
				- 1. 문자전송[default]
					response.setContentType("text/html;charset=UTF-8");
				- 2. JSON전송 
					response.setContentType("application/json;charset=UTF-8");
					
	javas는 dto를 쓰고 js는 json을 사용. dto를 json 형태로 바꿔줘야됨. (라이브러리 사용)
	------------------------------------------
	JACKSON : JAVA객체를 JSON 형식에 대한 다양한 클래스 제공 라이브러리
		jackson-annotations-2.14.2 , jackson-core-2.14.2 , jackson-databind-2.14.2
		1. ObjectMapper 클래스 : JAVA객체를 JSON형식으로 변환해주는 함수들을 제공하는 클래스  
			1. .writeValueAsString( 변환할JAVA객체 ) : 해당객체를 JSON형식의 문자열로 반환 


//----------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto boardDto =new BoardDto("제목2", "안녕하세요2");
		//DTO --> JSON 변환[*JS에게 데이터 전달하는데 .. JS는 Dto 타입 몰라] 번역
			//java가 문자열타입의 json모양 만들어 js에게 전달
			// 라이브러리: jackson
				//ObjectMapper클래스: 
		
		//1. Dto -->json 변환 해 주는 변환 객체 [objectmapper]
		ObjectMapper mapper= new ObjectMapper();
		String jsondata=mapper.writeValueAsString(boardDto); //json형식으로 변환할 객체 넣기
		System.out.println("자바");
		//2. 응답 타입
		response.setContentType("application/json;charset=UTF-8");
		//3. 응답 데이터
		response.getWriter().print(jsondata);
	}


 */