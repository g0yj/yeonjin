<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer">
		<form class="registerForm">
			카테고리 <select name="pcno">
						<option value="1">노트북</option>				
						<option value="2">테블릿</option>				
						<option value="3">냉장고</option>				
					</select> <br>
			
			제품명 <input name="pname" type="text">
			제품설명 <textarea name="pcontent"></textarea><br>
			제품가격 <input name="pprice" type="number"><br>
	
			제품장소: 
				<div id="map" style="width:100%;height:350px;"></div>
				<p><em>지도를 클릭해주세요!</em></p> 
				<div id="clickLatlng"></div>

			<!-- 1. 첨부파일이 1개일때 
				 제품이미지 <input name="pimg" type="file"><br>
			-->
			
			<!-- 2. 첨부파일 여러개일때, input속성에 multiple="multiple" 
										//cos.jar은 multiple 안됨.. 업로드는 되는데 그 다음 처리(파일호출)가 불가능함. 만약 쓰려면 <input>을 사진 별로 넣어줘야됨
			 							//해결방안: multiple 사용하지 않고 input 여러개 사용
			 							//해결방안: multiple 사용하고 cos.jar 대신 commons.jar 사용
			 제품이미지 <input name="pimg" type="file" multiple="multiple"><br>
			-->
				
			<!-- 3. 드래그앤드랍 -->
			<div class="fileDropBox" style="width:200px;height: 100px; border: 1px solid red;">
				여기에 드래그 해서 파일을 올려주세요
<!-- 				<div>
					<span>파일명</span>
					<span>파일사이즈</span>
					<span><button type="button">tkrwp</button></span>
				</div> -->
			
			</div>
			
			
			
			
			<button onclick="onRegister()"  type="button">등록</button>
		
		
		</form>
	
	</div>
	
	
	<script src="/jspweb/js/product/register.js"type="text/javascript"></script>
	
	<!-- 카카오지도 사용 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=51d7cc458129199f074655a9b837dbe3"></script>
	
</body>
</html>
<!-- 		<h3>제품 등록 페이지[form 태그 없는 경우1]</h3>
		<div>
			제품명: <input class="pname1" type="text"><br>
			제품설명: <textarea class="pcontent1"></textarea><br>
			<button onclick="register1()" type="button">등록</button>		
		</div>
	
		<h3>제품 등록 페이지[form 태그를 이용한 경우 2]</h3>
		<form class="registerForm1">
			<div>
				제품명: <input class="pname2" name="pname2" type="text"><br>
				제품설명: <textarea class="pcontent2" name="pcontent2"></textarea><br>
				<button onclick="register2()" type="button">등록</button>		
			</div>
		</form> -->