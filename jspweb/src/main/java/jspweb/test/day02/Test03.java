package jspweb.test.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test03")
public class Test03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Test03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 콘솔 출력
		System.out.println("Test03 안녕 자바스크립트");//콘솔은 한글지원 O
		//2. 웹 출력
			//1. 응답데이터의 타입과 인코딩타입 설정
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Test03 안녕 자바스크립트");//웹은 한글 지원 안하기 때문에 인코딩 안하면 깨져서 나옴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
