package controller.transaction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	
// 매수-매도 등록============================================================================
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uploadpath=  request.getSession().getServletContext().getRealPath("/member/img");
    	System.out.println("member 폴더 img 폴더 실제(서버)경로: "+uploadpath);
    	
    	MultipartRequest multi=new MultipartRequest(
				request, //1. 요청방식
				uploadpath, //2. 첨부파일을 저장할 폴더 경로
				1024*1024*10,//3. 첨부파일 용량 허용 범위[바이트단위]10MB ,내가 정하기~ 
				"UTF-8",//4.한글인코딩타입
				new DefaultFileRenamePolicy()//5. 만약에 서버 내 첨부파일이 동일한 이름이 있을때 [보안] 이름 뒤에 숫자를 자동으로 붙이기
				);
		//1. 요청
    	String transactSelect = multi.getParameter("transactSelect"); System.out.println("매수냐 매도냐: "+transactSelect);
		String amount= multi.getParameter("amount"); System.out.println("수량: "+amount);
		String price= multi.getParameter("price"); System.out.println("가격: "+price);
		String tdate= multi.getParameter("tdate"); System.out.println("날짜: "+tdate);
		String ttitle= multi.getParameter("ttitle"); System.out.println("제목: "+ttitle);
		String tcontent= multi.getParameter("tcontent"); System.out.println("내용: "+tcontent);
		String codenumber = multi.getParameter("codenumber"); System.out.println("종목코드 "+codenumber);
		//2. 객체화
		TransactionDto dto = new TransactionDto(codenumber, transactSelect, amount, price, ttitle, tcontent, tdate);
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
