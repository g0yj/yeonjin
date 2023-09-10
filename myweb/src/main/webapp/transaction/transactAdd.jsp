<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/transaction/transactionAdd.css" rel="stylesheet">
		<!-- 부트스트랩에서 만든 CSS 적용 -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
   <!-- 썸머노트 css 적용 - 부트스트랩v5 -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="webcontainer"><!-- 웹전체 -->
	<h2> 거래 등록 페이지</h2>
	
	<form class="transactForm" name="transactForm">
		<!-- 매수/매도 -->
			<div class="transactionSelectbox">
				<select class="transactSelect" name="transactSelect">
					<option >매수</option>
					<option>매도</option>
				</select>
			</div>
			
		<!-- 종목 -->	
			<div class="codenamebox">
				<select class="codename" name="codename">
					<option>신성</option>
					<option>박셀</option>
					<option>한비</option>
					
				</select>
			</div>
			
		<!-- 수량 -->
			<div>
				수량<input class="tamount" name="tamount"  type="text">
			</div>

		<!-- 가격 -->
			<div>
			가격<input class="tprice" name="tprice" type="text">
			</div>
		
			
		<!-- 날짜 -->	
			<div>
			날짜 <input class="tdate" name="tdate" type="text">
			</div>
			
		<!-- 제목 -->	
			<div>
				제목<input class="ttitle" name="ttitle" type="text">
			</div>
			
		<!-- 내용 -->	
			<div>
				내용 <textarea id="summernote"  class="tcontent" name="tcontent"></textarea>
			</div>
		</form>
		
		
		<div>
			<button onclick="add()">등록</button>
		</div>
	
		<div>
			<a href="transactList.jsp"><button >뒤로가기</button></a>
		</div>
	
	
	
	</div>

	<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 썸머노트 js 적용 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
	<!-- 썸머노트 한글적용  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
	
	<script src="../js/transaction/transactAdd.js"type="text/javascript"></script>
</body>
</html>