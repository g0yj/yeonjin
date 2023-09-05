package model.dto;

public class BoardDto {

	private int bno ; // 게시판번호
	private String btitle; //게시판제목
	private String bcontent; //게시판내용
	private String bfile ; //게시판파일
	private String bdate ; //게시판등록날짜
	private int bview;
	private int mno ; // 작성자번호
	private int cno; // 카테고리 번호
	private int bcno; // 카테고리코드
	
	//-- db에 없지만 추가하면 좋은 것(join사용)
		//위 필드에 포함하기 보다는 별도로 나눠서 적고 db와연동시켜 생각해보기(dto는 휘발성, db는 영구저장. 가장 가벼운 mno를 저장하고 db에서 관ㄹ
	private String mid; //작성자 회원아이디
	private String bcname;//카테고리명
	private String mimg; //작성자 프로필
	 //조회대상자와 게시문 작성자의 일치여부(본인글인지 아닌지 체크)
	private boolean ishost;

	


	//생성자----------------------------------------------------
	//빈생성자
	public BoardDto() {}
	//풀생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int cno,
			int bcno, String mid, String bcname) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.cno = cno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
	}

	//글등록할때 쓸 생성자
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int bcno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.bcno = bcno;
	}
	
	//모든 글 출력시 사용되는 생성자(풀생성자)
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int cno,
			int bcno, String mid, String bcname, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.cno = cno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
		this.mimg = mimg;
	}

	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String bcname, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
		this.mimg = mimg;
	}
	
	//수정할 때 쓸
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int bcno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bcno = bcno;
	}
	//메소드-------------------------------------------------------	
	public int getBno() {
		return bno;
	}
	public String getMimg() {
		return mimg;
	}
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBcno() {
		return bcno;
	}
	public void setBcno(int bcno) {
		this.bcno = bcno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBcname() {
		return bcname;
	}
	public void setBcname(String bcname) {
		this.bcname = bcname;
	}
	
	public boolean isIshost() {
		return ishost;
	}
	public void setIshost(boolean ishost) {
		this.ishost = ishost;
	}
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", mno=" + mno + ", cno=" + cno + ", bcno=" + bcno
				+ ", mid=" + mid + ", bcname=" + bcname + "]";
	}
	
	

	
	
	
}
