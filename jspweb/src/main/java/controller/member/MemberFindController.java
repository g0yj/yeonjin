package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

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
		
		//- 만약 로그인에 성공하면 세션에 로그인 정보를 담기
		if(result==true) {
			//1. 세션에 저장할 데이터를 만듦
				MemberDto loginDto = MemberDao.getInstance().info(mid);
			//2. 세션에 [로그인 성공한 회원의 정보(loginDto)] 저장
			request.getSession().setAttribute("loginDto",loginDto);
			//*세션 상태 확인 : 강제형변환 필요
				MemberDto dto =(MemberDto) request.getSession().getAttribute("loginDto");
				System.out.println("세션상태:"+ dto);
		}
		
		//4. 결과응답
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}

/*	- 저장소
 * 		1. java/js 일반 변수들(메모리)
 * 			- java 종료되거나 js 종료/페이지전환/새로고침 되면 휘발성(초기화)
 * 			- dto 이동객체 , 로직에 필요한 변수들 <- 생성 조건에 따라 사용 범위가 다름
 * 			- 세션(객체)static 
 * 				- 장점: 모든 곳에서 동일한 메모리(동일한 주소값) 사용
 * 				- 단점: 프로그램/서버가 종료될 때까지 유지 (메모리 큼)
 * 				- 로그인정보: 페이지 전환 되더라도 로그인 상태 유지
 * 				- 게임 캐릭터 상태
 * 		2. DB 메모리 
 * 			- 주로 영구저장을 하는 곳 [논리구조(관계형/표) 저장
 * 			- 회원정보, 게시판정보, 제품정보 등
 * 			- 실제 데이터가 저장
 * 		3. 파일 
 * 			- 주로 영구 저장을 하는 곳 [문자열 저장]
 * 			- 로그/기록(예외처리 오류 정보, 최상위 보안 자료 등에 유용)
 * 			- 실제 데이터 저장
 * 		4. 세션/쿠키
 * 		
 * 
 * 
 * 
 *	로그인 했다는 증거 => 인증 [인증서를 세션에 저장]
 *
 *
 *	세션: 미리 만들어진 전역메모리(변수)
 *
 *		- js : 모든 js에서 사용 가능한 메모리 공간
 *			세션타입: 문자열 타입 (타입변환필수)
 *			세션저장: sessionStorage.setItem(키,데이터); (노출 위험)
 *			세션호출: sessionStorage.getItem(키); (노출 위험)
 *		
 *		- java(서블릿제공) : 모든 서블릿에서 사용 가능한 메모리 공간
 *			세션타입: Object (타입변환필수) 
 *			세션저장: request.getSession().setAttribute("속성명", 데이터);
 *	        세션호출: request.getSession().setAttribute("속성명");
 *			세션 내 속성 초기화: 
 *				//방법1: (모든 세션의 속성) 초기화하는 함수
    				//request.getSession().invalidate(); //로그인 정보 뿐만 아니라 모두 삭제 .. 
    			//방법2:(세션의 특정 속성) jvm gc(해당 객체를 아무도 참조하고 있지 않으면 삭제)
    				//삭제할 세션속성명과 동일하게 null 값을 대입 , 덮어씌우기 느낌
 *
 *	서블릿
 *		내장객체
 *			- request (요청객체)
 *				request.getParameter() : ajax로부터 전달된 데이터 요청
 *				request.getServletContext().getRealPath : 서블릿 저장소의 실제(c:) 경로 검색
 *				request.getSession() : 서버 내 세션 객체 호출
 *			
 *			- response(응답객체)
 * 				response.getWriter().print() : ajax에게 전달 할 데이터 응답
 * 				response.setContentType("application/json;charset=UTF-8"); [데이터 타입설정]
 **/
