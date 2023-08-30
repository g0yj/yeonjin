package model.dto;

public class HrmDto {
	
	//필드
	private int hno; 
	private String hname; 
	private String hposition;
	private String hphone;
	private String himg; 
	private String hdate;

	//빈생성자
	public HrmDto() {}
	
	//풀생성자
	public HrmDto(int hno, String hname, String hposition, String hphone, String himg, String hdate) {
		super();
		this.hno = hno;
		this.hname = hname;
		this.hposition = hposition;
		this.hphone = hphone;
		this.himg = himg;
		this.hdate = hdate;
	}

	//인사등록 시 사용
	
	public HrmDto(String hname, String hposition, String hphone, String himg) {
		super();
		this.hname = hname;
		this.hposition = hposition;
		this.hphone = hphone;
		this.himg = himg;
	}
	
	//출력 시 사용
	
	
	
	//메소드
	public int getHno() {
		return hno;
	}


	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHposition() {
		return hposition;
	}

	public void setHposition(String hposition) {
		this.hposition = hposition;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", hname=" + hname + ", hposition=" + hposition + ", hphone=" + hphone + ", himg="
				+ himg + ", hdate=" + hdate + "]";
	}
	
	
	
	

	

	
}
