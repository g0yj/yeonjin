package 과제.과제6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.xml.sax.SAXNotRecognizedException;

public class 과제5_키오스크_파일처리 {

	public static void main(String[] args) throws IOException {
		
		
		
		/* ----------- */
		
		while(true) {
			Scanner scanner = new Scanner(System.in); //입력객체
			String filePath = "./src/과제/과제6/재고파일.txt";	// 파일경
			FileOutputStream fileOutputStream= new FileOutputStream(filePath,true);//1 , true는 이어쓰기 , 파일출력객체
			FileInputStream fileInputStream=new FileInputStream(filePath);//파일입력객체
			File file= new File(filePath); //파일정보객체 <- length 쓰기 위해 가져옴
			
			/*--------파일내 제품정보----스트림[바이트]--------->배열로 옮기기---------->문자열반환-------*/
			byte[] inByteArray=new byte[(int)file.length()];// 파일의 용량만큼 배열 선언
			fileInputStream.read(inByteArray);// 읽어온 바이트를 바이트배열에 저장
			String fileInfo= new String(inByteArray); //바이트배열 --> 문자열 변환
				System.out.println(fileInfo);
			
				
			/*-----파일 내 제품정보 문자열--->배열에 저장--->*/	
				
				// 1. 하나 문자열로 모든 제품의 문자열을 각 제품별로 분리
				String[] 재고관리=fileInfo.split("\n"); System.out.println("제품별 분리: "+Arrays.toString(재고관리));
				//2. 각 제품별로 각 필드/정보 분리
				
					
				
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("-1:제품등록 0:결제");
				// 재고관리 배열에 있는 제품의 정보만 출력 가능하도록
				for(int i=0; i<재고관리.length;i++) {
					//만약에 제품이 하나도 없다면
					if(!재고관리[i].equals("")) {//배열내 데이터가 공백이 아니면, 제품이존재
						
					
					
					String product = 재고관리[i];
					String name = 재고관리[i].split(",")[0]; // 제품명
					int stock = Integer.parseInt( 재고관리[i].split(",")[1] ); // 재고
					int price = Integer.parseInt( 재고관리[i].split(",")[2] ); // 가격
					int basket = Integer.parseInt( 재고관리[i].split(",")[3] ); // 바구니
					
					
					if(stock==0) {//재고가 없으면
						System.out.print( (i+1) + ":" + name+"[재고없음] ");
						}else {//재고가 있으면
							System.out.print( (i+1) + ":" + name+"["+price+"] ");
						
					}
					
				}
				}
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			if(ch==-1) {//만약 -1을 입력했다면 제품 등록 기능
				//1.  추가할 제품의 정보를 입력받아 각 변수에 저장
				System.out.print("제품명: "); String name=scanner.next();
				System.out.print("초기재고: "); String stock=scanner.next();
				System.out.print("가격: "); String price=scanner.next();
											int basket=0;// 0부터 시작
				//2. 해당 변수들을 하나의 데이터로 구성[제품별\n   제품내정보구분" ,
				String outStr=name+","+stock+","+price+","+basket+"\n";
				
				//3. 파일 내보내기 //1.파일출력스트림객체 if 밖으로 빼뒀음.
					//1.파일 출력스트림 객체 2.문자열->바이트열로 변환 3.바이트배열 내보내기 예외처리해야됨
				
				fileOutputStream.write(outStr.getBytes()); //2,3
				
				System.out.println("안내) 제품등록했음");
				
			}
			
		/*---------------------------------------선택한 제품을 바구니에 담기-----------------------------------------------------------------*/	
			
			else if(ch>0&&ch<=재고관리.length) {//배열내 존재하는 제품만 선택
				System.out.println(재고관리[ch-1].split(",")[0]+"를 선택했습니다");
				int stock = Integer.parseInt( 재고관리[ch-1].split(",")[0] );
				int basket = Integer.parseInt(  재고관리[ch-1].split(",")[1] );
				int price = Integer.parseInt(  재고관리[ch-1].split(",")[2] );
				String name =  재고관리[ch-1].split(",")[3] ;
				
				if(stock>0) {stock--;basket++;System.out.println(name+"제품을 담았음");}
				else {System.out.println(name+"재고부족");}
				//3. 배열 상태 업데이트
				재고관리[ch-1]=name+","+stock+","+price+","+basket+"\n";
				
				
				//4. 파일에 내보내기 // 파일내 제품들의 변화가 있으므로 업데이트 // 현재 재고관리배열 상태를 파일에 저장
				String outStr="";
				for(int i =0; i<재고관리.length;i++) {//배열내 모든 데이터를 하나의 문자열 변환
					outStr+=재고관리[i].split(",")[0]+재고관리[i].split(",")[1]+
							재고관리[i].split(",")[2]+재고관리[i].split(",")[3]+"\n";
				}
				//4. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트배열로 변환 후 내보내기
				FileOutputStream fileOutputStream2= new FileOutputStream(filePath); // 이어쓰기 안하겠음
				fileOutputStream2.write(outStr.getBytes());
			
			}
			
			
			
			
			
			
			
			if( ch == 1 || ch == 2 || ch==3  ) {
				String product = 재고관리[ch-1];	
					System.out.println( ch+1 + " 번 제품 : " + product );
				
				int stock = Integer.parseInt( product.split(",")[0] );
				int basket = Integer.parseInt( product.split(",")[1] );
				int price = Integer.parseInt( product.split(",")[2] );
				String name =  product.split(",")[3] ;
				
				// 3. 유효성검사를 통한 상태 변경 
				if( stock > 0 ) { 
					stock--; 	basket++; System.out.println( name+ " 바구니 담았습니다.");
				}
				else {System.out.println(" 재고 부족 ");}
				재고관리[ch-1] = stock+","+basket+","+price+","+name;
			}
			else if( ch ==0 ) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for( int i = 0 ; i<재고관리.length ; i++ ) {
					int basket = Integer.parseInt( 재고관리[i].split(",")[1] );
					int price = Integer.parseInt( 재고관리[i].split(",")[2] );
					String name = 재고관리[i].split(",")[3];
					
					if( basket > 0 ) { 
						System.out.printf( "%10s %10s %10s \n" , name ,  basket , basket*price );
					}
				}
			}
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 



