package controller.transaction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		//1. type: 전체출력(1) 개별출력(2)
		String type=request.getParameter("type");
		//반복되는 로직은 전역변수로 써서 코드양 줄이기
		ObjectMapper mapper = new ObjectMapper();//java 객체를 json 객체로 바꿔주는
		String jsonArray=""; 
		
		if(type.equals("1")) {//type(1) : 전체출력이면
			ArrayList<TransactionDto> result =TransactionDao.getInstance().transactPrint();
			System.out.println("Dao로부터 리스트 받아옴 객체갰쥬: "+result);
			jsonArray =mapper.writeValueAsString(result); System.out.println("ObjectMapper객체의 writeValueAsString은 java배열을 json배열로 변환 "+jsonArray);

			
		}//if 1번 type구분- 전체출력
		else if(type.equals("2")) {//type(2) : 개별출력
			int bno=Integer.parseInt(request.getParameter("bno")); System.out.println("전달받은bno: "+bno);
			TransactionDto result= TransactionDao.getInstance().viewPrint(bno);System.out.println("Dao전달받은 내용: "+result);
			jsonArray = mapper.writeValueAsString(result);System.out.println("서블릿 출력물 확인: "+jsonArray);
		}//if 1번 type구분-개별출력
		
		//반복되는 로직은 전역변수
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}//f()
	
	
// 매수-매도 등록============================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multi= new MultipartRequest(
									request, //요청방식 
									request.getServletContext().getRealPath("/upload/transaction"),//저장경로
									1024*1024*1024,//업로드허용용량
									"UTF-8",//인코딩타입
									new DefaultFileRenamePolicy()//제목 자동 변경
									);
		System.out.println(request.getServletContext().getRealPath("/board/transaction"));
		
    	String transactSelect =multi.getParameter("transactSelect"); System.out.println("매수냐 매도냐: "+transactSelect);
    	String codename = multi.getParameter("codename"); System.out.println("종목코드 "+codename);
		String tamount= multi.getParameter("tamount"); System.out.println("수량: "+tamount);
		String tprice= multi.getParameter("tprice"); System.out.println("가격: "+tprice);
		String tdate= multi.getParameter("tdate"); System.out.println("날짜: "+tdate);
		String ttitle= multi.getParameter("ttitle"); System.out.println("제목: "+ttitle);
		String tcontent= multi.getParameter("tcontent"); System.out.println("내용: "+tcontent);
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
