console.log('js실행')

//클릭 시 누른 글 no
let no =JSON.parse( localStorage.getItem('no'));
//쿠키에 있는 글 리스트 가져옴
let qList= JSON.parse(localStorage.getItem('qList'));
			if(qList==null){qList=[]};
//페이지 내에서 앞/뒤 페이지를 가져올 인덱스를 찾기 위해 list.js에서 만듦
let indexN=JSON.parse(localStorage.getItem('indexN'))

onView()

// 상세페이지 출력 함수---------------------------------
function onView(){
	// 어디에 받을건지
	// 왔다갔다 하다 보니 js와 jsp에 있는 변수명을 착각함. 변수명 주의해서 잘 보기.
	// 특히 복붙할 때 !!! 
	let title= document.querySelector('.v_title')
	let content=document.querySelector('.v_content')
	let selectInput=document.querySelector('.v_selectInput')
	let date=document.querySelector('.v_date')
	
	for(let i=0; i<qList.length;i++){
		let q= qList[i]
		// 전체 게시물의 no와 상세페이지 no가 동일할 때 함수 실행
		if(q.no==no){
			title.innerHTML=q.title;
			content.innerHTML=q.content; 
			selectInput.innerHTML=q.selectInput;
			date.innerHTML=q.date;
			break;
			
		}
	}
	
}

// 전체 게시물 중 클릭한 페이지를 가져오기 위해 인수로 실행
// jsp 파일이 아직 연동이 되는 건 아니기 때문에 각 페이지에서 만든 함수가 동기화 되지 않음.
// 필요한 함수를 쓰기 위해 각 페이지에 js에 다시 한번 함수 선언이 필요함.(업데이트js 가보셈)
function onViewLoad( no ){

	// 클릭된 결과를 다른페이지로 옮기기
	localStorage.setItem( 'no' , no )
		// 조회수 증가 함수 
		increaseView( no )
	// 페이지 이동 
	location.href="view_go.jsp"
}



//  조회수 증가함수
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
function back(){ location.href='list_go.jsp' }

// 왼쪽 넘기기 onclick
function left(){
	if(0 == indexN){return;}
	indexN--
	//전역변수 사용. 다른 js에서 만들어 쿠키에 저장했고. 그걸 전역 변수로 끌어왔음.
	localStorage.setItem( 'indexN' , JSON.stringify( indexN))
	// no 숫자로 받기. 이전글을 가기 위해 -1
	onViewLoad(Number(no)-1) 
	}

// 오른쪽 넘기기 onclick
function right(){
	//리스트의 마지막 인덱스와 동일할 때 실
	if(qList.length-1==indexN){return;}
	indexN++
	localStorage.setItem( 'indexN' , JSON.stringify( indexN))
	// 다음 글로 가기 위해 +1씩 증가 
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


	

