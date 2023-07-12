console.log('write 함수 실행')

// 1. 썸머노트 실행할때 사용되는 코드 
$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});
// 관리자만 쓰기 가능
let mID= 1234

// 전역변수------------------------------------------------
 //검색 버튼 내 option 배열 / 해당 검색 결과만 불러오기 위해 선언
let select=['전체', '이용방법', '계정', '결제', '점포', '쿠폰']
//전체 글 목록
let qList=[]


//등록함수--------------------------------------------------------------------------

function onWrite(){ console.log('onWrite 함수 실행')
	let selectInput= document.querySelector('.form-select').value;   console.log('select선택받음');
	let title = document.querySelector('.form-control').value;   console.log('제목 입력 받음');
	let content= document.querySelector('#summernote').value; console.log('summernote작성')
	let qList=JSON.parse(localStorage.getItem('qList'));
		if(qList==null){qList=[]}; console.log('쿠키에서 qList 가져옴')
	
	let no = (qList.length == 0 ? 1: (qList[qList.length-1].no+1)); console.log('no 부여: '+no)//??????????여기 ,,
	let date= new Date() ; console.log('작성일: '+date)
	
	// qList 인덱스를 객체화. view는 조회수
	let board={
		selectInput: selectInput,
		no:no,
		title:title,
		content: content,
		date: `${new Date().getFullYear()}-${new Date().getMonth()+1 }-${new Date().getDate() }` ,
		view: 0	
	} ; console.log('추가될 객체'+ board)//??????????????여기 ,객체화 전역 변수로 올리기 가능? nope. 받아온 값이 함수 안에서 시행되기 때문에 전역으로 나갈 수 없
	//전역변수에 푸쉬
	console.log(board.title);
	qList.push(board) ;  console.log('변경된 qList'+ qList)
	
	//쿠키에 저장
	localStorage.setItem('qList', JSON.stringify(qList)) ; console.log('쿠키에 저장')
	
	console.log(qList)
	
	alert('글쓰기 성공'); console.log('글쓰기성공')
	// 고객센터 맨 앞 페이지 호출
	location.href = "/teamProject1/customer/list_go.jsp";
	
	
}

//select 내 option 가져오기 / .form-select

let mselect= document.querySelector('.form-select');
let html='';
	
		for(let i=0; i<select.length; i++){
		html+= 
			`<option>${select[i]}</option>`;
				}		
mselect.innerHTML=html;

