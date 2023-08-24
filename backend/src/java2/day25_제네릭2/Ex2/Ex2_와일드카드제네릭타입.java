package java2.day25_제네릭2.Ex2;
//12시
public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {
		
		//1. 모든 사람이 신청 가능
			// 1. 사람 객체
		Person person = new Person();
			//2. 지원자객체[지원자 객체에 사람 객체를 생성자 대입]
		Applicant<Person> applicant = new Applicant<>(person);
		
			//3. 모든 객체가 지원 가능한 코스 등록 함수
		Course.resisterCourse1(applicant);
		
		//-- 코스1 : (모든 지원서-사람,직장인,학생,고등,중) 누구나 등록 가능한 코스
		Course.resisterCourse1(new Applicant<Person>(new Person()));
		Course.resisterCourse1(new Applicant<Worker>(new Worker()));
		Course.resisterCourse1(new Applicant<Student>(new Student()));
		Course.resisterCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.resisterCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		//--코스2: 학생만 신청 가능
			//Applicant<? extends Student> applicant
			//지원서 중에 Student 자손 객체만 가능 [person,worker 불가능]
		//Course.registerCourse2(new Applicant<Person>(new Person()));//불가능
		//Course.registerCourse2(new Applicant<Worker>(new Worker()));//불가능
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		//--코스3: 직장인 및 일반인만 신청 가능
			//Applicant<? super Worker>applicant
			//지원서 객체 중에 Worker 객체와 Worker 부모객체만 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		//Course.registerCourse3(new Applicant<Student>(new Student())); //불가능
		//Course.registerCourse3(new Applicant<HighStudent>(new HighStudent())); //불가능
		//Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent())); //불가능
		
		
	/* 교재코드 <-어려워서 수업시간에 풀어서 써준게 위에꺼
		Course.resisterCourse1(new Applicant<Person>(new Person()));
		Course.resisterCourse1(new Applicant<Worker>(new Worker()));
		Course.resisterCourse1(new Applicant<Student>(new Student()));
		Course.resisterCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.resisterCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		
	 */	
		
		
		
		
	}
}
