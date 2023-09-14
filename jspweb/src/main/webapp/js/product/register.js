console.log('등록페이지 실행')

/*
	<FormData> 객체에 데이터 추가/삭제하는 방법
	

 */


//제품등록은 회원제이므로 비로그인시 접근 제한
if(loginState==false){alert('로그인 후 사용');location.href="/jspweb/index.jsp"}

//-----------------카카오 지도 표시--------------------------------------//
	//1. 현재 접속한 사용자(클라이언트의 브라우저의 위치) 위치 좌표 구하기
	navigator.geolocation.getCurrentPosition(e=>{
		console.log(e);
		console.log(e.coords);
		console.log(e.coords.latitude);//위도
		console.log(e.coords.longitude);//경도
		let currentlat=e.coords.latitude;
		let currentlon=e.coords.longitude;
		
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(currentlat, currentlon), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		// 지도를 클릭한 위치에 표출할 마커입니다
		var marker = new kakao.maps.Marker({ 
		    // 지도 중심좌표에 마커를 생성합니다 
		    position: map.getCenter() 
		}); 
		// 지도에 마커를 표시합니다
		marker.setMap(map);
		
		// 지도에 클릭 이벤트를 등록합니다
		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
		    
		    // 클릭한 위도, 경도 정보를 가져옵니다 
		    var latlng = mouseEvent.latLng; 
		    
		    // 마커 위치를 클릭한 위치로 옮깁니다
		    marker.setPosition(latlng);
		    
		    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
		    message += '경도는 ' + latlng.getLng() + ' 입니다';
		    
		    var resultDiv = document.getElementById('clickLatlng'); 
		    resultDiv.innerHTML = message;
		  
		  현재위도=latlng.getLat();//위도와 경도를 전역변수로 이동 후 제품등록 시 사용
		  현재경도=latlng.getLng();
		  
		    
		});

})//	navigator.geolocation.getCurrentPosition(e=>{ 과 연결

//form으로 보내기 위해 위에서 얻어온 걸 전역변수로 사용
let 현재위도=0;	//현재 카카오지도에서 선택한 좌표
let 현재경도=0;

//1. 제품 등록-----------------------------------------------------------------------------
function onRegister(){
	
	//1. form dom객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0]; console.log(registerForm)
	
	//2. formData 객체 생성 [ ajax 전송타입: multipart/form-data]
	let formData= new FormData(registerForm); console.log(formData);
	
	
		//*카카오지도에서 선택된 좌표 사용했을 때,
		if(현재경도==0||현재위도==0){alert('제품위치를 선택해주세요');return;}
		
			formData.set('plat',현재위도)	//속성명은 dto 맞출 걸 추천!
			formData.set('plng',현재경도)
		
	
	
		//*드래그앤드랍을 사용했을 때, 현재 드랍된 파일들을 form에 같이 가져가려면..!! [드랍된 파일은 input이 아니었음. div는 html형식임!]
			//이미지는 몇장일지 모르기 때문에 form전송 시 가장 아래에 배치해둬야 됨.
		if(fileList.length>=1){//드랍된 파일이 존재하면 
			fileList.forEach(f=>{
				//이렇게 전송하면 키 값 중복으로 여러개 못 들어감..!! 
				//formData.set('fileList',f); //폼 데이터 객체.set('키', 값) : 폼데이터 객체에 데이터를 추가하는 방법(키값은 중복이 안됨에 유의! 기존의 동일한 키가 있으면 덮어쓰기. 즉, 기존의 것이 사라짐)
				formData.append('fileList',f); //폼데이터객체.append('키',값 ): 기존에 동일한 키가 있으면 기존 데이터에 추가로 들어감
			})
		}
	//3.
	$.ajax({
	      	url : "/jspweb/ProdectInfoController",     
	     	method : "post",   
	     	data : formData,      
	    	contentType:false, //ajax전송타입: multipart/form-data이니까 false
	    	processData:false,
	      	success : r=>{console.log('통신성공'+r)
	      		if( r == true ){
					alert('제품등록성공');
					location.href="/jspweb/index.jsp";
				}else{
					alert('제품등록실패');
			}
	      	} ,       
	      	error : e=>{console.log('통신실패'+e)} ,         
	   });

}//f()


