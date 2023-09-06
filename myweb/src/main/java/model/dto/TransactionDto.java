package model.dto;

public class TransactionDto {
	int bno; 
    String codenumber; // 종목 코드
    String transactSelect; //매수-매도
    String amount; // 갯수
    String price; // 가격
    String ttitle ; // 코멘트제목
    String tcontent; //내용
    String tdate;// 거래날짜
	
    
//생성자-------------------------------------------------------    
    public TransactionDto() {}


	public TransactionDto(int bno, String codenumber, String transactSelect, String amount, String price, String ttitle,
			String tcontent, String tdate) {
		super();
		this.bno = bno;
		this.codenumber = codenumber;
		this.transactSelect = transactSelect;
		this.amount = amount;
		this.price = price;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tdate = tdate;
	}

//생성자 - 등록 시 사용
	public TransactionDto(String codenumber, String transactSelect, String amount, String price, String ttitle,
			String tcontent, String tdate) {
		super();
		this.codenumber = codenumber;
		this.transactSelect = transactSelect;
		this.amount = amount;
		this.price = price;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.tdate = tdate;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getCodenumber() {
		return codenumber;
	}


	public void setCodenumber(String codenumber) {
		this.codenumber = codenumber;
	}


	public String getTransactSelect() {
		return transactSelect;
	}


	public void setTransactSelect(String transactSelect) {
		this.transactSelect = transactSelect;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
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


	





}

