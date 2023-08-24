console.log('js실행');
aread(); //js가 시작될 때 최초 1번 실행
//create(저장)------------------------------------------------------------------
function awrite(){
	//1. input 태그 객체 호출
	let atextInput= document.querySelector('.atext'); console.log(atextInput.value);
	let apayInput= document.querySelector('.apay'); console.log(apayInput.value);
	
	//2. 객체화
	let info={
		atext:atextInput.value,
		apay:apayInput.value,

	}; console.log(info)
	
	//3. 유효성검사
	
	//4. ajax
	$.ajax({
      url : "/jspweb/Accountbook",      
      method : "post",   
      data : info,      
      success : function f(r){console.log('doPost()연동');
		if(r==true){
			alert('등록성공'); aread();//업데이트 후 출력
			//초기화
			atextInput.value='';apayInput.value='';
		}	      
      
      } ,       
      error : function 함수(r){} ,         
   });
}
//read(출력)---------------------------------------------------------
aread(); //js가 시작될 때 최초 1번 실행
function aread(){
	//1.호출x
	//2.객체화x
	//3.유효성검사
	//4.ajax
	 $.ajax({
      url : "/jspweb/Accountbook",      
      method : "get",   
      data :"",      
      success : function f(r){console.log('doGet()연동');
      	//1. 응답 받은 객체를 html에 출력
      		//1.[어디에] 출력할 구역의 객체 호출
      		let output=document.querySelector('.printwrap')
      		//2.[무엇을]반복문을 이용한 데이터 html형식으로 만들기
      		let html=``;
      			//리스트 내 모든 데이터를
      			for(let i=0;i<r.length;i++){
					  //객체를 html 형식으로 누적
					  html+=`
					<div class="print">
						<div class="atext">${r[i].atext}</div>
						<div class="apay">${r[i].apay}</div>
						<div class="adate">${r[i].adate}</div>
						<button onclick="aupdate(${r[i].ano})" type="button">수정</button>
						<button onclick="adelete(${r[i].ano})" type="button">삭제</button>
					</div> `
			  }//f
			  //3.[대입] 출력객체 html형식 대입
			  output.innerHTML=html;
		  
	  } ,       
      error : function f(r){} ,         
   });
	
}	
	
//update(수정)--------------------------------------------------------
	// 누구를(클릭된번호,ano) 어떻게 (atext,apay)
function aupdate(ano){console.log('aupdate() 실행'+ano);
	// 수정할 내용
	let atext=prompt('항목 수정: ');
	let apay=prompt('가격수정: ');
	// 필요한 준비물 : ano , atext, apay
	 $.ajax({
      url : "/jspweb/Accountbook",     
      method : "Put",   
      data : {ano:ano, atext:atext,apay:apay},      
      success : function f(r){console.log('doPut통신')
      	if(r==true){alert('수정성공');aread();}
      	else{alert('수정실패');}
      } ,       
      error : function f(r){} ,         
   });

}		
//delete(삭제)-----------------------------------
	// ano 보내고 끝
function adelete(ano){
	 $.ajax({
      url : "/jspweb/Accountbook",     
      method : "delete",   
      data : {ano:ano},      
      success : function f(r){console.log('doDelete통신')
      	if(r==true){alert('삭제성공');aread();}
      	else{alert('삭제실패');}
      } ,       
      error : function f(r){} ,         
   });
	
	
}	
	
//class