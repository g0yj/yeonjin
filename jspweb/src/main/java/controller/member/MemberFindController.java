package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberFindController() {
        super();
    }

    //하나의 메소드의 여러개 ajax와 통신할 때는 type전송(1: 아이디 중복검사 2: 이메일중복검사 vs 필드명 mid:아이디중복검사 ,memail:이메일중복검사)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청
		String type=request.getParameter("type");
		String data= request.getParameter("data");
		//2. 객체화x
		//3. 유효성
		boolean result=MemberDao.getInstance().findIdOrEmail(type,data);
		//4.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	//로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 매개변수 요청
		String mid = request.getParameter("mid"); System.out.println(mid);
		String mpwd = request.getParameter("mpwd");System.out.println(mpwd);
		
		//2. 객체화유효성
		
		//3. dao 전달 후 결과
		boolean result=MemberDao.getInstance().login(mid, mpwd);
		
		//4. 결과응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
