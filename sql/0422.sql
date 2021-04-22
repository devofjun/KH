-- 테이블 생성
-- create table 테이블명 (
--  컬럼명1 데이터타입 제약조건,
--  컬럼명1 데이터타입 제약조건
-- );
-- emp01 테이블생성(숫자형식(사번),문자형식(이름), 숫자(급여))
create table emp01(
    empno number(4), -- 숫자4자리, 제약조건 없음
    ename varchar2(14), -- 문자 14자리(한글 3byte)
    sal number(7, 3) -- 전체 7자리, 소숫점이하 3자리
);

insert into emp01 (empno, ename, sal)
values (1001, '정병준', 2000); -- 데이터타입은 아래처럼 자동으로 맞춰주기도 한다.
insert into emp01 (empno, ename, sal)
values('1002', 100, 1000);    -- '1002' -> 1002 / 100 -> '100'

insert into emp01 (empno, ename, sal)
values ('일천삼', '윤수', 1000); -- 유효하지 않은 숫자

-- 컬럼 추가
-- 이미 생성된 테이블(emp01)에 컬럼 추가
alter table emp01
add birth date; -- date데이터타입의 birth라는 이름의 컬럼을 추가함

-- 컬럼 변경
-- 주의사항: 길이를 변경할때 늘리는건 괜찮지만 줄이는건 문제가 될 수 있다.
-- 이미 생성된 테이블(emp01)의 이름(ename) 컬럼의 데이터형식 변경
-- update ename(x)
-- modify ename(o)
alter table emp01
modify ename varchar(30);

-- 컬럼 제거
-- 이미 생성된 테이블(emp01)의 이름(ename) 컬럼을 삭제
-- delete(x), drop(o)
alter table emp01
drop column ename;

-- 테이블명 변경하기(rename A to B)
rename emp01 to emp02;

-- 테이블 삭제(drop)
-- delete table(x)
-- 테이블의 데이터를 삭제(x), 테이블 자체를 삭제(o)
drop table emp02;

-- 테이블의 모든 데이터 삭제
truncate table emp01;


select * from emp01;
desc emp02;