<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/member.css" rel="stylesheet">
	
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"><!-- 회원가입 전체 구역 -->
		<form class="signupForm">
			<h2>마이페이지</h2>
			
			<div class="intitle">프로필변경</div>
			<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*">
																					<!-- accept: input속성 중 하나, 이미지만 넣을 수 있도록 -->
				<!-- <태그명 이벤트명="함수명(this)"> -->
			<img  class="preimg" alt="" src="img/default.webp"  ><!-- 등록 사진을 미리보기 할 사진 태그 -->
			<div class="intitle">아이디</div>
			<div class="mid"></div>
			<div class="intitle">이메일</div>
			<div class="memail"> </div>
			
			<div class="intitle">기존비밀번호</div>
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password">
			
			<div class="intitle">새로운 비밀번호</div>
			<input onkeyup="pwcheck()" class="newmpwd" name="newmpwd" type="password">
			<div class="pwcheckbox"></div><br>
	
			
			<button class="signupbtn" onclick="mupdate()" type="button">수정</button>
			<button class="signupbtn" onclick="mdelete()" type="button">탈퇴</button>
		</form>
	</div>
	
	
	<script src="../js/signup.js" type="text/javascript"></script>
	<script src="../js/info.js" type="text/javascript"></script>

</body>
</html>