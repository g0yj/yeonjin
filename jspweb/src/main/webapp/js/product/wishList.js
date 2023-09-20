/* 
	1. document.querySelector(선택자); : 해당 선택자의 dom객체로 가져오기
	2. document.quertSelectorAll(선택자): 해당 선택자의 dom객체를 여러개 가져오기 [배열]

*/


getWishProductList() // 0번을 하기 위해서는 이 함수가 먼저 시행되어야함.
						//만약 ajax가 비동기[astnc:true]이면 해당 함수를 실행하고 ajax결과가 오기 전에 아래 코드가 실행
						//만약 동기이면 해당 함수를 실행하고 ajax결과가 오기전까지 대기상태
let checkIndex=[]; // 현재 체크된 인덱스들 (삭제 , 구매 등 기능을 위해 필요)
/*0.제품목록에서의 선택 상자 모두 체크 기능 */	
 	//1. 모든 checkbox 가져오기
	let checkList= document.querySelectorAll('.checkbox');
		console.log(checkList) // getWishProductList() 위에 안 넣었으면 출력 안됨
	//2. 첫번째 체크박스를 클릭 이벤트
		//dom객체명.addEventListener('이벤트명', (이벤트결과매개변수)=>{})	
	checkList[0].addEventListener('click',(e)=>{
		console.log('첫번째 체크박스를 클랙했음');console.log(e);
		//type="checkbox"인 input태그는 checked속성 이용한 체크여부 확인
		console.log(checkList[0].checked);//checked 속성(html이 가지고 있는거임) 이용한 체크여부 확인. true:체크되어있는 상태
	//3. 만약에 첫번째 체크박스가 체크 되면 모든 체크박스는 체크 활성화
	if(checkList[0].checked==true){
		checkList.forEach((check)=>{check.checked=true;})
	}else{
		checkList.forEach((check)=>{check.checked=false;})
	}
		
	})




if(loginState==false){location.href="/jspweb/member/login.jsp"}
//1. 찜한 제품 목록 출력

function getWishProductList(){
	
	$.ajax({
      	url : "/jspweb/PwishListController",     
     	async:false,
     	method : "get",   
     	data : {type:"findByAll"},      
      	success : r=>{console.log('통신성공'+r)
			let table = document.querySelector('.table');
			let html =``
			html=`
				<tr>
					<th width="5%"><input class="checkbox" type="checkbox"></th>
					<th width="5%">이미지</th>
					<th width="40%">상품정보</th>
					<th width="10%">가격</th>
					<th width="10%">비고</th>
				</tr>
			`
			r.forEach((p)=>{
				
			html+=`
			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td><img src="/jspweb/product/img/${Object.values(p.imgList)[0]}" width="100%"></td>
				<td style="text-align: left; padding-left: 20px;">${p.pname}</td>
				<td>${p.pprice.toLocaleString()}원</td>
				<td><button onclick="deleteWish(${p.pno})" type="button">x</button></td>
			</tr>`
				
				
				
			});
			table.innerHTML=html;
 
      	}        
         
   });

	
}//f()


//2. x버튼을 눌렀을 때 개별 찜 제품 취소/제거
function deleteWish(pno){}