package controller.transaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.TransactionDao;
import model.dto.TransactionDto;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Transaction() {
        super();
    }
    
    
    
 // 출력 함수=================================================================   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TransactionDto> result =TransactionDao.getInstance().transactPrint();
		System.out.println("Dao로부터 리스트 받아옴 객체갰쥬: "+result);
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray =mapper.writeValueAsString(result); System.out.println("ObjectMapper객체의 writeValueAsString은 java배열을 json배열로 변환 "+jsonArray);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}
	
	
// 매수-매도 등록============================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		//1. 요청
    	String transactSelect =request.getParameter("transactSelect"); System.out.println("매수냐 매도냐: "+transactSelect);
    	String codename = request.getParameter("codename"); System.out.println("종목코드 "+codename);
		String tamount= request.getParameter("tamount"); System.out.println("수량: "+tamount);
		String tprice= request.getParameter("tprice"); System.out.println("가격: "+tprice);
		String tdate= request.getParameter("tdate"); System.out.println("날짜: "+tdate);
		String ttitle= request.getParameter("ttitle"); System.out.println("제목: "+ttitle);
		String tcontent= request.getParameter("tcontent"); System.out.println("내용: "+tcontent);
		//2. 객체화
		TransactionDto dto = new TransactionDto(transactSelect, codename, tamount, tprice, ttitle, tcontent, tdate);
		//3. dao
		boolean result = TransactionDao.getInstance().add(dto);
		//4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
