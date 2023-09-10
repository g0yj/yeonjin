console.log('개별출력js 열림')


viewPrint();
function viewPrint(){
	//1. 필요한 데이터: 게시물번호, selvlet통합을 위한 type , 내용물
		// 현재 주소(url)상의 매개변수 가져오기
	let urlParams=new URL(location.href).searchParams; console.log('현재 주소상의 매개변수는? '+urlParams )
		// 해당 게시물을 가져오기 위한 bno 
			//new URL(location.href).searchParams.get("매개변수명");
	let bno= urlParams.get("bno") ;console.log('url로 가져온 bno: '+bno);
	
	//2.
	$.ajax({
      	url : "/myweb//Transaction",     
     	method : "get",   
     	data : {bno:bno, type:2},      
      	success : r=>{console.log('개별출력 통신성공: '+r)
      		let webcontainer= document.querySelector('.viewbox');
      		let html=``;
      		html=
	      		`<div class="page">
					<a href="transactList.jsp"><button>목록</button></a>
					<a href="/myweb/Transaction?boardbno=${r.bno}"><button>이전</button></a>
					<a href="#"><button>다음</button></a>
				</div>
			
				<div class="title">${r.ttitle}</div>
				<div class="date">${r.tdate}</div>
				
				<table class="summary">
					<tr>
						<td>거래</td>
						<td>종목</td>
						<td>가격</td>
						<td>수량</td>
					</tr>
					<tr>
						<td>${r.transactSelect}</td>
						<td>${r.codename}</td>
						<td>${r.tprice}</td>
						<td>${r.tamount}</td>
					</tr>
				</table>
				
				<div class="content">${r.tcontent}</div>
				
		
				<div class="update">
					<button onclick="tUpdate()">수정</button>
					<button onclick="tDelete()">삭제</button>
				</div>
			
			`
	webcontainer.innerHTML=html;
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
	
	
	
}//f()