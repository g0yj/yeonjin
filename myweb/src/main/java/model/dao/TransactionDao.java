package model.dao;

import java.util.ArrayList;

import model.dto.TransactionDto;

public class TransactionDao extends Dao{

	private static TransactionDao t = new TransactionDao();
	public static TransactionDao getInstance() {return t;}
	private TransactionDao() {};
	
	
// 등록
	public boolean add(TransactionDto dto) {
		try {
			String sql="insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values (?,?,?,?,?,?,?);";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getTransactSelect());
			ps.setString(2, dto.getCodename());
			ps.setString(3, dto.getTamount());
			ps.setString(4, dto.getTprice());
			ps.setString(5, dto.getTtitle());
			ps.setString(6, dto.getTcontent());
			ps.setString(7, dto.getTdate());
			int count =ps.executeUpdate();
			if(count==1) {return true;}
		} catch (Exception e) {System.out.println("Dao오류: "+e);}
		return false;
	}//f()
	
	
//출력
	public ArrayList<TransactionDto> transactPrint() {
		ArrayList<TransactionDto> list= new ArrayList<>();
		
		try {
			String sql = "select transactSelect,codename,tamount,tprice,tdate from transaction";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				TransactionDto dto= new TransactionDto(rs.getString("transactSelect"), rs.getString("codename"), rs.getString("tamount"), rs.getString("transactSelect"), rs.getString("tprice"), rs.getString("tdate"));
				list.add(dto);
			}//w
			return list;
			
		} catch (Exception e) {System.out.println("출력Dao오류: "+e);}
		
		return null;
	}
	
	
}
