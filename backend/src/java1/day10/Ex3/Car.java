package java1.day10.Ex3;

public class Car {
	
	//1. 필드
	int gas; // 현재 객체의 gas 데이터를 저장하는 곳
	
	//2. 생성자
	
	//3. 메소드 
				// 관례적으로 메소드명은 
					//1.필드에 저장하는 용도의 함수는 "set필드명" 사용
					//2.필드에 값을 호출하는 용도의 함수는 "get필드명" -->setter/getter 사용
					//3. 필드에 값의 존재여부(boolean) 확인하는 함수는 "is필드명" 을 사용
		
		//1. 리턴이 없고 매개변수가 1개: 매개변수로부터 전달받은 gas값을 필드 gas에 저장하는 함수
	void setGas(int gas) {
		this.gas=gas; //this: 현재객체 [this.필드명] . this는 매개변수 아님!! 
											// 매개변수와 필드와 이름 동일할 때 식별용으로 사용
	
	}//setGas()
	
		//2. 리턴이 있고 매개변수 없음: 현재 객체의 gas필드가 0이면 false리턴, 아니면 true 리턴 함수
	boolean isLeftGas() {
		if(this.gas==0) {
			System.out.println("gas가 없음");
			return false;
		}
		System.out.println("gas가 있음");
		return true;
	}
		//3. 리턴이 없고 매개변수도 없음 : 필드의 gas가 0일때까지 gas가 1씩 차감하고 0이면 종료되는 함수
		void run() {
			while(true) {
				if(this.gas>0) {
					System.out.println("달림. 가수 잔량: "+this.gas);
					this.gas--; //1차감
				}//if
				else {//아니면
					System.out.println("멈춤. 가스 잔량: "+this.gas);
					return; // 메소드 강제 종료 되므로 while문이 종료
					
				}//else
			}//while()
		}//run()
	}


