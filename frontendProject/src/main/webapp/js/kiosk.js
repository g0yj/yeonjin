console.log('js열림')

// 1. 광고 이미지 변경

// 1-1 광고 이미지 여러개= 배열
let bimgList=['himg1.png','himg2.png','himg3.jpg','himg4.png','himg5.png']
//1-2 특정시간마다 이미지 변경
//1-2 -> setInterval(함수/기능, 밀리초)
			//function 함수() , function(){} , ()=>{}
//setInterval(()=>{실행코드},2000) //2초마다 실행코드가 주기적으로 실행됨


let viewhimg=0; //현재 출력중인 광고 이미지 인덱스 저장하고 있는 변수.


setInterval(()=>{
	//1. 어디에 : 해당 이미지 태그 객체 호출
let himg= document.querySelector('.himg');
	//2. 호출 : 호출된 객체에서 src 속성 대입(바꿔치기)
	//        -> 배열내 이미지 하나씩 대입 :setinterval밖에다 변수 선언(11번줄)
	viewhimg++; //인덱스 증가시킴
		//마지막인덱스 다음이면 처음인덱스로 이동
		if(viewhimg>=bimgList.length){viewhimg=0;}
		himg.src=`../img/${bimgList[viewhimg]}`
},2000);




// 2. 카테고리 출력 [어디에 무엇을 출력?]함수---------------------------

//2-1 카테고리 여러개 저장하는 배열
let categoryList=['신제품(new)','프리미엄','와퍼&주니어','치킨&슈림프','올데이킹&킹모닝']

//2-2 카테고리 출력함수 정의
categoryPrint(0);  //최초 1번 실행[가장 앞에 잇는 카테고리 선택 가정]

function categoryPrint(selectNo){
	//2-2-1 : 어디에
	let categorymenu=document.querySelector('.categorymenu');
	//2-2-2: 무엇을
	let html=``
		//html 구성: 배열 내 모든 데이터를 li 형식으로 출력	
		for( let i = 0 ; i<categoryList.length ; i++ ){
		// 선택된카테고리(selectNo) 와 i 와 같으면 i번재 인덱스 선택된 카테고리 
		if( i == selectNo ){ html += `<li onclick="categorySelect( ${ i } )" class="categoryselect">${ categoryList[i] }</li>`  }
		else{ html += `<li onclick="categorySelect( ${ i } )" >${ categoryList[i] }</li>`  }
	}
		//2-2-3: 구성된 html 출력
		categorymenu.innerHTML=html;	
}
//2-3 카테고리 클릭 함수



// 3. 카테고리 클릭 함수[실행조건:1. li에서 클릭했을때]

function categorySelect(selectNo){
	//<li> 여러개 존재 하는데 무엇 선택했는지 식별
	console.log(selectNo)
	//0. 카테고리의 모든 li호출
	let categoryli=document.querySelectorAll('.categorymenu li');
		console.log(categoryli)
	//3-1 해당 선택된 인덱스의 class 추가//!!!js에서 class 추가/삭제 가능
		for(let i=0; i<categoryList.length;i++){
			//3-1-1 선택된 카테고리[selectNo]의 i번째 카테고리 찾기
			if(selectNo==i){
				//goekd li에 class 추가 dom객체명.classList.add('새로운 클래스명)
				categoryli[i].classList.add('categoryselect')
			}
			else{//해당 li에서 class 삭제  dom객체명.classList.remove('새로운 클래스명')
				categoryli[i].classList.remove('categoryselect')
			}			
		}
}
