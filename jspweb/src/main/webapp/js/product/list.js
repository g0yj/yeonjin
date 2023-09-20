console.log('list.jsp열림')

    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
        level : 14 // 지도의 확대 레벨
    });

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
/*    
$.ajax({
	url : "/jspweb/ProductInfoController" , method : "get" ,
	data : { type : "findByAll" },
	success : jsonArray => { console.log( jsonArray ); 
		var markers = jsonArray.map( (p) => {
	        return new kakao.maps.Marker({
	            position : new kakao.maps.LatLng( p.plat, p.plng )
	        });
	    });
		clusterer.addMarkers(markers);
	}
})*/
    
 /*   카카오api는 이렇게 나와있는데 우리한테 익숙한 ajax로 바꿨음!!
    $.get("/download/web/data/chicken.json", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.positions).map(function(i, position) {
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
            });
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });*/

    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
 
 
 //1. 현재 보고 있는 지도의 동서남북 좌표 얻기----------------------------------------------------------
 getInfo()       
 function getInfo() {//카카오 - <지도정보불러오기> 사용

    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    console.log(bounds) // 남서북동 순으로 되어있는 걸 확인 . 카카오문서도 참고

    
    let 동=map.getBounds().oa; console.log("동: "+동);
    let 서=map.getBounds().ha;  console.log("서: "+서);
    let 남=map.getBounds().qa; console.log("남: "+남 );
    let 북=map.getBounds().pa; console.log("북: "+북);
    
    // 개발자도구를 통해 직접 message 내용을 확인해 보세요.
     //console.log(message);
	
	findByLatLng(동,서,남,북);

}   

//2. 해당 동서남북 좌표에 범위 내 제품만 출력--------------------------------------------------------
function findByLatLng(east,west,south,north){
	  //*클러스터 내 모든 마커 초기화
	  clusterer.clear(); // 안해주면 드래그할 때마다 숫자 증가함.
	   $.ajax({
      	url : "/jspweb/ProdectInfoController",     
     	method : "get",   
     	async:false ,/* ajax는 기본적으로 비동기(결과를 기다리지 않음.기본값true) 통신임. false를 넣는 건 동기화하겠다는 걸 의미 */
     		// 3번 드래그하는 것 보다 ajax 시간이 길어질 수 있으니 동기화 시킬 걸 추천
     	data : {type:"findByLatLng",
     			east:east,
     			west:west,
     			south:south,
     			north:north
     		},      
      	success : jsonArray=>{console.log('통신성공'+jsonArray)
      		//---------1. 마커를 생성해서 클러스터에 저장---------------
      		var markers =jsonArray.map((p)=>{
				  console.log(p)
				  return new kakao.maps.Marker({
					  position: new kakao.maps.LatLng(p.plat, p.plng )
				  });
			  });
			  clusterer.addMarkers(markers);
			 //---------2.사이드바에 제품 출력-----------------------//
			 let sidebar=document.querySelector('.sidebar');
			 let html=``;
			 
			 	//
			 	jsonArray.forEach((p)=>{
					html+=`
					<div class="card mb-3" style="max-width: 540px;"> 
					  <div class="row g-0">
					    <div class="col-md-5">
					      <a href="/jspweb/product/view.jsp?pno=${p.pno}">
					      	<img src="/jspweb/product/img/${Object.values(p.imgList)[0]}" class="img-fluid rounded-start" alt="...">
					      </a>
					    </div>
					    <div class="col-md-7">
					      <div class="card-body">
					        <h5 class="card-title">${p.pname}</h5>
					        <p class="card-text">
					        	<div>${p.pcontent}</div>
					        	<div>${p.pprice.toLocaleString()}원</div>
					        </p>
					      </div>
					    </div>
					  </div>
					</div>
					 `
				 });
				 sidebar.innerHTML=html;
      	}         
   });//ajax
}    


    





//3. 카카오지도에서 드래그를 하고 끝났을 때 1번함수 재실행 (1번함수가 동서남북 구해주고 2번함수가 실행)-------------
		//문서-drag검색-dragend 사용
kakao.maps.event.addListener(map, 'dragend', function() {
    // do something
    getInfo();
});