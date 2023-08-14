
# 기본 세팅-----------------------------------------------------------------------------------------------------------------------------------
drop database if exists sqldb4web;
create database sqldb4web;
use sqldb4web;

drop table if exists member;
create table member(          
   mid char(8) not null ,         # 식별키       
    mname varchar(10) not null ,   # 그룹명    
    mnumber int not null ,         # 인원수      
    maddr char(2) not null ,       # 지역     
    mphone1 char(3) ,            # 지역번호    
    mphone2 char(8) ,            # 전화번호    
    mheight smallint ,            # 평균키      
   mdebut date ,               # 데뷔일       yyyy-mm-dd 
    primary key ( mid )        # 제약조건 
);

drop table if exists buy;
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여 
    mid char(8),                  # 구매자      FK 
    bpname char(6) not null ,         # 제품명      최대 6자리 
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수 
    bamout smallint not null ,         # 구매수량   정수 
    primary key(bnum) ,               # 제약조건 
    foreign key ( mid ) references member(mid) # 제약조건 
);

# 샘플데이터 ---------------------------------------------------------------------------------------------------------------------------------
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);


# select문----------------------------------------------------------------------------------------------------------------------------------

# 1. 테이블의 전체 레코드 검색
select*from member;
select*from buy;

#2. 테이블 전체 레코드 검색 [특정 필드 표시]
select mid from member;
select mid , mname from member;

# 3. 필드의 별칭 [필드명 as 별칭 vs  필드명 별칭  - 검색결과에 표시할 필드명의 별명. 실제 필드명이 변경되는 건 아님]
select mid as 그룹식별명 from member;
select mid 그룹식별명 from member;
select mid 그룹식별명 from member m;

#------------------------------------------------------------------------------------------------------------------------------------------
# 4. 조건절[where 조건절]
select* from member where mname = '블랙핑크'; # 1. 필드의 값[문자이면 '']이 일치한 레코드 검색 
select*from member where mnumber=4; # 2. 필드의 값 [숫자] 이 일치한 레코드 검색 
select*from member where mheight<=162;  # 3. 필드의 값이 이하이면 레코드 검색
select*from member where mheight>=165 and mheight <170; # 4. 필드의 값이 이상이면서 이하이면 레코드 검색
	select*from member where mheight between 165 and 170; # 4번과 동일한 효과
select*from member where mheight>=165 or mnumber>6;	#5. 필드의 값이 이상 이거나 초과 이면 레코드 검색
select*from member where maddr='경기' or maddr='전남' or maddr='경남';
	select*from member where maddr in('경기','전남','경남');
    select*from member where not maddr in('경기','전남','경남');
select*from member where mname = '에이핑크';
select*from member where not mname='에이핑크'; #'에이핑크'가 아니면
select*from member where mname != '에이핑크';	
select*from member where mname like '에이%';	# 6. '에이'로 시작하는 문자
select*from member where mname like '%핑크'; # 7. '핑크'로 끝나는 문자
select*from member where mname like '에이_'; # 8. '에이'로 시작하는 세글자
select*from member where mname like'_핑크'; # 9. '핑크'로 끝나는 세글자 
select*from member where mname like '%우%'; #10. '우'가 포함된 문자
select*from member where mname like '_우_'; #11. '우'가 두번째에 위치한 세글자 
select mname 그룹명 , mnumber 멤버수 , 
	mnumber +10, mnumber-10, mnumber*10, mnumber div 3 , mnumber mod 3,
    mnumber*mheight
from member;								#12. 산술연산자. 필드끼리도 가능 

select*from member where mphon1='';		 # 공백검색
select*from member where mphon1=' ';	 # 띄어쓰기 하나 들어간 데이터 검색
select*from member where mphone1 = null;	# 오류는 안나지만 불가능 
select*from member where mphone1 is null;  # null 검색
select*from member where mphone1 is not null; # null 아닌 검색


# 5. 검색 결과의 레코드 정렬------------------------------------------------------------------------------------------------------
#[ order by 필드명 asc/desc] 
	# acs: 오름차순, 작은수->큰수 ,과거날짜->최근날짜
    # desc: 내림차순, 큰수-> 작은수 ,최근날짜-> 과거날짜
select*from member order by mdebut asc; #데뷔일 필드 기준으로 오름차순
select*from member order by mdebut desc; #데뷔일 필드 기준으로 내림차순

# 정렬 기준 2개 이상[order by 필드명 정렬기준, 필드명 정렬기준]
	# 첫번째 정렬 후 동일한 키가 있을 경우 동일한 키 중에서 데뷔날짜를 오름차순
select*from member order by mheight desc, mdebut asc; 


#6. 검색된 레코드 제한 [limit 레코드수 , limit 시작레코드번호, 개수]--------------------------------------------------------------------------
select*from member limit 2; # 검색 결과의 레코드를 2개만 표시 
select*from member limit 0, 3;	# 0(첫번째)레코드부터 3개만 표시 
select*from member order by mheight desc limit 3;

#7. 검색된 필드의 레코드 중복 제거[distinct]---------------------------------------------------------------------------------------------
select maddr from member; 
select distinct maddr from member;	# 모든 주소에서 중복 제거 검색

