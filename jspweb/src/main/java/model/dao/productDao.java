package model.dao;


import java.sql.Statement;
import java.util.List;

import model.dto.productDto;

public class productDao extends Dao{

	private static productDao p = new productDao();
	public static productDao getInstance() {return p;}
	private productDao() {};
	
	//1. 제품 등록
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
	
	
	//2. 제품 전체 출력
	public List<productDto> findByTop(int count){return null;}
	public List<productDto> findByLatLng(String east,String west,String south,String north){return null;}
	public List<productDto> findByPno(int pno){return null;}
	public List<productDto> findByAll(){return null;}
	
	//3. 제품 개별 조회
	
	
	//4. 제품 수정
	
	
	//5. 제품 삭제
	
	
	
	
}
