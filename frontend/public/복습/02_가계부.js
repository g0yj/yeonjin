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
let 날짜=[]
let 항목=[]
let 금액=[]

//-------------등록함수---------------------
function 등록(){
	let inputDate= document.querySelector('.inputDate').value; console.log('날짜 받아옴: '+inputDate)
	let inputName= document.querySelector('.inputName').value; console.log('항목 받아옴: '+inputName)
	let inputMoney= document.querySelector('.inputMoney').value; console.log('금액 받아옴: '+inputMoney)
	
	날짜.push(inputDate)
	항목.push(inputName)
	금액.push(inputMoney)
	
	출력();
	
	alert('등록 완료')
	
	inputDate=``
	inputName=``
	inputMoney=``
	
	
}


//--------------------출력함수----------------------------
function 출력(){ console.log('가계부 출력 ㄱ?')
	let table= document.querySelector('.table')
	
	let html= 	`<tr>
					<th>날짜</th>
					<th>항목</th>
					<th>가격</th>
					<th>비고</th>
				</tr>`
		for(let i=0;i<날짜.length;i++){				
			html+= `<tr>
						<td>${날짜[i]}</td>
						<td>${항목[i]}</td>
						<td>${Number(금액[i])}</td>
						<td><button onclick="삭제(${i})">삭제</button></td>
					</tr>`	
					
					}// for문 끝

		table.innerHTML=html
				
						}	
						
						
						
//-------------삭제함수----------------------------------	
	
function 삭제(삭제인덱스){
	console.log('삭제할인덱스번호: '+삭제인덱스)
	날짜.splice(삭제인덱스,1)
	항목.splice(삭제인덱스,1)
	금액.splice(삭제인덱스,1)
	출력()
	}
