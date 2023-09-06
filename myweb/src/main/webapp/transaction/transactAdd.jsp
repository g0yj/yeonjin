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
	<h2> 거래 등록 페이지</h2>
	
	<form class="transactForm">
		<!-- 매수/매도 -->
			<div class="#">
				<select class="transactSelect" name="transactSelect">
					<option >매수</option>
					<option>매도</option>
				</select>
			</div>
			
		<!-- 종목 -->	
			<div class="#">
				<select class="codenumber" name="codenumber">
					<option>신성</option>
					<option>박셀</option>
					<option>한비</option>
					
				</select>
			</div>
			
		<!-- 수량 -->
			<div>
				수량<input class="amount" name="amount"  type="text">
			</div>

		<!-- 가격 -->
			<div>
			가격<input class="price" name="price" type="text">
			</div>
		
			
		<!-- 날짜 -->	
			<div>
			날짜 <input class="tdate" name="tdate" type="text">
			</div>
			
		<!-- 제목 -->	
			<div>
				제목<input class="ttitle" name="ttitle" type="text">
			</div>
			
		<!-- 내용 -->	
			<div>
				내용 <textarea class="tcontent" name="tcontent"></textarea>
			</div>
		</form>
		
		
		<div>
			<button onclick="add()">등록</button>
		</div>
	
		<div>
			<a href="transactList.jsp"><button >뒤로가기</button></a>
		</div>
	
	
	
	</div>
	
	<script src="../js/transaction/transactAdd.js"type="text/javascript"></script>
</body>
</html>