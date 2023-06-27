/*
- 과제3 : 가계부 만들기 ( 과제3.HTML , 과제3.JS , 과제3.CSS )
요구사항
   - 1.배열 3개 사용 ( 날짜배열 , 항목배열 , 금액배열 ) / 객체X { }
   - 2.함수 3개 이상 정의해서 구현 
   - 3.총합계는 계산해서 테이블 가장 하단에 출력하시오.
   - 4. 해당 삭제 버튼 클릭시 해당 항목 제거 
   - 5. 출력시 숫자를 천단위 쉼표로 출력하시오. [ toLocaleString() 함수( 천단위쉼표가 있는 문자열로 변환)  ]
      - let 금액 = 1200000
      - 금액.toLocaleString( ) => '1,200,000'
   - 6. css 적절하게 적당히 꾸며서 제출해주세요.

ex) 입력 예시 [ input 3개 사용 ]
   날짜 : <input type="date" />
   항목 : <input type="text" />
   금액 : <input type="text" />

ex) 출력 예시 [ table 사용 ]
   날짜         항목      금액         비고
   2023-06-06   콜라      300         삭제버튼
   2023-06-05   노트북   1,200,000   삭제버튼
   2023-06-03   교통비   1,750      삭제버튼
      -총합계-         1,202,050      
 */


// 입력받은 데이터 여러개를 저장하기 위한 배열. 함수 안에 넣으면 초기화 되기 때문에 밖에서 선언
let 날짜배열=[]
let 항목배열=[]
let 금액배열=[]

console.log('js열림')
출력();  // js 열렸을 때 최초 1번 실행


 //---------------------------<주요기능1-등록>-----------------------------
 //1. html 작성:  input 3개 button 1개
 //2. 클릭 이벤트(버튼을 클릭했을 때 입력 받은 3개를 저장하는 이벤트)
 //3. 구체적인 이벤트 내용물(함수정의)
 function 등록(){
	console.log('등록함수 클릭')
	//input에 입력된 3개의 데이터 가져옴 , dom객체 함수를 이용한 선택자의 마크업 객체로 호출 queryselector와 getelement~ 선택지 있음
	//선택자를 가지고 오기 때문에 html에 선택자가 있어야됨(class, id, 마크업)
	//html 작성 시 class랑 id 만들어 놓고 시작하는 걸 추천(dateInput, input date 등)
	
	let dateInput= document.querySelector(".date") ; console.log(dateInput)
	let nameInput= document.querySelector(".name"); console.log(nameInput)
	let moneyInput=document.querySelector(".money") ; console.log(moneyInput)
	
	//태그의 입력된 값 호출
	let date= dateInput.value;  console.log(date)
	let name= nameInput.value;	console.log(name)
	let money= moneyInput.value;	console.log(money)
	
	//유효성검사: 만약 3가지 중에 하나라도 공백이 있다면
	if(date==''||name==''||money==''){
		alert('미입력이 존재함[등록불가]')
		return; // 함수 강제 종료, 아래 코드 실행x
	}

	//가져온 것들을 배열에 저장
	//각 배열당 0번 인덱스가 날짜, 항목, 금액
	//함수 밖에 만들어야 사라지지 않음
	//배열저장  , 유효성 검사 하려면 배열 저장 전에 해주면 좋음.
	날짜배열.push(date);	console.log(날짜배열)
	항목배열.push(name);	console.log(항목배열)
	금액배열.push(money);	console.log(금액배열)
	
	//등록하고 출력이 있어야 비로소 변함.
	출력()
	
	//저장 성공시 input 상자 입력값을 초기화(추천)
	alert('항목 등록이 성공')
	dateInput.value=``
	nameInput.value=``
	moneyInput.value=``
 }
 
 
 //----------------------------<주요기능2-출력>--------------------------
 
 
 // 1. 출력 예상 html 작성
 // 2. 출력이벤트 만들기 : 입장했을 때(스크립트열렸을때) , 등록했을때(등록함수 안에 push 밑)
 // 3. 함수정의 , 함수 밖에 js 최초 열렸을 때 출력함수 한번 넣어줘야됨. 함수 밖에 출력()한번 써주셈 , 등록 성공했을때도 한번!
 function 출력(){console.log('가계부목록 출력함')
	 
	 //어디에 출력할건지. table 가져오기
	 let outputTable=document.querySelector('.outputTable')
	 
	 //테이블에서 thml 넣어주기. 무엇을 넣을건지
	 let html=	`<tr>
					<th>날짜</th>
					<th>항목</th>
					<th>가격</th>
					<th>비고</th>
				</tr>`
		
		for(let 인덱스=0;인덱스<날짜배열.length;인덱스++){
		
		html+= `<tr>
					<td>${날짜배열[인덱스]}</td>
					<td>${항목배열[인덱스]}</td>
					<td>${Number(금액배열[인덱스]).toLocaleString()}원</td>
					<td><button onclick="삭제(${인덱스})">삭제</button></td>
				</tr>`
			}	
		// 위 요구사항에 총액 출력이 있음. 금액배열에 있는 데이터를 모두 더하기
		let 총합계 =0;
		for(let 인덱스=0;인덱스<금액배열.length;인덱스++){
			console.log(인덱스) // 배열에 저장된 순서번호
			console.log(금액배열[인덱스]) 
			총합계+=Number(금액배열[인덱스])
		}
		html+=`<tr>
					<td colspan="2">총합계</td>
					<td colspan="2">${총합계.toLocaleString()}원</td>
			 </tr>`
	 //html에 넣어주기 (table은 value가 없기 때문에 innerHTML 사용)
	 outputTable.innerHTML=html;	 
 }
 
 
 //-------------------------------<주요기능3-삭제>--------------------------
 // 1. html 만들기: 앞서 삭제 버튼을 만들어덨음
 // 2. 삭제 이벤트 언제 발생? : 버튼을 클릭했을 때
 
 function 삭제(삭제할인덱스번호){
	 console.log('삭제할인덱스번화: '+삭제할인덱스번호)
	 날짜배열.splice(삭제할인덱스번호,1)
	 항목배열.splice(삭제할인덱스번호,1)
	 금액배열.splice(삭제할인덱스번호,1)   
	 //화면 업데이트(새로고침)
	 출력()
 }
 