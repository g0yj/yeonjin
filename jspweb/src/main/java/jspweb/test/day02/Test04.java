package jspweb.test.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test04
 */
@WebServlet("/Test04")
public class Test04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test04() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. JSON 타입 모양의 문자열 [-자바는 JSON 없음]
		String jsonData = "{ \"title\" : \"제목1\" , \"content\" : \"안녕하세요\" }";
		// " " 문자열 처리 연산자 // " 출력하고 싶은데 => \"
		System.out.println( "자바[String타입]에서의 JSON 모양 직접 만들기 : " +  jsonData );
		//1.json타입
		 response.setContentType("application/json;charset=UTF-8");// JSON타입[객체.속성] 가능
		// response.setContentType("text/html;charset=UTF-8"); // 문자타입 [ 객체.속성 ] 불가능
		
		 //2. 전송/응답 할 데이터
		response.getWriter().print(jsonData);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
