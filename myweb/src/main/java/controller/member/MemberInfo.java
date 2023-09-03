package controller.member;

//myweb
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

@WebServlet("/MemberInfo")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInfo() {
        super();
    }

	
    //회원가입
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
    	
    	//-----DB처리-------------------------------
    	//호출
    	String mid= multi.getParameter("mid"); System.out.println("mid: "+mid);
    	String mpw= multi.getParameter("mpw");System.out.println("mpw: "+mpw);
    	String mmail= multi.getParameter("mmail");System.out.println("mmail: "+mmail);
    	//String mimg= multi.getParameter("mimg");System.out.println("mimg: "+mimg);
    	String mimg=multi.getFilesystemName("mimg"); 
    	//조건
    	if(mimg==null) {mimg="default.png";} System.out.println("mimg: "+mimg);
    	
    	//객체화
    	MemberDto dto = new MemberDto(mid, mpw, mmail, mimg);
    	
    	//dao
    	boolean result=MemberDao.getInstance().signup(dto);
    	
    	//응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    	
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
