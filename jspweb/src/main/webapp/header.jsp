<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 헤더는 절대 경로 사용 -->
	<link href="/jspweb/css/header.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
</head>
<body>

	<!-- 헤더 -->
	<div id="header">
		<div class="mainLogo"><!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/ezenlogo.png">
			</a>
		</div>
		
		<ul class="mainmenu"><!-- 본메뉴 -->
			<li><a href="/jspweb/visitlog/visitlog.jsp">방문록</a></li>
			<li><a href="/jspweb/board/list.jsp">게시판</a></li>
			<li><a href="/jspweb/datago/datago.jsp">공공데이터</a></li>
			<li><a href="/jspweb/chatting/chatting.jsp">채팅</a></li>
			<li><a href="/jspweb/product/register.jsp">제품등록</a></li>
			<li><a href="/jspweb/product/list.jsp">제품찾기</a></li>
			<li><a href="/jspweb/accountbook/accountbook.jsp">(과1)가계부</a></li>
			<li><a href="#">(과2)열람실</a></li>
			<li><a href="/jspweb/hrm/hrm.jsp">(과3)</a></li>
		</ul>
		
		<ul class="submenu"><!-- 서브메뉴 js에서 로그인 상태에 따라 변화됨 -->
			
		<!--  
			<li>xxx님</li>
			<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
			<li><a href="/jspweb/member/login.jsp">로그인</a></li>
			<li><a href="#">로그아웃</a></li>
			<li><a href="#">마이페이지</a></li>
			<li><img class="hmimg" src="/jspweb/member/img/default.webp"></li>
		-->	
		</ul>
		
		
	</div>
	
	
		<!-- 최신 jquery import(ajax()를 사용할 js파일보다 위에 호출) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/jspweb/js/header.js"></script>
</body>
</html>

<!-- 404: 경로문제 [1. 그 경로에 파일이 없거나 2. 있는데 파일 경로가 오타난 경우 -->
<!-- 
	상대경로: 현 위치 기준으로 경로를 작성
		../ : 상위 경로 1번 이동
		
	절대경로: 모든 경로 작성
		- 헤더파일은 불특정 페이지에서 사용되므로 절대경로 링크를 권장함
	

 -->
 
 <!-- 
 	헤더는 많은 페이지에서 참고하는 페이지이므로 공통적인 코드를 넣어두면 좋음
 	1. 라이브러리
 			최신 jquery import(ajax()를 사용할 js파일보다 위에 호출
 			
 			
  -->

