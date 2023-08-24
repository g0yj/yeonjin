<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!--css import -->
	<link href="visitlog.css" rel="stylesheet">

</head>
<body>
	<%@include file="../header.jsp" %>


	<!-- crud(restful) 기반의 비회원 게시판(방문록) 구현 -->
	<div class="visitwrap"> <!-- 전체구역 -->
		
		<div class="visit_top"><!-- 쓰기 구역 -->
			<div class="visit_input">
				<input class="vwriter" type="text" placeholder="작성자">
				<input class="vpwd"type="password" placeholder="비밀번호">
			</div>		
			<textarea class="vcontent"></textarea>
			<button onclick="vwrite()" type="button">등록</button>
			
		</div>
		
		
		
		<div class="visit_bottom"><!-- 출력구역 -->
			<div class=visitbox><!-- 방문록1개의 표시구역 -->
			<!--	<div class="visitbox_top">
					<div>유재석</div>
					<div class="visitdate">2023-02-22 13:50:40 </div>
				</div>
				<div class="visitbox_center">안녕하세요.안녕.안녕</div>
				<div class="visitbox_bottom">
					<button>수정</button>
					<button>삭제</button>
				</div>
			</div>  -->
			
		</div>
	</div>
	
	
	

	<!-- 최신 jquery import(ajax()를 사용할 js파일보다 위에 호출) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- js import -->
	<script src="visitlog.js"type="text/javascript"></script>
</body>
</html>