console.log('1_통신.js')

//예제1
function 예제1(){console.log('예제1()실행')

	/*
		ajax: jquery라이브러리에서 통신http 함수 제공
			jquery : js언어로 여러개 함수를 제공하는 라이브러리집단
		
		1. 정의 : js언어에서 외부와 통신하는 것이 목표
		2. 형태: $ajax();
		3. 필수! : jquery 라이브러리 필수 
					<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
					 ㄴ 추가 안하면?! : $in not defined: jquery 라이브러리 추가 안했을 때 발생하는 오류
		4. 매개변수: 객체{속성:값, 속성:값, 속성:값}
			<속성>
			1. url속성: 통신할 대상(링크,주소)
			2. http통신메소드: post, get, put , delete  등등  <-crud
			3. success결과 속성: 통신을 성공했을 때 반환된 데이터를 함수의 매개변수 반환 받음
		
	 */
	$.ajax({
		url: "https://jsonplaceholder.typicode.com/posts", 	// 1.통신할 경로 
		method: "get",										//2. 통신할 http메소드 방식
		success : function 결과(result){console.log(result);}	//3. 통신 성공했을때 반환된 데이터
		
		
		});

}

//https://jsonplaceholder.typicode.com/posts
//외부 링크[사이트]에 json 데이터 통신

	
//예제2
function 예제2(){
	console.log('예제2()실행');
		
		$.ajax({
	//url:"http://아이피주소/jspweb/Test01"  둘 중 하나 가능.
		url: "/jspweb/Test01", 	// 1.통신할 경로 
		method: "get",										//2. 통신할 http메소드 방식
		success : function 결과(result){console.log(result);}	//3. 통신 성공했을때 반환된 데이터
		
		
		});
	
	
	
}	
	