console.log('update.js 실행')

$(document).ready(function() {
  // $('#summernote').summernote( {설정객체} );
  $('#summernote').summernote( { 
	lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
	height : 500 , 
	placeholder : '여기에 내용작성'
  });
});



let no = localStorage.getItem( 'no' ); 
let List = JSON.parse( localStorage.getItem('qList') ) ; 

let select=['전체', '이용방법', '계정', '결제', '점포', '쿠폰']

//select 내 option 가져오기 / .form-select. 제목이나 내용은 앞에서 가져온거고 선택은 다시 보여주는거임.


let mselect= document.querySelector('.v_selectInput');
let html='';
	
		for(let i=0; i<select.length; i++){
		html+= 
			`<option>${select[i]}</option>`;
				}		
mselect.innerHTML=html;

onView() 


// 함수
function onView(){ console.log('onView 함수 실행')  
	
	// 어디에 받을건지  / 복붙할때 JS를 가져오다보니 JSP의 클래스 명이 달랐음. console 잘 찍기
	let v_title= document.querySelector('.v_title')
	let v_content=document.querySelector('.v_content')
	
	console.log(v_title)
	console.log(v_content)
	
	console.log(List)
	for(let i=0; i<List.length;i++){
		let q= List[i]
		
		console.log(q)
		
		if(q.no==no){
			v_title.value=q.title;
			v_content.value=q.content;
			break;
			
		}
	}
	
}



// 수정함수-------------------------------
function onUpdate(){ console.log('update 함수 실행')
	 //qList로 자꾸 했는데 전역변수에 let List = JSON.parse( localStorage.getItem('qList') ) ; 가져왔었음
	for(let i = 0 ; i<List.length ; i++ ){
		let q = List[i];
			if( q.no == no ){// 현재 보고 있는 게시물
			// 새롭게 입력받은 값 
		let title= document.querySelector('.v_title').value  ; console.log(title)
		let content=document.querySelector('#summernote').value ; console.log(content)
		let selectInput=document.querySelector('.v_selectInput').value ; console.log(selectInput)
		
		//수정에서 날짜 변경할 일 없음. 빼기
		//let date=document.querySelector('.v_date').value
			// 수정/대입 
			q.title = title  ; console.log(q.title)
			q.content = content;console.log(q.content)
			q.selectInput=selectInput; console.log(q.selectInput)
	
			
			// 쿠키 업데이트/새롭게대입 
			localStorage.setItem( 'qList' , JSON.stringify( List ) );
			console.log(localStorage)
			// * 알림 , 페이지 전환
			alert('수정 했습니다.');  
			location.href="view_go.jsp"; 
			break;
		}
	}
	
}


	
