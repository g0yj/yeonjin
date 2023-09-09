console.log('거래내역등록페이지')

//1. 거래내역 등록
function add(){
	//1. 요청
	let transactForm= document.querySelectorAll('.transactForm')[0];
	console.log(transactForm);
	let transactData= new FormData(transactForm);
	console.log(transactData)
	//2.
	  $.ajax({
        url : "/myweb/Transaction",     
        method : "post",   
        data : FormData, 
       	//contentType:false,
    	//processData:false,
    
        success : r=>{console.log('통신성공')
        	if(r){alert('거래 내역이 추가되었습니다')}
        	else{alert('거래 내역 추가에 실패했습니다')}
        
        } ,       
         error : e=>{console.log('통신실패')} ,         
   });

}

//2. 뒤로가기
