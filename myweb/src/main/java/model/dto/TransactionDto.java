package model.dto;

public class TransactionDto {
	int bno; 
    String codename; // 종목 코드
    String transactSelect; //매수-매도
    String tamount; // 갯수
    String tprice; // 가격
    String ttitle ; // 코멘트제목
    String tcontent; //내용
    String tdate;// 거래날짜
	
    // 출력 함수를 위해 추가
    int codenumber; //코드번호
    
//생성자-------------------------------------------------------    
    public TransactionDto() {}


	public TransactionDto(int bno, String codename, String transactSelect, String tamount, String tprice, String ttitle,
			String tcontent, String tdate) {
		super();
		this.bno = bno;
		this.codename = codename;
		this.transactSelect = transactSelect;
		this.tamount = tamount;
		this.tprice = tprice;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tdate = tdate;
	}

//글등록
	public TransactionDto(String transactSelect, String codename, String tamount, String tprice, String ttitle,
			String tcontent, String tdate) {
		super();
		this.transactSelect = transactSelect;
		this.codename = codename;
		this.tamount = tamount;
		this.tprice = tprice;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tdate = tdate;
	}


 //전체출력	
	
	public TransactionDto(int bno, String codename, String transactSelect, String tamount, String tprice, String ttitle,
			String tdate) {
		super();
		this.bno = bno;
		this.codename = codename;
		this.transactSelect = transactSelect;
		this.tamount = tamount;
		this.tprice = tprice;
		this.ttitle = ttitle;
		this.tdate = tdate;
	}
	
	
//메소드---------------------------------------------------------	
	
	
	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getCodename() {
		return codename;
	}


	public void setCodename(String codename) {
		this.codename = codename;
	}


	public String getTransactSelect() {
		return transactSelect;
	}


	public void setTransactSelect(String transactSelect) {
		this.transactSelect = transactSelect;
	}


	public String getTamount() {
		return tamount;
	}


	public void setTamount(String tamount) {
		this.tamount = tamount;
	}


	public String getTprice() {
		return tprice;
	}


	public void setTprice(String tprice) {
		this.tprice = tprice;
	}


	public String getTtitle() {
		return ttitle;
	}


	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}


	public String getTcontent() {
		return tcontent;
	}


	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}


	public String getTdate() {
		return tdate;
	}


	public void setTdate(String tdate) {
		this.tdate = tdate;
	}


	public int getCodenumber() {
		return codenumber;
	}


	public void setCodenumber(int codenumber) {
		this.codenumber = codenumber;
	}




}

