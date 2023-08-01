#한줄주석
-- 한줄주석
/*
여러줄 주석
*/

/*
	데이터 베이스: 데이터[자료] , 베이스[모임]
		- 종류
			1. 계층형 데이터베이스 : 트리형태
            2. 네트워크형 데이터베이스: 양방향 형태
            3. 관계형 데이터베이스: 행/열로 구성된 테이블[표] 형태
            4. NoSQL 데이터베이스: key-value 형태
        - 용어
			DBA [데이터베이스 관리자]
				-개발자
            DBMS[데이터베이스 관리 시스템]
				- MySQL, OLACLE, MariaDB , SQLSERVER(각 회사별 소프트웨어)
                - SQL[구조화된 질의/질문 언어]
            DB[데이터베이스]
				- 실제 데이터가 저장된 곳= DB server
                - 메모리[바이트16진수] : 개발자는 직접적으로 관리가 어려움. 
                
		- 관계
        
			DBA -------------> DB
            개발자								기계어
            
            DBA ----------DBMS----------------> DB
            
            
            
		- SQL[DB 조작/관리/제어 할때 사용되는 언어/문법 (대소문자 구분없)
			1.DDL[ 데이터베이스정의어]
				- create : 데이터베이스, 테이블, 뷰(가상테이블) 생성
					-create database db명;
                    - create table table명(필드명 속성명, 필드명 속성명);
              
				- drop : 데이터베이스, 테이블, 뷰(가상테이블) 삭제  <- 테이블 자체를 삭제
					-drop database db명;
                    -drop database if exists db명;
                    -drop table table명 ; 
                
                - alter : 테이블, 뷰(가상테이블) 속성 수정
                
                - truncate : 테이블 내 데이터를 초기화(삭제) <- 안에 내용만 삭제(설정값 속성 등까지 사라짐)
                
                - rename: 테이블, 뷰의 이름 변경
                
                - show(외울필요없) 
					-show databases; : 데이터베이스 전체 목록보기
					-show variables like 'datadir'; : 데이터베이스 저장소 로컬 경로 확인
            
            2.DML[데이터베이스 조작어]
				- insert : 테이블(표)에 레코드(행) 삽입
                - select : 테이블(표)에 레코드(행) 검색
					-select*from 테이블명: 테이블 내 모든 레코드(행) 검색[* : 와일드카드(모든)]
                - update : 테이블(표)에 레코드(행) 수정
                - delete : 테이블(표)에 레코드(행) 삭제 <- 데이터만 사라짐
            
            3.DCL[데이터베이스 제어어]
				- grant : 사용자 권한 부여
                - revoke : 사용자 권한 취소
            
            4.TCL[ 트랜잭션 제어어]
				- commit : 트랜잭션[명령어 단위] 완성
				- rollback : 트랜잭션[명령어 단위] 취소
            
            
         - 테이블 용어
			테이블[표] 
				학번			학생명 			전화번호			주소	-가로=행=row=레코드
                1010		김현수		010-3333-4444		안산
                1011		강호동		010-3222-3422		수원
               1. 속성(=colum=열=필드) : 테이블의 열 
               학번필드, 학생명필드, 전화번호필드, 주소 필드 
			   2. 레코드(=row=행=레코드) : 테이블의 행
               1번레코드 , 2번레코드
               3. 행과 열로 구성된 테이블(표)를 다른 표와 연결/관계 = 관계형 데이터베이스
               
		- 데이터 필드 타입[mysql기준]
			1. 정수
				tinyint(1바이트,-128~127), smallint(2바이트,+-3만), mediumint(3바이트,+-8백만정도), int(4바이트,+-21억정도), bigint(8바이트)
			2. 실수
				float(4바이트) : 소수점 7자리
                double(8바이트): 소수점 15자리
			3. 문자
				- char(문자길이,고정길이, 최소1~ 최대255) : char(3) 인데 'ab'저장 -> 3바이트 [*저장할 데이터의 글자수가 정확히 정해져있는 경우]
                - varchar(문자길이,가변길이, 최소1~ 최대65535) : varchar(3)인데 'ab'저장 -> 2바이트[*저장할 데이터의 글자수가 정확하지 않을때]
			4. 날짜
				date(날짜 YYYY-MM-DD) 
                time(시간 HH:MM:SS)
                datetime( 날짜시간 YYYY-MM-DD HH:MM:SS)
			5. 대용량
				text(최소1~최대 65535, 고정길이)
                mediumtext(최소1~최대16000000)
                longtext(4G) : 긴글 텍스트
			6. 논리
				boolean(1바이트) : 0or1 
            
*/


-- # 예1 : 데이터베이스(여러개의 테이블들이 저장되는 공간- 폴더랑 비슷) 생성
create database squldb1;
-- #creat : 생성
-- #database : 데이터베이스
-- #squldb1 : 이름 정의 [아무거나, 대소문자 구분 없음, 키워드는 안됨]
-- #; : 하나의 명령 끝났음을 알림 
	-- # 해당 명령어 줄에 커서 위치한 상태에서 ctrl+enter(초록색 뜨면 성공)
    -- # navigater 새로고침 해줘야 생성 된 거 확인 가능
    
create database squldb2;
create database squldb3;
create database squldb4;
create database squldb5;

-- # 예2 : 데이터베이스 목록 보기
show databases;

-- # 예3 : 데이터베이스가 저장된 로컬[pc] 경로 확인
show variables like 'datadir';

-- # 예4 : 데이터베이스 삭제
drop database squldb2;
drop database squldb3;
drop database squldb4;
drop database squldb5;

-- # 예5: 만약에 데이터베이스가 존재했을 때 삭제[*만약 데이터베이스가 없을 때 삭제 명령어 사용하면 오류 발생]
drop database if exists squldb1;
	#if exists
    
-- # 예6 : 여러개의 데이터베이스 중 사용할 데이터베이스 선택
use sqldb1;
use sqldb2;

-- #활용1: 데이터베이스 새롭게 생성하세요
	-- #1. 데이터베이스가 존재하면 삭제처리
    drop database if exists test1;
    -- #2. 데이터베이스 생성
    create database test1;
    -- #3. 데이터베이스 사용준비
    use test1;

/*--------표만들기--------------------------------*/
-- #테이블(표)는 데이터베이스 안에 저장되는 테이블[*무슨 데이터베이스에서 테이블 생성할건지 use DB명;]
-- #예1: 테이블 생성
-- use sqldb1; -> 테이member블을 생성할 데이터베이스 선택
create table member(아이디 text, 비밀번호 text);
	-- #create : 생성한다
    -- #table : 테이블
    -- #member : 이름정의 [아무거나, 대소문자 구분x, 키워드x]
   --  #(); : 테이블 속성(열/필드) 정의
		-- #( 필드명 타입, 필드명 타입, 필드명 타입): 테이블(표) 제목/속성/열/필드 정의

-- #예2: 테이블 확인
select*from member;

-- #예3: 테이블 삭제
drop table member;
