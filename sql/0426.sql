
-- 데이터 딕셔너리에서 제약 조건 확인
desc user_constraints;

select * from user_constraints;

select constraint_name, constraint_type, table_name
from user_constraints;

-- NOT NULL (NULL 값을 허용하지 않음)
-- 값을 반드시 결정해서 넣어라(비워두지 말아라)
-- 사번, 이름은 널값을 허용하지 않음
create table user02(
    empno number(4) not null,
    ename varchar2(20) not null,
    job varchar2(10),
    deptno number(2)
);
-- user02 테이블에 데이터 입력
-- insert절에 컬럼명은 생략가능
-- desc명령어로 나오는 순서대로 values 절에 입력

insert into user02(empno, ename, job, deptno)
values (1001, '김사랑', '사원', 10);

desc user02;
insert into user02
values (1002, '조인성', '대리',20);

-- 테이블 데이터 날리기
truncate table user02;

-- not null 제약조건이 적용된 컬럼(empno, ename)에 널값 넣어보자
insert into user02
values(null, null, '사원', 10); -- 에러뜸

-- not null 제약조건이 적용되지 않은 컬럼(job, deptno)에 널값 넣어보기
insert into user02(empno, ename, job, deptno)
values(1001, '김사랑', null, null); -- 에러뜨지 않음

-- not null 제약조건은 해당 컬럼에 데이터를 반드시 넣도록 강제

-- 테이블삭제
DROP TABLE emp02 CASCADE CONSTRAINTS;
-- 테이블명 변경
rename user02 to emp02;
-- 정의된 제약조건 보기
select constraint_name, constraint_type, table_name
from user_constraints;


-- 사번(unique), 이름(not null), 직급, 부서번호
create table emp03(
    empno number(4) unique,
    ename varchar(10) not null,
    job varchar(10),
    deptno number(2)
);

insert into emp03(empno, ename, job, deptno)
values(1001, '김사랑', '사원', 10);

insert into emp03(empno, ename, job, deptno)
values(1001, '박사랑', '대리', 20); -- 오류발생 unique 제약조건 위반

-- unique 제약조건이 적용된 empno 컬럼에 널값 넣어보자
insert into emp03(empno, ename, job, deptno)
values(null, '박사랑', '대리', 20); -- unique지만 널값은 허용됨
-- unique : 중복되지 않는 데이터, 널값은 허용한다.

-- 제약조건에 이름 넣기
create table emp04(
    empno number(4) constraint uk_emp04_empno unique,
    ename varchar2(10) constraint nn_emp04_ename not null,
    job varchar2(10),
    deptno number(2)
);

-- primary key = unique + not null
-- 다른행들과 구분하기 용도로 사용된다.
-- primay key 적용해보기
create table emp05(
    empno number(4) constraint pk_emp05_empno primary key,
    ename varchar2(10) constraint nn_emp05_ename not null,
    job varchar2(10),
    deptno number(2)
);

insert into emp05(empno, ename, job, deptno)
values (null, '김사랑', '사원', 10); -- primary key에서 null값 허용하지 않음


insert into emp05(empno, ename, job, deptno)
values (1001, '김사랑', '사원', 10);

insert into emp05(empno, ename, job, deptno)
values (1001, '박사랑', '대리', 20); -- unique 제약조건에 위배됨




select *
from user_constraints;
select * from emp05;