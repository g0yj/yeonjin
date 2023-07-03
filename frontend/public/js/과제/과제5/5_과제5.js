//1. 제어할 dom 객체 가져옴 . html 태그 호출
let userbox= document.querySelector('.userbox');
// 유저 위치 = x좌표
let u_left=50;

//어떻게 : 키보드를 누를때
// dom객체명.addEventListner('이벤트명' , ()=>{})
// div는 keydown 시킬수 없음(userbox.addEventListert 안됨)
document.body.addEventListener('keydown',(e)=>{
	console.log('키눌림');
	
	//1. 눌린 키상태 확인. e.keyCode 사용
	console.log('e') // 키다운 이벤트 상태 객체
	
		// 만약 왼쪽, 오른쪽 키를 눌렀을 때 css left 변경
		if(e.keyCode==37){console.log('왼쪽으로 이동')
			u_left-=10;
			//유효성검사[배경 밖으로 못 나가게]
			if(u_left<0){u_left=0;}  // 위치가 0보다 작아지면 0으로 고정
			
			
		}else if(e.keyCode==39){
			console.log('오른쪽으로 이동')
			u_left+=10;
			if(u_left>900){u_left=900;};
			userbox.style.backgroundImage=`url(img/캐릭터_이동.png)`
		}else if(e.keyCode==65){//a키를 눌렀을 때
			console.log('공격');
			userbox.style.backgroundImage=`url(img/캐릭터_공격.png)`;  //a 눌렀을 때 공격 이미지 출력
		}
		//3. 현재 위치값을 대입
		userbox.style.left=`${u_left}px`
		
		//확인
		console.log(userbox.style.left)
})


//2. 키를 누르고 떼었을 때 (keyup)
document.body.addEventListener('keyup', (e)=>{
	//원래 기본 이미지로 변경
	userbox.style.backgroundImage=`url(img/캐릭터.png)`
})
