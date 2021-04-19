select deptno, dname, loc
from dept;

select empno, ename, job, deptno
from emp;

select *
from emp;

--null�� ���ؼ� ��������� �ϸ� ����� null�̴�.
select ename, sal, sal*12+comm
from emp;

-- nvl�Լ� - Null Value : ���� ���� ��� Ư�������� ��ü
select ename, sal, sal*12+nvl(comm, 0)
from emp;

-- ��Ī�ο� : as ��Ī, �����ϰ� ��Ī
select ename as �̸�, sal �޿�, sal*12+nvl(comm,0) "�� �� �� �� ��"
from emp;

-- �ѿ��� �븮�� �޿��� 250�����Դϴ�.
-- db������ ���ڿ��� ''(Ȭ����ǥ)�ȿ� ���
select ename || ' ' || job || '�� �޿��� ' || sal || '�����Դϴ�.'
from emp;

-- distinct(����Ʈ) : �ߺ��� ����
-- ������̺��� ��å(����, job) ��ȸ
select DISTINCT job
from emp;

-- ��(row) ����, ����, where ��
-- �޿��� 500���� �̻��� ��� ��ȸ
-- �޿�: sal
-- 500�����̻�: 500������ ���Ե�( >= 500)
select *
from emp
where sal >= 500;

-- �񱳿�����
-- ���� : =
-- �����ʴ� : <>
-- �̸��� �̹����� ��� ���� ��ȸ
-- �̸�: ename='�̹���'
select *
from emp
where ename = '�̹���'; --���ڵ����ʹ� ''�� ���Ѵ�.

-- 10���μ��� �ٹ��ϴ� ��� ��ȸ
-- �μ���ȣ: deptno
select *
from emp
where deptno = 10; -- ���ڵ����ʹ� ''�� ������ �ʴ´�.

-- 2005�� 1�� 1�� ������ �Ի��� ��� ��ȸ
-- ��ǻ�ÿ��� ��¥������ ������\��
-- Unix Time(1970�� 1�� 1�� 0��)
select *
from emp
where hiredate < '2005/01/01' -- ��¥ �����͵� ''�� ���Ѵ�.
-- ����, ����, ��¥ ũ�� �������� �����µ� ���ڸ� ''�� �ȵ���.

-- ��������
-- AND, OR, NOT
-- �޿��� 400���� �̻�, 500���� ������ ��� ��ȸ
-- �޿��� 400���� 500 ������ ��� ��ȸ (���� ���� ���̴�.)
select *
from emp
where sal>=400 AND sal<=500;

-- �޿��� 400���� �̸�, 500���� �ʰ��� ��� ��ȸ
select *
from emp
where sal<400 OR sal>500;

-- Ŀ�̼��� 80, 100, 200�� ��� ��ȸ
select * 
from emp
where comm=80 OR comm=100 OR comm=200;

-- in ������
-- �ݺ��Ǵ� or ������ �ٿ��� ���
select *
from emp
where comm in(80, 100, 200);

-- ���� : between A and b (A�� B�� ���Ե�)
-- �޿��� 400�������� 500���� ������ ��� ��ȸ
select *
from emp
where sal between 400 and 500;
i
-- �޿��� 400���� �̸�, 500���� �ʰ��� ��� ��ȸ
-- sal < 400 or sal > 500
-- !(sal >= 400 and sal <= 500)
-- �޿��� 400�������� 500���� ���̰� �ƴ�(not)
select *
from emp
where sal not between 400 and 500;

-- 2003�⿡ �Ի��� ��� ��ȸ
select *
from emp
where hiredate between '2003/01/01' and '2003/12/31';

-- Ŀ�̼��� 80, 100, 200�� �ƴ� ��� ��ȸ
select *
from emp
where comm not in(80, 100, 200);

-- like(~ó��, ~�� ����)
-- �˻����� ����
-- ������ھ�(_)�� �ۼ�Ʈ(%)�� �Բ� ���δ�.
-- ������ھ�: �ش� ��ġ�� �ѱ���(�ƹ����ڳ�)�� �ǹ�
-- �ۼ�Ʈ: �ش� ��ġ�� 0�� �̻�(�ƹ����ڳ�)�� �ǹ�

-- ��� ����� ������ �ѱ��ڶ�� ����
-- ������ �̾���
select *
from emp
--where ename = '��' --�̸��� '��'��
where ename like '��%'; -- '��'�� �����ϰ� �ڿ� ���ڴ� 0�� �̻�

-- �̸��� '��'���� ������ �����ȸ
select *
from emp
where ename like '%��';

-- �̸��� '��'�� ���ԵǾ��ִ� �����ȸ
select *
from emp
where ename like '%��%';

-- �̸��� �ι�° ���ڰ� '��'�� ��� ��ȸ
select *
from emp
where ename like '_��%';

-- �̸��� '��'�� ��� ���� ���� ��� ��ȸ
select *
from emp
where ename not like '%��%';

-- �ΰ� ��
-- Ŀ�̼��� ���� ��� ��ȸ
select *
from emp
--where comm = null; --null ���� ������ �ִ� ���� �ƴ϶� �������� �ȵ�
where comm is null;

-- Ŀ�̼��� ������ ��� ��ȸ
select *
from emp
where comm is not null;

-- <ol> : Ordered List (�������)
-- order : ����
-- order by �÷��� : �ش� �÷����� ������ ���� -> ����
-- 2��,3�� .. n�� ������ �ʿ��ϴٸ�
-- order by �÷���1, �÷���2, ...
-- �⺻ ������ ��������(���������� ū��������) : asc(ascending) -��������
-- ��������(ū��->������)���� : desc(descending) -���

-- ��������� �Ի��� ������ �����ؼ� ��ȸ
select *
from emp
order by hiredate asc; -- asc�� ��������

