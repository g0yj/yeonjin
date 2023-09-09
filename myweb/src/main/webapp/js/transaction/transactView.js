console.log('개별출력js 열림')


viewPrint()
function viewPrint(){
	//필요한 데이터
	//1. 게시물번호: 전체글에서 누른 게시물의 번호에 따라 출력물이 달라짐.
	let bno= 
	$.ajax({
      	url : "/myweb//Transaction",     
     	method : "put",   
     	data : {bno:bno},      
      	success : r=>{console.log('통신성공')} ,       
      	error : e=>{console.log(e)} ,         
   });

	
	
	
	
}//f()