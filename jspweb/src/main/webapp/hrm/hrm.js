console.log('js실행')
//1.인사등록
function hrmjoin(){ console.log('hrmjoin함수실행')
	//1.입력 받은 데이터 가져오기
	let hireform = document.querySelectorAll('.hireform')[0];
	console.log(hireform);
	//2. 객체화
	let hirejoinData= new FormData(hireform);
	console.log(hirejoinData);
	//3. ajax에게 전송
		$.ajax({
		   url : "/jspweb/HrmController",     
		   method : "post",   //첨부파일 form전송은 무조건 post
		   data : hirejoinData,   
		   contentType:false,	//form객체 전송 타입
		   processData:false,    
		   success : r=>{console.log('통신성공');hireprint()
		     
		      	} ,       
		      	error : e=>{console.log(e)} ,         
		   });
	
}//f()

//2. 인사등록 출력--------------------------
hireprint(); //js가 시작될 때 최초 1번 실행
function hireprint(){
	//1.입력x
	//2.객체화x
	//3.ajax에게 전송
	$.ajax({
     url : "/jspweb/HrmController",     
     method : "get",   
     data : "",      
     success : r=>{console.log('통신성공')
     	//1. 응답 받은 객체를 html에 출력
     		//1.[어디에] 출력할 구역의 객체 호출
     		let output=document.querySelector('.print');
     		//2.[무엇을] 반복문을 이용한 데이터 html형식으로 만들기
     		let html=``;
     			//리스트 내 모든 데이터를
     		for(let i=0;i<r.length;i++){
				 console.log('포문도나');
				 console.log('r'+r[i].hname);
				html+=`
		     		<div class="print1">
   						<div class="hname">${r[i].hname}</div>
						<div class="hposition">${r[i].hposition}</div>
						<div class="hphone">${r[i].hphone}</div>
						<div class="hdate">${r[i].hdate}</div>
						<button class="update" onclick="update(${r[i].hno})" type="button">수정</button>
						<button class="delete" onclick="delete(${r[i].hno})" type="button">삭제</button>
					</div> `
			 }
     		//3. 출력객체 html형식 대입
     		output.innerHTML=html;
     } ,       
     error : e=>{console.log(e)} ,         
   });

	
	
	
	
}