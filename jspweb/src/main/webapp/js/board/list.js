console.log('js실행')

//1. 글쓰기 버튼을 클릭하면 
	/* 회원제 게시판으로 글쓰기는 로그인 사람에 한해 가능하도록 해야됨.
		유효성 검사가 필요한데 .. header에 loginsession을 전역변수로 두는 방식을 사용. session에 저장하는 등 여러가지 방법이 있다는 점!! */
function onWrite(){// 비로그인이면 로그인 페이지로 이동
	if(loginState){//loginState는 다른 페이지의 변수임에도 쓸 수 있는 이유는 header를 통해 연결되어 있는 상태이기 때문. ctrl+click해서 연결된 것들 살펴보기
		location.href="/jspweb/board/write.jsp";
	}else{
		alert('로그인 후 글쓰기 가능함')
		location.href="/jspweb/member/login.jsp";
	
	}

	
}//f()

//2. 모든 글 조회 [js가 열렸을 때 자동실행]
getList();
function getList(){
	$.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "get",   
     	data : {},      
      	success : r=>{console.log(r);
      		//1. 출력할 위치
      		let boardTable=document.querySelector('.boardTable')
      		
      		//2. 출력할 내용구성
      		let html=`<tr>
						<th>번호</th><th>카테고리</th><th>제목</th>
						<th>작성자</th><th>조회수</th><th>작성일</th>
					</tr>`
					//*서블릿으로부터 전달받은 내뇽[배열]반복해서 html구성
					//배열명.forEach(반복변수명=>{실행코드})
					r.forEach(b=>{
						html+=`<tr>
								<th>${b.bno}</th>
								<th>${b.bcname}</th>
								<th>${b.btitle}</th>
								<th>${b.mid}/<img src="/jspweb/member/img/${b.mimg}"></th>
								<th>${b.bview}</th>
								<th>${b.bdate}</th>
								</tr>`
					})//for
      		//3.구성된 html 내용을 출력
      		boardTable.innerHTML=html;
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
}