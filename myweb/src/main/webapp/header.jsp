<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 헤더 절대 경로 사용 -->
	<link href="/myweb/css/header.css" rel="stylesheet">
</head>

<body>
	<div id="header">
	
		<div class="top">
			<div class="logo">
				<a href="/myweb/index.jsp">
					<img alt="" src="/myweb/img/mainlogo.png">
				</a>
			</div>
			<div class="smenu">
				<li><a href="/myweb/member/signup.jsp">회원가입</a></li>
				<li>로그인</li>
			</div>
		</div>
	
		<div class="bottom">
			<ul class="mmenu">
				<li><a href="#">기능1</a></li>	
				<li><a href="#">기능3</a></li>	
				<li><a href="#">기능4</a></li>	
				<li><a href="#">기능5</a></li>	
			</ul>
		</div>
	
	</div>




		<!-- 최신 jquery import -->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="/myweb/js/header.js" type="text/javascript"></script>
</body>
</html>