package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Email;




@WebServlet("/Memberemail")
public class Memberemail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Memberemail() {
        super();
    }


    //이메일 인증 번호 가져오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
		String mmail = request.getParameter("mmail");
		
		//2 인증번호 생성[난수6자리]
		String auth=""; //인증번호를 저장할 문자열
		for(int i=0;i<6;i++) {
			Random random= new Random(); //랜덤객체 사용
			auth+=random.nextInt(10); //random.nextInt(끝수) : 0~씉 수 번위 내 난수 생성
		}//f
		
		System.out.println("인증번호: "+auth);
		//3. 인증번호를 해당 이메일에 전송 [SMTP: 간이 우편 전송 프로토콜]
			//메일전송서비스 객체 선언
		Email email =new Email();
			//객체를 통한 메일 전송 함수 호출(받는 사람의 이메일, 인증코드)
		email.msend(mmail, auth);
		
		//4. 인증번호 반환
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(auth);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
