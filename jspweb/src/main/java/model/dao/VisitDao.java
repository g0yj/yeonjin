package model.dao;

import java.util.ArrayList;

import model.dto.VisitLogDto;

public class VisitDao extends Dao{

	private static VisitDao visitDao=new VisitDao();
	private VisitDao() {}
	public static VisitDao getVisitDao() {return visitDao;}

	//1. 저장[인수: 저장할 내용이 담긴 dto/ 리턴: 성공/실패 =boolean]
	public boolean vwrite(VisitLogDto dto) {
		try {
			String sql = "insert into visitlog(vwriter,vpwd,vcontent) value (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getVwriter());
			ps.setString(2, dto.getVpwd());
			ps.setString(3, dto.getVcontent());
			ps.executeUpdate();
			return true;
		
		}catch (Exception e) {System.out.println("dao실패:"+e);}
		return false;
	}
	
	
	//2. 호출[인수 없 / 리턴: 여러개의 방문록 dto=모든 레코드 가져오기]
	public ArrayList<VisitLogDto> vread(){
		
		ArrayList<VisitLogDto>list=new ArrayList<>();
		try {
			String sql = "select * from visitlog order by vdate desc";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				//레코드를 dto로 변환 (레코드마다 각 필드 호출 = rs.get타입(필드순번) vs rs.get타입("필드명")
				VisitLogDto visitDto = new VisitLogDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				//여러개 DTO를 리스트에 저장
				list.add(visitDto);
				
			}
		}catch (Exception e) {System.out.println("dao오류: "+e);}
		return list;}
	
	
	
	
	//3. 수정[인수 : 수정할 방문록번호, 수정할 방문록 내용, 비밀번호검토(string) / 리턴: true/false]
	public boolean vupdate(int vno , String vcontent, String vpwd) {
		try {
			String sql = "update visitlog set vcontent=? where vno=? and vpwd=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(2, vno);
			ps.setString(1, vcontent);
			ps.setString(3, vpwd);
			int row = ps.executeUpdate();
			if(row==1) {return true;}
			else {return false;}
		} catch (Exception e) {System.out.println("dao: "+e);}
		return false;}
	
	//4. 삭제[인수: 삭제할방문록번호, 비밀번호검토(string) /리턴: true/false]
	public boolean vdelete(int vno,String vpwd) {
		try {
			String sql = "delete from visitlog where vno=? and vpwd=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vno);
			ps.setString(2, vpwd);
			int row =ps.executeUpdate();
			if(row==1) {return true;}
			else {return false;}
		}catch (Exception e) {System.out.println("dao실패: "+e);}
		
		return false;}







}
