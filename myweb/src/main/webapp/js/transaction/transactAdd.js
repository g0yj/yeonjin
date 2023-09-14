console.log('거래내역등록페이지')

$(document).ready(function() {

   let option = { // 썸머노트 옵션관련 객체 만들기 
      lang : 'ko-KR' , 
      height : 500 , 
      placeholder : '여기에 내용작성'
   }
   
   $('#summernote').summernote( option );
  
});




//1. 거래내역 등록
function add(){
	//1. 요청
	let transactForm= document.querySelectorAll('.transactForm')[0];
	console.log('form으로 가져온거'+transactForm);
	let transactData= new FormData(transactForm);
	console.log('new FormData() 한거: '+ transactData)
	//2.
	  $.ajax({
        url : "/myweb/Transaction",     
        method : "post",   
        data : transactData, 
       contentType:false,
    	processData:false,
    
        success : r=>{console.log('통신성공')
        	if(r){alert('거래 내역이 추가되었습니다')}
        	else{alert('거래 내역 추가에 실패했습니다')}
        
        } ,       
         error : e=>{console.log('통신실패')} ,         
   });

}

//2. 뒤로가기
