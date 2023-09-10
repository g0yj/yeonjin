console.log('전체화면출력페이지실행')


// 출력함수
transactPrint();

function transactPrint(){
	let ttable = document.querySelector('.ttable');
	 $.ajax({
      	url : "/myweb/Transaction",     
     	method : "get",   
     	data : {type:1},      
      	success : r=>{console.log('전체출력 통신 성공 '+r)
		
		let html=`				
					<tr>
						<th>거래</th>
						<th>종목</th>
						<th>금액</th>
						<th>수량</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>`
		r.forEach(t=>{
			html+=`<tr>
							<td>${t.transactSelect}</td>
							<td>${t.codename}</td>
							<td>${t.tprice}</td>
							<td>${t.tamount}</td>
							<td><a href="/myweb/transaction/transactView.jsp?bno=${t.bno}">${t.ttitle}</a></td>
							<td>${t.tdate}</td>
						</tr>`
		})			
	
					
		ttable.innerHTML=html;
      	
      	
      	
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
	
	
		
}//f()