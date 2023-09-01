console.log('js실행')

/* */

function bwrite(){
	//1. form 가져오기
		//querySelectAll(): 배열타입으로 여러 dom객체
		//querySelect(): 객체 타입으로 한개 dom객체
	let form= document.querySelectorAll('.writeForm')[0] //여러개 중 한개만 가져오면됨.(첫번째배열)
	//2. form 객체화하기
	console.log('이거 찍힘?')
	let formData=new FormData(form);
	console.log(formData);
	
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