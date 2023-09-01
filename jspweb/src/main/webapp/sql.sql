drop database if exists jspweb;
create database jspweb;
use jspweb;

#방문록
drop table if exists visitlog;
create table visitlog(
	vno int auto_increment,
    vwriter varchar(30) not null, # 방문록작성자명, 공백 불가
    vpwd varchar(10) not null ,
    vcontent text,
    vdate datetime default now(), # 생략시 자동날짜/시간 등록
    primary key(vno)
    );
    
    select * from visitlog order by vdate desc;
    
    #1. 저장 insert / 레코드 추가
    # insert into visitlog(vwriter,vpwd,vcontent) value (?,?,?); 
    insert into visitlog(vwriter,vpwd,vcontent) values ('아','아','?'); 
 
 #2.호출 select  

#3.수정[삭제할 식별자 거의 필수]
update visitlog set vcontent='내용수정함' where vno=3; # vno3이면 vcontent필드의 값을 수정 
update visitlog set vcontent='내용수정함' where vno=3 and vpwd='1234'; #vno 3이면서 vpwd1234면 vcontent 내용 수정 
# update visitlog set vcontent=? where vno=3 and vpwd=?
#4.삭제 [삭제할 식별자 거의 필수]
-- delete from visitlog;
delete from visitlog where vno=3 and vpwd='1234'; #vno3 이면서 vpwd1234이면 레코드 삭제
# delete from visitlog where vno=? and vpwd=?;

#가계부
drop table if exists accountbook;
create table accountbook(
	ano int auto_increment,
    atext text not null ,
    apay varchar(200) not null,
    adate datetime default now(),
    primary key (ano)
);

#회원
drop table if exists member;
create table member(
	mno int auto_increment,
    mid varchar(20) not null unique,
    mpwd varchar(30) not null,
    memail varchar(50) not null unique ,
    mimg longtext , 
    primary key(mno)
);

#인사관리
drop table if exists hrm;
create table hrm(
	hno int auto_increment, #직원번호
    hname varchar(10) not null, #직원이름
    hposition varchar(10) not null ,#직급 
    hphone varchar(15) not null unique,#직원전화번호
    himg longtext,#직원사진
    hdate datetime default now(), #등록일
    primary key(hno)
);
select*from hrm;
insert into hrm (hname,hposition,hphone,himg) values ('고연진','사장','1','이미지');
insert into hrm (hname,hposition,hphone,himg) values (?,?,?,?);
select hname,hposition,hphone,hdate from hrm where hno=1;
select hname,hposition,hphone,hdate from hrm where hno=?;

#게시판 카테고리
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment,
    bcname varchar(30) not null,
    primary key (bcno)
);
insert into bcategory values(1,'공지사항');
insert into bcategory values(2,'자유게시판');
insert into bcategory values(3,'노하우');
select*from bcategory;

#게시판
drop table if exists board;
create table board(
	bno int auto_increment,
    btitle varchar(30) not null,
    bcontent longtext not null,
    bfile longtext,#첨부파일1개
    bdate datetime default now(),
    bview int default 0,
    mno int,
    bcno int,
    primary key (bno),
    foreign key (mno) references member(mno) on delete cascade, # 회원탈퇴 시 게시물도 같이 삭제[제약조건]
    foreign key (bcno) references bcategory (bcno) on delete cascade on update cascade # 카테고리 삭제 시 게시물도 삭제, 카테고리번호 변경시 fk도 같이 변경
);

select*from board;


#회원가입
insert into member(mid,mpwd,memail,mimg)values('유재석','a1234','123@123.com','default.jpg');
insert into member(mid,mpwd,memail,mimg)values(?,?,?,?);

#아이디중복검사[특정 mid의 아이디로 검색했을 때 존재하면 중복] 
select*from member where mid='eee';
select*from member where mid=?;
select mid from member where mid=?;

#로그인[아이디와 비밀번호가 일치한 레코드가 있냐 없냐]
select*from member where mid='duswls3333' and mpwd='Gg1234';
select*from member where mid=? and mpwd=?;

#회원정보 호출 [아이디를 이용한 패스워드를 제외(보안)한 모든 회원정보 호출]
select mno, mid, memail, mimg from member where mid=?;

#회원탈퇴 [누구를 탈퇴할지, 검증(탈퇴할 회원의 패스워드)]
delete from member where mid='rhduswls'; 
delete from member where mno=? and mpwd=?;

#프로필수정[누구(mno)를 수정할껀지, 수정할 내용(사진명)]
update member set mimg='ad.jpg' where mno=1; 
update member set mimg=? where mno=?; 



select*from accountbook;
select atext,apay,adate from accountbook where ano=1;

insert into accountbook(atext,apay) values ('고연진가계부','10000');
# insert into accountbook(atext,apay,adate) values (?,?,?);

update accountbook set atext='수정할내용' , apay='수정금액' where ano=1;
update accountbook set atext=? , apay=? where ano=?;

delete from accountbook where ano=1;
delete from accountbook where ano=?;

select*from member;