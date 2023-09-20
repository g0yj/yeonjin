package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.productDao;
import model.dto.MemberDto;
import model.dto.productDto;

/**
 * Servlet implementation class PwishListController
 */
@WebServlet("/PwishListController")
public class PwishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PwishListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("type");
		if(type.equals("findByWish")) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			int mno =((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
			boolean result=productDao.getInstance().getWish(mno, pno);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
		}
		else if(type.equals("findByAll")) {
			int mno =((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
			List<productDto> result= productDao.getInstance().getWishProdutList(mno);
			System.out.println("list결과"+result);
			ObjectMapper mapper = new ObjectMapper(); System.out.println("잭슨사영: "+ mapper);
    		String jsonArray= mapper.writeValueAsString(result);
    		response.setContentType("application/json;charset=UTF-8");
    		response.getWriter().print(jsonArray);
		}
	
	}

	//찜하기 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.찜하기로 등록할 제품번호 요청
		int pno= Integer.parseInt(request.getParameter("pno"));
		System.out.println("pno 잘 넘어옴: "+pno);
		//2. 찜하기를 등록한 회원번호 요청 x[서블릿은 로그인한 정보를 이미 알고 있음. 서블릿 세션 사용]
		int mno =((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		System.out.println("헤더에있는mno: "+mno);
		//3.Dao 전달
		boolean result = productDao.getInstance().setWish(mno, pno);
		//4.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
