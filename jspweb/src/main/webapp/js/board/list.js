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

/*게시물 조회 조건 객체
	type: 1-전체조회 2-개별조회
	bcno: 조회할 카테고리번호[기본값은 전체보기]
	listsize: 하나의 페이지에 최대 표시할 게시물 수 [기본값10개]
	page: 조회할 페이지 번호
	key: 검색할 기준 필드명
	keyword: 검색할 데이터
*/
let pageObject={type: 1 ,bcno:0, listsize:10, page:1, key:'', keyword:''}


//3. 카테고리 버튼을 클릭햇을 때
function onCategory(bcno){
	console.log('클릭된 카테고리: '+bcno);
	pageObject.bcno=bcno; //조회 조건 객체 내 카테고리 번호를 선택한 카테고리로 변경
	pageObject.key = ''; pageObject.keyword=''; //검색해제. 페이지 전환 시 검색 내용란을 빈 공간으로 (선택임. 안하면 그대로 딸려옴)
	getList(1); //조건이 변경되었기 때문에 다시 출력[재랜더링/새로고침]
	
	
}
//4. 한페이지 최대 표시할 개수를 변경햇을 때
function onListSize(){
	pageObject.listsize=document.querySelector('.listsize').value; //선택된 게시물 수를 조회 조건 객체에 저장
	getList(1);//조건이 변경되었기 때문에 다시 출력
	
}



//2. 모든 글 조회 [js가 열렸을 때 자동실행] // 페이지번호
getList(1);

function getList(page){ console.log('글목록페이지js열림')
	pageObject.page=page; //클릭된 페이지번호를 조건객체에 대입
	$.ajax({
      	url : "/jspweb/BoardinfoController",     
     	method : "get",   
     	data : pageObject,  //원래 type:1 만 보냈었는데 3번을 추가하면서 바뀜.(해당 카테고리의 글만 출력)
      	success : r=>{console.log(r);
      	//--------------------------1.게시물출력------------------//	
      		//1. 출력할 위치
      		let boardTable=document.querySelector('.boardTable')
      		
      		//2. 출력할 내용구성
      		let html=`<tr>
						<th>번호</th><th>카테고리</th><th>제목</th>
						<th>작성자</th><th>조회수</th><th>작성일</th>
					</tr>`
					//*서블릿으로부터 전달받은 내뇽[배열]반복해서 html구성
					//배열명.forEach(반복변수명=>{실행코드})
						// controller에서 정보 통합하면서 다시 한번 묶은 적이 있음. 객체로 받은 상황이기 때문에 boardList 안으로 들어가줘야됨.
					r.boardList.forEach(b=>{
						html+=`<tr>
								<td>${b.bno}</td>
								<td>${b.bcname }</td>
								<td><a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle } </a></td>
								<td>
									${b.mid}
									<img src="/jspweb/member/img/${b.mimg}">
								</td>
								<td>${b.bview}</td>
								<td>${b.bdate}</td>
								</tr>`
					})//for
      		//3.구성된 html 내용을 출력
      		boardTable.innerHTML=html;
      		
      	//------------------2. 페이지번호 출력----------------------------------------//
      	
      	html=``;
      	//페이지 개수만큼 페이징 번호 구성
      			// page: 조회한 페이지 번호 [현재 보고 있는 페이지번호]
      			//1.이전버튼 (만약 1페이지에서 이전 버튼 클릭 시 1페이지로 고정)
				html+=`<button onclick="getList(${page<=1?page:page-1})" type="button"><</button>`
      			//2. 페이지번호버튼 [페이지 개수만큼 반복]
      			
	
      			for(let i =r.startbtn; i<=r.endbtn;i++){
					  //만약에 현재페이지(페이지)와 i번째 페이지와 일치하면 버튼 태그에 class="selectpage" 추가
					  html+=`<button class="${page==i?'selectpage' : ''}"onclick="getList(${i})" type="button">${i}</button>`
				  }
				//3.다음버튼[page>=pageDto.totalpage 면 마지막 페이지면 가만히! 아니면 page+1]
			  html+=`<button onclick="getList(${page>=r.totalpage ? page : page+1 })" type="button">></button>`
      	//pagebox 구역에 구성된 html 출력
      	document.querySelector('.pagebox').innerHTML=html;	
      
      //---------------3. 게시물 수 출력--------------------------------------//
      let boardcount= document.querySelector('.boardcount');		
    	//1.검색이 있을때
    	if(pageObject.key==''&&pageObject.keyword==''){
	      boardcount.innerHTML=`총게시물수: ${r.totalsize} 개`		  
			
		}else{
			
	      boardcount.innerHTML=`검색된 게시물수: ${r.totalsize} 개`		  
		}

      		
      	} ,       
      	error : e=>{console.log('전체글 출력 실패: '+e)} ,         
   });

	
}//f()


/*검색버튼 클릭 */
function onSearch(){
	pageObject.key=document.querySelector('.key').value; 
	pageObject.keyword=document.querySelector('.keyword').value;   
	getList(1);
	
}//f()

/*
	HTTP URL에 매개변수(파라미터)전달- 쿼리스트링방식
		- 정의: 페이지 전환 시 매개변수(pk)전달
		
		- 형태
		URL?변수명=데이터
		URL?변수명=데이터&변수명=데이터
		localhost:80/jspweb/board/view.jsp?bno=${b.bno}
		
		- URL에서 매개변수 호출
			new URL(location.href).searchParams.get("매개변수명"); 


 */