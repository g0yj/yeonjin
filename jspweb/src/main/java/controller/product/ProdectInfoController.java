package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.dao.productDao;
import model.dto.MemberDto;
import model.dto.productDto;

@WebServlet("/ProdectInfoController")
public class ProdectInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProdectInfoController() {
        super(); }

	
    //1. 제품 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("doPost 통신");
    		//cos는 파일명 호출이 불가능하기 때문에 여러개의 이미지를 구분하지 못해서 이미지 여러개 쓰기 위해서는 다른 방법이 필요.(input여러개 쓰거나 commons 쓰기)
    	//*commons.jar 이용한 업로드 구현 :commons-io.jar , commons-fileupload.jar
    		//1.요청방식 2.저장위치 3.용량 4.한글인코딩 5.파일명중복일때
    	
    	//1.저장경로[첨부파일이 저장될 폴더 위치]
    	String uploadPath = request.getServletContext().getRealPath("/product/img");
    	
    	//2. 파일아이템저장소 객체: 업로드 할 옵션을 만들어주는 객체 [import org.apache.commons.rileuploasd.FileItem]
    	DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    	itemFactory.setRepository(new File(uploadPath)); //리턴 타입이 파일임! 우리가 주는건 String이니까 new File을 통해 바꿔줘야함.
    	itemFactory.setSizeThreshold(1024*1024*1024);
    	itemFactory.setDefaultCharset("UTF-8");
    	
    	//3. 파일 업로드 객체 [import org.apache.commons.fileupload.servlet.ServletFileUpload;]
    	ServletFileUpload fileUpload= new ServletFileUpload(itemFactory);
    	
    	//4. 파일 업로드 요청 [요청방식: request] , 예외처리 발생
    	Map<Integer, String> imgList = new HashMap<>(); //업로드된 파일명 들을 저장하기 위한 map컬렉션
    	//form 전송 시 모든 데이터 한번에 요청해서 결과를 List반환 (multi.getpar~ 하나씩 다 써줄 필요 없음) 
    	try {
    		List<FileItem> fileList= fileUpload.parseRequest(request);
    		
    		//5. 업로드 실행
    		int i=0;
    		for(FileItem item: fileList) {//요청한 input(select등)들의 데이터를 반복문으로 하나씩 꺼내기
    				//FileItem: 각 요청한 데이터
    			//1. 일반 필드 [isFormField(): 만약에 일반폼필드이면 true/ 아니고 첨부파일 필드이면 false
    			if(item.isFormField()) {
    				System.out.println("일반필드호출??  "+item.getString()); //.getString(): 해당 요청 input의 value 호출
    			}else {//2. file 필드
    				 //만약에 파일 필드이면 업로드 진행
    				System.out.println("업로드할 파일명: "+item.getName());
    				//6. 업로드경로+파일명[조합]
	    				//파일명에 중복이 있을 때 식별이 필요 (Multi~는 이미지 뒤에 자동 번호 부여하는 식이었는데 com은 없는 옵션임)
		    				UUID uuid = UUID.randomUUID();
		    					//UUID 클래스(JAVA내장) : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약[ -로 4개 구분]
		    				String filename=uuid+"-"+item.getName().replaceAll("-", "_");
		    									//만약에 파일명에 -이 존재한다면 _로 변경
		    									// 왜?! 파일명과 uuid 간의 식별을 위해 (uuid가 -)
		    									// 추후 파일명만 추출 시 사용자가 파일명에 -이 있으면 파일명 추출 시 쪼개기가 어려움..!! 추후 행동을 위해 _로 바꿔주는게 좋겠쥬?
		    										//UUID[ - - - ] -파일명 : 추후에 파일명만 추출 시에 -으로 쪼개면 됩니당
    				File fileUploadPath = new File(uploadPath+"/"+filename) ;
    					System.out.println("업로드할경로와 파일명이 조함된 경로: "+fileUploadPath);
    					// .write("저장할경로[파일명포함]") 파일 업로드할 경로를 file 타입으로 제공
    					item.write(fileUploadPath); // 내보내기할 파일 업로드할 경로를 file타입으로 제공해줘야됨.
    				//7. 업로드된 파일명을 Map에 저장 [db에 저장하려고]
    					i++; //추후 db연동으로 자동 생성이기 때문에 저장할 때는 꼭 필요하지 않음.
    					imgList.put(i, filename); //i 위치=>저장 시에는 이미지 번호가 필요 없기 때문에 아무거나 넣어도 상관 없음. 
    			}
    			System.out.println(imgList);
    			
    		}
    		System.out.println(fileList);
    		
    		//-----------------------업로드 끝.db처리----------------------------------//
    		//제품 등록한 회원번호 [서블릿세션. import 주의]
    		Object object = request.getSession().getAttribute("loginDto");
    		MemberDto memberDto=(MemberDto)object;
    		int mno=memberDto.getMno();
    		productDto productDto = new productDto(
    										Integer.parseInt( fileList.get(0).getString()),// fileList.get(0) : name = pcno 호출  
    										fileList.get(1).getString(), //name = pname 값 호출
    										fileList.get(2).getString(), //pcontent 값 호출
    										Integer.parseInt( fileList.get(3).getString()), //pprice 값 호출 
    										fileList.get(4).getString(), //위도
    										fileList.get(5).getString(), //경로
    										mno, // 현재 로그인된[제품등록한]회원의 번호 호출
    										imgList);// 여러개의 이미지는 위에서 리스트를 구성해서 한번에 가지고 옴. 업로드한 파일명의 개수만큼 MAP리스트
    			System.out.println("완성 dto: "+productDto);
    			
    			//Dto를 Dao처리
    			boolean result= productDao.getInstance().register(productDto);
    			
    			response.setContentType("application/json;charset=utf-8");
    			response.getWriter().print(result);
    			
    	} catch (Exception e) {System.out.println("파일업로드요청실패"+e);}
    
    }
    //console 찍어보면 ---> []는 LIST , {}는 MAP
    
    
    //2. 제품 조회
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    
    }

	
	
	
	//3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
	
	
	//4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

/*
 * //[form 태그 없는 경우1] //1. ajax 전달한 data 객체 속성명을 이용한 호출 String
 * pname1=request.getParameter("pname1"); System.out.println(pname1); String
 * pcontent1=request.getParameter("pcontent1"); System.out.println(pcontent1);
 * 
 * //[form 태그 이용하는 경우 2- 첨부파일 없을때 있을 때 모두 MultipartRequest 써야됨] MultipartRequest
 * multi= new MultipartRequest(request,
 * request.getServletContext().getRealPath("/product"));
 * 
 * String pname2=multi.getParameter("pname2"); System.out.println(pname2);
 * String pcontent2=multi.getParameter("pcontent2");
 * System.out.println(pcontent2);
 */