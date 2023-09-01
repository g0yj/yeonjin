package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberinfoController")
public class MemberinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberinfoController() {
        super();
    }
    //1. [c]회원가입 -첨부파일 있을때. (필드명을 확인할 수 없지 ...)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //-----------------파일 업로드---------------------------------------------------
    	//첨부파일 전송했을때
	    	//1.첨부파일 저장할 폴더의 절대경로(개발자pc경로에 업로드) - 우리는 git에서 만들고 있었는디 ,, 사용자가 보기 위해서는 서버에 업로드를 해야 볼 수 있음
	    		//String uploadpath="C:\\Users\\504\\git\\yeonjin\\jspweb\\src\\main\\webapp\\member\\img";
	    	//2.서버pc 경로 업로드(사용자는 바로 서버pc 업로드, git에 올릴 수 없음,,,,
	    		// String uploadpath="C:\Users\504-t\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps"
	    	//3. 서버pc경로(상대경로=서버경로 찾아주는 함수 사용)	
	    			//request.getSession().getServletContext().getRealPath("프로젝트명 이하 경로");
    		String uploadpath=  request.getSession().getServletContext().getRealPath("/member/img");
    				//RealPath: C:\Users\504-t\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
    				//HttpPath: http://localhost/jspweb/member/img
    		System.out.println("member 폴더 img 폴더 실제(서버)경로: "+uploadpath);
    				
    				//1. 첨부파일 서버pc에 업로드(COS 라이브러리사용)
    			//MultipartRequest: 파일 업로드 클래스
    		MultipartRequest multi=new MultipartRequest(
    				request, //1. 요청방식
    				uploadpath, //2. 첨부파일을 저장할 폴더 경로
    				1024*1024*10,//3. 첨부파일 용량 허용 범위[바이트단위]10MB ,내가 정하기~ 
    				"UTF-8",//4.한글인코딩타입
    				new DefaultFileRenamePolicy()//5. 만약에 서버 내 첨부파일이 동일한 이름이 있을때 [보안] 이름 뒤에 숫자를 자동으로 붙이기
    				);
    //----------------db처리------------------------------------------------------			
    		//2. form 안에 있는 각 데이터 호출
    	
    	//1.ajax 통신받는 data 요청[request] - data객체의 속성명
    	// 일반input: multi.getParameter("form객체전송시 input name");
    	// 첨부파일input : multi.getFilesystemName();
    	
    	String mid= multi.getParameter("mid"); System.out.println("mid: "+mid);
    	String mpwd= multi.getParameter("mpwd");System.out.println("mpwd: "+mpwd);
    	String memail= multi.getParameter("memail");System.out.println("memail: "+memail);
    	//String mimg= multi.getParameter("mimg");System.out.println("mimg: "+mimg);
    	String mimg=multi.getFilesystemName("mimg"); System.out.println("mimg: "+mimg);
    	
    	//*만약에 사진 업로드 안했으면 기본 프로필 사용하도록 변경= default.webp
    	if(mimg==null) {mimg="default.webp";}
    	
    	//2. 객체화(선택)  , 유효성검사(선택)
    	MemberDto dto = new MemberDto(mid, mpwd, memail, mimg);
    	//3. dao에게 전달하고 결과 받음
    	boolean result= MemberDao.getInstance().signup(dto);
    	//4. ajax 통신으로 결과 데이터를 응답 보냄[response]
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    	
    	
    /* 첨부파일이 없는 회원가입 (form으로 묶찌 않은)
    	//1.ajax 통신받는 data 요청[request] - data객체의 속성명
    	String mid= request.getParameter("mid"); System.out.println("mid: "+mid);
    	String mpwd= request.getParameter("mpwd");System.out.println("mpwd: "+mpwd);
    	String memail= request.getParameter("memail");System.out.println("memail: "+memail);
    	String mimg= request.getParameter("mimg");System.out.println("mimg: "+mimg);
    	
    	//2. 객체화(선택)  , 유효성검사(선택)
    	MemberDto dto = new MemberDto(mid, mpwd, memail, mimg);
    	//3. dao에게 전달하고 결과 받음
    	boolean result= MemberDao.getInstance().signup(dto);
    	//4. ajax 통신으로 결과 데이터를 응답 보냄[response]
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	*/
    }
    //2. 회원정보(세션호출) / 로그아웃(세션초기화)호출
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. 요청
    	String type = request.getParameter("type");
    		//* 만약 type info이면
    	if(type.equals("info")) {
			//*세션에 저장된 로그인객체 꺼내기
			//1. 세션 호출 [세션타입은 Object]
			Object session = request.getSession().getAttribute("loginDto"); //findController과 속성명 같아야
						//2. 타입변환[부모가 자식이 되기 위해서는 강제타입변환 필요. 캐스팅]
			MemberDto loginDto=(MemberDto)session;
				//-DTO는 JS 이해할 ㅅ ㅜ없는 언어이므로 JS가 이해할 수 있게 JS 언어로 변환[jackson라이브러리]
			ObjectMapper objectMapper=new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
		 	response.setContentType("application/json;charset=UTF-8");
	    	response.getWriter().print(json);
	    
    	}
    	else if(type.equals("logout")) {
    		//* 세션에 저장된 로그인객체를 없애기/ 초기호ㅏ/ 지우기/삭제
    		//방법1: (모든 세션의 속성) 초기화하는 함수
    			//request.getSession().invalidate(); //로그인 정보 뿐만 아니라 모두 삭제 .. 
    		//방법2:(세션의 특정 속성) jvm gc(해당 객체를 아무도 참조하고 있지 않으면 삭제)
    			//삭제할 세션속성명과 동일하게 null 값을 대입 , 덮어씌우기 느낌
    			request.getSession().setAttribute("loginDto", null);
    	}

    }


    //3. 회원수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("파일업로드전까지는감");
		//multipart/form-data 전송요청//cos.jar[MultipartRequest클래스]
		//----------------------파일 업로드------------------------------//
		MultipartRequest multi=new MultipartRequest(
				request, //1. 요청방식
				request.getServletContext().getRealPath("/member/img") , //2. 첨부파일을 저장할 폴더 경로
				1024*1024*10,//3. 첨부파일 용량 허용 범위[바이트단위]10MB ,내가 정하기~ 
				"UTF-8",//4.한글인코딩타입
				new DefaultFileRenamePolicy()
				);
		System.out.println("파일업로드는됨");
		//-----------------------DB업데이트------------------------------//
		//*form 전송일때는 input의 데이터 호출 시 
		String mimg=multi.getFilesystemName("mimg");
		
		//Dao[로그인된 회원번호,수정할 값]
		Object object = request.getSession().getAttribute("loginDto");// 1.로그인 세션 호출
		MemberDto memberDto= (MemberDto)object; //2. 타입 변환
		int loginMno = memberDto.getMno(); //3. 로그인객체에 회원번호만 호출
		
			//만약에 수정할 첨부파일(이미지)이 없으면 (회원정보만 수정하면)
		if(mimg==null) {//기존 이미지 그대로 사용
			mimg=memberDto.getMimg(); // 세션에 있던 이미지 그대로 대입 . (수정사항에 첨부파일 변화가 없을때)
			
		}
		
		boolean result= MemberDao.getInstance().mupdate(loginMno, mimg);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		//db에 사진은 변경되나 front에선 변화가 없는데 ,, 그 이유는 로그인 세션에선 수정이 된게 아니기 때문에. 로그아웃 후 다시 로그인하면 변경된걸 확인할 수 있음.
	}
	
	
//4. 회원삭제-----------------------------------------------------------------------------
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
		String mpwd= request.getParameter("mpwd"); System.out.println(mpwd);
		//2. 객체화.유효성
		//3. dao에 요청
			//1. 현재 로그인된 회원정보 => 세션
		Object object = request.getSession().getAttribute("loginDto");// 1.로그인 세션 호출
		MemberDto memberDto= (MemberDto)object; //2. 타입 변환
		int loginMno = memberDto.getMno(); //3. 로그인객체에 회원번호만 호출
			//2. 다오에 전달
		boolean result=MemberDao.getInstance().mdelete(loginMno, mpwd);
		
		//4. 응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
