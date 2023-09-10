console.log('js실행')

/* */

/* 썸머노트 실행 */
$(document).ready(function() {

   let option = { // 썸머노트 옵션관련 객체 만들기 
      lang : 'ko-KR' , 
      height : 500 , 
      placeholder : '여기에 내용작성'
   }
   
   $('#summernote').summernote( option );
  
});

function bwrite(){
	//1. form 가져오기
		//querySelectAll(): 배열타입으로 여러 dom객체
		//querySelect(): 객체 타입으로 한개 dom객체
	let form= document.querySelectorAll('.writeForm')[0] //여러개 중 한개만 가져오면됨.(첫번째배열)
	//2. form 객체화하기
	console.log('jsp에서 form으로 가져옴:'+form)
	let formData=new FormData(form);
	console.log('대용량 전달을 위해 new() :'+formData);
	
	//3. ajax로 대용량 form전송 (파일 있는거면 반드시 폼처리 해야서 이동해야됨)
	  $.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "post",   
     	data : formData,      
    	contentType:false,
    	processData:false,
      	success : r=>{console.log(r)
      	
      		if(r){
				  alert('글등록성공');
				  location.href="/jspweb/board/list.jsp";
			  }else{
				  alert('글등록실패');
			  }
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}//f()