console.log('js실행')

//클릭 시 누른 글 no 가져옴
let no =JSON.parse( localStorage.getItem('no'));

//쿠키에 있는 글 리스트 가져옴
let qList= JSON.parse(localStorage.getItem('qList'));
			if(qList==null){qList=[]};

// list에서 만들어 쿠키에 저장된 값을 가져온 거
let indexN=JSON.parse(localStorage.getItem('indexN'))

console.log(no)

onView()//

// 클릭한 글 출력 함수---------------------------------

function onView(){ console.log('onView 함수 실행')
	
	// 어디에 받을건지
	let title= document.querySelector('.v_title')
	let content=document.querySelector('.v_content')
	let selectInput=document.querySelector('.v_selectInput')
	let date=document.querySelector('.v_date')
	
	for(let i=0; i<qList.length;i++){
		let q= qList[i]
		
		if(q.no==no){
			title.innerHTML=q.title;
			content.innerHTML=q.content; 
			selectInput.innerHTML=q.selectInput;
			date.innerHTML=q.date;
			break;
			
		}
	}
	
}

//

function onViewLoad( no ){ // 인수 : 클릭한 제목(게시물)의 번호 
	console.log( ' 현재 클릭된 제목(게시물)의 번호 : ' + no);
	// 클릭된 결과를 다른페이지로 옮기는방법
		// JS는 페이지가 전환/새로고침 초기화 -> // 세션/쿠키
	// 1. 클릭된 게시물번호 세션에 저장 
	localStorage.setItem( 'no' , no )
		// * 조회수 증가 함수 호출 
		//increaseView( no )
	// 2. 페이지 이동 
	location.href="view_go.jsp"
}



// 3. 조회수 증가함수=수정 [ 실행조건 : 제목 클릭후 페이지 전환 전에 ]
function increaseView( no ){
	// 1. 클릭된 게시물번호의 게시물찾기
	for( let i = 0 ; i<qList.length ; i++ ){
		if( qList[i].no == no ){ // 찾았다..
			// 조회수 1 증가 
			boardList[i].view++;
			// * 만약에 세션/쿠기를 사용중 이라면 ...... 업데이트
			localStorage.setItem( 'qList' , JSON.stringify( qList) )
			break;
		}
	}
} // end 


//뒤로가기 버튼 onclick
function back(){ console.log('뒤로가기 성공')

	location.href='list_go.jsp' 
	
}

// 왼쪽 넘기기 onclick
function left(){
	console.log(no)
	
	//list에서 만든 변수 이용했고 위에 전역변수로 받음. indexN느ㅡㄴ 배열의 인덱스 의미.
	if(0 == indexN){return;}
	indexN--
	
	localStorage.setItem( 'indexN' , JSON.stringify( indexN))
	
	onViewLoad(Number(no)-1) 
	
	
}

// 오른쪽 넘기기 onclick
function right(){

	if(qList.length-1==indexN){return;}
	indexN++
	
	localStorage.setItem( 'indexN' , JSON.stringify( indexN))
	 
		
	
	onViewLoad(Number(no)+1)
	
}

// 게시물 삭제 함수
function onDelete(){
	for(let i= 0; i<qList.length; i++){
				if( no == qList[i].no  ){
			
			// i번째 인덱스 삭제 = 글 목록 제거
			qList.splice( i , 1 ); 
				// 배열에 변화 세션 저장
				localStorage.setItem( 'qList' , JSON.stringify( qList ) )
				//삭제했으면 클릭된 게시물 번호 사라져야함. 제거 함수
				sessionStorage.removeItem('no'); 
				alert('삭제했습니다.');
				console.log('테이블 페이지로 돌아감')
				//  페이지 전환
				location.href="list_go.jsp"
			
			break;
		} 
	}
		
}


	

