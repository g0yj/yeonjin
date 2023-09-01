<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!--css import -->
	<link href="accountbook.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp" %>

	<div class="webcontainer">
		<h3>고연진 가계부</h3>
		<div class="inputwrap"><!-- 입력 -->
			<input class="atext"type="text" placeholder="항목">
			<input class="apay"type="text" placeholder="금액">
			<button onclick="awrite()">등록</button>
		</div>
		<!-- 출력 -->
		<div class="printwrap">
	<!--  
			<div class="print">
				<div class="atext">고구마</div>
				<div class="apay">1000</div>
				<div class="adate">2023-02-12</div>
				<button onclick="aupdate()">수정</button>
				<button onclick="adelete()">삭제</button>
			</div>
	-->			
		</div>
</div>

	<!-- 최신 jquery import(ajax()를 사용할 js파일보다 위에 호출) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script src="accountbook.js"type="text/javascript"></script>
</body>
</html>