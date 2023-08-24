package model.dto;

public class VisitLogDto {
	//1. 필드
	private int vno; 
	private String vwriter; 
	private String vpwd;
	private String vcontent; 
	private String vdate ;

    //2. 생성자
    public VisitLogDto() {
	}

	public VisitLogDto(int vno, String vwriter, String vpwd, String vcontent, String vdate) {
		super();
		this.vno = vno;
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
		this.vdate = vdate;
	}
	
	// 저장할 때 사용하는 생성자
	
	public VisitLogDto(String vwriter, String vpwd, String vcontent) {
		super();
		this.vwriter = vwriter;
		this.vpwd = vpwd;
		this.vcontent = vcontent;
	}
	
	
	
	
	//메소드-------------------------------------------------
	public int getVno() {
		return vno;
	}


	public void setVno(int vno) {
		this.vno = vno;
	}

	public String getVwriter() {
		return vwriter;
	}

	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getVcontent() {
		return vcontent;
	}

	public void setVcontent(String vcontent) {
		this.vcontent = vcontent;
	}

	public String getVdate() {
		return vdate;
	}

	public void setVdate(String vdate) {
		this.vdate = vdate;
	}

	@Override
	public String toString() {
		return "VisitLogDto [vno=" + vno + ", vwriter=" + vwriter + ", vpwd=" + vpwd + ", vcontent=" + vcontent
				+ ", vdate=" + vdate + "]";
	}
    
    
    
    
    
    
}
