console.log('개별글출력페이지')

//1.list.jsp에서 클릭된 제목의 bno를 전달 받아 게시물 1개 가져오기
getBoard();
function getBoard(){
	
	//1. url에 있는 매개변수(쿼리스트링) 가져오기
		//1. 현재 주소(url)상의 매개변수 가져오기- 바닐라js
	let urlParams=new URL(location.href).searchParams;
		console.log(urlParams);	
	let bno = urlParams.get("bno");//url주소에서 bno의 데이터 가져오기
		//new URL(location.href).searchParams.get("매개변수명");
	console.log('url 주소에서 bno 가져오기 성공:  '+bno);
	//2. ajax 이용한 bno 전달해서 게시물 상세 정보 모두 가져오기
	 $.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "get",   
     	data : {type:2 , bno:bno},      
      	success : r=>{console.log('통신성공'+r);
      		//1. 어디에
      		let boardBox = document.querySelector('.boardBox');
      		//2. html 구성
      		let html= `
	      		부가정보1: <div>${r.bcname}, ${r.bview}, ${r.bdate}</div>
				부가정보2: <div>${r.mid}, <img src= "/jspweb/member/img/${r.mimg}" width="50px" ></div>
				제목: <div>${r.btitle}</div>
				내용: <div>${r.bcontent}</div>
				첨부파일: <div>${r.bfile}</div>
				
			`
					//글삭제, 수정을 위한 제어[본인글일시 수정,삭제 표시]
				html+= `<a href="list.jsp"><button type="button">목록</button></a>`
				if(r.ishost){
					html+=
						`<button onclick="onDelete(${r.bno})" type="button">삭제</button>
						<button onclick="onUpdate(${r.bno})" type="button">수정</button>`
				}
			//3. 출력
			boardBox.innerHTML=html;
      	
      	} ,       
      	error : e=>{console.log('통신실패'+e)} ,         
   });

	
}//f()


//삭제버튼을 누를 때(게시물삭제)--------------------------------------
function onDelete(bno){
	
	
	$.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "delete",   
     	data : {bno:bno},      
      	success : r=>{console.log('통신성공 bno: '+bno)
      		if(r){
				  alert('삭제성공')
				  location.href="/jspweb/board/list.jsp";
			  }else{alert('삭제실패')};
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()

//게시물 수정 페이지로 이동
function onUpdate(bno){
	//1. 수정 페이지로 이동
	location.href=`/jspweb/board/update.jsp?bno=${bno}`
	
}//f()