console.log('js실행')



//1.로그인된 회원의 정보 호출
getInfo();
function getInfo(){
	 $.ajax({
      	url : "/jspweb/MemberinfoController",     
     	method : "get",   
     	data : {type: "info"},      
      	success : r=>{console.log(r)
      	
      	if(r==null){//비로그인상태-> 페이지 차단
			  alert('회원만 사용가능한 페이지임')
			  location.href="/jspweb/member/login.jsp";
		  }else{//로그인상태 -> 마이페이지 구역에 정보 넣어주기
		  	document.querySelector('.preimg').src=`img/${r.mimg}`;
		  	document.querySelector('.mid').innerHTML=r.mid;
		  	document.querySelector('.memail').innerHTML=r.memail;
		  }
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()

//2.수정---------------------------------
function mupdate(){
	
	//첨부파일 전송할때.
		//1.form dom 객체 가져오기
		let form= document.querySelectorAll(".signupForm")[0];
		console.log(form);
		//2. form 데이터 객체화 하기
		let formdata=new FormData(form);
		console.log(formdata)
		//*form 전송 ajax
		$.ajax({
			url:"/jspweb/MemberinfoController",
			method:"put",
			data:formdata,
			// 폼 전송타입: 문자전송x, json전송x , multipart/form-data 타입o
			/*
				http 전송타입
					1.text/html : 문자타입[기본값]
					2.application/json: json타입
					3.multipart/form-data: 대용량 form 전송 타입
						contentType:false,
						processData:false
			*/ 
			contentType:false, //false로 하면 전송타입 form
			processData:false,  
			success:r=>{
				if(r){
					alert('수정성공'); logout();
				}else{alert('수정실패')}
				
			},
			error:e=>{}
			
			
			
			
		})
		
}//f()


//3.탈퇴--------------------------------------
function mdelete(){
	//1.탈퇴여부를 확인 
		//confirm() 확인/취소 버튼 알림창
	let dconfirm= confirm('정말 탈퇴?');
	//2. 확인 버튼을 눌렀을때
	if(dconfirm==true){
		let mpwd=prompt('비밀번호 확인');
	//3.ajax[패스워드 전송해서 로그인된 회원번호와 입력받은 패스워드와 일치하면 탈퇴]
	 $.ajax({
      	url : "/jspweb/MemberinfoController",     
     	method : "delete",   
     	data : {mpwd:mpwd},      
      	success : r=>{console.log('통신성공')
      		if(r){alert('회원탈퇴성공'); logout(); //logout() 함수를 사용할 수 있는 이유? 헤더?로 페이지끼리 연결되어 있어서 가능. 이런거 주의해야됨.
      		}else{alert('패스워드가 일치하지 않음')}
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
	
	
	
	}//if
	
}//f()