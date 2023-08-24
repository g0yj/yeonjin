console.log('1_AJAX통신 실행')

//1. 예제1--------------------------------------------------------------------------------
function 예제1(){
	
		$.ajax({
			url:"http://localhost/jspweb/test/day03/1_AJAX%ED%86%B5%EC%8B%A0.jsp",
			data:{'value1':'jsdata'} , 
			method:"get" ,
			success: function 함수(result){
				console.log('서블릿 응답한 내용: '+r);
			},
			error: function 함수(result){},
	});
}//f

//2. 예제2----------------------------------------------------------------------------
function 예제2(){
	//1. 입력 받은 데이터 가져옴
	let nameData=document.querySelector('.name').value;
	let ageData=document.querySelector('.age').value;
	//2. rorcpghk
	let info={
		name:nameData,
		age:ageData
	}
	//3. [객체를 자바(서블릿)에게 전달]
	$.ajax({
		url:"",
		data:info, 
		method:"get" ,
		success: function 함수(result){
				console.log('통신성공');
			}
	});

}//f()
	
	
	


/*
	$.ajax();
	객체{} 타입의 속성 대입
	
	$.ajax({
		url:""	,----통신할 http주소
		data:{} , -----보내는 데이터
		method:"" ,----통신방법(post,get,put,delete)
		success: function 함수(result){}	,-----통신 성공했을 때 응답데이터를  result 매개변수 받기
		error: function 함수(result){}	,------통신 실패했을 때 실재사유를 result 매개변수 받기
		
		
		
		
	});

*/