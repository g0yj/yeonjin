package controller.hrm;

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

import model.dao.HrmDao;
import model.dto.HrmDto;

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HrmController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청x
		//2.객체화x
		//3.dao 보내고 결과 받기
		ArrayList<HrmDto> result=HrmDao.getInstance().print();
		//js는 ArrayList타입을 사용할 수없음. jackson 라이브러리 사용
		ObjectMapper mapper= new ObjectMapper();
		//json타입으로 변환 불가능하니 json형식의 문자열 타입으로 변환
		String jsonArray =mapper.writeValueAsString(result);
		//4.결과받기
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		//response.getWriter().print(jsonArray); System.out.println("jsonArray"+jsonArray);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----파일업로드------------------
			//서버 pc 경로를 찾아주는 함수 사용
		String uploadpath=request.getSession().getServletContext().getRealPath("/hrm/img");
			//첨부파일을 서버 pc에 업로드 하기 위해서는 cos 라이브러리 필요
		//MultipartRequest : 파일 업로드 클래스
		MultipartRequest multi = new MultipartRequest(
				request, //1. 요청방식
				uploadpath, //2. 첨부파일을 저장할 폴더 경로
				1024*1024*10, //3. 첨부파일 용량 허용 범위
				"UTF-8", //4. 한글인코딩타입
				new DefaultFileRenamePolicy()//서버내 첨부파일명이 동일할때 뒤에 자동으로 번호 부여
				);
		
		//-----DB처리----------------------
		//1. ajax 통신 받은 data 요청[request]
			//일반 input: multi.getParameter("form객체전송시 input name");
			//첨부파일 input: multi.getFilesystemName();
		String hname= multi.getParameter("hname"); System.out.println(hname);
		String hposition= multi.getParameter("hposition");System.out.println(hposition);
		String hphone= multi.getParameter("hphone");System.out.println(hphone);
		String himg= multi.getFilesystemName("himg");System.out.println(himg);
		//2.객체화
		HrmDto dto = new HrmDto(hname, hposition, hphone, himg);
		//3. dao에게 전달하고 결과 받음
		boolean result= HrmDao.getInstance().hrmjoin(dto);
		//4. ajax 결과를 보냄 [response]
		response.setContentType("application/json;charset=UTF-8");	
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
