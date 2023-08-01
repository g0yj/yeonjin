package 복습.CRUD.model.dto;

public class BoardDto {
	
// 1. 필드 private 로 생성. 설계도이기 때문에 초기값 없이 ㄱㄱ
	private String content ;
	private String writer;
	private int view ;
			
//2. 생성자 (기본, 풀생성자, 추가 생성자)
	
	public BoardDto() {	}

	public BoardDto(String content, String writer, int view) {
		super();
		this.content = content;
		this.writer = writer;
		this.view = view;}

	public BoardDto(String content, String writer) {
		super();
		this.content = content;
		this.writer = writer;}

//3. 메소드 (setter/getter , toString)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "BoardDto [content=" + content + ", writer=" + writer + ", view=" + view + "]";
	}
	
	
	
	
	
}//class

/*
 *	DTO: 이동객체
 *		1. 객체에 저장할 필드 선정
 *			private 권장 : 객체 내 필드 직접 접근을 막기 위해 
 *
 *		2. 생성자
 *			1. 빈생성자 2. 풀생성자 3. 그 외 사용에 따라 선언
 *
 *		3. 메소드
 *			1. setter/getter  : 외부로부터 필드 값이 호출이 불가능
 *				(필드에 private로 선언)하기 때문에 만들어야됨- 함수를 통한 접근
 *				set필드명() - 필드에 값 대입할 때 사용되는 메소드
 *				get필드명() - 필드에 값 호출할 때 사용되는 메소드 
 			
 			2. toString(): 객체 호출 시 주소값이 반환 되지만 객체 내 필드값을 반환하고 싶을 때 사용되는 메소드
 *
 */
