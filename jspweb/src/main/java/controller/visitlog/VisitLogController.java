package controller.visitlog;

//8월22일 4시20분

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitLogDto;


@WebServlet("/VisitLogController")	// 해당 서블릿(자바,컨트롤러)을 호출하는 HTTP매핑
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public VisitLogController() {
        super();

    }
    //1. 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1. ajax의 data속성에 있는 객체 정보(속성명)를 요청
    	String vwriter=request.getParameter("vwriter"); System.out.println("vwriter: "+vwriter);
    	String vpwd=request.getParameter("vpwd"); System.out.println("vpwd: "+vpwd);
    	String vcontent=request.getParameter("vcontent"); System.out.println("vcontent: "+vcontent);
    
    	//2. 객체화
    	VisitLogDto dto=new VisitLogDto(vwriter, vpwd, vcontent); System.out.println(dto);
    	//3. dao 객체 전달 후 결과 응답 받음
    	boolean result= VisitDao.getVisitDao().vwrite(dto);
    	//4. 결과를 ajax에게 응답
    		//response.getWriter().print("응답할데이터");
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
    }
    /*
     *	1. 문자전송[default]
               response.setContentType("text/html;charset=UTF-8");
          
 		2. JSON전송 
               response.setContentType("application/json;charset=UTF-8");

     */
    
    //2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청 x : 모든 글 출력은 조건이 없으므로 요청값 없음(vs개별 글 출력은 조건 있음)
		//2.객체화x
		//3.dao
		ArrayList<VisitLogDto> result=VisitDao.getVisitDao().vread();
			//*js는 arraylist타입을 사용할 수 없으므로 json배열로 변환해서 전달!!(jackson라이브러리사용)
		ObjectMapper objectMapper =new ObjectMapper();
		//json타입으로 변환은 불가능하지만 json형식의 문자열타입으로 변환
		String jsonArray = objectMapper.writeValueAsString(result);
		//4.응답
		// response.getWriter().print(result);//응답은 가능하나 js가 ArrayList타입 사용이 불가능[문제발생]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(jsonArray);
	}

	//3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ajax data 데이터 요청
			//request.getParameter("속성명") ; String 으로 반환. 형변화 필요
		int vno =Integer.parseInt(request.getParameter("vno")) ;	System.out.println("vno: "+ vno);
		String vcontent=request.getParameter("vcontent");	System.out.println("vcontent: "+ vcontent);
		String vpwd=request.getParameter("vpwd");	System.out.println("vpwd: "+ vpwd);
				
		//2. (데이터 많으면 )객체화
		//3.Dao에게 전달후 sql 결과를 받음
		boolean result = VisitDao.getVisitDao().vupdate(vno, vcontent, vpwd);
		//4. 결과를 ajax에게 전달
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	
	
	//4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ajax data 데이터 요청
		int vno =Integer.parseInt(request.getParameter("vno")) ;	System.out.println("vno: "+ vno);
		String vpwd=request.getParameter("vpwd");	System.out.println("vpwd: "+ vpwd);
		//2. (데이터 많으면 )객체화
		//3.Dao에게 전달후 sql 결과를 받음
		boolean result =VisitDao.getVisitDao().vdelete(vno, vpwd);
		//4. 결과를 ajax에게 전달generated method stub
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/*
	   - http서블릿클래스는 기본적으로 get,post,put,delete 함수 제공
	   - 기본 톰캣서버는 get,post만 매개변수(데이터)전달 가능
	   - put, delete 함수도 매개변수 전달 가능하도록 설정 [서버마다 설정]
	   		- server.xml 63번째 쯤 원본코드  <Connector connectionTimeout="20000" maxParameterCount="1000" port="80" protocol="HTTP/1.1" redirectPort="8443" />
		    수정: <Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8"/>
	*/
	
}
