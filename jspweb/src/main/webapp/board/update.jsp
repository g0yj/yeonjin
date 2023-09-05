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
	
	<div class="webcontainer">
	
		<h3>글 수정 페이지</h3>
		
		<form class="writeForm"><!-- 쓰기 입력 구역 -->
			카테고리: <select class="bcno" name="bcno">
						<!-- 게시물에 저장되는 카테고리정보는 카테고리이름이 아닌 카테고리 번호임. 따라서 1,2,3으로 -->
						<option value="1">공지사항</option>			
						<option value="2">자유게시판</option>			
						<option value="3">노하우</option>			
					</select>
			제목:<input type="text" name="btitle" class="btitle"><br>
			내용:<input type="text" name="bcontent" class="bcontent"><br>
			<div class="oldfile">
			첨부파일: <input type="file" name="bfile" class="bfile"><br>
			<button onclick="onUpdate()" type="button">글수정</button>
			<a href="list.jsp">목록보기</a>
			</div>
		
		</form>
	
	</div>
	
	
	
	</div>

	<script src="../js/board/update.js" type="text/javascript"></script>
</body>
</html>