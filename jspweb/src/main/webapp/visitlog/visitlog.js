console.log('visitlog.js열림')

//1. Create(저장)
function vwrite(){
	//1. html input 태그 객체 호출
		//document.querySelector('.vwriter')
	let vwriterInput=document.querySelector('.vwriter'); console.log('vwriterInput: '+vwriterInput)
	let vpwdInput=document.querySelector('.vpwd'); console.log('vpwdInput: '+vpwdInput)
	let vcontentInput=document.querySelector('.vcontent');console.log('vcontentInput: '+vcontentInput)
	
	//2. 객체화
		//let 변수명={속성명: 데이터, 속성명:데이터}
	let info={
		vwriter: vwriterInput.value,  //8줄에 안쓰고 여기에 .value 붙인 이유?!
		vpwd: vpwdInput.value,
		vcontent: vcontentInput.value
	 } ; console.log(info)
	//3. 유효성검사(선택)
	
	//4. ajax(html에 jqury 라이브러리 필수로 호출)
	$.ajax({
		url:"/jspweb/VisitLogController",
		method:"post", 
		data: info, 
		success: function f(r){console.log("통신성공");console.log(r)
			if(r==true){
				alert('등록성공');vread();
				//초기화
				vwriterInput.value=''; vpwdInput.value='';vcontentInput.value='';
			}//if
			else{alert('등록실패');}
		},
		erroer: function f(r){}
			
	})
	
	
		//5. 결과에 따른 코드
	
}

//2. Read(호출)
vread();//js가 시작될 때 1번 실행
function vread(){//실행조건: js 열릴 때 1번 실행, 등록/수정/삭제 (최신화,화면새로고침) 시 실행
	
	//1. html input 태그 호출
	
	//2. 객체화
	
	//3. 유효성검사(선택)
	
	//4. ajax
	   $.ajax({
      url : "/jspweb/VisitLogController",      
      data :"",      
      method : "get",   
      success : function 함수(r){console.log(r); 
      	//1. 응답 받은 객체를 html에 출력
      		//1. [어디에] 출력할 구역의 객체 호출
      		let output =document.querySelector('.visit_bottom')
      		
      		//2. [무엇을] 반복문 이용한 데이터를 html 형식으로 만들기
      		let html=``; /*백틱 안에서 ;js문법 사용 ${} */
      			//리스트 내 모든 데이터를 
      			for(let i=0;i<r.length;i++){
					  //객체를 html형식으로 누적더하기
					  html+=`<div class=visitbox><!-- 방문록1개의 표시구역 -->
				<div class="visitbox_top">
					<div>${r[i].vwriter}</div>
					<div class="visitdate">${r[i].vdate} </div>
				</div>
				<div class="visitbox_center">${r[i].vcontent}</div>
				<div class="visitbox_bottom">
					<button onclick="vupdate(${r[i].vno})" type="button">수정</button>
					<button onclick="vdelete(${r[i].vno})" type="button">삭제</button>
				</div>
			</div>`
				  }
      		//3. [대입]출력객체 html형식 대입
      		output.innerHTML=html;
      
      } ,       
      error : function 함수(r){} ,         
   });

		//5. 결과에 따른 코드
	
}

//3. Update(수정)
	//누구를(클릭된방문록번호,vno) 어떻게(새롭게입력받아,vcontent) 수정할껀지.. 
function vupdate(vno){ console.log('함수실행'+vno);
	
	//1. 수정할 내용 입력
		//alert():확인알림창; confirm():확인/취소 알림창;prompt():알림창에서 입력받기;
	let vcontent=prompt('수정할 방문록 내용:');
	//2. 비밀번호가 일치할 경우에도 수정하므로 확인용 비밀번호 입력 받기
	let vpwd =prompt('방문록비밀번호: ');
	
	//수정할 때 필요한 준비물: vno(누구를), vcontent(어떤내용으로), vpwd(조건용:비밀번호일치여부)
	 $.ajax({
      url : "/jspweb/VisitLogController",     // 통신할 백엔드(컨트롤러주소(서블릿주소))
      method : "Put",   
      data : {vno:vno,vcontent:vcontent,vpwd:vpwd},      
      success : function f(r){console.log("doPut통신성공");
      	if(r==true){alert('수정성공');vread();}
      	else{alert('비밀번호일치안함');}
      
      } ,       
      error : function f(r){} ,         
   });

}

//4. Delete(삭제)
function vdelete(vno){console.log('함수실행'+vno);
	
	//1. 비밀번호가 일치할 경우에 수정하므로 확인용 비밀번호 입력 받기
	let vpwd = prompt('방문록비밀번호: ');
	
	//삭제할때 필요한 준비물: vno(누구를), vpwd(조건용:비밀번호일치여부)
	 $.ajax({
      url : "/jspweb/VisitLogController",      
      method : "Delete",   
      data : {vno:vno,vpwd:vpwd},      
      success : function f(r){console.log('doDelete통신성공')
    	if(r==true){alert('삭제성공');vread();}
      	else{alert('비밀번호일치안함');}
      
		} ,       
      error : function f(r){} ,         
   });

	
}