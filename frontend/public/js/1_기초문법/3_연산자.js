/**
 * 
 */

 // 산술 연산자
 console.log('더하기: '+10+3)  //103
 console.log('더하기: '+(10+3)) //13
 console.log('빼기: '+(10-3))
 console.log('곱하기: '+(10*3))
 console.log('나누기: '+(10/3))
 console.log('나머지: '+(10%3))
 
 // 문제
 
 
 // 1번문제
 let 국어= Number(prompt('국어 점수: ')) //입력 후에 변수에 저장 안하면 사라지니까 변수에 저장
 let 영어= Number(prompt('영어 점수: ')) //Number('300')-> 300
 let 수학= Number(prompt('수학 점수: '))// Number('숫자')-> 숫자
 
 let 총점=국어+영어+수학
 let 평균=총점/3
 
 console.log('총점: '+총점)
 console.log('평균: '+총점)
 
 
 //2번문제
 let 반지름=prompt('반지름: ')
 
 let 원넓이=반지름*반지름*3.14
 
 console.log('원넓이: '+ 원넓이)
 
 
 //문자 연산 예시
 console.log(10*3)
 console.log('10'*3)