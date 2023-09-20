console.log('메인페이지열림')


findByTop(10);//메인페이지에 최신 등록된 제품 10개 출력
//1. n개 제품들을 최신순으로 출력
function findByTop(count){
	  $.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	data : {type:"findByTop", count:count},      
      	success : jsonArray =>{console.log('통신성공'+jsonArray)
      	
      		let productBox = document.querySelector('.productBox');
      		let html=``;
      			jsonArray.forEach((p)=>{
					  //*대표 이미지 출력[첫번째이미지] Object.keys(객체명) : 해당 객체 내 모든 속성명/필드명을 키를 리스트로 반환
					  let firstImg= Object.values(p.imgList)[0];
					  html+=`
						<div class="col">
						    <div class="card" style="height:450px; border:none;">
						    <a href="/jspweb/product/view.jsp?pno=${p.pno}">
						      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
						    </a>
						      <div class="card-body">
						        <h5 class="card-title">${p.pname}</h5>
						        <p class="card-text">
						        	${p.pprice.toLocaleString()}원
						        </p>
						      </div>
						    </div>
						  </div>
					  `
					  
				  });
				  productBox.innerHTML=html;
      	
      	
      	
      	} ,       
      	error : e=>{console.log(e)} ,         
   });
}
/*
	★자바스크립트 객체
		-형태: let 변수명={키:데이터, 키:데이터, 키:데이터}
				(데이터: 데이터,변수,함수,배열,리스트 등등)
			객체명.새로운필드명= 데이터 
			delete 객체명.삭제할 속성명
				*사용자정의 함수(우리가만들어쓰는) 중에 delete라는 이름으로 선언 불가능
			객체명.속성명 : 호출 
			객체명['속성명']:호출	
				-Object.keys(객체명) : 객체내 모든 키를 배열로 반환
				-Object.values(객체명): 객체내 모든 값을 배열로 반환


	
	★자바스크립트 배열/리스트
		-형태: let 변수명=[데이터,데이터,데이터]
			배열명.push(데이터) : 추가
			배열명.splice(인덱스, 개수): 삭제
			배열명[인덱스]: 호출
				-배열명.length: 배열의 길이


 */




//2.현재 카카오지도 내 보고 있는 동서남북 기준 내 제품들을 출력(list.js에서 사용함)
function findByLatLng(east,west,south,north){
	  $.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	data : {type:'findByTop' , east:east ,  west:west ,  south:south ,  north:north},      
      	success : jsonArray=>{console.log('통신성공'+jsonArray)} ,       
      	error : e=>{console.log(e)} ,         
   });

}

//3. 선택된 제품번호에 해당하는 제품 출력 함수
function findByPno(pno){
	  $.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	data : {type:'findByPno' , pno:pno},      
      	success : jsonObject=>{console.log('통신성공'+jsonObject)} ,       
      	error : e=>{console.log(e)} ,         
   });

}

//4. 모든 제품들을 출력
function findByAll(pno){
	$.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	data : {type:'findByAll'},      
      	success : jsonArray=>{console.log('통신성공'+jsonArray)} ,       
      	error : e=>{console.log(e)} ,         
   });

}