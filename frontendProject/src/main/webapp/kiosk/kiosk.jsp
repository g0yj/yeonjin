<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/frontendProject/css/kiosk.css" rel="stylesheet">

</head>
<body>
	<%@include file="../header.jsp" %>
	<h4> 키오스크 입니다. </h4>
	
	<div class="kioskwrap">
		<div>
			<img class="himg" src="../img/himg1.png">
			
			
			<!-- 카테고리 -->
			<ul class="categorymenu">
				
				
				<!--  <li class="categoryselect">신제품(new)</li>
				<li>프리미엄</li>
				<li>와퍼&주니어</li>
				<li>치킨&슈림프</li>
				<li>올데이킹&킹모닝</li>-->
			</ul>
			
			
		</div><!-- 헤더: 광고이미지/카테고리출력 표시 구역 -->
		
		
		<!-- 본문 ------------------------------------------------------->
		<div class="kioskcontent">
			<div class="productbox">


				<!-- 제품 1개 기준 -->
				<div class="product">
					<img src="../img/헬로디아블로와퍼.png">
					<!-- 제품 이미지 -->
					<div class="pname">헬로 디아블로 와퍼</div>
					<!-- 이름 -->
					<div class="pprice">15,000원</div>
					<!-- 가격 -->
				</div>



			</div>
			<!-- 제품구역 -->
			<div class="cartbox">
				<div class="cartcontent">
					<div class="carttop">
					<!-- 제품개수/총가격 출력 구역 -->
						<div>카트 <span class="ccount">3</span></div>
						<div>총 주문금액 <span class="ctotal">31,000</span></div>
					</div>



					<div class="cartbottom">
						<div class="citem">
							<div class="iname">더블비프불고기버거</div><!-- 제품명 -->
							<div class="iprice">12,000원</div><!-- 제품가격 -->
							<span class="icencel">x</span><!-- 제품 개별취소 -->
						</div>
					
					
					</div>
					<!-- 제품정보 출력 구역 -->

				</div>
				<!-- 제품정보 출력 -->
				<div class="cartbtn">
					<button class="cancelbtn">취소하기</button>
					<button class="orderbtn">주문하기</button>
				</div>
				<!-- 제품버튼구역 -->
			</div>
			<!-- 카트구역 -->

		</div>
		<!-- 본문: 제품출력/카트 출력 -->

	</div>

	
	
	<%@include file="../footer.jsp" %>
	
	
	<script type="text/javascript" src="/frontendProject/js/kiosk.js"></script>
	
</body>
</html>