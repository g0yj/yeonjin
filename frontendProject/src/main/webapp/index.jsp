<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 다른 jsp 파일 호출을 위해 톰캣 사용 -->
	<%@include file="header.jsp" %>
	
	<p>
	대문입니다
	코드 변경되면 저장 후에 페이지에서 새로고침하면서 확인. ctrl+f5: 강력새로고침
	</p>
	
	
	<%@include file="footer.jsp" %>
	
</body>
</html>