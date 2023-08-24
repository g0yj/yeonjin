package java2.day25_제네릭2.Ex2;

	/*		-----extends ---->Worker
	 * 
	 * Person
	 * 
	 * 		----extends ---->Student
	 * 								----extends----> HighStudent
	 * 								----extends----> MiddleStudent
	 *
	 */




	//사람클래스
	public class Person {
	
	}//c


// *하나의 .java 파일 안에 여러개 클래스 선언 가능
	
	//직장인클래스
	class Worker extends Person{}
	
	//학생클래스
	class Student extends Person{}
	
	//고등학생클래스
	class HighStudent extends Student{}
	
	//중학생클래스
	class MiddleStudent extends Student{}