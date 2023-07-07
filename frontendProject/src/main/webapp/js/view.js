

//1. list.js에서 클릭된 게시물 번호 호출[세션]
let no= sessionStorage.getItem('no');
let boardList=JSON.parse(localStorage.getItem('boardList'))
console.log('list.js에서 저장된 세션정보: '+no)
onView()
//2. 클릭된 게시물번호의 게시물 찾아서 출력
function onView(){
	//식별자: 인덱스, 게시물번호=인덱스 찾기
	
	//1. 어디에
	let title = document.querySelector('.title')
	let writerdate = document.querySelector('.writerdate')
	let content = document.querySelector('.content')
	
	//2. 무엇을
	//1. 해당하는 게시물번호의 게시물 찾기
	for(let i=0; i<boardList.length;i++){
		let b= boardList[i] //i 번째 게시물을 꺼내기
		if(b.no==no){
			//만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log(b);
			//3. 대입
			title.innerHTML=b.title
			writerdate.innerHTML=`작성자: ${b.writer} 작성일: ${b.date}`
			content.innerHTML=b.content
			break; // 가장 반복문 종료
		}
	}
}


//현재 보고 있는 게시물 삭제하기 [실행조건: 삭제하기 버튼을 클릭했을 때]
function onDelete(){// 인수 필요 없음. 삭제할 식별자가 없음. 전역 변수에 있기 때문에
	//1. 삭제할 게시물 찾기
	for(let i=0; i<boardList.length;i++){
		//2. 클릭된 게시물(현재 보고 있는 게시물)와 i번째 게시물과 번호가 같으면
		if(no==boardList[i].no){
			//3. 삭제하기
			boardList.splice(i,1); // i번째 인덱스 1개 삭제
			
				/*배열에 변화된 결과를 쿠키에 반영 : 4번 해도 쿠키는 그대로 남아있음.
				쿠키는 자바스크립트 메모리가 아님. 변환해서 다시 한번 적용해야됨*/
				localStorage.setItem('boardList', JSON.stringify(boardList))
				/* 클릭된 게시물이 삭제했으면 클릭된 게시물 번호가 ㅈ장된 세션 삭제*/
				sessionStorage.removeItem('no')
				//페이지전환
				location.href="list.jsp"
			//4. 삭제 후 다음 인덱스는 확인 할 필요가 없음
			break;
		}
	}
	
	
}