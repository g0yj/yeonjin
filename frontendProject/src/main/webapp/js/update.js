console.log( 'update.js 실행' )

// 1. 썸머노트 실행할때 사용되는 코드 
$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});

//2. 수정할 게시물=클릭된 게시물=현재보고있는 게시물[게시물 번호= 세션]

let no= sessionStorage.getItem('no'); console.log(no)
let boardList=JSON.parse(localStorage.getItem('boardList')); console.log(boardList)
onView()

//2. 출력할 게시물을 출력
function onView(){
	//1. 어디에[input.textarea이기 때문에 value가 맞음. view.js에 있는건 innerHTML]
	let title=document.querySelector('.title')
	let content=document.querySelector('#summernote')
		
	//2. 무엇을 [클릭된 게시물 정보 1개]
	for(let i =0; i<boardList.length;i++){
		let b= boardList[i]
		if(b.no==no){
			//3. 출력/대입
			title.value=b.title
			content.value=b.content
			break
		}
		
	}	
}
//3. 수정 함수[실행조건: 등록 버튼을 클릭했을 때] 

function onUpdate(){
	//누구를(현재 보고 있는 게시물)
	for(let i=0; i<boardList.length;i++){
		let b= boardList[i];
		if(b.no==no){//현재 보고 있는 게시물 찾기
			document.querySelector('.title').value;
			document.querySelector('#summernote').value;
			//수정 대입
			b.title=title;
			b.content=content;
			/*쿠키나 세션을 사용 중이라면 업데이트 해줘야됨 */
			localStorage.setItem('boardList',JSON.stringify(boardList));
			//페이지전환 알림 (필수 아님)
			alert('수정했음')
			location.href="view.jsp"
			
		break}
	}
	
	//어떻게(새롭게 입력 받은 값)
	
	
	//수정/대입
}
