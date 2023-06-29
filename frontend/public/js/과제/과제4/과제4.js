// 객체 담을 배열
let boardlist=[]
// 첫 화면을 보여주기 위한 출력함수
onPrint()

//1.글등록함수
function onWrite(){
	console.log('js 시작')
	let writerValue=document.querySelector('#writer').value
	let passwordValue=document.querySelector('#password').value
	let titleValue=document.querySelector('#title').value
	let contentValue=document.querySelector('#content').value
	console.log('변수 선언 성공 ' + writerValue +passwordValue+titleValue+ contentValue);
	
	//1-1 객체 생성
	let board = {writer : writerValue ,
				 password : passwordValue ,
				 title : titleValue ,
				 content : contentValue  ,
				 date : new Date(), 
				  view : 0 }
	//1-2 객체 배열에 push 		  
	boardlist.push(board) ; console.log('객체 배열 확인'+ boardlist)
				  
	//1-3 글 목록 페이지에 나타내기 위한 함수			  
	onPrint()
	  
				  
}//onWrite() 끝



//-----------------------------------------
//2. 출력 함수
function onPrint(){ console.log('onPrint()함수' )
	//2-1 value값 테이블로 받아오기
	let boardTable= document.querySelector('#boardTable')
	//2-2 테이블 생성 , for문 사용
	let html=
	`<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
	</tr>`

		for(let i=0; i<boardlist.length;i++){
			
			let board=boardlist[i]
		// 제목 클릭하면 글보기 페이지로 넘겨야됨	
		html+=`<tr>
				<td>${i+1}</td>
				<td onclick="onView(${i})">${board.title}</td>  
				<td>${board.writer}</td>
				<td>${board.date}</td>
				<td>${board.view}</td>
				</tr>	`
	}
	boardTable.innerHTML=html
	
}


//3. 보여주기 함수. onView()
function onView(index){
	// html 테이블 가져오기
	let viewbox=document.querySelector('#viewbox')
	// 객체를 보여주기 위한 변수 선언
	let board=boardlist[index] // index: 전달 받은 인덱스의 객체
	// 보여지는 페이지 내용
	let html=`<div>제목: ${board.title}</div>
			 <div>내용: ${board.title}</div>
			 <div>작성자: ${board.title}</div>
			 <button onclick="onDelete(${index})">삭제</button>`
	viewbox.innerHTML=html
	//조회수 증가
	board.view++
	// 조회수 증가 모습 보여주는 출력()
	onPrint()
}


//---------------------------------------------------
//4. 삭제함수
function onDelete(index){
	//해당 index 안에 있는 객체
	let board=boardlist[index]
	
	let password=prompt('비밀번호: ')
	
	if(board.password==password){
		boardlist.splice(index, 1) // 배열 삭제= 객체가 삭제됨
		// 삭제한 뒤 모습 새로고침
		onPrint()
		//삭제했으니까 글 보이기 페이지에서도 사라져야됨. ``을 사용해서 빈 공간으로 만들어줌
		document.querySelector('#viewbox').innerHTML=`` 
	}	
	
}