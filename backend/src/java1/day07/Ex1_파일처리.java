package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {
		
	public static void main(String[] args) throws IOException {
		/*
		 * 
		 *이클립스에서 실행 중에 필요한 메모리(변수,객체,배열 등)은 주기억장치 <-휘발성
		 *따라서 이를 영구 저장할 수 있는 과정이 필요. (현재 실행 중인 메모리를 c드라이브에 저장/호출)
		 *
		 * String a= scanner.next(); ---------->c:저장  [파일처리, 데이터베이스]
		 * 컴퓨터 종료 후 다음날
		 * String b=           <-----------------c: 불러오기[파일처리, 데이터베이스]
		 * 
		 */
/*	♥1. 파일처리 라이브러리 사용  - console에 저장된 내용이 메모장에 영구 저장 되며 이클립스를 꺼도 사라지지 않음.
	1. FileOutputStream: 파일 내보니개/저장 관련 메소드 제공하는 클래스
			1. 해당 파일과 연동/연결
			new FileOutputStream("파일경로"); //만약 해당파일이 존재하지 않으면 해당 파일 생성. 이어쓰기 안됨
			new FileOutputStream("파일경로",true); // 파일경로에 해당 파일이 존재하지 않으면 해당 파일이 생성. 이미 존재한다면 이어쓰기
			 java 상대경로: 프로젝트 명을 생략 - > ./src/패키지명/파일명
		
			 FileOutputStream fileOutputStream= new FileOutputStream("./src/java1/day07/Ex1_테스트.txt");
//----------------여기까지만 하면 무조건 오류. 스트림(자바 외부와 통신할 때 사용되는 통로로 *바이트단위로 이동)
			 통신 과정에 갑자기 오류 발생할 수 있음(자바 내인지 외부인지 판단 불가. *예외처리필수)
			 예외처리 하는 방법: x 표시 누르면 추천해줌. (Add throw declaration vs arround with try/catch)
			 메인 함수 옆에 throws FileNotFoundException 추가됨 (2.과정에서 throws IOException(Input/Output)로 바뀜
	
	2. 제공하는 함수 (위에서 생성된 객체 fileOutputStream을 이용)
			1.  .write(바이트배열)  <- 바이트 단위 : 문자를 넣기 위해서는 배열이 들어감. 영어기준 1바이트=한글자
		- 문자열.getBytes() : 해당 문자열을 바이트 배열로 변환 꼭꼭!!
			//오류뜸 *예외처리 필요
		  	fileOutputStream.write("안녕하세요".getBytes()); 
		
*/	

/* ♥ 2. 파일 불러오기
 * 	1. FileInputStream : 파일 불러오기 관련 메소드 제공하는 클래스
 * 	 		1. 해당파일과 연동/연결
 * 			new FileInputStream("파일경로"); 
 * 			 ㄴ 불러오기니까 true 사용 없음.
 *  2. 제공하는 함수
 *  	1. .read(바이트배열) : 해당 객체와 연결된 파일의 바이트를 읽어와 바이트 배열에 저장
 *		2. String str=new String(바이트배열); : 해당 바이트배열을 문자열로 반환 
 * 
 */
		
/* ♥ 3. 외부파일 불러오기[csv파일]
 * 		1. 역대 로또 번호 [csv파일]
		FileInputStream 복권파일= new FileInputStream("./src/java1/day07/로또.csv");
 * 		2. 해당파일의 용량 알기[겁나큼]
 * 			ㄴ File : 파일에 관련 메소드 제공 (존재여부, 삭제, 해당파일경로)
 *				존재여부- .exists() : 파일 경로에 파일 존재여부 t/f
 * 				삭제 -  .delete() : 삭제
 * 				경로- .getPath() : 파일이 위치한 경로를 문자열 반환
 * 				용량- .length() : 파일의 용량(바이트)를 long 타입 반환 (따라서 형변환이 필요)
 * 
 * 
 */
	
/* ♥ 4. 외부 파일 불러오기	[csv]
 * 	
 */
		
		
		
		// 콘솔은 scanner를 바로 띄울 수 없으니까 앞에 어떤 코드든 작성 ㄱㄱ
		System.out.println("파일에 저장할 내용: ");
		
		// 입력객체 = 입력 값은 바이트로 들어옴. 
		Scanner scanner= new Scanner(System.in);
		String instr = scanner.nextLine(); //객체 입력받은 값의 바이트열을 문자열로 변환
								//next()는 띄어쓰기 안됨. 
//파일처리[저장]------------------------------------------------------		
		//♥ 1. 파일처리[저장] ♥
			//1 파일 출력스트림 객체 선언
		FileOutputStream fileOutputStream= new FileOutputStream("./src/java1/day07/Ex1_테스트.txt",true);
			//2 파일출력스트림 객체를 이용한 내보내기 메소드 사용[바이트단위]
		fileOutputStream.write(instr.getBytes()); // scanner 입력받은 내용(문자열)을 바이트 처리
		
		// 변환 과정을 좀 더 직관적으로 보기 위해 만듦
		byte[]outstrArray=instr.getBytes(); // 문자열을 바이트 배열로 받음
		fileOutputStream.write(outstrArray); // 바이트배열로 내보내기
		

		
//파일처리[불러오기]-----------------------------------------------------
		//♥ 2. 파일처리[불러오기]
			//1 파일 입력스트림 객체 선언 [파일경로]
		FileInputStream fileInputStream=new FileInputStream("./src/java1/day07/Ex1_테스트.txt");
			//2 파일입력스트림 객체를 이용한 파일 내용 읽어오기[바이트단위] 
				// 내용 만큼의 배열이 필요한데 ... 바이트길이 어케 앎?
					// 정확한 파일 용량을 알수 없어서 일단 임의로 넣겠음. 추후 파일클래스를 통해 찾을 수 있음
				//2-1 읽어온 바이트를 저장할 배열을 우선 선언
		byte[]instrArray= new byte[10000];
				//2-2 바이트를 읽어서 해당 바이트
		 fileInputStream.read(instrArray);
		 	//3 바이트배열을 문자열 변환
		 String str= new String(instrArray); //빈바이트는 공백으로 채움. 지금 10000으로 되어 있기 때문에 메모리 낭비중..
		 System.out.println(str);
	
		 
//	외부 파일 불러오기--------------------------------------------------
		 FileInputStream 복권파일= new FileInputStream("./src/java1/day07/로또.csv");
		 // 해당파일 용량 알기. File 클래스 사용
		 File file = new File("./src/java1/day07/로또.csv");
		 	System.out.println("해당 경로에 파일존재여부: "+file.exists());
		 	System.out.println("해당 파일의 용량(바이트): " +file.length());
		 	byte[]복권파일바이트배열=new byte[(int)file.length()]; //용량만큼 배열 선언,  형변환 필요!!
		 복권파일.read(복권파일바이트배열);
		 String 복권파일정보= new String(복권파일바이트배열);
		 System.out.println(복권파일정보);
		 
// 외부파일 불러오기--------------------------------------------------------------------
		 String 경로="./src/java1/day07/전국관광지정보표준데이터.csv";
		 	//1. 파일입력 객체 생성
		 FileInputStream 관광지파일 = new FileInputStream(경로);
		 	//2. 파일 정보 객체 생성
		 File file2=new File(경로); //<- file.length() 메소드 사용하기 위해 필요
		 
		 	//3. 파일 용량만큼의 바이트배열 선언
		 byte[] 관광지파일바이트배열 = new byte[(int)file2.length()];
		 	//4. 읽어온 바이트를 해당 뱅ㄹ에 저장
		 관광지파일.read(관광지파일바이트배열);
		 	//5. 바이트배열을 문자열로 변환
			 //5-1 한글이 깨질 수 있음. 인코딩 필요(UTF-8 / EUC-KR)
				 //String 관광지파일정보 = new String(관광지파일바이트배열); 
		 String 관광지파일정보 = new String(관광지파일바이트배열,"EUC-KR");
		 System.out.println(관광지파일정보);
		 
		 System.out.println(관광지파일정보.split("\n")[0]);
		 System.out.println(관광지파일정보.split("\n")[1]);
		 	
		 
		 
	
	}//main

}//class


		