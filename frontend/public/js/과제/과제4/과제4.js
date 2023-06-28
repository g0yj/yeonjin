/*

---------------글쓰기 페이지--------------------- 
 onclick : register()
- 정보 담기만 하면 되는 함수
- 객체로 담기
*/
//객체 배열 생성
let data=[]
// 함수
function register(){
	let name= document.querySelector('.name').value ; console.log('작성자: '+ name);
	let pw= document.querySelector('.pw').value ; console.log('비밀번호: '+ pw);
	let title= document.querySelector('.title').value ; console.log('제목: ' + title);
	let content= document.querySelector('.content').value ; console.log('내용: '+ content)
	
	let register_oj={ 작성자:name, 비밀번호:pw , 제목:title , 내용:content}; console.log('객체 만들어짐?!' +register_oj)
	
	data.push(register_oj); console.log('객체 배열 올라 갔는지 체크' +data)
	register_tb()

}



/*
-------------------글목록 페이지------------
onclick: register_tb()
- tr, th ,td 반복문 사용해서 만듦
onclick: click()
- 조회수 올라감
- 전달 받은 내용을 글보기 페이지에 전달
*/
function register_tb(){
	let table=document.querySelector('.table')
let html= `<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
			</tr>`

for(let i=0; i<data.length;i++){//????????????????

html+=`<tr>
			<td>${i+1}</td>  
			<td>${data[i].title}</td>  
  			<td>${data[i].name}</td> 
			<td>${data[i].pw}</td>  
			<td>${data[i].content}</td> 
</tr>`
}
table.innerHTML=html

}

/*
-------------------글보기 페이지--------------------
onclick: delete()
- 비밀번호확인. 객체.비밀번호== 입력받은 값
*/

 
 
 