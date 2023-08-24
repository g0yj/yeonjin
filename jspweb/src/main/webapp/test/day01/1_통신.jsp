<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>통신1갔음</h3>

	<h6>1. 외부 링크[테스트링크]에 데이터 통신</h6>
	<button onclick="예제1()">예제1</button>



	<h6>2. 외부 링크[자바(서블릿)]에 데이터 통신</h6>
	<button onclick="예제2()">예제2</button>
	<!-- js파일 불러오기 -->
	
	
	
	<script src="1_통신.js" type="text/javascript"></script>

	<!-- 최신 jquery불러오기 : ajax메소드 사용하기 위해 : 외부로부터 통신하기 위해 -->
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>



</body>
</html>