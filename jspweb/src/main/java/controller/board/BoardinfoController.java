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
import model.dto.pageDto;

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
    	int bcno= Integer.parseInt(multi.getParameter("bcno")) ;
    		
    	//작성자(mno)는 입력 받지 않았었음. 유효성 검사로 회원인 사람만 들어오고 있음 (세션에 저장된 상태)
    	int mno=((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
    	//3. 유효성/객체화
    	BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno); System.out.println(boardDto);
    	//4. Dao처리
    	boolean result= BoardDao.getInstance().bwrite(boardDto);
    	//5. 결과 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    }
 //-------------------------------------------------------------------- 
    	//2. type1:전체 조회, type2:개별 조회
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	//1.요청(속성명전달)
    	String type=request.getParameter("type");
    	
    	ObjectMapper mapper = new ObjectMapper(); //공통로직은 밖으로 빼주기
    	String json="";//공통로직 밖으로 뺴주기 위함
    	
    	if(type.equals("1")) { //전체글 조회
    		
    		//-------------------1. 카테고리-----------------------------------//
    		int bcno = Integer.parseInt(  request.getParameter("bcno"));
    		
    		//------------------2. 출력할 게시물수/하나의 페이지의 최대 게시물 수--------//
    		int listsize =Integer.parseInt(request.getParameter("listsize"));
    		
    		//--------------3. 페이징 처리----------------------------------//
    		int page= Integer.parseInt(request.getParameter("page"));
    			//1.페이지 별 레코드의 시작번호
    		int startrow= (page-1)*listsize;//페이지번호*최대개시물수
    		
    		//------------4. 마지막 페이지번호---------------------------//
    			//1.마지막페이지번호(총페이지수) = 전체게시물수/페이지별최대게시물수(listsize)
    			//2.전체 게시물 수
    		int totalsize= BoardDao.getInstance().getTotalSize(bcno);
    			//3. 마지막페이지번호/총페이지수
    		int totalpage=totalsize%listsize==0? //만약 나머지가 없으면
    						totalsize/listsize: //몫만
    						(totalsize/listsize)+1; // 있으면 몫+1 (나머지 페이지 수를 표시할 페이지 1개 추가)
    				//만약에 게시물수:10, 페이지별 2개씩 출력 => 총페이지수는 5[몫]
    				//		게시물:20, 페이지별 3개씩 출력 => 총 페이지수 6[몫]+1 <- 나머지가 있기 때문에
    			
    		//3. DAO
        	ArrayList<BoardDto> result= BoardDao.getInstance().getList(bcno,listsize,startrow);
        		System.out.println(result);
        	
        	//----------------5. pageDto 구성-----------------------------------------//
        		// 위에 result와 totalsize+totalpage 를 같이 보내야하기 때문에 다시 묶어줌.(pageDto 생성)
        		pageDto pageDto = new pageDto(page, listsize, startrow, totalsize, totalpage, result);
        		
        		
        		//*java객체-> js객체[json]형식의 문자열로 변환
        	json =mapper.writeValueAsString(pageDto);
        	
        	System.out.println("mapper 됨? : "+json);
       /*	//4. 응답
        	response.setContentType("application/json;charset=UTF-8");//얘도 공통이라 밖으로 뺴줘도 됨
        	response.getWriter().print(json);//얘도 공통이라 밖으로 뺴줘도 됨
    	*/ 	
    	}else if(type.equals("2")) {//개별글 조회
    		int bno=Integer.parseInt(request.getParameter("bno"));
    		BoardDto result= BoardDao.getInstance().getBoard(bno);
    			
    			//만약 (로그인 혹은 비로그인) 요청한 사람과 게시물 작성자가 동일하면
    		Object object = request.getSession().getAttribute("loginDto");
    		
    		if(object == null) {//비로그인
    			result.setIshost(false); //남이 쓴 글
    		}
    		else {//로그인
    			MemberDto login = (MemberDto)request.getSession().getAttribute("loginDto");
    			//내가 쓴글
    			if(login.getMno()==result.getMno()) {result.setIshost(true);}
    			else {result.setIshost(false);}
    			
    		}
    		json =mapper.writeValueAsString(result);
    	}
    	
    	response.setContentType("application/json;charset=UTF-8");//얘도 공통이라 밖으로 뺴줘도 됨
    	response.getWriter().print(json);//얘도 공통이라 밖으로 뺴줘도 됨
    	
    /*
   	
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
      */
    
    }

	
	//게시글 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 수정할 첨부파일 업로드
		MultipartRequest multi= new MultipartRequest(
									request, //요청방식 
									request.getServletContext().getRealPath("/board/upload"),
									1024*1024*1024,//업로드허용용량
									"UTF-8",//인코딩타입
									new DefaultFileRenamePolicy()//제목 자동 변경
										);
		
		//2. 수정할 데이터 요청
		int bcno=Integer.parseInt(multi.getParameter("bcno"));
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		String bfile=multi.getFilesystemName("bfile");
		
		//* 수정할 게시물 식별키
		int bno= Integer.parseInt(multi.getParameter("bno"));
		BoardDto updateDto= new BoardDto(bno, btitle, bcontent, bfile, bcno);
		//*만약에 수정할 첨부파일이 없으면 기존 첨부파일 그대로 사용
		if(updateDto.getBfile()==null) {
			updateDto.setBfile(BoardDao.getInstance().getBoard(bno).getBfile());
		}
		//3. dao
		boolean result=BoardDao.getInstance().onUpdate(updateDto);
		//4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	
	
	
	//게시글 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno")); //getParmeter의 반환타입은 string임
		boolean result= BoardDao.getInstance().ondelete(bno);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
	
	}

}
