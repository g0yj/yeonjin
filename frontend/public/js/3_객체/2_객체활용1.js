

let 회원리스트=[]  //객체 하나 하나를 배열[]로 받음. 회원리스트[0]에는 아이디,비밀번호 묶인 객체가 들어감

//1. 등록함수 (회원가입 버튼 클릭할 때)
function 등록(){console.log('등록()실행')
	//1-1 입력값 가져오기
	let mid= document.querySelector('#mid').value ; console.log(mid);
	let mpwd= document.querySelector('#mpwd').value ; console.log(mpwd);

		//유효성검사1 공백
		if(mid==''||mpwd==''){ 
			alert('[회원가입실패]: 회원정보 모두 입력해주세요'); return;} // 유효성검사1이 아니라면 아래로 내려갈 필요 없으니까 함수 자체를 강제종료
		//아이디,비밀번호길이
				if(mid.length<8||mpwd.length<8){alert('길이조절하셈'); return;}

	//1-2 객체담기 (입력된 데이터(mid,mpwd)를 {}안에서 속성명(아이디,비밀번호)붙여 저장)
	let member={아이디: mid, 비밀번호: mpwd} //객체화
	console.log(member)
	
	//1-3 등록할때 (함수가 실행될 )마다 객체 생성되고 '}'가 끝나면 사라짐.
	// 밖에 전역변수 만들어 저장.= 객체 여러개 (배열)
	회원리스트.push(member) ; console.log(회원리스트)
	
	/*회원리스트.push(
		{아이디:document.querySelector('#mid').value,
		 비밀번호: document.querySelector('#mpwd').value
		 }) 위에 세줄을 이렇게 줄일 수 있음 */
}

//2. 로그인(로그인 버튼을 클릭했을 때)
function 로그인(){console.log('로그인()실행')
	//2-1 입력값 가져오기
	let mid2= document.querySelector('#mid2').value ; console.log(mid2);
	let mpwd2= document.querySelector('#mpwd2').value ; console.log(mpwd2);
	//2-2 입력된 값이 존재하는지 검사
		
		//로그인 상태 저장 변수(for문 속 if의 상태를 저장해주는 변수)
		let login=false;
		//-회원리스트(전체) 중에서 회원1명(1개씩)꺼내서 검사하는데 아이디와 비밀번호 일치 찾기
		for(let i=0; i<회원리스트.length ; i++){
			// i는 0부터 마지막인덱스까지 1씩 증가 반복-> 회원리스트 중에 한명씩 꺼냄
			let member= 회원리스트[i]//i번째 인덱스의 객체1개 꺼내기
			if(member.아이디==mid2){//꺼낸 객체의 아이디가 입력한 아이다와 같으면
				if(member.비밀번호==mpwd2){//i 번째 객체의 비밀번호가 입력한 비밀번호와 같으면}
					login=true; // i번째 객체는 로그인 성공했다는 '증거'를 변수에 저장. 위에 login 변수 
					//로그인성공 1회성이기 때문에 로그인 성공시 다른 객체 볼 필요 없음! 반복문 종료됨
					i=회원리스트.length// 방법1. 조건을 false로 만들자
					break; // 방법2/ break;사용. 가장 가까운 반복문 강제 종료
					
					}
			
				}	
	
			}// if2 조건 모두 충족했을 때 login 변수는 true 값으로 변경
			// 판단: 로그인 상태 저장 변수
			if(login==true){alert('로그인성공')}
			else{alert('로그인실패')}
	}