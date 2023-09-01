package controller.board;

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

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

@WebServlet("/BoardinfoController")
public class BoardinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardinfoController() {
        super();
    }
	
    
    //1. 쓰기
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. 첨부파일 업로드[COS.jar 파일 사용 -> MultiparRequest클래스]
    	MultipartRequest multi= new MultipartRequest(
    									request, //요청방식 
    									request.getServletContext().getRealPath("/board/upload"),
    									1024*1024*1024,//업로드허용용량
    									"UTF-8",//인코딩타입
    									new DefaultFileRenamePolicy()//제목 자동 변경
    										);
    		//*업로드가 잘 되었는지 확인! syso 찍고 서버 경로로 이동해봄
    		System.out.println(request.getServletContext().getRealPath("/board/upload"));
    		
    	//2.(입력받은 매개변수) 요청
    	String btitle=multi.getParameter("btitle");
    	String bcontent=multi.getParameter("bcontent");
    	String bfile=multi.getFilesystemName("bfile");
    		//작성자(mno)는 입력 받지 않았었음. 유효성 검사로 회원인 사람만 들어오고 있음 (세션에 저장된 상태)
    	int mno=((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
    	int bcno= Integer.parseInt(multi.getParameter("bcno")) ;
    	//3. 유효성/객체화
    	BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); System.out.println(boardDto);
    	//4. Dao처리
    	boolean result= BoardDao.getInstance().bwrite(boardDto);
    	//5. 결과 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1.요청
    	
    	//2. 유효성/객체화
    	
    	//3. DAO
    	ArrayList<BoardDto> result= BoardDao.getInstance().getList();
    		System.out.println(result);
    	//*java객체-> js객체[json]형식의 문자열로 변환
    	ObjectMapper mapper = new ObjectMapper();
    	System.out.println("객체화됨? mapper" + mapper);
    	String jsonArray =mapper.writeValueAsString(result);
    	System.out.println("mapper 됨? : "+jsonArray);
    	//4. 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(jsonArray);
    }

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
