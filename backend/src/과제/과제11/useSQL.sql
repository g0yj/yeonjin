#JDBC와 연결할 DB선언
drop database if exists sqldb4web;
create database sqldb4web;

#회원번호[자동] 아이디 비밀번호 이름 전화번호를 저장하는 member 테이블 생성
use sqldb4web;
drop database if exists member;
create table member(
	mno int auto_increment not null unique, 
    mid varchar(20) not null unique, 
    mpw varchar(20) not null, 
    mname varchar(20) not null, 
    mphone varchar(20) not null unique,
    primary key(mno)
    ); 
    select*from member;
    select mid from member;
    select mid,mpw from member;
    select mpw,mid from member;
    
    #회원가입 ( java랑 연동했기 때문에 자바에서 작성하면됨)
    insert into member(mid,mpw,mname,mphone)values('audtjq','1234','고명섭','010-2222-2222'); -- sql에서 직접 넣은 거
    insert into member(mid,mpw,mname,mphone)values(?,?,?,?);
    
    #로그인할때 필요한 필드 검색
    select mid,mpw from member; -- *로 전체를 다 가져와도 상관x  왜?! 우리가 필요한 건 로그인 성공 여부임. 검색 레코드가 있는지 없는지만 판단하면 되는거임!!
    
    #아이디와 패스워드가 일치한 레코드 검색
    select mid,mpw from member where mid='qwe';  #만약에 mid필드에 'qwe'문자열에 있는 레코드 검색
    select mid,mpw from member where mid='연진3000';
    select mid,mpw from member where mid='연진3000' and mpw='1234'; #만약에 mid필드가 '연진3000'이면서 비밀번호가 '1234'인 레코드 검색
    
    
    
    
    
    
    #로그인[테이블에 값 검색(select)]
    /*
		1. 테이블의 필드에 해당하는 레코드 검색
			select 필드명 from 테이블명 
			select*from 테이블명 									테이블의 모든필드[*]에 해당하는 레코드 검색
		
        2. 필드에 조건 추가
			select 필드명 from 테이블명 where 조건
            select 필드명, 필드명 from 테이블명 where 조건
            select * from 테이블명 where조건
    */
