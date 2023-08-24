package jspweb.test.day01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Test01") // 해당 클래스의 url주소 // 해당 클래스를 호출하고 싶으면
public class Test01 extends HttpServlet { //!!!!!!!!!: HttpServlet서블릿클래스 상속
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test01() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>js가 input");
		response.getWriter().append("js output: Hello Servlet  ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
