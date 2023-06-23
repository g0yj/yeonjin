//배열 선언
let 회원리스트 =[]

//onclick 시 이벤트 실행 함수
function 회원가입(){
//input 객체 호출	
	let idInput=document.querySelector(".id")
	let pwInput=document.querySelector(".pw")
	
//입력 받을 데이터 가져오기	
	
	let joinId=idInput.value
	let joinPw=pwInput.value
	
//입력받은 데이터를 배열에 추가
	회원리스트.push(joinId)
	회원리스트.push(joinPw)

	idInput.value=''
	pwInput.value=''
	
	
}



let 회원리스트1=[]
function 로그인(){
	let idInput=document.querySelector(".id1")
	let pwInput=document.querySelector(".pw1")
	
	let joinId1=idInput.value
	let joinPw1=pwInput.value
	
	
	학생리스트1.indexOf(joinId1) !=-1? alert('실패') : 학생리스트1.push(joinId1)
	학생리스트1.indexOf(joinPw1) !=-1? alert('실패') : 학생리스트1.push(joinPw1)
	
	idInput.value=''
	pwInput.value=''	

}	
