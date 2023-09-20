<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/product/wishList.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
	<%@include file="../header.jsp"%>
	
	<div class="container"> <!-- bs의 class : 디바이스 크기에 따른 반응형 구역-->
		<h3 class="my-5">찜 목록 현황</h3>
		<table class="table table-hover text-center align-middle"><!-- bs class -->

		
		</table>
		
		<div class="selectbtn">
			<button type="button">선택삭제</button>
			<button type="button">전체삭제</button>
		</div>

		<div class="buybtn">
			<button type="button">선택구매</button>
			<button type="button">전체구매</button>
		
		</div>	
	</div>
	
	
	
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51d7cc458129199f074655a9b837dbe3&libraries=clusterer"></script>
	<script src="../js/product/wishList.js"type="text/javascript"></script>
</body>
</html>