package 과제.과제4;

import java.util.Random;
import java.util.Scanner;

public class 과제4_2_가위바위보 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 플레이어;
		int 컴퓨터;
		int 게임수 = 0; 
		int 플레이어승리수 = 0 ; int 컴퓨터승리수 = 0 ;
		
		while(true) {
			

			System.out.println("\n\n--------------[[ 가위바위보 게임 ]] ----------- ");
			System.out.print(" >>>>>>>  가위[0] 바위[1] 보[2] 종료[3] 중 선택 : ");
			플레이어 = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
			//랜덤 객체 생성
			Random random = new Random();
			//컴퓨터가 낼 가위바위보
			컴퓨터= random.nextInt(3);
			
			//여기에 썼으면 아래 if문에 하나씩 추가할 필요 없었음.
			//System.out.println("컴퓨터가 낸 수: " + 컴퓨터);
			

			if(플레이어!=3){// 게임 진행
				//게임수 파악을 위함.
				++게임수;
				
				// 강사님은 && || 사용해서 조건 나눔
				// 컴퓨터를 기준으로 하겠음 (승리 판단)
				if(컴퓨터>플레이어) {//컴퓨터가 더 큰 수 일때(이길때) : (0,1)(1,2) 
					System.out.println("컴퓨터가 낸 수: "+ 컴퓨터);
					System.out.println("플레이어가 낸 수: "+ 플레이어);
					System.out.println("컴퓨터 승리");
					
					컴퓨터승리수+=1;
				}
				else if(컴퓨터<플레이어) {// 컴퓨터가 더 작을 때 (질때) : (0,2)
					System.out.println("컴퓨터가 낸 수: "+ 컴퓨터);
					System.out.println("플레이어가 낸 수: "+ 플레이어);
					System.out.println("플레이어 승리");
					플레이어승리수+=1;
				}
				else{
					System.out.println("컴퓨터가 낸 수: "+ 컴퓨터);
					System.out.println("플레이어가 낸 수: "+ 플레이어);
					System.out.println("무승부임");}
				//컴퓨터 기준으로 승리한 경우 확인 끝--------------------------------------
			}//게임 진행하는 if문 
			else {//게임 끝냄. 결과물 출력 후 while 벗어남. 이걸 난수 생성 전에 배치하면 효율성을 높일 수 있음
				System.out.println("게임수: "+게임수+","+"플레이어승리: "+ 플레이어승리수 +"컴퓨터승리: "+컴퓨터승리수);
				break;}
				
			/* ----------- */
		}//while
			
	}  //main
}  //class

/*
 	주제 : 가위바위보 만들기 
 		입력 조건 
 			1. 플레이어 값은 가위 대신 0 , 바위 대신 1 , 보 대신 2 , 종료 대신 3 입력받는다.
 			2. 컴퓨터 값은 난수 0~2 사이로 입력받는다.
 		실행 조건 
 			1. 플레이어에게 입력 받은 후 컴퓨터수는 난수로 자동으로 생성 한다.
 			2. 승리자 판단 한다.
 			3. 게임은 플레이어가 3을 입력할때까지 계속 진행 
 		출력 조건 
 			1. 매 게임 마다 승리자 출력 
 			2. 게임종료시 게임수 와 최종승리자 출력[ 가장 많이 이긴 플레이어 호출 
*/





