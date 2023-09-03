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
select*from mmember;
select mid from mmember where mid='duswls';
-- select mid from mmember where mid=?