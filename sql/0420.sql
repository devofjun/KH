-- 정오(12:00) 기준, round 반올림, trunc 버림
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
        to_char(round(sysdate), 'YYYY-MM-DD HH24:MI:SS'),
        to_char(round(to_date('2021-04-20 13:01:00','YYYY-MM-DD HH24:MI:SS')),'YYYY-MM-DD HH24:MI:SS'),
        to_char(trunc(to_date('2021-04-20 13:01:00','YYYY-MM-DD HH24:MI:SS')),'YYYY-MM-DD HH24:MI:SS')
from dual;

-- 입사한 달의 첫 1일
select ename, hiredate, trunc(hiredate, 'MONTH')
from emp;

-- 사원들의 근무 개월수
-- 날짜에 연산 : 날수
-- months_between : 달수
select ename 이름, sysdate 오늘, hiredate 입사일,
    trunc(sysdate-hiredate) 근무한날수,
    trunc(months_between(sysdate, hiredate)) 근무한달수
from emp;

-- 사원들의 입사일, 입사후 6개월후 날짜
-- 날짜에 연산 : 날 수
-- add_months : 달 수
select ename 이름, hiredate 입사일, 
    hiredate + 6 "6일후",
    add_months(hiredate, 6) "6개월후",
    add_months(hiredate, -6) "6개월전"
from emp;

-- 돌아오는 ~요일
-- 사원들의 입사후 첫 주말
select sysdate 오늘,
    next_day(sysdate, '수요일') "돌아오는 수요일"
from dual;

select hiredate 입사일,
    next_day(hiredate, '토요일') "입사후 첫 주말"
from emp;

-- 윤년 4년(29), 100년(28), 400년(29)
-- 해당 날짜의 마지막 날
select sysdate 오늘,
    last_day(sysdate) "이달의 마지막 날",
    last_day(to_date('2000/02/01', 'YYYY-MM-DD'))
from dual;
-- 사원들의 입사일의 마지막 날
select ename, hiredate 입사일,
    last_day(hiredate) "입사일의 마지막 날"
from emp;

-- Null Value
-- nvl(널값, 대체값)
-- nvl2(값, 널이아닌경우, 널인경우)
select ename 이름, sal 급여,
    nvl2(comm, sal*12+comm, sal*12) "연봉(보너스합)"
from emp;

-- nullif(값1, 값2) : 두 값이 같으면 null, 다르면 첫번째 값
select nullif('A', 'A'), nullif('A','B')
from dual;

-- coalesce(값1, 값2, ... 값n) : 여러 값들 중에서 널이 아닌 첫번째 값
select ename 이름, comm 커미션, sal,
    coalesce(comm, sal)
from emp;

-- 사원들이 근무하는 부서명
-- decode = switch~case 와 유사하다.
select ename 이름, deptno 부서번호,
    decode(deptno, 10, '경리부',
                    20, '인사부',
                    30, '영업부',
                    40, '전산부',
                    '부서없음')
from emp;

-- case = if, else if, else 와 유사하다.
select ename 이름, deptno 부서번호, 
    case
        when deptno = 10 then '경리부'
        when deptno = 20 then '인사부'
        when deptno = 30 then '영업부'
        when deptno = 40 then '전산부'
    end 부서명
from emp;

select *
from emp;
-- 1. substr 함수를 사용하여 9월에 입사한 사원 조회
select *
from emp
where substr(hiredate, 6, 2) = '09';
-- 2. substr 함수를 사용하여 2003년도에 입사한 사원 조회
select *
from emp
where substr(hiredate, 1, 4) = '2003';
-- 3. substr 함수를 사용하여 "기"로 끝나는 사원 조회
select *
from emp
where substr(ename, -1, 1) = '기';
-- 4. instr 함수를 사용하여 이름의 두번째 글자에 "동" 이 있는 사원 조회
select *
from emp
where instr(ename, '동', 1, 1)=2;
-- 5. 직급(job)에 따라 직급이 "부장"인 사원은 5%, "과장"인 사원은 10%, "대리"인 사원은 15%,
--    "사원"인 사원은 20% 가 인상된 급여 조회
select ename 이름, job 직급, sal,
    case
        when job = '부장' then sal*0.05+sal
        when job = '과장' then sal*0.10+sal
        when job = '대리' then sal*0.15+sal
        when job = '사원' then sal*0.20+sal
    end "인상된 월급"
from emp;
-- 6. 입사일을 년도 2자리, 월 2자리, 일 2자리 요일은 약어("수요일" ->"수")로 지정하여 출력
select ename, to_char(hiredate,'YY-MM-DD dy')
from emp;


-- 여기서부터

-- 그룹함수

-- count : 갯수 세기(로우의 갯수)
-- 전체 사원수와 커미션이 정해진 사원수
select count(*) 사원수, count(comm) 커미션사원수
from emp;

-- 사원들의 급여 총액, 급여 평균, 최대 급여, 최소 급여 조회
-- sum : summary
-- avg : average
-- max : maximum
-- min : mininum
select sum(sal) "급여 총액",
    round(avg(sal)) "급여 평균",
    max(sal) "최대 급여",
    min(sal) "최소 급여"
