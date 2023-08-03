create table 상호(
   호점_pk int,
    전화번호 int,
    primary key(호점_pk)
);
create table 강의실(
   강의실코드_pk int, 
   호수 int,
    수업코드_fk int,
   호점_fk int,
   직원코드_fk int,
    primary key(강의실코드_pk),
    foreign key(호점_fk) references 상호(호점_pk),
    foreign key(수업코드_fk) references 수업(수업코드_pk),
    foreign key(직원코드_fk) references 직원(직원코드_pk)
);
create table 직원(
   직급 varchar(10), 
    이름 varchar(10),
    직원코드_pk int,
    primary key(직원코드_pk)
);
 create table 수업(
   수업코드_pk int,
    수업이름 varchar(10),
   primary key(수업코드_pk)
 );
create table 학생(
   강의실코드_fk int,
    이름 varchar(10),
    학생번호_pk int,
    primary key(학생번호_pk),
    foreign key(강의실코드_fk) references 강의실(강의실코드_pk)
);
create table 출결(
   출결번호_pk int,
    학생번호_fk int,
    출결여부 boolean,
    날짜 datetime,
    primary key(출결번호_pk),
    foreign key(학생번호_fk) references 학생(학생번호_pk)
);