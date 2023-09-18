package model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.productDto;

public class productDao extends Dao{

	private static productDao p = new productDao();
	public static productDao getInstance() {return p;}
	private productDao() {};
	
//1. 제품 등록---------------------------------------------------------------------------------------------------
	public boolean register(productDto productDto) {
		//1-1 제품등록
		try {
			String sql="insert into product(pcno,pname,pcontent,pprice,plat,plng,mno) value(?,?,?,?,?,?,?)";
			//*sql insert 후 자동생성[auto_]된 pk번호를 반환하는 방법
			ps=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, productDto.getPcno());
			ps.setString(2, productDto.getPname());
			ps.setString(3, productDto.getPcontent());
			ps.setInt(4, productDto.getPprice());
			ps.setString(5, productDto.getPlat());
			ps.setString(6, productDto.getPlng());
			ps.setInt(7, productDto.getMno());
			int count=ps.executeUpdate(); //제품등록
			
			rs=ps.getGeneratedKeys(); //제품 등록 시 생성된 식별키[pk]반환해서 resultset[ps]에 대입
			rs.next();//반환된 식별키들 중에서 다음으로 이동(시작이 null이기 때문에 한번 이동해줘야됨!)
			
			if(count==1) {//만약에 제품등록 1개 등록했으면
				//1-2 제품 등록 후 생성된 제품pk를 가지고 이미지 등록
					//1.dto에 저장된 이미지 개수만큼 insert 실행
						//Map<Integer,String>	: map객체명.keySet(): map객체 내 모든 키 호출
						//-----get(i) 안쓰는 이유?!-> map, set 컬렉션은 인덱스가 없음.
						//-----get(키) :set컬렉션 mapㅋ컬렉션은 키로 전달!
				for(String img: productDto.getImgList().values()) {
					sql="insert into productimg(pimg,pno) values(?,?)";
					
					ps=conn.prepareStatement(sql);
					ps.setString(1, img);
					ps.setInt(2,rs.getInt(1) ); // 위에서 insert된 제품 번호를 어케 가져온담?
					ps.executeUpdate();
				}//f
				return true;//제품등록과 이미지 등록 성공 했을 때 
			}
			
	} catch (Exception e) {System.out.println("dao오류: "+e);}
		return false;
	}
	
	
//2. 제품 전체 출력----------------------------------------------------------------------------------------
	
		//0. 제품 이미지 출력 함수(모든 출력함수에 공통으로 들어가는 내용을 함수화시킴)
	public Map< Integer , String > getProductImg( int pno){ // * 이미지테이블에서 현재 레코드의 제품 번호에 해당하는 (여러개)이미지 출력해서 map객체 담기 
		try {
			Map< Integer , String > imglist = new HashMap<>(); // 제품별 여러개 이미지 
			String sql = "select * from productimg where pno = "+pno; 
			PreparedStatement ps = conn.prepareStatement(sql);// * 다른 함수에서 먼저 사용중인 rs 인터페이스 객체 가 사용중 이므로 [ while ] 중복 사용불가능  // 해결방안 새로운 rs 만들기 ( PreparedStatement , ResultSet 2개 사용 )
			ResultSet rs =  ps.executeQuery();
			while(rs.next() ) { imglist.put( rs.getInt("pimgno"), rs.getString("pimg") ); } return imglist;
		}catch (Exception e) { System.out.println(e); } return null;
	}
	
	
	//3. 선택된 제품번호에 해당하는 제품 출력
	public productDto findByPno(int pno){
		try { 
			String sql ="select * from product p natural join pcategory pc natural join member m where p.pno="+pno;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				productDto productDto = new productDto(
						rs.getInt("pcno"), 
						rs.getString("pcname"), 
						rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getString("pcontent"), 
						rs.getInt("pprice"), 
						rs.getString("pstate"), 
						rs.getString("pdate"), 
						rs.getString("plat"), 
						rs.getString("plng"), 
						rs.getInt("mno"), 
						getProductImg( rs.getInt("pno") ), 
						rs.getString("mid"));				
				return productDto;
			}
		} catch (Exception e) { System.out.println(e);} 
		return null; 
	}
	
	//1. n개 제품들을 최신순으로 출력
	public List<productDto> findByTop(int count){
		List<productDto> list = new ArrayList<>();
		try { 
			String sql = "select * from product order by pdate desc limit "+count;
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ); 	} return list;
		} catch (Exception e) { System.out.println(e); } return null; 
	}
					//*위에서 먼저 사용중인 rs 인터페이스가 사용중이므로 [while] 중복 사용 불가능
					//해결방안: 새로운 rs 만들기 (PreparedStatement ,ResultSet 2개사용)
			/*	PreparedStatement ps2= conn.prepareStatement(sql);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()) {
					imglist.put(rs2.getInt("pimgno"),rs2.getString("pimg"));
					}
				
				productDto productDto=new productDto(
												rs.getInt("pcno"), 
												rs.getString("pcname"), 
												rs.getInt("pno"), 
												rs.getString("pname"), 
												rs.getString("pcontent"), 
												rs.getInt("pprice"), 
												rs.getString("pstate"), 
												rs.getString("pdate"), 
												rs.getString("plat"), 
												rs.getString("plng"), 
												rs.getInt("mno"), 
												imglist, 
												rs.getString("mid"));
				
			}//w
		} catch (Exception e) {System.out.println("Dao오류: "+e);}
		
		
		
		return null;}
	
	*/
		//2. 현재 카카오 지도 내 보고 있는 동서남북 기준 내 제품들을 출력
	public List<productDto> findByLatLng(String east,String west,String south,String north){
		try { 	// 제품의 경도가 '동쪽'보다 작고 경도가'서쪽'크고 위도가 '남쪽'보다 작고 '북쪽' 크다
			List<productDto> list = new ArrayList<>();
			String sql = "select*from product where plat>=? and plat<=? and plan>=? and plan<=? order by pdate";
			ps = conn.prepareStatement(sql); 
			
			ps.setString(1, east);
			ps.setString(2, west);
			ps.setString(3, south);
			ps.setString(4, north);
			
			rs = ps.executeQuery();
			while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ) ;	} return list;
		} catch (Exception e) { System.out.println(e); } return null; 
	}	
	
		//4. 모든 제품을 출력
	public List<productDto> findByAll(){
		try {
			List<productDto> list = new ArrayList<>();
			String sql ="select * from product"; ps = conn.prepareStatement(sql); rs = ps.executeQuery();
			while( rs.next() ) {  list.add( findByPno( rs.getInt("pno") ) ) ;	} return list;
		} catch (Exception e) { System.out.println(e); } return null; 
	}
	
//3. 제품 개별 조회------------------------------------------------------------------------------------
	
	
//4. 제품 수정----------------------------------------------------------------------------------------
	
	
//5. 제품 삭제-------------------------------------------------------------------------------------
	
	
	
	
}
