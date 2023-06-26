
/*정수 3개를 입력 받아 오름차순으로 출력 */
let f1=Number(prompt('정수 입력: '))
let f2=Number(prompt('정수입력: '))
let f3=Number(prompt('정수입력: '))


if(f1>f2){
	let temp=f1
	f1=f2
	f2=temp}
if(f1>f3){
	let temp=f1
	f1=f3
	f3=temp}
if(f2>f3){
	let temp=f2
	f2=f3
	f3=temp
	}
console.log(f1+','+f2+','+f3)
	

/*가위가 '0'이고 바위가 '1'이고 보가'2'일 때 플레이어1와 플레이어2가 있음
	승자가 판단과 무승부 경우의수를 출력하셈
	입력: 플레이어1가 0혹은 1혹은 2를 입력 받아 변수에 저장
	플레이어2가 0혹은 1 혹은 2를 입력 받아 변수에 저장
	
	경우의수 판단
	플레이어1이겼을 때 경우의 수 '플레이어1승리'출력
	플레이어2 이겼을때 경우의수 '플레이어2승리'출력
	비겼을 경우 '무승부'출력 */
	
	let s=0
	let r=1
	let p=2
	let player1=Number(prompt('0,1,2 중 하나 입력'))
	let player2=Number(prompt('0,1,2 중 하나 입력'))
	
	if(player2==player1){console.log('무승부')}
	else if(player2<player1){console.log('플레이어1승리')}
	else{console.log('플레이어2승리')}