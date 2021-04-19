select deptno, dname, loc
from dept;

select empno, ename, job, deptno
from emp;

select *
from emp;

--null에 대해서 산술연산을 하면 결과도 null이다.
select ename, sal, sal*12+comm
from emp;

-- nvl함수 - Null Value : 값이 널인 경우 특정값으로 대체
select ename, sal, sal*12+nvl(comm, 0)
from emp;

-- 별칭부여 : as 별칭, 생략하고 별칭
select ename as 이름, sal 급여, sal*12+nvl(comm,0) "연 간 지 급 액"
from emp;

-- 한예슬 대리의 급여는 250만원입니다.
-- db에서는 문자열을 ''(홑따옴표)안에 기술
select ename || ' ' || job || '의 급여는 ' || sal || '만원입니다.'
from emp;

-- distinct(디스팅트) : 중복행 제거
-- 사원테이블에서 직책(직급, job) 조회
select DISTINCT job
from emp;

-- 행(row) 선택, 조건, where 절
-- 급여가 500만원 이상인 사원 조회
-- 급여: sal
-- 500만원이상: 500만원이 포함됨( >= 500)
select *
from emp
where sal >= 500;

-- 비교연산자
-- 같다 : =
-- 같지않다 : <>
-- 이름이 이문세인 사원 정보 조회
-- 이름: ename='이문세'
select *
from emp
where ename = '이문세'; --문자데이터는 ''로 감싼다.

-- 10번부서에 근무하는 사원 조회
-- 부서번호: deptno
select *
from emp
where deptno = 10; -- 숫자데이터는 ''로 감싸지 않는다.

-- 2005년 1월 1일 이전에 입사한 사원 조회
-- 컴퓨팅에서 날짜정보는 숫자정\보
-- Unix Time(1970년 1월 1일 0시)
select *
from emp
where hiredate < '2005/01/01' -- 날짜 데이터도 ''로 감싼다.
-- 글자, 숫자, 날짜 크게 세가지로 나뉘는데 숫자만 ''가 안들어간다.

-- 논리연산자
-- AND, OR, NOT
-- 급여가 400만원 이상, 500만원 이하인 사원 조회
-- 급여가 400에서 500 사이인 사원 조회 (위와 같은 말이다.)
select *
from emp
where sal>=400 AND sal<=500;

-- 급여가 400만원 미만, 500만원 초과인 사원 조회
select *
from emp
where sal<400 OR sal>500;

-- 커미션이 80, 100, 200인 사원 조회
select * 
from emp
where comm=80 OR comm=100 OR comm=200;

-- in 연산자
-- 반복되는 or 구문을 줄여서 사용
select *
from emp
where comm in(80, 100, 200);

-- 사이 : between A and b (A와 B가 포함됨)
-- 급여가 400만원에서 500만원 사이인 사원 조회
select *
from emp
where sal between 400 and 500;
i
-- 급여가 400만원 미만, 500만원 초과인 사원 조회
-- sal < 400 or sal > 500
-- !(sal >= 400 and sal <= 500)
-- 급여가 400만원에서 500만원 사이가 아닌(not)
select *
from emp
where sal not between 400 and 500;

-- 2003년에 입사한 사원 조회
select *
from emp
where hiredate between '2003/01/01' and '2003/12/31';

-- 커미션이 80, 100, 200이 아닌 사원 조회
select *
from emp
where comm not in(80, 100, 200);

-- like(~처럼, ~와 같은)
-- 검색에서 사용됨
-- 언더스코어(_)나 퍼센트(%)와 함께 쓰인다.
-- 언더스코어: 해당 위치에 한글자(아무글자나)를 의미
-- 퍼센트: 해당 위치에 0개 이상(아무글자나)을 의미

-- 모든 사원이 성씨가 한글자라고 가정
-- 성씨가 이씨인
select *
from emp
--where ename = '이' --이름이 '이'인
where ename like '이%'; -- '이'로 시작하고 뒤에 글자는 0개 이상

-- 이름이 '성'으로 끝나는 사원조회
select *
from emp
where ename like '%성';

-- 이름에 '성'이 포함되어있는 사원조회
select *
from emp
where ename like '%성%';

-- 이름의 두번째 글자가 '성'인 사원 조회
select *
from emp
where ename like '_성%';

-- 이름에 '성'이 들어 있지 않은 사원 조회
select *
from emp
where ename not like '%성%';

-- 널값 비교
-- 커미션이 널인 사원 조회
select *
from emp
--where comm = null; --null 값은 정해져 있는 값이 아니라 논리연산이 안됨
where comm is null;

-- 커미션이 정해진 사원 조회
select *
from emp
where comm is not null;

-- <ol> : Ordered List (순서목록)
-- order : 순서
-- order by 컬럼명 : 해당 컬럼으로 순서를 정함 -> 정렬
-- 2차,3차 .. n차 정렬이 필요하다면
-- order by 컬럼명1, 컬럼명2, ...
-- 기본 정렬은 오름차순(작은값에서 큰값순으로) : asc(ascending) -생략가능
-- 내림차순(큰값->작은값)정렬 : desc(descending) -명시

-- 사원정보를 입사일 순으로 정렬해서 조회
select *
from emp
order by hiredate asc; -- asc는 생략가능

-- 최근 입사한 순으로 사원 조회
select *
from emp
order by hiredate desc;

