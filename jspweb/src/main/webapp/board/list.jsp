<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/board/list.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"> <!-- header.css에 webcontainer 만들어뒀었음 -->
		<!-- 상단(페이지제목) -->
		<div class="boardtop">
			<h2>게시판</h2>
			<p>다양한 사람들과 정보를 공유하세요</p>
		</div>
		<!-- 2. 상단 부가버튼 -->
		<div class="boardtopetc">
			<div>
				<select class="listsize bbtn" onchange="onListSize()"><!-- 하나의 페이지에 표시할 최대 게시물 수 -->
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="30">30</option>
				</select>
				<span class="boardcount"><!-- js --></span><!-- 전체 게시물 수 -->
			</div>
			<button onclick="onWrite()" class="bbtn" type="button">글쓰기</button>
		</div>
		
		<!-- 3. 카테고리구역 -->
		<div class="boardcategorybox">
			<button onclick="onCategory(0)" class="bbtn" type="button">전체보기</button>
			<button onclick="onCategory(1)"class="bbtn" type="button">공지사항</button>
			<button onclick="onCategory(2)"class="bbtn" type="button">자유게시판</button>
			<button onclick="onCategory(3)"class="bbtn" type="button">노하우</button>
			
		</div>
		
		<!-- 4. 테이블 -->
		<table class="boardTable"><!-- js 컨트롤 --></table>
		
		<div class="boardbottom">
			<!-- 5. 페이징처리 구역 -->
			<div class="pagebox"><!-- js실행 --></div>
			
			<!-- 6. 검색 구역 -->
			
			<select><!-- 검색카테고리 -->
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
			<input class="keyword"type="text"><!-- 검색내용 -->
			<button type="button">검색</button>
		
		</div>
	</div>
	<!-- write 페이지로 넘어가야되니까 js연결 필요. -->
	<script src="../js/board/list.js" type="text/javascript"></script>
	
</body>
</html>