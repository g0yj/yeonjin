/*
			-1. DDL [ 데이터베이스 정의어 ]
				- 1. create 	: 데이터베이스 , 테이블(표) 생성
					- create database db명;
                    - create table table명( 필드명 속성명 , 필드명 속성명 , 필드명 속성명 );
                    
                - 2. drop 		: 데이터베이스 , 테이블(표) 삭제 
					- drop database db명;
                    - drop database if exists db명;
                    - drop table table명;
                    
                - 3. alter 		: 테이블(표) 속성 수정 
                - 4. truncate  	: 테이블(표)내 데이터 초기화/삭제
                - 5. rename 	: 테이블(표) 의 이름 변경 
                - 6. show		:
					- show databases;					: 데이터베이스 전체 목록보기 
                    - show variables like 'datadir';	: 데이터베이스 저장소 로컬 경로 확인 
				- 7. use
					- use db명	: 데이터베이스 사용 선택
                    
            -2. DML [ 데이버베이스 조작어 ]
				- 1. insert 	: 테이블(표)에 레코드(행) 삽입 
                	# 1. insert into 테이블명 values( 값1 , 값2 , 값3 );					# 모든 필드에 값 삽입 할때
					# 2. insert into 테이블명( 필드명1, 필드명2 ) values( 값1 , 값2 ) 		# 특정 필드에 값 삽입 할때.
                    
                - 2. select 	: 테이블(표)에 레코드(행) 검색 
					- select * from 테이블명	: 테이블내 모든 필드의 레코드(행) 검색 [ * : 와일드카드(모든) ]
                    
                - 3. update 	: 테이블(표)에 레코드(행) 수정 
                - 4. delete 	: 테이블(표)에 레코드(행) 삭제 
            -3. DCL [ 데이터베이스 제어어 ]
				- 1. grant		: 사용자 권한 부여 
                - 2. revoke		: 사용자 권한 취소 
            -4. TCL [ 트랜잭션 제어어 ]
				- 1. commit		: !! 트랜잭션[명령어 단위] 완료
                - 2. rollback	: 트랜잭션[명령어 단위] 취소
                
  

               int			[4] 		: +-21억정도

               double		[8]			: 소수점 15자리 
			
			문자
				char(문자길이)			: [ 글자수 최소1~최대255 ] 고정길이			
                varchar(문자길이)			: [ 글자수 최소1~최대65535 ] 가변길이		
                	
            5.대용량 문자 
				text 					: 최소1~최대65535 ]
                longtext 	[4G]		: 긴글 텍스트 
			4.날짜
				date					: (날짜) YYYY-MM-DD
                time 					: (시간) HH:MM:SS
                datetime				: (날짜시간)YYYY-MM-DD HH:MM:SS
			6.논리
				boolean		[1]			: 0 or 1  = tinyint
                
		- 제약조건 
			1. pk	: primary key( pk필드명 )
				- 기본키[식별키] : 식별가능한 필드 , 중복X , nullX , 공백X , 테이블1당 1개 이상 권장
					- 예) 학번 , 사번 , 주민등록번호 , ISBN , 상호코드 등등 
                    - 다른테이블의 필드에서 해당 PK필드를 참조 당한다.  
                    - not null + unique = primary key
                    
            2. fk 	: foreign key( fk필드명 ) references pk테이블명(pk필드명) [ 선택 옵션 ]
				- 외래키[참조키] : 다른테이블의 PK필드를 참조하는 필드 , 중복o , null o 
					- 예) 점수테이블(접수자) , 출결(출근한사번) , 각종서류(주민등록) , 대여(ISBN) , 재고관리(상호코드)
                    - 다른테이블의 PK필드을 참조하는 FK필드
            
            3. auto_increment	: 	insert(삽입) 할때 해당 필드를 생략하면 자동번호 부여 [ 자동으로 1씩 증가 ]
				* auto_increment 사용할려면 무조건 pk필드 이면서 만 가능 
                
			4. not null			: 	insert(삽입) 할때 해당 필드의 공백 방지 
            5. unique			: 	insert(삽입) 할때 해당 필드의 값 중복 방지 
            6. default			:	insert(삽입) 할때 해당 필드의 값 생략하면 자동으로 대입되는 기본값 
				default 숫자	
                default now()
                default '문자열'
			
        - SQL 함수 
			1. now()	: 현재날짜/시간 반환해주는 함수 
            

#--------------------------------------------------------------------------------------
drop database if exists sqldb3web;
create database sqldb3web;
use sqldb3web;
# ---------------- 예제 변경될때 실행
drop table if exists member1;
# create table member1( mno int , primary key(mno) );									# 예1)
#create table member1( mno int , mid varchar(10) , primary key(mno) );					# 예2)
#create table member1( mno int auto_increment , mid varchar(10) , primary key(mno) ); 	# 예3)
#create table member1( mno int auto_increment , mid varchar(10) not null , memail varchar(20) , primary key(mno) ); # 예4)
#create table member1( mno int auto_increment , mid varchar(10) not null unique , memail varchar(20) , primary key(mno) ); # 예5)
create table member1( 
	mno int auto_increment , 								-- 회원번호 [ pk , 자동번호 부여 ]
    mid varchar(10) not null unique , 						-- 회원아이디 [ 공백x , 중복x ]
    memail varchar(20) not null unique , 					-- 회원이메일 [ 공백x , 중복x ]
	mpoint int not null default 0,							-- 회원포인트 [ 공백x , 기본값 0	]					-- 회원가입시 고객이 입력하는 사항 x
    mdate datetime not null default now(),					-- 회원가입일 [ 공백x , 기본값 현재날짜/시간 ]			-- 회원가입시 고객이 입력하는 사항 x
    mreceive boolean not null default true ,				-- 회원이메일수신여부 [ 공백x , 기본값 true ]		 
    mimg varchar(1000) not null default '기본프로필.jpg' ,		-- 회원프로필사진 [ 공백x , 기본값 '기본프로필' ] 
    primary key(mno) 										-- pk설정 
); # 예6)

select * from member1;			# 반복!! : 확인할때 마다 실행 
# -------------------
# 예1) 테이블에 레코드/행 추가하기 . 	
	# 1. insert into 테이블명 values( 값1 , 값2 , 값3 );				# 모든 필드에 값 추가할때
    # 2. insert into 테이블명( 필드명1, 필드명2 ) values( 값1 , 값2 ) 		# 특정 필드에 값 추가할때.
insert into member1 values( 1 );	-- member1 테이블의 mno필드에 1 추가 

# 예2) 
# create table member1( mno int , primary key(mno) );	
insert into member1 values( 1 , '유재석' );	-- 직접 데이터 입력할경우 문자/날짜 입력시 ' ' 
insert into member1 values( 1 , '유재석' );	-- mno가 pk필드 이므로 중복방지해서 오류 발생 

# 예3) auto_increment : insert(삽입시) 해당 필드에 값 생략하면 자동번호가 삽입
#create table member1( mno int auto_increment , mid varchar(10) , primary key(mno) ); 
insert into member1 values( 1 , '유재석' );		-- 가능
insert into member1 values( '유재석' );			-- 오류 : '유재석' 데이터를 어떤 필드에 넣을지 식별 불가능 
insert into member1( mid ) values( '유재석' );	-- 오류방안 : 특정 필드에만 데이터를 삽입할경우 테이블명( 필드명제시 );

# 예4) not null : 해당 필드에 값이 무조건 존재해야되는 경우에 사용 [ JS-JAVA-DB 안정성 보장 ]
#create table member1( mno int auto_increment , mid varchar(10) , memail varchar(20) , primary key(mno) );
insert into member1( mid , memail ) values( '유재석' , 'qwe@com' );
insert into member1( mid ) values( '강호동' );			-- 삽입시 필드 생략하면 생략된 필드는 null(비어있음뜻) 대입
#create table member1( mno int auto_increment , mid varchar(10) not null , memail varchar(20) , primary key(mno) ); # 예4)
insert into member1( memail) values( 'qwe@com');		-- 오류 : mid필드는 not null 제약조건을 사용했으므로 무조건 값 대입 

# 예5 ) unique : 해당 필드에 값의 중복 방지 
create table member1( mno int auto_increment , mid varchar(10) not null unique , memail varchar(20) , primary key(mno) ); # 예5)
insert into member1( mid ) values( '유재석' );
insert into member1( mid ) values( '유재석' ) ;			-- 오류 : mid필드는 unique 제약조건을 사용했으므로 기존에 있는 값을 대입할수 가 없다. [ 중복방지 ]

# 예6 ) default : 해당 필드에 값 삽입시 생략할때 자동으로 들어가는 기본값 설정 
select * from member1;
insert into member1( mid , memail ) values( '유재석' , 'qwe@com');
insert into member1( mid , memail , mpoint ) values( '강호동' , 'asd@com' , 1000 );
insert into member1( mid , memail , mpoint , mdate ) values( '신동엽' , 'zxc@com' , 1000 , '2023-08-03 12:10:10' );
insert 
	into member1( mid , memail , mpoint , mdate , mreceive )
	values( '하하' , 'cvb@com' , 1000 , '2023-08-03 12:10:10' , false );
    
insert 
	into member1( mid , memail , mpoint , mdate , mreceive , mimg ) 
    values( '서장훈' , 'ert@com' , 0 , '2023-08-03 12:10:10' , false , '증명사진.jpg' );
    
insert into member1( mid , memail , mimg ) values( '김희철' , 'vbn@com' , '김희철증명사진.jpg' );

/*
	문제6 
		[조건1]
		1. 'sqldb3web2' 데이터베이스 생성한다.
		2. 'product' 테이블 생성합니다.
				[ 요구사항 ]
				제품번호		제품 식별용으로 정수형태로 저장하고 자동번호 부여 했으면 좋겠다.
				제품명		문자열 형태로 100글자 내외로 할것 같고 중복은 방지 해주세요.
				제품가격		정수로 저장하고 기본값은 0 으로 해주세요.
				제품등록일		날짜/시간 저장하고 제품등록할때 자동으로 날짜/시간 저장해주세요.				
			- 그리고 모든 필드에 null 값이 들어가지 않도록 해주세요.
		[조건2]
		1. 위에서 선언한 'product' 테이블에 제품 (레코드) 등록(insert) 
			[실행1] 제품명 : '콜라' , 1000  
			[실행2] 제품명 : '사이다'
            [실행3] 제품명 : '환타' , 1500 , '2023-08-03 17:10:30'
		
        [조건3]
		1. 위에서 선언한 'product' 테이블 과 관계가 있는 'category' 테이블 생성 
			[ 요구사항 ]
			1. 필드
				카테고리번호 		: 카테고리식별용으로 정수형태로 저장하고 자동번호 부여 했으면 좋겠다.
                카테고리명			: 문자열 형태로 20글자 내외로 할것 같고 중복X  , null X 해주세요.
            2. 관계 
				'product' 테이블 과 'category' 테이블 관계 연결 해주세요.
                
*/
# 1. DB 생성 
drop database if exists sqldb3web2;		create database sqldb3web2;		use sqldb3web2;
# 2. 테이블 생성 
drop table if exists product;
create table product( # 작성순서 :  1. 필드명 과 타입 선정 	# 2. 제약조건 [ pk -> 기타 등등 ]
	pno int auto_increment  , 				-- 제품번호 [ 정수타입 , pk필드(not null , unique) , 자동번호부여 ]
    pname varchar(100) unique not null , 	-- 제품명 [ 문자열(100) , 중복제거 ]
    pprice int default 0 not null , 		-- 제품가격 [ 정수타입 , 기본값 0 ]
    pdate datetime default now() not null ,	-- 제품등록일[ 날짜/시간타입 , 기본값 현재시간 ]
    primary key(pno) ,						-- 제품번호 필드를 pk필드 설정 
    # [조건3]
    cno int ,  -- 카테고리번호 
    foreign key( cno ) references category( cno )	-- category 테이블이 우선적으로 생성이 되어 있는 상태 이면 참조 가능 
);
#[실행1] 제품명 : '콜라' , 1000  
insert into product( pname, pprice ) values ( '콜라' ,1000 ); 			
# insert : 삽입하다. # into : ~~ 어디에 # ( ) : 값을 삽입할 필드명   # values	: 삽입할 값들    
#[실행2] 제품명 : '사이다'
insert into product( pname) values( '사이다');	
#[실행3] 제품명 : '환타' , 1500 , '2023-08-03 17:10:30'
insert into product( pname , pprice , pdate ) values( '환타' , 1500 , '2023-08-03 17:10:30');
select * from product; 

#[조건3] 'category' 테이블 생성 [ 상위테이블 생성 -> 하위테이블 생성  ]
drop table if exists category;
create table category(
	cno	int auto_increment , 
    cname varchar(20) unique not null ,
    primary key( cno )
);
#[실행1] 카테고리 등록 
insert into category( cname ) values( '에이드' );		# '에이드' 카테고리 등록 [ 자동번호 부여 = 1 ]
insert into category( cname ) values( '탄산' );		# '탄산' 카테고리 등록 [ 자동번호 부여 = 2 ]
# 1번카테고리[에이드] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '사과에이드' , 3000 , 1 );
# 1번카테고리[에이드] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '포도에이드' , 3500 , 1 );
# 2번카테고리[탄산] 에 제품 등록 
insert into product ( pname , pprice , cno ) values ( '제로콜라' , 4000 , 2 );
select * from product;