GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
drop database if exists myweb;
create database myweb;
use myweb;

drop table if exists mmember;
create table mmember(
   mno int auto_increment,
    mid varchar(15) not null unique,
    mpw varchar(15) not null,
    mmail varchar(30) not null unique,
    mimg longtext,
    mname varchar(10),
    mphone varchar(15) unique,
    primary key (mno)
);
insert into mmember (mid,mpw,mmail,mphone)  values ('duswls','Gg1234','duswls3000@naver.com',1);
insert into mmember (mid,mpw,mmail,mphone)  values ('duswls3000','Gg1234','duswls@naver.com',2);

drop table if exists codetable;  # 종목테이블
create table codetable(
   codenumber int not null unique,
    codename varchar(10) not null unique,
    primary key (codenumber)
);
insert into codetable (codenumber,codename) values(388050,'지투파워');
insert into codetable (codenumber,codename) values(005860,'한일사료');
insert into codetable (codenumber,codename) values(033180,'KH필룩스');
insert into codetable (codenumber,codename) values(053050,'지에스이');
insert into codetable (codenumber,codename) values(065350,'신성델타테크');
insert into codetable (codenumber,codename) values(090460,'비에이치');
insert into codetable (codenumber,codename) values(092220,'KEC');
insert into codetable (codenumber,codename) values(112040,'위메이드');
insert into codetable (codenumber,codename) values(206560,'덱스터');
insert into codetable (codenumber,codename) values(247540,'에코프로비엠');
insert into codetable (codenumber,codename) values(256840,'한국비엔씨');
insert into codetable (codenumber,codename) values(294630,'서남');
insert into codetable (codenumber,codename) values(323990,'박셀바이오');
insert into codetable (codenumber,codename) values(347860 ,'알체라');

select*from codetable;

drop table if exists transaction; # 매수-매도 거래
create table transaction(
   bno int auto_increment,  # 거래내역
    transactSelect varchar(2), # 매수/매도 선택
    codename varchar(10),   # 종목이름
    tamount varchar(4), #거래 갯수
    tprice varchar(10), #거래가격
    ttitle varchar(50),
    tcontent longtext,
    tdate datetime default now(),
    codenumber int,#종목코드 
    primary key (bno),
    foreign key (codenumber) references codetable (codenumber)
);

insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매수','신성','10','6600','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-05-10');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매수','신성','20','6000','제목11:샘플데이터로 아무거나 적어봅니다','내용11:샘플데이터 내용으로 주식 대박나게 해주세요','2023-05-12');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매수','신성','80','6100','제목22:샘플데이터로 아무거나 적어봅니다','내용22:샘플데이터 내용으로 주식 대박나게 해주세요','2023-05-15');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매수','신성','10','6040','제목44:샘플데이터로 아무거나 적어봅니다','내용44:샘플데이터 내용으로 주식 대박나게 해주세요','2023-05-16');
insert into transaction (transactSelect,codename,tamount,tprice,tdate) values ('매수','신성','10','6040','2023-05-16');
insert into transaction (transactSelect,codename,tamount,tprice,tdate) values ('매수','신성','50','6000','2023-05-18');
insert into transaction (transactSelect,codename,tamount,tprice,tdate) values ('매수','신성','10','5900','2023-05-19');

insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매도','신성','20','6650','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-05-16');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매도','신성','10','7120','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-06-08');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매도','신성','20','6650','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-06-09');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매도','신성','30','7000','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-06-19');
insert into transaction (transactSelect,codename,tamount,tprice,ttitle,tcontent,tdate) values ('매도','신성','100','6650','제목:샘플데이터로 아무거나 적어봅니다','내용:샘플데이터 내용으로 주식 대박나게 해주세요','2023-06-26');

 select transactSelect,codename,tamount,tprice,tdate from  transaction;

-- insert into mmember(mid,mpw,mmail,mimg) values(?,?,?,?)

select*from mmember;
select*from transaction;
select * from mmember where mid='duswls';
-- select mid from mmember where mid=?