// 드래그 앤 드랍 (2번함수 아래에 있음!! e=> 어쩌구 쪽)---------------------------------------------------------------------------
	// onclick 함수 같은 건 제공되는 걸로 함수임. 우리는 클릭 시 실행되는 함수를 만들어왔던건데... 제공되는 onclick 함수에서
	//필요한 정보들을 가져와서 커스텀해서 사용해보자!! 

	//1. 드래그 앤 드랍 할 구역 dom 객체 호출
	let fileDropBox = document.querySelector('.fileDropBox');
	//2. 해당 dom 객체에 구역 내 드래그가 들어왔을 때
	fileDropBox.addEventListener("dragenter", (e)=>{console.log('드래그가 들어왔을 때'+e)
	e.preventDefault();// 상위 이벤트 무시하고 현 이벤트 우선 점유
	})
	//3. 해당 dom객체에 구역 내 드래그가 올라왔을때
	fileDropBox.addEventListener("dragover",(e)=>{console.log('드래그가 위치 중'+e);
		fileDropBox.style.backgroundColor ='#e8e8e8';
		e.preventDefault();// 상위 이벤트 무시하고 현 이벤트 우선 점유
		})
	//4. 
	fileDropBox.addEventListener("dragleave",(e)=>{
		e.preventDefault();// 상위 이벤트 무시하고 현 이벤트 우선 점유
		console.log('드래그가 나갔을 때'+e);
		fileDropBox.style.backgroundColor ='#ffffff'
	})
	//5.
	fileDropBox.addEventListener("drop",(e)=>{//e: 이벤트 함수에서 제공되는 함수의 결과.
		console.log('해당 드래그가 drop했음'+e);
		console.log(e);
	//*브라우저는 자체적으로 'drop' 이벤트를 실행하고 있음. 우선적으로 실행되기 때문에 해당 이벤트 실행이 불가능. (웨일은 파일 다운, 크롬은 파일열림)
	// - 해결 방안 : 기존 상위 (브라우저) 이벤트 무시
	e.preventDefault();// 상위 이벤트 무시하고 현 이벤트 우선 점유
	console.log(e); // drop된 이벤트에 대한 정보를 얻을 수 있음. drop(onclick 등)은 js에 제공되는 거임.
	
	//---------드랍된 파일의 정보??--------------------------//
		//1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log(e.dataTransfer)
		console.log(e.dataTransfer.files)
		console.log(e.dataTransfer.files[0])
		console.log(e.dataTransfer.files[0].name)
		//
		let files= e.dataTransfer.files;
		for(let i=0; i<files.length;i++){
			if(files[i]!=null&&files[i]!=undefined){
				//드랍된 파일의 정보가 존재하면 [null 그리고 undefined 아닌 상태]
				fileList.push(files[i]);
			}
		}
		//3. 배경색 초기화
		fileDropBox.style.backgroundColor ='#ffffff'
		//4. 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시
		fileListPrint();
	});//f()


let fileList=[];//현재 드래그앤드랍으로 등록된 파일들	

//3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수-------------------------------------------------------------------------------------------	
function fileListPrint(){
	//1. 어디에 fileDropBox에 [fileDropBox dom객체가 함수 밖에 있으므로 재호출하지 않겠음]
	//2. 무엇을 html구성
	let html=``;
		fileList.forEach((f,i)=>{
			let fname=f.name; //파일의 이름. console 찍으면 속성들 알 수 있으니 확인하고 사용하기
			let fsize=(f.size/1024).toFixed(1)//파일의 용량[바이트단위]를 KB로 변환
									//.toFixed(소수점단위) : JS에서 제공하는 함수. 소수점 자르기
		html+=`
				<div>
					<span>${fname}</span>
					<span>${fsize}</span>
					<span><button onclick="fileDelete(${i})" type="button">삭제</button></span>
				</div>
		  `	
		})
	//3.대입
	fileDropBox.innerHTML=html;	
} //f()

//4. 현재 드랍된 파일들 중에 삭제 버튼 클릭 시 해당 파일 제거-------------------------------------------	

function fileDelete(i){ fileList.splice(i,1); fileListPrint();
	
}//f()
	
	
/*
			
	<dom 객체 이벤트 추가하는 방법 2가지>- 가정: 특정 구역에 클릭 이벤트 추가
	1. HTML 속성 이벤트 사용 
		<butto onclick="함수명()"></button>
	2..addEventListener('이벤트명', 함수) 사용하는 방법
		let button= document.querySelector('.button');
		button.addEventListener("onclick()",)

	<이벤트>
		- 종류: click ,keyup,keydown 등등
		- 정의: 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트의 결과물을 반환 해주는 구조
		-
	
	
	
		<드래그 앤 드랍 관련 이벤트>
			1. dragenter
			2. dragover
			3. dragleave
			4. drop
	
	 */



/*	
//1.
function register1(){
	
	$.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "post",   
     	data : {
			 pname1: document.querySelector('.pname1').value,
			 pcontent1: document.querySelector('.pcontent1').value,
			 
			 
		 },      
      	success : r=>{console.log('통신성공')} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()

//2.
function register2(){
	let registerForm1 = document.querySelectorAll('.registerForm1');
	let formData = new FormData(registerForm1);

	$.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "post",   
     	data : formData,
     	//data 전송 타입: 1.text/html, 2.application/json, 3.multipart/form-data
     	contentType:false,
    	processData:false,
      	success : r=>{console.log('통신성공')} ,       
      	error : e=>{console.log(e)} ,         
   });

}//f()


*/

