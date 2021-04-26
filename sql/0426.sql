
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


-- foreign key 사용해보기
-- 부서테이블(dept)의 부서번호(deptno) 컬럼을 참조
-- 해당컬럼에 값을 넣을때 참조되는 테이블에 존재하는 값만 넣을 수 있다.

create table emp06(
    empno number(4) constraint pk_emp06_empno primary key,
    ename varchar2(10) constraint nn_emp06_ename not null,
    job varchar2(10),
    deptno number(2) 
);

insert into emp06(empno, ename, job, deptno)
values (1001, '김사랑', '사원', 10);

-- 부서테이블에 없는 부서인 60번 부서로 배정
insert into emp06(empno, ename, job, deptno)
values (1001, '박사랑', '대리', 60); -- 60번 부서 허용하지 않음


-- check 제약조건 사용해보기
-- check 제약 조건은 해당 컬럼의 값을 특정 값이나 범위로 한정
-- 사번(pk), 이름(nn), 급여(500이상 5000이하), 성별(M, F)

create table emp07(
    empno number(4) constraint pk_emp07_empno primary key,
    ename varchar2(10) constraint nn_emp07_ename not null,
    sal number(7,2) constraint ck_emp07_sal check(sal between 500 and 5000),
    gender varchar2(1) constraint ck_emp07_gender check(gender in ('M', 'F'))
);

-- 급여가 체크 범위를 벗어나는 데이터 입력
-- check 제약조건 위배
insert into emp07(empno, ename, sal, gender)
values (1001, '김사랑', 6000, 'F');

-- 성별(gender)에 설정되지 않은 M, F 이외의 값을 입력
-- check 제약조건 위배
insert into emp07(empno, ename, sal, gender)
values(1001, '김사랑', 1000, 'A'); -- 'A' 는 gender에 허용된 값이 아님

-- default 제약조건 -> 생략되어있다면 기본값이 입력되도록한다.
-- 보통 입사일 같은 속성에 현재시간이 기본값으로 들어가게 만들때 많이 사용된다.
-- 해당컬럼에 기본값(default) 설정
-- 부서테이블에 loc(위치, 지역)에 '서울'이라는 값을 기본값으로 설정
create table dept01(
    deptno number(2),
    dname varchar(10),
    loc varchar2(10) default '서울'
);

-- loc에 값 제외하고 데이터 추가
insert into dept01(deptno, dname)
values (10, '경리부');

select * from dept01;


select *
from user_constraints;

select * from emp07;


-- number puzzle 에 사용된 테이블 삭제 후 제약조건 설정
drop table tbl_score;
drop table tbl_user;

create table tbl_user(
    u_id varchar2(20)
        constraint pk_user_id primary key,
    u_pw varchar2(20)
        constraint nn_user_pw not null,
    u_name varchar2(20)
        default '아무개'
);

create table tbl_score(
    u_id varchar2(20) constraint fk_score_id references tbl_user(u_id),
    score number constraint nn_score_socre not null
);

select * from tbl_user;

-- 이위까진 컬럼레벨 방식 제약조건

drop table emp02;
create table emp02(
    empno number(4),
    ename varchar2(10)
        constraint nn_emp02_ename not null, -- not null은 컬럼레벨로만 정의할 수 있다.
    job varchar2(10),
    deptno number(2), -- 이 아래로 테이블 레벨 제약조건 지정방식
    constraint pk_emp02_empno primary key (empno),
    constraint uk_emp02_job unique(job),
    constraint fk_emp02_deptno foreign key (deptno) references dept(deptno)  
);

select *
from user_constraints;

-- 제약조건 변경하기
drop table emp01;
create table emp01(
    empno number(4),
    ename varchar2(20),
    job varchar2(10),
    deptno number(2)
);

select * from user_constraints
where table_name = 'EMP01';

-- 생성된 테이블(emp01)의 empno 컬럼에 기본키 제약 조건 추가
alter table emp01
add constraint pk_emp01_empno primary key (empno);

-- 생성된 테이블(emp01)의 deptno 컬럼에 외래키 제약 조건 추가
alter table emp01
add constraint fk_emp01_deptno foreign key(deptno)
    references dept(deptno);
        
-- not null은 추가한다는 개념이 아니라 수정하는거라고 생각해야 한다.
alter table emp01
modify ename constraint nn_emp01_ename not null;


