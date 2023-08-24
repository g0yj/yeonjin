package jspweb.test.day03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * !!!!!!!!!!!!서버 내 동일한 HTTP주소는 절대적으로 가질 수 없음!!!!!!!!!!!!!
 * 
 */
@WebServlet("/Test06") //해당 클래스를 호출하는 url 매핑(연결) http주소
public class Test06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Test06() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[js]통신 보내옴");
		//1. 요청 request
		String value1=request.getParameter("value1"); //ajax data 속성의 객체 내 value1이라는 속성의 값 요청
		//request.getParameter(data객체내 속성명); 
		System.out.println("[js] ajax가 보내온 데이터: "+value1);
		//2. 응답 response
		response.getWriter().print(true);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
