<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="../css/view_go.css" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">	
	
<title>Insert title here</title>
</head>

<body>
<%@include file="../header.jsp" %>
<div class="wrap">
	<div class="container">	<!-- 전체구역 -->
		<div class="q">
			<img  src="../img/img_go/icon_back.png" class="icon1" onclick="back()">
			<span>자주하는질문</span><!-- 사이즈 조절 필요 -->
			
		</div>
		
		<div class="contentBox"> <!--  content box -->
			<div class="top"><!-- 제목, 내용 -->
				<div class="v_title">제목</div>
				<div class="v_content">내용</div>		
			</div> <!-- top끝 -->
			
			<div class="bottom"><!-- 날짜, 목록버튼, 앞뒤버튼 -->
				<div class="date_s"> <!-- 날짜, 셀렉터 상자 -->
			<span class="v_selectInput">계정</span>
					<span class="v_date">2017-11-20</span>
					
				</div>
	 					
				
				<div class="arrow">
					<ol>
						<li><img src="../img/img_go/left.png" onclick="left()"></li>
						<li><img src="../img/img_go/right.png" onclick="right()"></li>
					</ol>
				</div>
			</div><!-- bottom끝 -->
		</div><!--  content box 끝 -->
				<div class="row justify-content-md-center g-3">
				<div class="col-1"> <input onclick="onDelete()" class="form-control btn btn-dark" type="button" value="삭제"> </div>
				<div class="col-1"> <a href="update_go.jsp"> <input class="form-control" type="button" value="수정"> </a>  </div>
	
			</div>
	
			<div id="content3">
	
				
					
					<ul class="info1">
						<li class="li_01">한솥도시락 고객상담실</li>
						<li class="li_02">02-585-1114</li>
						<li class="li_03">가까운 점포를 찾기 어려우시거나 문의 내용이 있을 경우</br>고객상담실로 문의 하세요.</li>
					</ul>
					
					<ul class="info1">
						<li class="li_01">한솥도시락 고객상담실</li>
						<li class="li_02">02-585-1114</li>
					</ul>
					
					<ul class="info1">
						<li class="li_01">한솥도시락 고객상담실</li>
						<li class="li_02">02-585-1114</li>
						<li class="li_03">가까운 점포를 찾기 어려우시거나 문의 내용이 있을 경우</br>고객상담실로 문의 하세요.</li>
					</ul>
					
	
				
				
			</div> <!-- 3번째 컨텐츠 end -->


	
	</div> <!-- 전체 구역 끝 -->
</div><!-- wrap end -->

	<!-- 부트스트랩에서 만든 JS 적용 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- 내가 사용할 script -->
<script type="text/javascript" src="../js/view_go.js"></script>

<%@include file="../footer.jsp" %>


	


</body>
</html>