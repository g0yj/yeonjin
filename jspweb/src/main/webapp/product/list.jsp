<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/product/list.css" rel ="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>

	<div class="mapcontent">	<!-- 지도와 사이드바 포함된 구역 -->
		<!-- 지도표시구역 -->
		<div id="map" ></div>
		

		<!-- 사이드바 구역 -->
		<div class="sidebar">
		
			<!-- 카드 start -->
			<!-- <div class="card mb-3" style="max-width: 540px;"> mb-3:아래마진 , m:margin , b:bottom
			  <div class="row g-0">row:flex역할-하위 요소를 가로 배치 / g-0:여백(간격)제거
			    <div class="col-md-4">구역마다 12그리드를 사용(12개의 col이존재)
			      <img src="..." class="img-fluid rounded-start" alt="...">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <h5 class="card-title">Card title</h5>
			        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
			      </div>
			    </div>
			  </div>
			</div> -->
		
		
		</div>
		

	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51d7cc458129199f074655a9b837dbe3&libraries=clusterer"></script>
	<script src="../js/product/list.js"type="text/javascript"></script>
</body>
</html>