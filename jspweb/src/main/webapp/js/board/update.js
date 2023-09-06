console.log('수정 페이지 실행')

// 1번 2번에서 모두 쓰일거라 전역변수로
	let bno= new URL(location.href).searchParams.get("bno"); 
	console.log('내용가져오기:'+bno);

//1. 수정할 게시물의 기존 정보를 보여주기-------------------------------------
getBoard()
function getBoard(){
	//2. 쿼리스트링(url주소상의 변수)의 변수 가져오기  //bno: 속성명임!
		//쿼리스트링: URL?변수명=값 &변수명=값

		
	//3. ajax
	$.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "get",   
     	data : {type:2, bno:bno},      
      	success : r=>{console.log('통신성공')
      		console.log(r);
      		document.querySelector('.bcno').value =`${r.bcno}`;
      		document.querySelector('.btitle').value =`${r.btitle}`;
      		document.querySelector('.bcontent').innerHTML =`${r.bcontent}`;
      		document.querySelector('.oldfile').value =`${r.bfile}`;
      		
      		/*썸머노트적용!  write랑 위치 다름*/
				$(document).ready(function() {
					
					let option={ //썸머노트 옵션 적용
				      lang : 'ko-KR' , 
				      height : 500 , 
				      placeholder : '여기에 내용작성'
					}
					
					
				  $('#summernote').summernote(option);
});
      		
      		
      		
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}//f()

//2. 수정하기-----------------------------------------------------
function onUpdate(){
	let writeForm= document.querySelectorAll('.writeForm')[0];
	let formdata = new FormData(writeForm);
		//*form객체에 데이터 추가하기[bno]
			//.set(속성명,값); // form전송에서 데이터속성 추가하는 방법
		formdata.set("bno",bno);
	// ajax 대용량 multipart
	$.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "put",   
     	data : formdata ,      
    	contentType:false,
    	processData:false,
      	success : r=>{console.log('통신성공')
      		if(r){
				  alert('글 수정 성공');
				  location.href=`/jspweb/board/view.jsp?bno=${bno}`; //bno 전달 유의!
			  }else{alert('글수정 실패')}
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}//f()