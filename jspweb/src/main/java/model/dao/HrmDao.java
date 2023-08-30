package model.dao;

import java.util.ArrayList;

import model.dto.HrmDto;

public class HrmDao extends Dao{
	private static HrmDao d= new HrmDao();
	public static HrmDao getInstance() {return d;}
	private HrmDao() {};
	
	//1. 인사등록-----------------------------------
	public boolean hrmjoin(HrmDto dto) {
		try {
			String sql="insert into hrm (hname,hposition,hphone,himg) values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getHname());
			ps.setString(2, dto.getHposition());
			ps.setString(3, dto.getHphone());
			ps.setString(4, dto.getHimg());
			int row= ps.executeUpdate();
			if(row==1) {return true;}
			else {return false;}
		} catch (Exception e) {System.out.println(e);}
		return false;
	}//f()
	
	
	//2. 출력 (인수x,리턴dto)-----------------------------------
	public ArrayList<HrmDto> print() {
		ArrayList<HrmDto>list=new ArrayList<>();
		try {
			String sql="select * from hrm";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();

				while(rs.next()) {
					HrmDto dto1= new HrmDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)); 
					list.add(dto1);
				}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}//f()
	
}
