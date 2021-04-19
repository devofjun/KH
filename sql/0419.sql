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

-- 커시면이 정해진 사원 조회
select *
from emp
where comm is not null;