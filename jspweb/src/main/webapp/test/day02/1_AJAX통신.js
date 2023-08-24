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
	



 */