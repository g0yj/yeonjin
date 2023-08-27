package jspweb.test.day02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Test05
 */
@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Test05() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto boardDto =new BoardDto("제목2", "안녕하세요2");
		//DTO --> JSON 변환[*JS에게 데이터 전달하는데 .. JS는 Dto 타입 몰라] 번역
			//java가 문자열타입의 json모양 만들어 js에게 전달
			// 라이브러리: jackson
				//ObjectMapper클래스: 
		
		
		//1. Dto -->json 변환 해 주는 변환 객체 [objectmapper]
		ObjectMapper mapper= new ObjectMapper();
		String jsondata=mapper.writeValueAsString(boardDto); //json형식으로 변환할 객체 넣기
		System.out.println("자바");
		//2. 응답 타입
		response.setContentType("application/json;charset=UTF-8");
		//3. 응답 데이터
		response.getWriter().print(jsondata);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
