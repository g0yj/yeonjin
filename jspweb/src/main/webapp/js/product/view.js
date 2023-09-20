
//* 게시판상세페이지, 제품상세페이지에서는 클릭된 제품번호[식별자]
//URL(인터넷주소)에서 매개변수(쿼리스트링) 가져오기
let pno = new URL(location.href).searchParams.get("pno") //pno는 list.js 쿼리스트링의 키값과 맞춰야됨.

//1. pno 해당하는 제품1개 호출
findByPno(pno)
function findByPno(pno){
	
	$.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	data : {type:'findByPno' , pno:pno},      
      	success : jsonObject=>{
			  console.log('통신성공 ');
      		  console.log(jsonObject)
      		// 캐러셀에 이미지 여러개 대입--------------------------
      			let imgbox = document.querySelector('.imgbox')
      			let html=``;
      			Object.values( jsonObject.imgList).forEach((img,i)=>{
					  //첫번째 이미지에만 active 삽입
					  html+=`
					  	<div class="carousel-item ${ i==0 ? 'active' : '' }">
					      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
					    </div>
					  `
				  })
      			imgbox.innerHTML=html;
      			//----------각 위치에 데이터 넣어주기
      			document.querySelector('.mid').innerHTML=`판매자:${jsonObject.mid} `
      			document.querySelector('.pcname').innerHTML=`카테고리:${jsonObject.pcname} `
      			document.querySelector('.pdate').innerHTML=`등록일:${jsonObject.pdate} `
      			document.querySelector('.pname').innerHTML=`제목:${jsonObject.pname} `
      			document.querySelector('.pprice').innerHTML=`가격:${jsonObject.pprice} `
      			document.querySelector('.pcontent').innerHTML=`글내용:${jsonObject.pcontent} `
      		
      	}        
             
   });
	
	
	
}//f()

//2. 찜하기 [비회원제:ip주소/디바이스식별번호 , 회원제식별:header에있음]
function setWish(){
	//1. 회원제 유효성검사
	if(loginState==false){alert('로그인 후 가능함');return}
	//2. 
	$.ajax({
      	url : "/jspweb/PwishListController",     
     	method : "post",   
		async:false,//동기화
     	data : {pno:pno}, //로그인된 상태를 알고 있기 때문에 pno는 굳이 전달하지 않음.      
      	success : r=>{console.log('통신성공'+r)
      		if(r){getWish();}
      		else{}
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

	
	
}//f()

//3.찜하기 상태호출
getWish()
function getWish(){
	let wish=document.querySelector('.wish'); //<span> 구역
	
	//1.비회원이면 
	if(localStorage==false){wish.innerHTML='1'} //비로그인상태. 찜선택x
	//2. 
	$.ajax({
      	url : "/jspweb/PwishListController",     
     	method : "get",   
     	async : false ,	// 동기화
     	data : {type : "findByWish", pno:pno },      
      	success : r=>{console.log('통신성공'+r)
      		if(r){wish.innerHTML='2'} //찜선택
      		else{wish.innerHTML='1'}
      	} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()
