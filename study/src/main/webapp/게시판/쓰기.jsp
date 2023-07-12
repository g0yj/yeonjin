<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 뷰포트 : 반응형 동작 코드  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩에서 만든 CSS 적용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
	
		<!-- 썸머노트 css 적용 - 부트스트랩v5 -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
	
<link href="../css/write_go.css">

<title>Insert title here</title>
</head>


<body>
<%@include file="../header.jsp" %>
	<div class="container">
		<select class="form-select" aria-label="Default select example"></select>
	
	<input type="text" placeholder="제목" class="form-control"><br>
	<textarea id="summernote" class="form-control" rows="10" placeholder="내용"></textarea><br>
	<div class="row"><!-- 수정,등록,삭제 가로배치 -->
		<div class="col"><input onclick="onWrite()"class="col-2" type="button" value="등록"></div>
	</div><!-- 수정 등록 삭제 가로배치 -->
	</div><!-- .container -->
	
	
	
	
	
	
	<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
	<!-- jquery : js 최신 라이브러리  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 썸머노트 js 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
	
	<!-- 썸머노트 한글적용  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	<!-- write_go.js 파일 사용 -->
	<script type="text/javascript" src="../js/write_go.js"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>