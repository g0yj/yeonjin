package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 개인정리_파일처리 {

	public static void main(String[] args) throws IOException {
		
		
		
		/* ----------- */
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			
			// FileOutputStream과 InputStream 주고 같으니까 편하게 변수를 만들어줌( "./src/과제/과제5/재고파일.txt")
			String filePath= "./src/과제/과제5/재고파일.txt";
			FileOutputStream fileOutputStream= new FileOutputStream(filePath,true); //true는 이어쓰기 가능
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath); // 파일정보객체 클래스(29번째줄 쓸라고)
			
			/*---------------파일 내 제품 정보-----스트림[바이트]----> 바이트배열로옮기기----->문자열변환----------*/

			byte[] inByteArray = new byte[(int)file.length()]; // 퍄일의 용량만큼의 배열 선언. File클래스 사용 (25번줄)
			fileInputStream.read(inByteArray);// 읽어온 바이트를 바이트배열에 저장
			String fileInfo = new String(inByteArray); //바이트배열-> 문자열 변환
			System.out.println(fileInfo);
			
			/*--------파일내 제품정보 문자열-----> 배열저장-----------------*/
			
			//1. 배열(제품개수만큼) 선언
				 //1. 문자열 가공이 필요: 하나의 문자열로 모든 제품의 문자열을 각 제품별로 분리
					String[] fileArray =fileInfo.split("\n"); System.out.println("제품별 분리: "+ Arrays.toString(fileArray));				
				 //2. 문자열 가공 필요: 각 제품별로 각 필드/정보 분리
					//String[] 재고관리= new String[fileArray.length];
			 
					/*  ※ 굳이 나누자면 위와 같은데 이건 결국 1과 2인데
					String[] 재고관리= fileInfo.split("\n"); 을 의미함!
					즉, 파일내 제품정보 하나의 문자열에 각 제품별로 된 배열을 각 인덱스에 저장
			*/
			
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			
			System.out.print("-1:제품등록 0:결제");
				
				//2. 재고 관리 배열에 있는 제품의 정보만 출력 가능하도록 출력
				for(int i=0; i<fileArray.length;i++) {
					if(!fileArray[i].equals("")) {// 유효성검사:  배열내 데이터가 공백이 아니면  
						
						
						String name =fileArray[i].split(",")[0]; // 제품명
						int stock = Integer.parseInt(fileArray[i].split(",")[1]);//재고
						int price = Integer.parseInt(fileArray[i].split(",")[2]);// 가격
						int basket = Integer.parseInt(fileArray[i].split(",")[3]);//바구니
						
						if(stock==0) {//재고없
						System.out.print((i+1)+" "+name+"재고없음"); 
						}//재고없
						else {//재고있
							System.out.print((i+1)+" "+name+"["+price+"] "); 
							
						}//재고있
					}//if
				}
			System.out.print("\n>>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			if(ch==-1) {
				//1. 추가할 제품의 정보를 입력 받아 각 변수에 저장
				System.out.println("제품명: "); String name=scanner.next();
				System.out.println("초기재고: "); int stock =scanner.nextInt();
				System.out.println("가격: "); int price = scanner.nextInt();
											int basket=0;
				//2. 해당 변수들을 하나의 데이터로 구성 <- csv파일로 만들기 위한 과정! ,로 구분하고 \n으로 줄바꿈 되어 있는 형식임
				String outStr = name+","+stock+","+price+","+basket+"\n";
				
				//3. 파일에 내보내기	(1. 파일 출력스트림 객체 2. 문자열을 바이트열로 변환 3. 내보내기)
									//ㄴ if 밖으로 빼겠음(23번째줄)
				fileOutputStream.write(outStr.getBytes());
				
				System.out.println("안내)제품 등록이 되었음");
				
			
			
			
			}//ch-1
			
			
			else if( ch>0&&ch<=fileArray.length ) {
				//1. 선택한 제품번호의 각 정보 호출
				String product = fileArray[ch-1];	
				System.out.println( ch+1 + " 번 제품 : " + product );
				
				int stock = Integer.parseInt( product.split(",")[3] );
				int basket = Integer.parseInt( product.split(",")[2] );
				int price = Integer.parseInt( product.split(",")[1] );
				String name =  product.split(",")[0] ;
				
				// 2. 재고가 0보다 크면 
				if( stock > 0 ) { 
					stock--; 	basket++; System.out.println( name+ " 바구니 담았습니다.");
				}
				else {System.out.println(" 재고 부족 ");}
				//3. 배열상태업데이트
				fileArray[ch-1]=name+","+stock+","+price+","+basket;
				
				//4. 파일에 내보내기 // 파일내 제품들의 변화가 있으므로 업데이트		
				// 배열 내 정보를 수정하기 보다는 덮어쓰기가 편함. => 현재 재고관리배열 상태를 파일에 저장!
				String outStr="";
				for(int i=0; i<fileArray.length;i++) { //배열 내 모든 데이터를 하나의 문자열 변환해서
	
					outStr += fileArray[i].split(",")[0]+","+fileArray[i].split(",")[1]+fileArray[i].split(",")[2]
							+fileArray[i].split(",")[3]+"\n";
				}
				//5. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트배열로 변환 후 내보내기
				//5-1 덮어쓰기를 위해서는 위에서 만든 fileOutPutStream 쓰면 안됨!.이어쓰기인 true 붙인 객체임
					// fileOutputStream.write(outStr.getBytes()); <--- 틀린거
				//이어쓰기 안하는 형식으로 새롭게 만들어줘야됨
				FileOutputStream fileOutputStream2=new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				
				
			}
			else if( ch == 0 ) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for( int i = 0 ; i<=fileArray.length ; i++ ) {
					int basket = Integer.parseInt( fileArray[i].split(",")[1] );
					int price = Integer.parseInt( fileArray[i].split(",")[2] );
					String name = fileArray[i].split(",")[3];
					
					if( basket > 0 ) { 
						System.out.printf( "%10s %10s %10s \n" , name ,  basket , basket*price );
					}
				}
			}
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 



