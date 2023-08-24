package model.dao;

import java.util.ArrayList;

import model.dto.AccountbookDto;

public class AccountbookDao extends Dao{

	private static AccountbookDao d= new AccountbookDao();
	public static AccountbookDao getInstance() {return d;}
	private AccountbookDao() {};
	
//저장 : 인수-dto , 리턴-t/f-------------------------------------
	public boolean awrite(AccountbookDto dto) {
		try {
			String sql ="insert into accountbook(atext,apay) values (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getAtext());
			ps.setString(2, dto.getApay());
			int row= ps.executeUpdate();
			if(row==1) {return true;}
			else {return false;}
		} catch (Exception e) {System.out.println("dao연동실패"+e);}
		return false;
	}//f()

//출력: 인수x , 리턴 dto---------------------------------------
	public ArrayList<AccountbookDto> aread(){
		ArrayList<AccountbookDto> list= new ArrayList<>();
		try {
			String sql ="select *from accountbook order by adate desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				AccountbookDto dto = new AccountbookDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(dto);
				}
		} catch (Exception e) {System.out.println("dao연동: "+e);}
		return list;
	}
	
//수정: 인수:dto / 리턴:t/f-----------------------
	public boolean aupdate(int ano, String atext, String apay) {
		try {
			String sql ="update accountbook set atext=? , apay=? where ano=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(3,ano);
			ps.setString(1,atext);
			ps.setString(2, apay);
			int row =ps.executeUpdate();
			if(row==1) {return true;}
			//else {return false;}
		} catch (Exception e) {System.out.println("dao실패: "+e);}
		
		return false;
	}
	
//삭제: 인수 ano /리턴 :t/f
	public boolean adelete(int ano) {
		try {
			String sql = "delete from accountbook where ano=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ano);
			int row= ps.executeUpdate();
			if(row==1) {return true;}
			else {return false;}
		} catch (Exception e) {System.out.println("오류이유: "+e);}
		return false;
		}
	
}//c
