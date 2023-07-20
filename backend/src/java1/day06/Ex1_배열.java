package java1.day06;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex1_배열 {

		public static void main(String[] args) {
			
			
//p.168-----------------------------------------------------------------------------------------------------------------------------------
			//1. 선언
			String[] season= {"spring","summer","fall","winter"}; //String[] : String 타입으로 배열선언했으니 String 타입의 데이터만 저장 가능
			// season은 변수(stack),  String은 힙영역
			
			//2. 호출
			System.out.println(season); // 주소값 출력 ( @39234~) . season변수는 배열 주소값을 가지고 있는 스택영역
			System.out.println(Arrays.toString(season));
			// Arrays.toString(배열변수명) // 주소를 찾아서 배열의 정보 호출 . [spring,summer,fall,winter]
			
			System.out.println(season[0]);
			System.out.println(season[1]);
			System.out.println(season[2]);
			System.out.println(season[3]);
			
			//3. 변경(새로운값 대입)
			season[1]="여름";
			System.out.println(season[1]); // 원래 있던 summer-> 여름으로 변환
			
			//4. 삭제는 없음<- 배열은 선언될 때 고정되기 때문에 . 해당 인덱스를 null로 만들 수는 있지만 이게 삭제는 아님. 
				
			//5. 추가도 불가능. 배열은 선언될 때 고정임 . 인덱스 중 null이 있으면 해당위치에 데이터 추가는 가능.
				if(season[1]==null) {
					season[1]="초여름";
				}else {System.out.println("공간이 부족");}
				
				
			
			//
				int[]scores= {83,90,87};
				//총합, 평균
				int sum=0;
				for(int i=0;i<3;i++) {//i는 0부터 3미만까지 길이를 가지는 배열 생성
					sum+=scores[i];	// 1회전: 83  2회전 90  3회전 87
				}//for끝
				System.out.println("총합: "+ sum);  //260
				System.out.println("평균: "+(sum/3));  //86
			
//p.173---------------------------------------------------------------------------------------------------------------
				//1. new 연산자를 이용한 배열 선언
				int[]arr1= new int[3]; //int 3개를 저장할 수 있는 배열 선언 [0,0,0]
				System.out.println(Arrays.toString(arr1));
			
				//2. 배열 내 모든 데이터 호출
				for(int i=0; i<3; i++) {
					System.out.println(arr1[i]);
				}
				
				//3. 배열 내 값 변경
				arr1[0]=10;	arr1[1]=20;	arr1[2]=30;
					System.out.println(Arrays.toString(arr1));
					
				
				//double형 배열
					//1. new 연산자를 이용한 배열 선언
					double[] arr2= new double[3]; //[0.0 ,0.0 ,0.0]  <- 기본값 0.0
					//2. 배열내 모든 데이터 호출 // 길이를 모를 때는 배열명.length를 사용! (얘는 상태, 필드)
														//문자열의 길이 구할 때는 문자열.length() (얘는 함수)
					for(int i=0 ; i<arr2.length ; i++) {
						System.out.println(arr2[i]);
					}
					//3. 배열 내 값 변경
					arr2[0]=0.1; arr2[1]=2.0; arr2[2]=0.3;
					arr2[3]=0.4;
					System.out.println(arr2[3]); // 오류남. 배열의 인덱스 길이를 넘으면 안됨.(없는 인덱스 호출 불가능)
					
			//3. String 클래스 배열
				String[]arr3=new String[3]; // 배열 선언 [null,null.null]
				for(int i=0; i<arr3.length;i++){System.out.println(arr3[i]);}
				arr3[0]="1월"; arr3[1]="2월";arr3[2]="3월";
				
				//값 삭제 ( 배열 선언 시 고정 길이이기 때문에 삭제 불가능. 값 대신 기본값으로 변경함으로써 대체할 수 있음
				arr3[1]=null;
						// 삭제된 인덱스 뒤로 한칸 당기고 싶다면
						for(int i= 0; i<arr3.length; i++) {
							// 주의: arr3[i]=arr3[i+1]; //오류발생. i는 고정값인데 +1을 해줄 수 없음. 마지막은 어차피 없음.
							// 만약 마지막 인덱스에 도달했으면 다음인덱스가 없으므로 당기기 할 필요가 없음
							if(i==arr3.length-1) {arr3[3]=null;break;}
							//마지막 인덱스가 아니라면 한칸씩 당기기
							arr3[i]=arr3[i+1];
						}
						
				//값 추가 (불가능: 빈 공간이 있다면 null에 대입함으로써 추가 기능처럼 보이게 할 수 있)
				for(int i= 0; i<arr3.length;i++) {
					if(arr3[i]==null) {// 만약 i번째 인덳이 값이 비어있다면
						arr3[i]="5월"; break; // break 안 넣으면 배열 전체가 5월로 댜체됨. 해당 위치에만 값을 추가하고 싶다면 break 사용.
					}
				}
			
	
		}//main
}//class


/*
 * 변수: 하나의 데이터를 저장
 * 배열: 여러개의 데이터를 저장
 * 		1. 연속적인 공간에 데이터 저장하고 나열
 * 		2. 각 데이터공간에 인덱스를 부여
 * 		3. 특정: 배열은 선언된 타입의 값만 저장. 선언과 동시에 고정됨으로 배열의 길이는 수정 불가능.
 * 			※ 고정길이의 불편함을 해결하기 위한 라이브러리(프레임워크) 있음.  
 * 		4. 선언=> 타입[] 변수명;
 * 			선언과 동시에 값 대입 => 타입[]변수명={값1,값2,...}
 * 			new 연산자로 배열 생성 기본값으로 생성 => 타입[]변수명=new 타입[길이];         <- 길이= 배열에 저장할 수 있는 데이터 개수
 */
