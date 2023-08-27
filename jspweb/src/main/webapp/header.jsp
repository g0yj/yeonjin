<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 헤더 -->
	<div>
		<ul>
			<li><a href="/jspweb/index.jsp">홈으로</a></li>
			<li><a href="/jspweb/visitlog/visitlog.jsp">방문록</a></li>
			<li><a href="/jspweb/accountbook/accountbook.jsp">과제1:가계부</a></li>
			<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
			
		</ul>
	</div>
	
	
		<!-- 최신 jquery import(ajax()를 사용할 js파일보다 위에 호출) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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

