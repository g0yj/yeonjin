package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {

	public static void main(String[] args) throws IOException {

	




//스택영역: 함수는 호출 시 메모리가 할당, 종료시 메모리 초기화 *지역변수
//힙영역: 객체,배열은 참조하는 스택이 없으면 자동으로 메모리 초기화됨(삭제)
	//--> RAM 주기억장치를 씀: 현재 처리된 명령어를 저장 - > 전기가 없으면 저장도 안됨. 휘발성 메모리!! 

//영구저장: 
	//--> 보조기억장치(C: ,usb,cd 등등) 사용: 명령어 영구저장-> 컴퓨터가 꺼져도 저장이 가능 -> 비휘발성


//Ex1_파일처리.java
	//저장위치: 내가 작성한 코드, 문법 c:~~~~~~~ 보조기억장치
	//실행[ctrl+f11] : 실행 중에 필요한 메모리(변수,객체,배열 등) -> 주기억장치
	// 실행 중인 메모리를 다음에 또 사용하려면 주기억장치에 메모리를 보조기억장치에 저장/불러오기 해야함
	
	//String a = scanner.next();---------------------> c: 저장 [파일처리, 데이터베이스]
	// 컴퓨터 종료 후 다음날
	// String b=           <----------------------c: 불러오기 [파일처리, 데이터베이스]


//파일처리 라이브러리(미리 만들어진 클래스/메소드)
	//*스트림: 자바 외부와 통신할 때 사용하는 통로 [*바위트단위로]
		//*통신하다가 갑자기 오류가 발생할 수 있음.  (자바의 오류인지 자바 외부 오류인지 판단이 불가능) [*필수: 미리 예외처리/오류처리]
	//	1.FileOutputStream: 파일 내보니개/저장 관련된 메소드 제공하는 클래스
		//new Fi

		
	//	2. 제공하는 함수/메소드
		//1. .write(바이트배열) <- 바이트 하나는 변수니까 한개 밖에 안됨. 따라서 배열로 만들면서 여러글자로 넣기 가능
		//2. 문자열.geyBytes() :  해당문자열을 바이트 배열로 반환
//--------------------------------------------------------------------------------------------------
		Scanner scanner= new Scanner (System.in);  // 입력객체= 입력한 값이 바이트로 들어옴
		String instr= scanner.nextLine(); // 객체 입력받은 값의 바이트열을 문자열로 반환	
		
		
		
		
//1. 파일처리[저장]
	//1. 파일출력스트림 객체 선언[파일경로]
FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt");
	//2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용[바이트 단위]
byte[] outstrArray= instr.getBytes(); //

fileOutputStream.write("안녕하세요".getBytes()); //문자열을 바이트배열로 변환 후
fileOutputStream.write(outstrArray); // 바이트배열을 내보내기

//2. 파일 호출[불러오기]
	//1.파일입력스트림 객체 선언[파일경로]
FileOutputStream filOutputStream= new FileOutputStream("./src/java1/day07/Ex1_테스트.txt");
	//2. 파일입력스트림 객체를 이용한 파일 내용 읽어오기[바이트 단위]
		//1. 읽어온 바이트를 저장할 배열을 우선 선언
byte[] intstrArray= new byte[1000]; // 파일의 바이트만큼 배열 선언[*정확한 파일의 용량 알수 없어서 임의로 , 추후 알 수 있는 방법 있음]
		//2. 바이트 읽어서 해당 바이트배열에 저장
fileInputStream.read(intstrArray);
	//3. 저장된 바이트배열을 문자열 변환
String str=new String(intstrArray);
System.out.println(str);

//3. 외부파일 불러오기 [CSV불러오기]
	//1. 역대 로또번호[CSV]
FileInputStream 복권파일= new FileInputStream("./src/java1/day07/로또.csv");
	//2. 해당파일의 용량 알기[40,960바이트]
File file = new FileInputStream("./src/java1/day07/로또.csv");
	System.out.println("해당 경로에 파일 존재 여부: "+file.exists());

	}//main

}//class