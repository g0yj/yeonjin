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
import service.Fileservice;

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
    										//getAttribute() : 내장객체 속성이름이 name인 속성값
    										//loginDto : MemberFindController랑 맞춰야됨
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
    		
    		//--------------7. 검색처리------------------------------------------//
    		String key = request.getParameter("key");
    		String keyword = request.getParameter("keyword");
    		
    		
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
    		int totalsize= BoardDao.getInstance().getTotalSize(bcno, key, keyword);
    			//3. 마지막페이지번호/총페이지수
    		int totalpage=totalsize%listsize==0? //만약 나머지가 없으면
    						totalsize/listsize: //몫만
    						(totalsize/listsize)+1; // 있으면 몫+1 (나머지 페이지 수를 표시할 페이지 1개 추가)
    				//만약에 게시물수:10, 페이지별 2개씩 출력 => 총페이지수는 5[몫]
    				//		게시물:20, 페이지별 3개씩 출력 => 총 페이지수 6[몫]+1 <- 나머지가 있기 때문에
    			
    		//-----------5. 페이지번호벝튼 시작번호, 마지막 번호---------------------------//
    			//5개씩 : 1~5(1,5) 6~10(6,10)
    			//10개씩 : 1~10(1,10) 11~20(11,20)
    		/*
    		 * 페이지		시작		마지막	시작계산식[int btnsize=5]
    		 * 1페이지	1		5 		(page*btnsize)/	1*5
    		 * 2페이지	1		5 
    		 * 3페이지	1		5 
    		 * 4페이지	1		5 
    		 * 5페이지	1		5 
    		 * 6페이지	6		10 
    		 * 7페이지	6		10
    		 * 8페이지	6		10
    		 * 
    		 * 
    		 * page
    		 * 
    		 * 
    		 * 
    		 */
    		
    			//1.페이지 버튼 번호의 최대 갯수
    		int btnsize=5;
    			//2.페이지 버튼 번호의 시작번호
    		int startbtn = (page/btnsize); System.out.println(startbtn);
    			startbtn =startbtn*btnsize; System.out.println(startbtn);
    			startbtn=startbtn+1;		System.out.println(startbtn);
    				//규칙찾기. 
    			startbtn=((page-1)/btnsize)*btnsize+1;
    			//3. 페이지 버튼 번호의 마지막 번호
    		int endbtn=startbtn+(btnsize-1);
    			//*단 마지막번호는 총 페이지수 보다 커질 수 없음(유효성검사)
    				//만약 마지막번호가 총 페이지수 보다 크거나 같으면 총페이지 수로 제한두기
    		if(endbtn>=totalpage) {endbtn=totalpage;}
    		
    		//----------------6. pageDto 구성-----------------------------------------//
    		//3. DAO
        	ArrayList<BoardDto> result= BoardDao.getInstance().getList(bcno,listsize,startrow,key,keyword);
        		System.out.println(result);
        		
        		// 위에 result와 totalsize+totalpage 를 같이 보내야하기 때문에 다시 묶어줌.(pageDto 생성)
        		pageDto pageDto = new pageDto(page, listsize, startrow, totalsize, totalpage, startbtn, endbtn, result);
        		
        		
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
	
		if(updateDto.getBfile()==null) {//*만약에 수정할 첨부파일이 없으면 기존 첨부파일 그대로 사용
			updateDto.setBfile(BoardDao.getInstance().getBoard(bno).getBfile());
		} else {//만약에 수정할 첨부파일이 있으면 기존 첨부파일은 서버업로드폴더에서 삭제
			String filename = BoardDao.getInstance().getBoard(bno).getBfile();
			filename = request.getServletContext().getRealPath("/board/upload")+"/"+filename;
			Fileservice.fileDelete(filename);
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
		String filename = BoardDao.getInstance().getBoard(bno).getBfile();
		boolean result= BoardDao.getInstance().ondelete(bno);
		
			// 만약에 게시물 삭제가 성공되면. 서버에 업로드된 파일도 삭제해줘야됨
			if(result) {// 만약 게시물 삭제 성공이면
				//String filename = BoardDao.getInstance().getBoard(bno).getBfile();
					// 삭제가 성공했는데 서버에 있는 함수?를 사용할 수 없겠찌? 레코드를 삭제하기 전에 전역변수에 저장해 놓도록!! (230번째줄)
				filename=request.getServletContext().getRealPath("/board/upload")+"/"+filename;
				Fileservice.fileDelete(filename);
			}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
	
	}

	
	
	
	
}
