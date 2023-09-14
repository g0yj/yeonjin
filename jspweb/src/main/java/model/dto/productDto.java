package model.dto;

import java.util.HashMap;
import java.util.Map;

public class productDto {
	
	int pcno; 	//카테고리번호
	String pcname; // 카테고리명
	int pno;
	String pname ;
	String pcontent ;
	int pprice;
	String pstate; //[0: 판매중 , 1:거래중 , 2: 판매대기, 3: 판매완료]
	String pdate; 
	String  plat ;
	String  plng ;
	int mno;
	
	// 키: 이미지번호, 값: 이미지
	Map<Integer, String> imgList= new HashMap<>(); // 이미지 여러개 넣어야됨.
	//-
	String mid;//*제품 등록한 회원의 아이디

	
// 생성자------------------------------------------------------------------------------------	
	public productDto() {}

	public productDto(int pcno, String pcname, int pno, String pname, String pcontent, int pprice, String pstate,
			String pdate, String plat, String plng, int mno, Map<Integer, String> imgList, String mid) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
		this.pno = pno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.pstate = pstate;
		this.pdate = pdate;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
		this.mid = mid;
	}

	//등록 시 필요한 생성자
	
	public productDto(int pcno, String pname, String pcontent, int pprice, String plat, String plng, int mno,
			Map<Integer, String> imgList) {
		super();
		this.pcno = pcno;
		this.pname = pname;
		this.pcontent = pcontent;
		this.pprice = pprice;
		this.plat = plat;
		this.plng = plng;
		this.mno = mno;
		this.imgList = imgList;
	}
	
	
//메소드----------------------------------------------------------------------------------------	
	public int getPcno() {
		return pcno;
	}


	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public String getPlng() {
		return plng;
	}

	public void setPlng(String plng) {
		this.plng = plng;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public Map<Integer, String> getImgList() {
		return imgList;
	}

	public void setImgList(Map<Integer, String> imgList) {
		this.imgList = imgList;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "productDto [pcno=" + pcno + ", pcname=" + pcname + ", pno=" + pno + ", pname=" + pname + ", pcontent="
				+ pcontent + ", pprice=" + pprice + ", pstate=" + pstate + ", pdate=" + pdate + ", plat=" + plat
				+ ", plng=" + plng + ", mno=" + mno + ", imgList=" + imgList + ", mid=" + mid + "]";
	}
	
	
	
	
	
	
}