-- 급여순, 급여가 같다면 이름순(가나다순)으로 정렬 조회
select *
from emp
order by sal, ename;
-- 급여가 많으순(역정렬)으로, 같다면 이름순(순정렬)
select *
from emp
order by sal desc, ename asc; -- 역정렬이 나오면 순정렬도 명시해주는게 좋다.

-- 1. 사원의 이름과 급여와 입사일 조회
select ename, sal, hiredate
from emp;
-- 2. 부서번호와 부서명 조회(별칭사용 '부서번호', '부서명')
select deptno "부서번호", dname "부서명"
from dept;
-- 3. 직급을 중복하지 않고 한 번씩 나열해서 조회
select distinct job
from emp;
-- 4. 급여가 300 이하인 사원 번호, 이름, 급여 조회
select empno, ename, sal
from emp
where sal<=300;
-- 5. 이름이 "오지호" 인 사원의 사원번호, 이름, 급여 조회
select empno,ename,sal
from emp
where ename = '오지호';
-- 6. 급여가 250이거나, 300이거나, 500인 사원들의 사번, 이름, 급여 조회
select empno, ename, sal
from emp
where sal in(250, 300, 500);
-- 7. 급여가 250도, 300도, 500도 아닌 사원의 사번, 이름, 급여 조회
select empno, ename, sal
from emp
where sal not in(250, 300, 500);
-- 8. 성씨가 김씨이거나 이름에 '기'가 들어있는 사원조회
select *
from emp
where ename like '김%' OR ename like '%기%';
-- 9. 상급자(mgr)가 없는 사원조회
select *
from emp
where mgr is null;
-- 10. 사원 테이블에서 최근 입사한 직원 순으로 사번, 이름, 직급, 입사일 조회
select empno, ename, job, hiredate
from emp
order by hiredate desc;
-- 11. 부서번호가 빠른 사원부터 출려하되, 같은 부서내의 사원인 경우 입사한지 오래된 사원부터 출력되도록 조회
select *
from emp
order by deptno, emp.hiredate;

-- dual 테이블
-- 테이블 구조 보기
-- desc 테이블명, describe(설명하다)
desc emp; -- 구조를 본다.
desc dual; 
select 24 * 60
from dual;
-- 위와같이 임시로 결과를 볼 수 있는 테이블이다.

-- 절대값
select -10, abs(-10)
from dual;

-- 버림
select 34.5678, floor(34.5678)
from dual;

-- 반올림
select 34.5678, round(34.5678)
from dual;

select round(34.5678, 1), round(34.5678, -1)
from dual;

-- 나머지: %(x)
select mod(27, 2), mod(27, 5), mod(27, 7)
from dual;

-- upper: 대문자로 변경, lower: 소문자로 변경
-- initcap(단어의 첫글자만 대문자): 이니셜, capitalize(대문자)
select 'Welcome to Oracle', upper('Welcome to Oracle'),
    lower('Welcome to Oracle'),
    initcap('Welcome to Oracle')
from dual;

-- length : 글자갯수
-- lengthb : 바이트수
select length('Oracle'), length('오라클'),
    lengthb('Oracle'), lengthb('오라클')
from dual;

---------------------------
-- 부분 문자열: substr
-- substr(대상, 시작위치, 갯수)
-- 인덱스는 1부터 시작
select substr('Welcome to Oracle',4,3)
from dual;

-- 인덱스에 음수값을 사용하는 경우
select substr('Welcome to Oracle',-4,3)
from dual;

-- instr: 위치(인덱스)찾기, index string
-- instr(대상, 찾을글자)
-- instr(대상, 찾을글자, 시작위치, 몇번째)
-- 앞에서부터 시작하고 찾고있는 글자가 나오면 끝
select instr('WELCOME TO ORACLE','O')
from dual;
-- 인덱스 6부터 찾기 시작해서 2번째 발견되는 'O'
select instr('WELCOME TO ORACLE','O',6,2)
from dual;

--lpad, rpad(채우기): left padding, rigth padding
-- lpad(대상, 자릿수, 채울문자)
select lpad('Oracle', 20, '#'),
    rpad('Oracle',20,'$')
from dual;

-- 오늘날짜
select sysdate, to_char(sysdate, 'YYYY-MM-DD dy AM HH:MI:SS')
from dual;

-- 숫자/날짜 데이터를 문자형으로 형변환(to_char);
select 1230000, to_char(1230000), to_char(1230000, 'L999,999,999')
from dual;


-- 날짜형으로 변경 (to_date)
-- 2007년 4월 2일에 입사한 사원의 이름과 입사일 조회
-- 이름: ename, 입사일: hiredate
select ename, hiredate
from emp
--where hiredate = '2007/04/02';
where hiredate = to_date(20070402, 'YYYYMMDD');

-- 올해 며칠이 지났는가
-- 오늘날짜(sysdate) - 2021/01/01

select floor(sysdate - to_date('2021/01/01'))
from dual;

-- 숫자로 변환 (to_number)
-- to_number('수','형식')
select to_number('20,000','99,999') - to_number('10,000', '99,999')
from dual;

-- 날짜도 내부적으로는 숫자데이터
select sysdate 오늘, sysdate+1 내일, sysdate-1 어제, sysdate+12 다음달1일
from dual;

--