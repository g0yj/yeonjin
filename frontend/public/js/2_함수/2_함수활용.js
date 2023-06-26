/*








 */

// 1. 인수x 반환x 함수
 function 함수1(){console.log('함수1 실행')}
 함수1()  // js에서 함수를 호출
 
 
 // 2. 인수o 반환x 함수 정의
 function 함수2(x,y){
	 console.log(x+y)
 }
함수2(3,5);     //8 출력
함수2('코카콜라: ', '3')    //코카콜라: 3 출력

// 3. 인수:2개  반환o 함수 정의
function 함수3(x,y){console.log(x+y); return x+y}
let 결과= 함수3(3,5); colsole.log('함수3 결과/리턴: '+결과)

// 4. 인수x, 반환o 함수 정의
function 함수4(){return 3+8;}  // 함수 강제 종료할 경우 return. [아래 코드가 있어도]
let 결과2= 함수4();console.log('함수4 결과 리턴: '+결과2)

// 5. 함수 정의 시 기존 함수 호출 가능
함수5(){console.log('함수5 실행 시 함수1도 실행') ; 함수1();}