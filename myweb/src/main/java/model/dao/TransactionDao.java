package model.dao;

import model.dto.TransactionDto;

public class TransactionDao extends Dao{

	private static TransactionDao t = new TransactionDao();
	public static TransactionDao getInstance() {return t;}
	private TransactionDao() {};
	
	
// 등록
	public boolean add(TransactionDto dto) {
		try {
			String sql="insert into transaction (codenumber,transactSelect,amount,price,ttitle,tcontent,tdate) values (?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getCodenumber());
			ps.setString(2, dto.getTransactSelect());
			ps.setString(3, dto.getAmount());
			ps.setString(4, dto.getPrice());
			ps.setString(5, dto.getTtitle());
			ps.setString(6, dto.getTcontent());
			ps.setString(7, dto.getTdate());
			int count =ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("Dao오류: "+e);}
		return false;
	}//f()
	
	
}
