-- 뷰 사용하는 이유 : 반복되는 작업을 줄이거나 보안을 높히기위해

-- system으로 접속
-- user01 사용자에게 뷰 생성 권한 부여
grant create view to user01;

-- user01로 접속
-- emp 테이블을 복사해서 emp_copy 테이블 생성
-- 제약조건은 복사가 안됨
create table emp_copy
as
select * from emp;

-- 30번 부서에서 근무하는 사원
select *
from emp
where deptno = 30;

-- 30번 부서에서 근무하는 사원을 보는 뷰 생성
-- 실제 물리적으로 존재하는 것이 아닌 논리적인 가상 테이블
create view emp_view30
as
select *
from emp_copy
where deptno = 30;

-- 생성된 뷰를 통해서 쿼리
select *
from emp_view30;

-- 제약조건 확인(딕셔너리)
select * from user_constraints;

-- 뷰 확인
select * from user_views;

-- 뷰는 보안에 유리하다.
-- 현재 계정 user01 사용자에게는 일부만 보이도록
drop view emp_view30;
create view emp_view20
as
select empno, ename, deptno
from emp_copy
where deptno = 20;

select *
from emp_view20;

-- 뷰에 대해서 crud 작업이 가능
-- 뷰를 대상으로 insert
insert into emp_view20(empno, ename, deptno)
values (1015, '김종형', 10);

select * from emp_copy; -- insert 확인됨

-- 조인(emp, dept)
create view emp_dname_view
as
select e.empno, e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno;

select * from emp_dname_view;

-- 뷰 제거
-- 뷰를 제거한다고해서 테이블이 삭제되지는 않는다.
drop view emp_dname_view;

-- 존재하는 뷰가 있는 경우 에러 발생
-- 없으면 새로 만들고, 없으면 수정하는 방법
create or replace view emp_view30
as
select empno, ename,deptno
from emp
where deptno = 30;

-- 실제 존재하지 않는 employees라는 테이블를 강제생성하는 대한 뷰
-- [force | noforce] : 기본값은 noforce
-- 테이블이 존재하지 않더라도 강제로 뷸르 생성 - force
create or replace force view employees_view30
as
select * from employees
where deptno =30;

select * from user_views;


-- 조건에 사용된 컬럼에 대해서 뷰를 통해 변경 불가
create or replace view emp_chk20
as
select empno, ename, deptno
from emp_copy
where deptno = 20 with check option;


select * from emp_chk20;

select * from user_views;

-- with check option : deptno 변경 불가
update emp_chk20
set deptno = 20;

-- 커미션에 대해서 변경
update emp_chk20
set ename = '홍길동';

create or replace view view_read20
as
select empno,ename,sal, comm, deptno
from emp_copy
where deptno = 30 with read only;

-- 조건에 사용된 컬럼 이외의 다른 컬럼도 변경할수 없다.
update view _read20
set comm = 10;

select * from view_read20;







-- 줄번호 가져오는법
select rownum, empno, ename, deptno
from emp_copy;

-- 게시판의 게시글이 100만개
-- 한페이지당 10개씩 끊어서 1페이지

-- rownum 값은 select 때 결정
select rownum empno, ename, deptno
from emp_copy
order by empno desc;

delete from emp_copy
where empno = 1015;
commit;

-- 서브쿼리는 코드 -> 그결과는 인라인뷰
-- 최근 입사 순으로 5명을 조회
select * from (select rownum rnum, a.* from(select empno, ename, deptno, hiredate 
                                            from emp_copy
                                            order by hiredate desc) a)
where rnum between 1 and 5;
-- select에서의 rownum과 where에서의 rownum은 다르기 때문에 인라인? 서브쿼리?를 한다
-- 1. 우선 순서대로 정렬한다.
-- 2. 정렬된 테이블에 rnum을 넣어준다.
-- 3. 정렬된 테이블에서 rnum이 1~5까지의 데이터를 추려낸다.






-- 시퀀스(Sequence) : 순차적으로 발행되는 번호
-- 되돌리기 안됨 = 한번 발행된 숫자는 변하지 않는다.

create table emp_copy2(
    empno number(4) primary key,
    ename varchar2(10) not null
);
-- 사원이 새로 입사하면 사원번호는 자동부여 - 시퀀스 사용
-- 1001번 부터 1씩 증가
create sequence seq_empno
start with 1001
increment by 1; -- 기본설정은 1부터 1씩 증가


insert into emp_copy2(empno, ename)
values (seq_empno.nextval, '홍길동');

insert into emp_copy2(empno, ename)
values (seq_empno.nextval, '유관순');

select * from emp_copy2;