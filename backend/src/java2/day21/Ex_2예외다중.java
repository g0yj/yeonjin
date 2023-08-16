package java2.day21;

public class Ex_2예외다중 {

	public static void main(String[] args) {
		
		String[] array = {"100","1oo"};
	
/*		for(int i= 0; i<array.length;i++) { // '<='로 하면 오류 발생. 인덱스는 0부터 시작이기때문에
			System.out.println(array[i]); //ArrayIndexOfBoundsException 오류
			
			//Integer.parseInt(문자열인숫자) : 문장를 숫자 -> 정수형 숫자 정수로 타입 변환
			int value = Integer.parseInt(array[i]);
			// NumberFormatException: For input string: "1oo"
		}
*/		
		
		
		for(int i= 0; i<array.length;i++) { // '<='로 하면 오류 발생. 인덱스는 0부터 시작이기때문에
			try {
				// System.out.println(array[i]); //ArrayIndexOfBoundsException 오류
			int value = Integer.parseInt(array[i]);
		}
		catch (NumberFormatException e) { System.out.println(" 숫자로 변환 할 수 없는 데이터" +e);}
		catch(ArrayIndexOutOfBoundsException e) {System.out.println("배열초과 인덱스 예외처리 "+e);}
		catch(Exception e) {System.out.println("예외발생");}
		}
		
			
		//예외클래스 catch 작성순서: 하위 예외 클래스 블록 먼저 작성(P.472)
		// 다중 catch 를 사용하는 이유? 다양한 예외 흐름을 제어
	}//m
	
	
}//c