#----------------------------------------------------------------------------------------------------------------------
create table board(
	bno			int	auto_increment , 	#정수 , 자동번호 부여  
    btitle		varchar(50) not null , 	#문자50 , 공백불가 
    bcontent	longtext , 				#긴글[4G]
    bdate		datetime default now(),	#날짜/시간 , 기본값을 레코드삽입기준 자동 
    bview		int default 0 ,			#정수 , 기본값을 0 
    mno			int ,					#작성자의 회원번호[ 작성자의 식별번호 ]
    primary key( bno )	,				#제약조건 [ PK ]
	foreign key( mno ) references member( mno ) on delete cascade  		# 회원탈퇴[PK레코드삭제] 되면 FK의 레코드 같이 삭제 
    #foreign key( mno ) references member( mno ) on delete restrict 	# (생략시기본값)회원탈퇴[PK레코드삭제] 할때 FK의 레코드가 존재하면 탈퇴 불가능 
    #foreign key( mno ) references member( mno ) on delete set null  	# 회원탈퇴[PK레코드삭제] 되면 FK의 값을 NULL 수정 
    #foreign key( mno ) references member( mno ) on delete no action 	# 아무런 변화 없는상태.
);


#------------------------------------------------------------------------------------------------------------------
# 테이블 합치기
# 1. select * from 테이블명1 , 테이블명2 	[ 레코드수 X 레코드수 ]
select * from member , board;
# 2. 테이블 합치는데 기준!!! [ PK --- FK 연관 ]
	# member pk = mno	/	board fk = mno
    # 1. 조건 조인 [ pk필드와 fk필드가 일치하면 검색 ] * 일반 조건들과 가독성 떨어짐 [ 조인을 위한 조건인지 식별 힘듬 ]
select * from member , board where member.mno = board.mno;
	# 테이블명 이 길어지면 sql문도 길어져서 그래서 *별칭!!! : 하나의 쿼리문 다수의 테이블이 존재할때. 식별용
	select * from member m , board b where m.mno = b.mno;
	# 2. 자연 조인 [ 자동으로 두 테이블간 pk필드와 fk필드를 식별해서 조인 ]	* pk 다수일때 힘듬 
select * from member natural join board;
	select * from member m natural join board b;
    # * 내가 보고 싶은것만 필드 골라서 출력 
    # b.* : board 테이블 모든 필드 
    # m.mid : member 테이블의 mid 필드
select b.* , m.* from member m natural join board b;
select b.* , m.mid from member m natural join board b;
select b.* , m.mid from member m natural join board b order by b.bdate desc;


# 1. 날짜/함수
	# 1. now() : 현재 시스템[db서버의pc]의 날짜/ 시간 반환
select now();
	#2. curdate() : 현재 시스템의 날짜 반환
select curdate();
	#3. curtime() : 현재 시스템의 시간 반환 
select curtime();
	#4. year(날짜) /  month(날짜) /  day(날짜) / 
		# weekday(날짜)- 해당 날짜의 연도 반환  
        # last_day(날짜)- 해당 날짜의 연도 반환
		# date('연도-월-일') - - 또는 . 사용
select year(now()),month(now()), weekday(now()), date('2023-09-13');
select hour(now()), minute(now()),second(now());

	# date_format(필드명, '형식') - 날짜/시간 형식 기준으로 변환<- java나 js 에서 가능하지만 db에서 꺼낼 때 변형해서 내보내는 걸 추천 
		# 날짜형식:  %y 년도2자리 %Y 년도4자리 %m 월2자리 %c 월1자리 %M월[영문]2자리 %d 일2자리 %D 일[서수] %e 일1자리 %W 요일(영문) %a 요일(영문약자) <- '-'는 원하는 문자를 넣으면 됨. 
select date_format(now(),'%y년 - %Y - %m월 - %M월 - %c월');
		# 시간형식: %H 시2자리 %i 분2자리 %S 초2자리 
select date_format(now(),'%H : %i : %S');
select date_format(time('11:10:30') , '%H시 %i분 %S초'  );
select date_format( now() , '%y년 - %Y년 - %m월 - %M월 - %c월 - %D일 - %e일' );
# 예)
    select * from member;
    select mname as 그룹명 , date_format( mdebut , '%Y년 %m월 %d일' ) as 데뷔일 from member;
    select date_format( time('11:10:30') , '%H %i분 %5초' );



# 2. 집계함수 
	#1. sum(필드명) : 해당 필드의 값 총합계 
select sum(bamout) as 총구매수량 from buy;
	#2. avg(필드명) : 해당 필드값의 평균 
select avg(bamout) as 구매수량평균 from buy;
	#3. max(필드명) : 해당 필드의 최댓값
    #4. min(필드명) : 해당 필드의 최솟값 
	#5. count(필드명) : 해당 필드의 레코드 수 , null 포함X   [상품 그룹의 개수] 
select count(bgname) as 구매횟수 from buy;
	#6. count(*) : 해당 필드의 레코드 수 , null 포함O 
select count(*) as 구매횟수 from buy;  # 상품 그룹의 개수 

	# 3. 수학함수
		# 1. abs(필드/값) :절대값 
select abs(100) , abs(-100);
		# 2.ceil(필드/값) : 올림
select ceil(10.1),ceil(10.4) , ceil(10.5) , ceil(10.0);
		# 3.floor(필드/값) : 내림
select floor(10.1),floor(10.4) , floor(10.5) , floor(10.0);
		# 4-1. round(필드/값) :반올림 
select round(10.1),round(10.4) , round(10.5) , round(10.0);
		# 4-2. round(필드/값, 표시할자리수) :반올림
select round(1.123456789,1),round(1.123456789,4) , round(1.123456789,7);
		#5. truncate(필드/값 , 표시할자리수) : 자르기 
select truncate(1.123456789,1),truncate(1.123456789,4) , truncate(1.123456789,7);
select pow(10,2);