from emp;

-- 입사한지 제일 오래된 날짜, 가장 최근 입사일
select min(hiredate) "오랜일",
    max(hiredate) "최근일"
from emp;

-- 일반적인 연산: null과의 연산 -> null
-- 그룹함수들의 연산: null을 제외하고 계산
select count(comm), sum(comm), avg(comm), min(comm)
from emp;

-- 그룹함수 : ~별 ...
-- 가장 높은 급여를 받는 사원의 이름과 급여 조회
-- select ename, max(sal) -- ename의 결과는 14개인데 max의 결과는 1개이기 때문에 실행안됨.
select ename, sal
from emp
where sal = (select max(sal) from emp); -- 서브쿼리

-- 직급(job)의 수 
--select count(job) -- null이 아닌 job 중복 포함된 로우의 수
select count(distinct job) -- 중복을 제거한 job의 로우의 수를 출력
from emp;

-- group by 절
-- group by 컬럼명 : 해당 컬럼명으로 그루핑(~별)
-- 그룹함수와 같이 쓰인다.
-- 부서번호별로 그루핑
-- 그루핑을 해줬기 때문에 가능해진다. -> 그룹별로 평균을 출력함
select deptno, round(avg(sal),1), sum(sal), min(sal), max(sal)
from emp
group by deptno;

-- 부서별 인원수, 커미션이 정해진 인원수
select deptno, count(*), count(comm)
from emp
group by deptno;

-- having은 group by에 대한 where(조건에 맞게 로우 추려냄)라고 생각하면됨
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 500;

-- order by는 항상 제일 나중에 기재
select deptno, round(avg(sal),1), sum(sal), min(sal), max(sal)
from emp
group by deptno
order by deptno;

-- 직급(job)이 "사원"인 직원을 제외하고, 직급별 급여 총액
-- 급여총액이 적운순으로 정렬
select job, sum(sal)
from emp
where job <> '사원'
group by job;

-- 평균 급여가 가장 높은 부서의 평균급여
select max(avg(sal))
from emp
group by deptno;


select *
from emp;

-- 1. 급여 최고액, 최저액, 총액 및 평균 급여 구하기
select max(sal) 급여최고액, min(sal) 급여최저액, sum(sal) 총액, avg(sal) 평균
from emp;
-- 2. 직급별로 급여 최고액, 최저액, 총액, 평균 급여 구하기
select job, max(sal), min(sal), sum(sal), avg(sal)
from emp
group by job;
-- 3. 직급별 사원수 구하기
select job, count(*)
from emp
group by job;
-- 4. 과장의 수 구하기
select count(*)
from emp
where job='과장';
-- 5. 급여 최저액과 급여 최고액의 차액 구하기
select max(sal)-min(sal)
from emp;
-- 6. 부서별 사원수, 평균 급여 구하기(부서번호 순으로 정렬)
select deptno, count(*), avg(sal)
from emp
group by deptno
order by deptno;
-- 7. 부서번호별 부서이름(dname), 지역명(loc), 사원수, 평균급여 구하기
select deptno 부서번호,
        decode(deptno, 10, '경리부',
                        20, '인사부',
                        30, '영업부',
                        40, '전산부') 부서명,
        decode(deptno, 10,'서울',
                        20,'인천',
                        30,'용인',
                        40,'수원') 지역,
        count(*) 사원수, round(avg(sal)) 평균급여
from emp
group by deptno;


-- DQL(Data Query Language) - select
-- DML(Data Manupulation Language) - 변경
-- -insert update delete

-- 트랜잭션 - 일의 단위

--CRUD 데이터처리
--insert - create
--select - read
--update - update
--delete - delete


-- 트랜잭션 시작
--잘 됐을땐 commit
--잘 안됐을 땐 rollback
-- 둘 중 하나의 답이 올 때 까지 트랜잭션은 실행중인 상태이다.


-- 부서 테이블의 구조
-- desc : describe( 설명하다)
desc dept;
select * from dept;

-- 부서테이블에 50, 홍보부, 울산 부서 추가
-- insert into 테이블명 (칼럼명1, 컬럼명2, ...)
-- values(값1, 값2,....);
-- 숫자는 따옴표 없고, 문자/날짜는 따옴표
insert into dept(deptno, dname, loc)
values(50, '홍보부', '울산');

desc emp;
select * from emp;
-- 사원 테이블에 데이터 추가
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values ('1015', '정병준','부장', 1009, sysdate, 2000, 500, 50);


-- 데이터 수정/갱신 update
-- where 절은 필수절이 아니지만 where이 없으면 전체를 수정하게됨.
-- set 은 값을 변경하고자하는 컬럼만 기재
update emp
set job = '차장',
    sal = 1000
where ename = '정병준';

select * from emp;

-- 데이터 삭제 - delete
-- 이름이 정병준인 직원 삭제
delete from emp
where ename = '정병준';


-- 처음 DML을 시작한 순간부터 여기까지의 작업 취소
rollback;
-- 처음 DML을 시작한 순간부터 여기까지의 작업을 처리
commit;
-- 커밋이후에 다시 새로 트랜잭션이 설정됨
