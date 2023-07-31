package java1.day13.Ex2.model.dto;

public class BoardDto {
	
	// 싱글톤 사용 금지! 
		// 게시물 1개당 DTO는 한 개-> 여러 DTO 필요함.

	
//1. 필드------------------------------------------------------------------
		//1. 작성자(String), 내용(String), 조회수(int)
		
		private String content ;
		private String writer;
		private int view ;
		
	
//2. 생성자 - 빈선택자, 풀선택자 권장------------------------------------------
		public BoardDto() {}
		public BoardDto(String content, String writer, int view) {
			super();
			this.content = content;
			this.writer = writer;
			this.view = view;
		}

		//게시물 등록 시 사용되는 생성자(선택)
		public BoardDto(String content, String writer) {
			super();
			this.content = content;
			this.writer = writer;
		}
		
		
//3. 메소드-toString , getter/setter-----------------------------------------------
		
		
		@Override
		public String toString() {
			return "BoardDto [content=" + content + ", writer=" + writer + ", view=" + view + "]";
		}
		
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