-- �ֱ� �Ի��� ������ ��� ��ȸ
select *
from emp
order by hiredate desc;

-- �޿���, �޿��� ���ٸ� �̸���(�����ټ�)���� ���� ��ȸ
select *
from emp
order by sal, ename;
-- �޿��� ������(������)����, ���ٸ� �̸���(������)
select *
from emp
order by sal desc, ename asc; -- �������� ������ �����ĵ� ������ִ°� ����.

-- 1. ����� �̸��� �޿��� �Ի��� ��ȸ
select ename, sal, hiredate
from emp;
-- 2. �μ���ȣ�� �μ��� ��ȸ(��Ī��� '�μ���ȣ', '�μ���')
select deptno "�μ���ȣ", dname "�μ���"
from dept;
-- 3. ������ �ߺ����� �ʰ� �� ���� �����ؼ� ��ȸ
select distinct job
from emp;
-- 4. �޿��� 300 ������ ��� ��ȣ, �̸�, �޿� ��ȸ
select empno, ename, sal
from emp
where sal<=300;
-- 5. �̸��� "����ȣ" �� ����� �����ȣ, �̸�, �޿� ��ȸ
select empno,ename,sal
from emp
where ename = '����ȣ';
-- 6. �޿��� 250�̰ų�, 300�̰ų�, 500�� ������� ���, �̸�, �޿� ��ȸ
select empno, ename, sal
from emp
where sal in(250, 300, 500);
-- 7. �޿��� 250��, 300��, 500�� �ƴ� ����� ���, �̸�, �޿� ��ȸ
select empno, ename, sal
from emp
where sal not in(250, 300, 500);
-- 8. ������ �达�̰ų� �̸��� '��'�� ����ִ� �����ȸ
select *
from emp
where ename like '��%' OR ename like '%��%';
-- 9. �����(mgr)�� ���� �����ȸ
select *
from emp
where mgr is null;
-- 10. ��� ���̺��� �ֱ� �Ի��� ���� ������ ���, �̸�, ����, �Ի��� ��ȸ
select empno, ename, job, hiredate
from emp
order by hiredate desc;
-- 11. �μ���ȣ�� ���� ������� ����ϵ�, ���� �μ����� ����� ��� �Ի����� ������ ������� ��µǵ��� ��ȸ
select *
from emp
order by deptno, emp.hiredate;

-- dual ���̺�
-- ���̺� ���� ����
-- desc ���̺��, describe(�����ϴ�)
desc emp; -- ������ ����.
desc dual; 
select 24 * 60
from dual;
-- ���Ͱ��� �ӽ÷� ����� �� �� �ִ� ���̺��̴�.

-- ���밪
select -10, abs(-10)
from dual;

-- ����
select 34.5678, floor(34.5678)
from dual;

-- �ݿø�
select 34.5678, round(34.5678)
from dual;

select round(34.5678, 1), round(34.5678, -1)
from dual;

-- ������: %(x)
select mod(27, 2), mod(27, 5), mod(27, 7)
from dual;

-- upper: �빮�ڷ� ����, lower: �ҹ��ڷ� ����
-- initcap(�ܾ��� ù���ڸ� �빮��): �̴ϼ�, capitalize(�빮��)
select 'Welcome to Oracle', upper('Welcome to Oracle'),
    lower('Welcome to Oracle'),
    initcap('Welcome to Oracle')
from dual;

-- length : ���ڰ���
-- lengthb : ����Ʈ��
select length('Oracle'), length('����Ŭ'),
    lengthb('Oracle'), lengthb('����Ŭ')
from dual;

---------------------------
-- �κ� ���ڿ�: substr
-- substr(���, ������ġ, ����)
-- �ε����� 1���� ����
select substr('Welcome to Oracle',4,3)
from dual;

-- �ε����� �������� ����ϴ� ���
select substr('Welcome to Oracle',-4,3)
from dual;

-- instr: ��ġ(�ε���)ã��, index string
-- instr(���, ã������)
-- instr(���, ã������, ������ġ, ���°)
-- �տ������� �����ϰ� ã���ִ� ���ڰ� ������ ��
select instr('WELCOME TO ORACLE','O')
from dual;
-- �ε��� 6���� ã�� �����ؼ� 2��° �߰ߵǴ� 'O'
select instr('WELCOME TO ORACLE','O',6,2)
from dual;

--lpad, rpad(ä���): left padding, rigth padding
-- lpad(���, �ڸ���, ä�﹮��)
select lpad('Oracle', 20, '#'),
    rpad('Oracle',20,'$')
from dual;

-- ���ó�¥
select sysdate, to_char(sysdate, 'YYYY-MM-DD dy AM HH:MI:SS')
from dual;

-- ����/��¥ �����͸� ���������� ����ȯ(to_char);
select 1230000, to_char(1230000), to_char(1230000, 'L999,999,999')
from dual;


-- ��¥������ ���� (to_date)
-- 2007�� 4�� 2�Ͽ� �Ի��� ����� �̸��� �Ի��� ��ȸ
-- �̸�: ename, �Ի���: hiredate
select ename, hiredate
from emp
--where hiredate = '2007/04/02';
where hiredate = to_date(20070402, 'YYYYMMDD');

-- ���� ��ĥ�� �����°�
-- ���ó�¥(sysdate) - 2021/01/01

select floor(sysdate - to_date('2021/01/01'))
from dual;

-- ���ڷ� ��ȯ (to_number)
-- to_number('��','����')
select to_number('20,000','99,999') - to_number('10,000', '99,999')
from dual;

-- ��¥�� ���������δ� ���ڵ�����
select sysdate ����, sysdate+1 ����, sysdate-1 ����, sysdate+12 ������1��
from dual;

--