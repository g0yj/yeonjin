<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!--부트스트랩에서 만든 CSS 적용-->	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 썸머노트 css 적용 - 부트스트랩v5 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
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
				<div class="signup"><li><a href="/myweb/member/signup.jsp">회원가입</a></li></div>
				<div class="login"><li><a href="/myweb/member/login.jsp">로그인</a></li></div>
				<div class="logout"><li><a href="#">로그아웃</a></li></div>
				<div class="mypage"><li><a href="#">마이페이지</a></li></div>
			</div>
		</div>
	
		<div class="bottom">
			<ul class="mmenu">
				<li><a href="#">공지사항</a></li>	
				<li><a href="/myweb/sale/saleList.jsp">상품</a></li>	
				<li><a href="#">기능4</a></li>	
				<li><a href="/myweb/manage/manageView.jsp">관리자</a></li>	
			</ul>
		</div>
	
	</div>



		<!-- 부트스트랩에서 만든 JS 적용 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
		<!-- 최신 jquery import -->
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="/myweb/js/header.js" type="text/javascript"></script>
</body>
</html>