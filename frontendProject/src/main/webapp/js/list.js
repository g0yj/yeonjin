console.log('list.js')


let boardList = JSON.parse(localStorage.hetItem('boardList'))

if(boardList==null)board
boardList=[]

boardPrint()
//1. 게시물 출력 함수[페이지 js 열리면]
function boardPrint(){
	
	let tcontent= document.querySelector('.tcontent')
	
	let html= ``
	
	let board= boardList[i];
	for(let i=0; i<boardList.length;i++){
		html+=`<tr>
					<td>${board.no}</td><td>${board.title}</td><td>${board.writer}</td>
					<td>${board.data}</td><td>${board.view}</td><td>${board.like}</td>
				</tr>`
	}
	 tcontent.innerHTML=html;
}