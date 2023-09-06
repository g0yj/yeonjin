<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/transaction/transactionAdd.css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="webcontainer"><!-- 웹전체 -->
	
	
	<!-- 매수/매도 -->
		<div class="#">
			<select class="transactSelect">
				<option >매수</option>
				<option>매도</option>
			</select>
		</div>
		
	<!-- 종목 -->	
		<div>
			<select>
				<option>신성</option>
				<option>박셀</option>
				<option>한비</option>
				
			</select>
		</div>
		
	<!-- 가격 -->
		<div>
		가격<input onkeyup="payIn()"type="text">
		</div>
		
	<!-- 날짜 -->	
		<div>
		날짜 <input type="text">
		</div>
		
	<!-- 제목 -->	
		<div>
			제목<input type="text">
		</div>
		
	<!-- 내용 -->	
		<div>
			내용 <textarea rows="" cols=""></textarea>
		</div>
		
		<div>
			<button onclick="">등록</button>
		</div>
	
		<div>
			<button onclick="">등록</button>
		</div>
	
	
	
	</div>
	
	<script src="../js/transaction/transactAdd.js"type="text/javascript"></script>
</body>
</html>