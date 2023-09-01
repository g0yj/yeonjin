package model.dto;

public class MemberDto {


	//1. 필드
		//1-1 
	private	int mno;
	private String mid; 
	private String mpwd; 
	private String memail; 
	private String mimg ;
	   
	//DB에 없는 필드
	private String loginDate; //로그인 시간
	
	
	
	//-* 로그인 객체를 만들 생성자 [패스워드 제외] : 오버로딩 하기 위해 매개 변수 타입 순서 변경이 필요 할 수 있음.
	
	public MemberDto(String loginDate, int mno, String mid, String memail, String mimg) {
		super();
		this.loginDate = loginDate;
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
	}

	//-* 로그인  getter/setter
	public String getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	
	
	
	// 빈생성자
	public MemberDto() {}

	// 풀생성자
	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg, String loginDate) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDate = loginDate;
	}


	//회원가입용
	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
	
	
	//메소드--------------------------
	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getMpwd() {
		return mpwd;
	}
	
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	
	public String getMemail() {
		return memail;
	}
	
	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	public String getMimg() {
		return mimg;
	}
	
	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDate=" + loginDate + "]";
	}
	
  
	 
		
		
	
	
}
