<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>

	<!-- jsp파일 안에 다른 jsp 파일 import하기 -->
	<%@include file="header.jsp" %>

	
<!----------------------------------------- 캐러셀(bs): 이미지 슬라이드 -------------------------------------------------------------->
	<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
	   
	    <div class="carousel-item active" data-bs-interval="1000">
	      <img src=/jspweb/img/main/main.jpg class="d-block w-100" alt="...">
	    </div>
	   
	    <div class="carousel-item" data-bs-interval="2000">
	      <img src="/jspweb/img/main/main3.jpg" class="d-block w-100" alt="...">
	    </div>
	   
	    <div class="carousel-item">
	      <img src="/jspweb/img/main/main2.jpg" class="d-block w-100" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	
<!---------------------------------카드(bs): 다양한 컨텐츠를 표시하는 컨테이너[구역]------------------- -->
	<div class="container"><!-- container(bs) -->
		<div class=" productBox row row-cols-1 row-cols-md-4 g-4">
		  <!-- <div class="col">
		    <div class="card h-100">
		      <img src="/jspweb/img/main/main.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		      </div>
		    </div>
		  </div> -->
		  
	</div>
	
	</div>
	
	
	
	
	
	
	
	
	
	<%@include file="footer.jsp" %>
		
		<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>