<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/transaction/transactionList.css" rel="stylesheet">
</head>
<body>
	
	<%@include file="/header.jsp" %>
	<div class="webcontainer">
		
		
		<div class="box1">
			<select class="search">
				<option>종목</option>
				<option>제목</option>
			</select>
			<input onkeyup="sinput()"class="sinput"type="text">
			<button type="button">검색</button>
			 <a href="transactAdd.jsp"><button type="button">글쓰기</button></a>
		</div>
		

		<div class="box2">
			<button onclick="all()">전체</button>	
			<button onclick="buy()">매수</button>		
			<button onclick="sell()">매도</button>		
		</div>
		
		
		<div class="box3">
			<table class="ttable">
		<!--  
				<tr>
				<th>거래</th>
					<th>금액</th>
					<th>수량</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				<tr>
					<td>매수</td>
					<td>1000</td>
					<td>100</td>
					<td>제목입니다</td>
					<td>2023-02-11</td>
				</tr>
		-->	
			</table>
		</div>
		
		
		
		<div class="box4">페이징</div>

	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	
	
	
	
	
	
	
	<script src="../js/transaction/transactList.js" type="text/javascript"></script>
</body>
</html>