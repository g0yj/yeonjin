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
	
	<div><!-- 회원가입 전체 구역 -->
		아이디: <input onkeyup="idcheck()" class="mid"type="text">
		<span class="idcheckbox"></span><br>
		
		비밀번호: <input onkeyup="pwcheck()" class="mpwd" type="password">
		비밀번호확인:<input onkeyup="pwcheck()" class="mpwdconfirm" type="password">
		<span class="pwcheckbox"></span><br>

		이메일:<input onkeyup="emailcheck()" class="memail" type="text"><button class="authReqBtn" onclick="authReq()" disabled type="button">인증요청</button><br>
		<div class="authbox">
		 <!-- js에서 조절 . 인증요청 버튼 클릭시 보이는 구역 
		 -->
		</div>
<!--  	
		<span class="timebox">02:00</span>
		<input class="ecode" type="text"><button type="button">인증</button><br>
-->	
		<span class="emailcheckbox"></span>
		
		프로필:<input class="mimg" type="file">
		<button onclick="signup()" type="button">회원가입</button>
	</div>
	
	
	
	<script src="../js/signup.js" type="text/javascript"></script>

</body>
</html>