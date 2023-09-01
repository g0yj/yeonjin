<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webcontainer"> <!-- header.css에 webcontainer 만들어뒀었음 -->
		<h3>글목록페이지</h3>
		<table class="boardTable">
			<!-- js 컨트롤 -->
		</table>
		
		<button class="write" onclick="onWrite()" type="button">글쓰기</button>
	</div>
	<!-- write 페이지로 넘어가야되니까 js연결 필요. -->
	<script src="../js/board/list.js" type="text/javascript"></script>
	
</body>
</html>