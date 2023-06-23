/*

	키오스크 주문 프로그램

*/
let 커피 = 2000;
let 에이드 = 3000;
let 스무디 = 4000;
let result = 0;			// 최종금액

let menu = [];			// 메뉴리스트
let option = [];		// 옵션리스트
let number = [];		// 수량리스트
let select = 0;			// 장바구니 선택
let select2 = 0;		// 결제 선택



console.log('키오스크 시작합니다.');

let takeout = prompt('수령방법을 선택해주세요.');		// 매장 or 포장 저장 변수

for(let i = 0; i < 1000; i++){  //이 i와 [i]는 다름.
	for(let j = 0; j < 1000; j++){
		menu[i] = prompt('메뉴를 선택해주세요')		// 메뉴 배열에 저장  [i]는 index의 i
		option[i] = prompt('옵션을 선택해주세요')		// 옵션 배열에 저장
		number[i] = prompt('수량을 선택해주세요')		// 수량 배열에 저장
		select = Number(prompt('장바구니에 담으시겠습니까? (yes = 1) (no = 2)'))
		if(select == 1){	// 장바구니에 담으면 for문을 빠져나감
			break;
		}else{			// 장바구니에 담지 않으면 배열에있던 상품들 삭제
			menu.pop();
			option.pop();
			number.pop();
		}
	}
	
	select2 = Number(prompt('결제하시겠습니까? (yes = 1) (no = 2)'));
	if(select2 == 1){ // 결제 버튼 누르면 for문 빠져나감
		break;
	}
}

for(let i = 0; i < 1000; i++){
	let select3 = Number(prompt('결제수단을 선택해주세요 (카드 = 1) (기프티콘은 = 2)'));
	if(select3 == 1){		// 카드 선택시 if문
		let second = Number(prompt('결제 경과 시간 (30이상 결제수단창으로) (30이하 다음단계)'));
		if(second < 30){	// 결제시간 30초이하면 다음단계
			break;
		}
	}else{		// 기프티콘 선택시 if문
		prompt('바코드를 입력해주세요');
		let second = Number(prompt('결제 경과 시간 (30이상 결제수단창으로) (30이하 다음단계)'));
		if(second < 30){	// 결제시간 30초이하면 다음단계
			break;
		}
	}
}

console.log('결제가 승인되었습니다.')

for(let i = 0; i < menu.length; i++){ // 최종금액 합산 
	if(menu[i] == 커피){
		result += 2000;
	}else if(menu[i] == 에이드){
		result += 3000;
	}else{
		result += 4000;
	}
}
console.log('최종금액은 ' + result + '입니다.')



let select4 = Number(prompt('적립 및 할인을 하시겠습니까? (yes=1) (no=2)'))

if(select4 == 1){
	prompt('바코드를 입력해주세요.')
}

let select5 = Number(prompt('영수증을 출력하시겠습니까? (yes=1) (no=2)'))
if(select5 == 1){
	console.log('영수증이 출력되었습니다.')
}

console.log('주문이 완료되었습니다.')

console.log('주문 내역')
console.log(takeout)
console.log(menu);
console.log(option);
console.log(number);

















