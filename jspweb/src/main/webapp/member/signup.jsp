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
			<h2>회원가입페이지</h2>
			<p>회원가입 고고고고고</p>
			
			<div class="intitle">아이디</div>
			<input maxlength="30" onkeyup="idcheck()" name="mid" class="mid"type="text">
			<div class="idcheckbox"></div><br>
			
			<div class="intitle">비밀번호</div>
			<input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password">
			<div class="intitle">비밀번호확인</div>
			<input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
			<div class="pwcheckbox"></div><br>
	
			<div class="intitle">이메일</div>
			<div class="emailbox">
				<input onkeyup="emailcheck()" name="memail" class="memail" type="text">
				<button class="authReqBtn" onclick="authReq()" disabled type="button">인증요청</button>
			 </div>
			
			<div class="authbox">
			 <!-- js에서 조절 . 인증요청 버튼 클릭시 보이는 구역  -->
			</div>
	<!--  	
			<span class="timebox">02:00</span>
			<input class="ecode" type="text"><button type="button">인증</button><br>
	-->	
			<div class="emailcheckbox"></div><br>
			
			<div class="intitle">프로필</div>
			<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*">
																					<!-- accept: input속성 중 하나, 이미지만 넣을 수 있도록 -->
				<!-- <태그명 이벤트명="함수명(this)"> -->
			<img  class="preimg" alt="" src="img/default.webp"  ><!-- 등록 사진을 미리보기 할 사진 태그 -->
			
			<button class="signupbtn" onclick="signup()" type="button">회원가입</button>
		</form>
	</div>
	
	
	
	<script src="../js/signup.js" type="text/javascript"></script>

</body>
</html>