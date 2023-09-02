package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Memberfind
 */
@WebServlet("/Memberfind")
public class Memberfind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Memberfind() {
        super();
    }
    
    //아이디(mid), 이메일(mmail)  중복성 검사
    	// type : mid / mmail
    	// data
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 (속성명)
		String type=request.getParameter("type");
		String data= request.getParameter("data");
		//2. 객체화:2개니까 굳이 필요x
		//3. DAO 연결
		boolean result= MemberDao.getInstance().idcheck(type,data);
		//4. 반환
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
