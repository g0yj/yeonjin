<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!--myweb-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/member/signup.css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="webcontainer">
	
	
	
		<h3>회원가입페이지</h3>
		<div class="signupbox">
			<form class="signupform"action="">
				<div><!-- 아이디 -->
					아이디:<input onkeyup="idcheck()" class="mid" name="mid" type="text" name="mid" maxlength="15">
					<div class="idcheck"><!-- js통신:아이디유효성검사 --></div>
				</div>
				
				<div><!-- 비밀번호 -->
					비밀번호: <input onkeyup="pwcheck()" class="mpw" name="mpw" type="password" maxlength="15"><br>
					<div class="pwcheck"><!-- js통신:비밀번호유효성검사 --></div>
				</div>
					
				<div><!-- 비밀번호확인 -->
					비밀번호 확인 : <input onkeyup="pwcheck()" type="password" class="repw" name="repw"><br>
					<div class="recheck"><!-- js통신 --></div>	
				</div>
				
				<div><!-- 이메일 -->
					이메일 : <input onkeyup="mailcheck()" class="mmail" name="mmail" type="text">
					<button disabled onclick="mSend()" class="mbutton" name="" type="button">보내기</button>
					<div class="mailcheck"><!-- js --></div>
					<div class="mailbox" ><!-- js --></div>
				</div>
			</form>
		</div>
		
		<div>
			<button onclick="signup()" type="button">회원가입</button>
			<button type="button">뒤로가기</button>
		</div>
		
	</div>
	
	
	<script src="../js/member/signup.js"type="text/javascript"></script>
	
</body>
</html>