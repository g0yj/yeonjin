/*prompt함수로 국ㅇ,영어, 수학 점수를 입력 받아 
각 변수에 저장하고 총점 출력, 평균 출력*/

let 국어 = Number( prompt('국어 점수 : ') ) // 입력후에 변수에 저장 안하면 사라지니까 변수에 저장/대입
let 영어 = Number( prompt('영어 점수 : ') )	// Number('300') => 300
let 수학 = Number( prompt('수학 점수 : ') )	// Number('숫자') => 숫자
	// 2. 세 과목 총점 연산 
let 총점 = 국어 + 영어 + 수학 
let 평균 = 총점 / 3 
	// 3. 연산 결과 출력 
console.log( '총점 : ' + 총점 )
console.log( '평균 : ' + 평균 )

/* prompt 함수 로 반지름 입력받아서 원넓이[ 반지름반지름3.14 ] 출력*/
let 반지름=Number(prompt('반지름: '))
let 넓이=반지름*반지름*3.14

console.log('원넓이: '+넓이)

/*prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력*/
let num1=prompt('입력 받을 실수1 : ')
let num2=prompt('입력 받을 실수2: ')
let value=num1/num2*100

console.log('값: '+value)

/* prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력*/
let num3=prompt('홀짝 정수: ')
let 짝수=num3%2

console.log('짝수면 true: '+(짝수==0))


/*prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력*/
let num4=prompt('7배수 정수: ')
let value1=num4%7

console.log('7배수 정수 맞으면 true: '+(value1==0))

/*prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기*/
 let 금액=prompt('금액: ')
 let 십만원=parseInt(금액/100000)
 let 만원=parseInt((금액-(십만원*100000))/10000)
 let 천원=parseInt((금액-(십만원*100000)-(만원*10000))/1000)
 
 console.log('십만원권: '+십만원)
 console.log('만원권: '+만원)
 console.log('천원: '+천원)
 
/*  prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면
결과 : true 출력 아니면 false 출력*/

let 아이디=prompt('아이디: ')
let 비밀번호=prompt('비밀번호: ')

console.log(아이디=='admin'&&비밀번호=='1234')

/* prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력*/
let 정수= prompt("입력 받을 정수: ")
console.log(정수%2-1==0&&정수%7==0)

/*정수 2개를 입력받아 더 큰수 를 출력*/
let 정수1=prompt('입력 받을 정수1: ' )
let 정수2=prompt('입력 받을 정수2: ')
console.log(정수1>정수2?정수1:정수2)

/*정수 3개를 입력받아 가장 큰수 를 출력*/
let 정수3=prompt('정수3: ')
let 정수4=prompt('정수4: ')
let 정수5=prompt('정수5: ')
let max=정수3
max=max<정수4?정수4:max
max=max<정수5?정수5:max
 
let min=정수3
min=min<정수4?min:정수4
min=min<정수5?min:정수5


let mid=Number(정수3+정수4+정수5-(max+min))
console.log('mid값:'+mid)
console.log('오름차순 정렬: ' + min +',' +mid +','+max)