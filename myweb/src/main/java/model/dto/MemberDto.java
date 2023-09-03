package model.dto;
// myweb

public class MemberDto {
//1. 필드
	private int mno; 
	private String mid;
	private String mpw ;
	private String mmail;
	private String mimg ;
	private String mname;
	private String mphone;
  
//=========================================================================
   public MemberDto() {}

   public MemberDto(int mno, String mid, String mpw, String mmail, String mimg, String mname, String mphone) {
	super();
	this.mno = mno;
	this.mid = mid;
	this.mpw = mpw;
	this.mmail = mmail;
	this.mimg = mimg;
	this.mname = mname;
	this.mphone = mphone;
}
   // 회원가입 진행 시

public MemberDto(String mid, String mpw, String mmail, String mimg) {
	super();
	this.mid = mid;
	this.mpw = mpw;
	this.mmail = mmail;
	this.mimg = mimg;
}

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

public String getMpw() {
	return mpw;
}

public void setMpw(String mpw) {
	this.mpw = mpw;
}

public String getMmail() {
	return mmail;
}

public void setMmail(String mmail) {
	this.mmail = mmail;
}

public String getMimg() {
	return mimg;
}

public void setMimg(String mimg) {
	this.mimg = mimg;
}

public String getMname() {
	return mname;
}

public void setMname(String mname) {
	this.mname = mname;
}

public String getMphone() {
	return mphone;
}

public void setMphone(String mphone) {
	this.mphone = mphone;
}

@Override
public String toString() {
	return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mmail=" + mmail + ", mimg=" + mimg
			+ ", mname=" + mname + ", mphone=" + mphone + "]";
}

 
 
   
   
//=================================================================================
   
   
   
   
}
