//주식 종목 DB생성
stockCode();
function stockCode(){
	
	  $.ajax({
      	url : "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=cm8jet1%252FFnFcA2BGS3E9orRiVyeathoek9wO7KQXYRZGDR7mEA4JpTA%252FmzpSkmsDrS8EeL6j6gkkrcMz943dmw%253D%253D",     
     	type : "get",   
     	dataType:'xml',      
      	success : r=>{console.log('통신성공'+r)
      		let tmp =${data}.find('')
      		
      	} ,       
      	error : e=>{console.log(e)} ,         
   });
}
