 /*
 

 function 함수1(){      }// 인수 x 반환 x
 function 함수2(x){}     // 인수(x=임의의인수,매개변수명), 반환 x 
 function 함수3(x,y,z){}   // 인수 다수 (,로 구분) , 반환 x
 function 함수4(x,y,z){   return 3;} // 인수 있음, 반환값 있음 ->함수 종료
 function 함수5() {   return 5;}  // 인수 없음, 반환값 있음-> 함수 종료
 function 함수6(){    return;}  // 인수 없음, 반환값 = 단순 함수 종료 역할
 
 함수 종료되는 조건
 1. {}를 만났을 때
 2. return 키워드를 만났을 때 [아래 코드 있어도 종료]
 
 함수 호출
 console.log('안녕!!')   // 미리 정의된 (js 만든 사람) log(인수=출력하고 싶은 문자열)함수
 배열명.splice(0,1)  // 미리 정의된 splice(인수1, 인수2)
 document.querySelector('')  // 미리 정의된 querySelector(인수1=??)
 								다른 사람이 만든(API, 프레임워크, 라이브러리)코드는 설계 모르기 때문에 암기X
 함수1();     //js에서 내가 만든 함수 호출
 함수2(3);  // 함수 호출과 동시에 해당 함수에 전달 [x=3]
 함수3(3,5,20)   // 함수 호출과 동시에 해당 함수에게 데이터 3개 전달
 let 함수결과1 =함수4(4,5,20)   // 함수 종료 후 리턴 값을 변수에 저장
 let 함수결과2= 함수5()     // 함수 종료 후 리턴 값을 변수에 저장
 함수6()					// 함수 종료 후 리턴 값이 없으므로 별도의 저장 필요 없음.
 
 <함수호출>
 1. html 이벤트 함수 호출
 <input type="button" onclick="함수명()">
 2. 함수 내에서 다른 함수 호출 가능
function함수7(){colsole.log();}
function 함수8(){함수7()} 


<함수 연산>
let 연산결과= 함수4()+10;  // 함수4 반환 값이 3이므로 [3+10]
 
 
  */