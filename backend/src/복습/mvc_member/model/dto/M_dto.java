package 복습.mvc_member.model.dto;

public class M_dto {
	
	//1.필드
		// private로 생성 하도록 권장
		//sql과 변수명은 동일하게 할 걸 권장(db연동예정)
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	
	//2.생성자
	public M_dto() {}


	public M_dto(int mno, String mid, String mpw, String mname, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
	}


	public M_dto(String mid, String mpw, String mname, String mphone) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
	}
	

	//3. 메소드
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
		return "M_dto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone + "]";
	}	
	
	
	
	
	
}
