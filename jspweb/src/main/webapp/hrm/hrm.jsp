<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/hrm/hrm.css" rel="stylesheet">
</head>

<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"><!-- 과제3 전체 -->
	<!--------- 인사 등록 ------------->	
		<form class="hireform">
			<h2>인사관리 등록</h2> 
			
			
			직원명: <input class="hname" name="hname" type="text" > <br>
			
			직급: <select class="hposition" name="hposition">
					<option value="사장">사장</option>
					<option value="부장">부장</option>
					<option value="팀장">팀장</option>
					<option value="대리">대리</option>
					<option value="주임">주임</option>
					<option value="사원">사원</option>
				</select><br>
			
			전화번호: <input class="hphone" name="hphone"  type="text"><br>
			
			사진: <input type="file" class="himg" name="himg"><br>
			사진미리보기: <img src="" alt=""> <br>
			
			<button class="" onclick="hrmjoin()" type="button">등록</button>
		</form>
		
	<!---------- 전 사원 출력---------->
		<div class="print"> 
  
<!-- 			<div class="print1">
				<div class="hname">이름</div>
				<div class="hposition">직급</div>
				<div class="hphone">전화번호</div>
				<div class="hdate">입사일</div>
				<button class="update" type="button">수정</button>
				<button class="delete" type="button">삭제</button>
			</div>
 -->				
		
		</div>
	</div>

	<script src="../hrm/hrm.js" type="text/javascript"></script>

</body>
</html>