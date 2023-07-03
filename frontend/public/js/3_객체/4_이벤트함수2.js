
// 1. select 목록상자에서 선택된 value 가져오기

let selectbox =document.querySelector('.selectbox')

// 이벤트 등록
selectbox.addEventListener('change')



//2.

let checkbox = document.querySelector('.checkbox')

//이벤트 등록
checkbox.addEventListener('change',()=>{
		console.log('체크상자가 변경됨')
		console.log(checkbox.checked)   //체크여부(t/f)
})




//3. 타이머 예제
//3-1 해당 태그 호출
let timer=document.querySelector('.timer');
let timerbox=document.querySelector('.timerbox')

//3-2 시간 함수에 필요한 변수
let time=0;
let timerId=0  // 타이머 함수가 저장되는 변수


//이벤트 등록
timer.addEventListener('change', ()=>{
		timerbox.innerHTML='체크'
		
		//만약 체크박스에 체크가 되어 있으면
		if(timer.checked){
			
			setInterval(()=>{
				
				//만약 체크박스에 체크가 있으면
				if(timer.checked){
					setInterval(()=>{
						time++ //변수 1씩 증가
						timerbox.innerHTML=`$[time}초`
					})
				}
			},1000)
			
		//체크가 없으면	
		}else{}
})

/*setInterval(): 특정시간마다 특정 함수 재호출 함수 
			setInterval(함수, 시간)
			
		함수
			1. 기존함수명			fuction 함수명(){}
			2. ()=>{}			
			3.function(){}
			
			시간: 밀리초[1초/1000초]
			
			
			
			
			
				
			*/