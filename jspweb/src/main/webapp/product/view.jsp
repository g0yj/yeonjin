<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<link href="../css/product/view.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>

<!-- *상세 페이지는 링크 타고 들어가기 때문에 pno 값이 없으면 view에서 출력이 안됨. 매개변수를 주거나 다른 페이지에서 켜고 링크 타고 들어가야됨. -->

	<%@include file="../header.jsp"%>
	<div class="webcontent">
		<div class="productBox">

			<!-- 캐러셀 -->
			<div id="carouselExample" class="carousel slide">
				<!-- 캐러셀 : 이미지슬라이드  -->

				<div class="imgbox carousel-inner">
					<!-- carousel-inner : 캐러셀 안에 넣을 이미지 목록 구역   -->
					<!-- carousel-item : 이미지1개당 / active : 현재 보고있는 이미지를 표현해주는 css클래스명  -->
				</div>

				<!-- 왼쪽 이동 버튼 -->
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExample" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<!-- 오른쪽 이동 버튼 -->
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExample" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span> 
				</button>

			</div>
			<!-- 캐러셀 end  -->
			<div class="mid">판매자 : 강호동</div>
			<div class="categorydate">
				<div class="pcname">카테고리</div>
				<div class="pdate">등록일</div> 
			</div>
			<div class="pname">노트북 팝니다.</div>
			<div class="pprice">657,000원</div>
			<div class="pcontent">
				노트북 팝니다.노트북 팝니다.<br>노트북 팝니다.노트북 팝니다.노트북 팝니다.
			</div>
			<div class="etcbtnbox"><!-- 버튼 css: 의사클래스 사용 -->
				<button type="button" onclick="setWish()">찜하기<span class="wish">1</span></button>
				<button type="button">바로구매</button>
			</div>
			
			<!-- bs 탭스기능 -->
			<ul class="mt-5 nav nav-tabs" id="myTab" role="tablist">
			 	<!-- 탭 1개목록  data-bs-target : 탭 버튼을 눌렀을 시 활성화 되는 탭내용의 id-->
			  <li class="nav-item" role="presentation">
			    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">제품위치</button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">제품후기</button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact-tab-pane" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">Q&A</button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="disabled-tab" data-bs-toggle="tab" data-bs-target="#disabled-tab-pane" type="button" role="tab" aria-controls="disabled-tab-pane" aria-selected="false" disabled>Disabled</button>
			  </li>
			</ul>
				<!-- 탭내용 -->
			<div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">...</div>
			  <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">...</div>
			  <div class="tab-pane fade" id="contact-tab-pane" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">...</div>
			  <div class="tab-pane fade" id="disabled-tab-pane" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">...</div>
			</div>
			
		</div>
	</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51d7cc458129199f074655a9b837dbe3&libraries=clusterer"></script>
	<script src="../js/product/view.js"type="text/javascript"></script>
</body>
</html>