-- 제약조건 제거하기 -> 테이블 변경
alter table emp01
drop constraint nn_emp01_ename;

--  기본키 제약 조건 삭제
-- 제약조건명을 몰라도 설정된 기본키 제약 조건을 삭제
alter table emp01
drop primary key;

select * from user_constraints
where table_name = 'EMP01';
-- 테이블 생성은 여기까지
------------------------------------------------


-- 테이블 조인 - 2개 이상의 테이블에서 데이터를 조회하기
-- 김사랑이 근무하는 부서명
select * from emp
where ename = '김사랑';
select dname from dept
where deptno = 20;
-- 이렇게 두번 select를 해야할 것을 한번에 기술하는 것을 조인이라 한다.

-- 아무런 조건없이 테이블 두개를 조인 = 크로스 조인(Cross Join) 두개의 테이블 데이터를 곱한다.?
select *
from emp, dept;

-- 이퀴조인(Equi Join) : Equal(이퀄) 을 사용하는 조인
-- 서로 곱해지는 테이블에서 같은 데이터, 유효한 데이터를 골라내기 위해서 이퀴조인을 쓴다.

-- 한 사원당 만들어지는 데이터 5개 중에서
-- 사원테이블의 deptno와 부서테이블의 deptno 값이 같은 데이터만 추림
select *
from emp, dept -- 75개(크로스된 상태)
where emp.deptno = dept.deptno -- 75 -> 15
and ename = '김사랑'; -- 1개
-- 일치하는 데이터만 추려냈을때.
-- 순서가 바뀌어도 잘됨
select *
from emp, dept
where ename = '김사랑'
and emp.deptno = dept.deptno;


-- 모호성
-- 사원명, 부서번호, 부서명 
-- deptno가 emp테이블의 deptno인지, dept 테이블의 deptno인지 모호하다(column ambiguously defined)
select ename, deptno, dname
from emp, dept
where emp.deptno = dept.deptno;
-- 모호한 속성을 테이블명을 명시해줌으로써 모호성을 해결한다.
select ename, emp.deptno, dname
from emp, dept
where emp.deptno = dept.deptno;

-- 테이블에 별칭 부여(emp -> e, dept -> d)
select e.ename, e.empno, d.dname
from emp e, dept d
where e.deptno = d.deptno;


-- Non-equi join 이퀄(=)을 사용하지 않는 조인
-- salgrade(급여등급) 테이블
desc salgrade;
select * from salgrade;
select * from emp;

-- 사원이름(emp.ename), 급여(emp.sal), 급여등급(slagrade.grade)
select e.ename, e.sal, s.grade
from emp e, salgrade s
-- where e.sal >= s.losal and e.sal <= s.hisal;
where e.sal between s.losal and s.hisal; -- 위와 같은 조건이다.

------------------------------------------------------------
-- 조인 조건을 정할때는 (테이블갯수 - 1)개 만큼의 조인 조건이 필요함.
-- 테이블 3개를 조인 : 조인조건은 2개 필요하다.
------------------------------------------------------------
-- 사원명(emp.ename), 부서명(dept.dname), 급여(emp.sal), 급여등급(salgrade)
select e.ename, d.dname, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal;



-- 김사랑 사원의 사수(관리자)이름
select ename, mgr
from emp
where ename = '김사랑';

select ename
from emp
where empno = 1013;

select * 
from emp e1, emp e2;

-- self join(자가 조인) -- 별칭 부여 필수
select e.empno, e.ename, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno
order by e.empno;


-- 오라클 방식
-- Cross Join
--select *
--from emp cross join dept
--where emp.deptno = dept.deptno;

-- ANSI(미국국가표준협회) JOIN
select *
from emp inner join dept
on emp.deptno = dept.deptno;

-- 이문세의 이름, 부서명, 부서번호를 ANSI Inner Join
select ename, dname, emp.deptno
from emp inner join dept
on emp.deptno = dept.deptno -- 조인 조건은 on 절에
where emp.ename = '이문세'; -- 컬럼 조건은 where 절에


-- Outer Join - 없는 데이터도 조회하고자 할 때
-- Oracle 방식
select e.empno, e.ename, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno (+);

select e.empno, e.ename, m.empno, m.ename
from emp right outer join emp m
on e.mgr = m.empno (+);