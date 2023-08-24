package controller.accountbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.AccountbookDao;
import model.dto.AccountbookDto;

/**
 * Servlet implementation class Accountbook
 */
@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Accountbook() {
        super();

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1.ajax의 data속성에 있는 객체 속성명 요청
    	String atext=request.getParameter("atext"); System.out.println("atext: "+atext);
    	String apay=request.getParameter("apay"); System.out.println("apay: "+apay);
    	//2.객체화
    	AccountbookDto dto= new AccountbookDto(atext, apay);
    	//3. dto 객체 전달 후 결과 응답 받기
    	boolean result=AccountbookDao.getInstance().awrite(dto);
    	//4. 결과를 ajax 전달
    		//json 전송을 위해 필요
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청x
		//2.객체화x
		//3.dao
		ArrayList<AccountbookDto> result = AccountbookDao.getInstance().aread();
			//*js는 ArrayList타입을 사용할 수 없음. json배열로 변환해 전달 (*jackson라이브러리)
		ObjectMapper objectMapper= new ObjectMapper();
		//json 타입으로 변환이 불가능하기 때문에 json형식의 문자열 타입으로 변환
		String jsonArray =objectMapper.writeValueAsString(result);
		//4. 결과를 ajax 전달
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(jsonArray);
		
	}

	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ajax 데이터 요청
			//request.getParameter("속성명") ; String 으로 반환. 형변화 필요
		int ano =Integer.parseInt(request.getParameter("ano"));System.out.println("ano: "+ano);
		String atext=request.getParameter("atext"); System.out.println("atext: "+atext);
		String apay=request.getParameter("apay"); System.out.println("apay" +apay);
		
		//2. 데이터객체화
		//3.Dao전달 후 sql 결과 받기
		boolean result = AccountbookDao.getInstance().aupdate(ano,atext,apay);
		//4. 결과를 ajax전달
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 데이터요청
		int ano=Integer.parseInt(request.getParameter("ano")); System.out.println("ano: "+ano);
		//3. sql결과 받기
		boolean result= AccountbookDao.getInstance().adelete(ano);
		//4. 결과 ajax 전달
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
