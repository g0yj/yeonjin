package model.dto;

public class AccountbookDto {
	
	//필드
	private int ano;
	private String atext;
	private String apay;
	private String adate;
     
     //생성자
     public AccountbookDto() {}

	public AccountbookDto(int ano, String atext, String apay, String adate) {
		super();
		this.ano = ano;
		this.atext = atext;
		this.apay = apay;
		this.adate = adate;
	}


	//등록할때
	public AccountbookDto(String atext, String apay) {
		super();
		this.atext = atext;
		this.apay = apay;
	}
	
	//출력할때
	
	public AccountbookDto(String atext, String apay, String adate) {
		super();
		this.atext = atext;
		this.apay = apay;
		this.adate = adate;
	}
	

	//메소드----------------------------------------------------	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAtext() {
		return atext;
	}

	public void setAtext(String atext) {
		this.atext = atext;
	}

	public String getApay() {
		return apay;
	}

	public void setApay(String apay) {
		this.apay = apay;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	@Override
	public String toString() {
		return "AccountbookDto [ano=" + ano + ", atext=" + atext + ", apay=" + apay + ", adate=" + adate + "]";
	}
	

	
	
     
     
     
     
     
}
