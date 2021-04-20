-- ����(12:00) ����, round �ݿø�, trunc ����
select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'),
        to_char(round(sysdate), 'YYYY-MM-DD HH24:MI:SS'),
        to_char(round(to_date('2021-04-20 13:01:00','YYYY-MM-DD HH24:MI:SS')),'YYYY-MM-DD HH24:MI:SS'),
        to_char(trunc(to_date('2021-04-20 13:01:00','YYYY-MM-DD HH24:MI:SS')),'YYYY-MM-DD HH24:MI:SS')
from dual;

-- �Ի��� ���� ù 1��
select ename, hiredate, trunc(hiredate, 'MONTH')
from emp;

-- ������� �ٹ� ������
-- ��¥�� ���� : ����
-- months_between : �޼�
select ename �̸�, sysdate ����, hiredate �Ի���,
    trunc(sysdate-hiredate) �ٹ��ѳ���,
    trunc(months_between(sysdate, hiredate)) �ٹ��Ѵ޼�
from emp;

-- ������� �Ի���, �Ի��� 6������ ��¥
-- ��¥�� ���� : �� ��
-- add_months : �� ��
select ename �̸�, hiredate �Ի���, 
    hiredate + 6 "6����",
    add_months(hiredate, 6) "6������",
    add_months(hiredate, -6) "6������"
from emp;

-- ���ƿ��� ~����
-- ������� �Ի��� ù �ָ�
select sysdate ����,
    next_day(sysdate, '������') "���ƿ��� ������"
from dual;

select hiredate �Ի���,
    next_day(hiredate, '�����') "�Ի��� ù �ָ�"
from emp;

-- ���� 4��(29), 100��(28), 400��(29)
-- �ش� ��¥�� ������ ��
select sysdate ����,
    last_day(sysdate) "�̴��� ������ ��",
    last_day(to_date('2000/02/01', 'YYYY-MM-DD'))
from dual;
-- ������� �Ի����� ������ ��
select ename, hiredate �Ի���,
    last_day(hiredate) "�Ի����� ������ ��"
from emp;

-- Null Value
-- nvl(�ΰ�, ��ü��)
-- nvl2(��, ���̾ƴѰ��, ���ΰ��)
select ename �̸�, sal �޿�,
    nvl2(comm, sal*12+comm, sal*12) "����(���ʽ���)"
from emp;

-- nullif(��1, ��2) : �� ���� ������ null, �ٸ��� ù��° ��
select nullif('A', 'A'), nullif('A','B')
from dual;

-- coalesce(��1, ��2, ... ��n) : ���� ���� �߿��� ���� �ƴ� ù��° ��
select ename �̸�, comm Ŀ�̼�, sal,
    coalesce(comm, sal)
from emp;

-- ������� �ٹ��ϴ� �μ���
-- decode = switch~case �� �����ϴ�.
select ename �̸�, deptno �μ���ȣ,
    decode(deptno, 10, '�渮��',
                    20, '�λ��',
                    30, '������',
                    40, '�����',
                    '�μ�����')
from emp;

-- case = if, else if, else �� �����ϴ�.
select ename �̸�, deptno �μ���ȣ, 
    case
        when deptno = 10 then '�渮��'
        when deptno = 20 then '�λ��'
        when deptno = 30 then '������'
        when deptno = 40 then '�����'
    end �μ���
from emp;

select *
from emp;
-- 1. substr �Լ��� ����Ͽ� 9���� �Ի��� ��� ��ȸ
select *
from emp
where substr(hiredate, 6, 2) = '09';
-- 2. substr �Լ��� ����Ͽ� 2003�⵵�� �Ի��� ��� ��ȸ
select *
from emp
where substr(hiredate, 1, 4) = '2003';
-- 3. substr �Լ��� ����Ͽ� "��"�� ������ ��� ��ȸ
select *
from emp
where substr(ename, -1, 1) = '��';
-- 4. instr �Լ��� ����Ͽ� �̸��� �ι�° ���ڿ� "��" �� �ִ� ��� ��ȸ
select *
from emp
where instr(ename, '��', 1, 1)=2;
-- 5. ����(job)�� ���� ������ "����"�� ����� 5%, "����"�� ����� 10%, "�븮"�� ����� 15%,
--    "���"�� ����� 20% �� �λ�� �޿� ��ȸ
select ename �̸�, job ����, sal,
    case
        when job = '����' then sal*0.05+sal
        when job = '����' then sal*0.10+sal
        when job = '�븮' then sal*0.15+sal
        when job = '���' then sal*0.20+sal
    end "�λ�� ����"
from emp;
-- 6. �Ի����� �⵵ 2�ڸ�, �� 2�ڸ�, �� 2�ڸ� ������ ���("������" ->"��")�� �����Ͽ� ���
select ename, to_char(hiredate,'YY-MM-DD dy')
from emp;


-- ���⼭����

-- �׷��Լ�

-- count : ���� ����(�ο��� ����)
-- ��ü ������� Ŀ�̼��� ������ �����
select count(*) �����, count(comm) Ŀ�̼ǻ����
from emp;

-- ������� �޿� �Ѿ�, �޿� ���, �ִ� �޿�, �ּ� �޿� ��ȸ
-- sum : summary
-- avg : average
-- max : maximum
-- min : mininum
select sum(sal) "�޿� �Ѿ�",
    round(avg(sal)) "�޿� ���",
    max(sal) "�ִ� �޿�",
    min(sal) "�ּ� �޿�"
from emp;

-- �Ի����� ���� ������ ��¥, ���� �ֱ� �Ի���
select min(hiredate) "������",
    max(hiredate) "�ֱ���"
from emp;

-- �Ϲ����� ����: null���� ���� -> null
-- �׷��Լ����� ����: null�� �����ϰ� ���
select count(comm), sum(comm), avg(comm), min(comm)
from emp;

-- �׷��Լ� : ~�� ...
-- ���� ���� �޿��� �޴� ����� �̸��� �޿� ��ȸ
-- select ename, max(sal) -- ename�� ����� 14���ε� max�� ����� 1���̱� ������ ����ȵ�.
select ename, sal
from emp
where sal = (select max(sal) from emp); -- ��������

-- ����(job)�� �� 
--select count(job) -- null�� �ƴ� job �ߺ� ���Ե� �ο��� ��
select count(distinct job) -- �ߺ��� ������ job�� �ο��� ���� ���
from emp;

-- group by ��
-- group by �÷��� : �ش� �÷������� �׷���(~��)
-- �׷��Լ��� ���� ���δ�.
-- �μ���ȣ���� �׷���
-- �׷����� ����� ������ ����������. -> �׷캰�� ����� �����
select deptno, round(avg(sal),1), sum(sal), min(sal), max(sal)
from emp
group by deptno;

-- �μ��� �ο���, Ŀ�̼��� ������ �ο���
select deptno, count(*), count(comm)
from emp
group by deptno;

-- having�� group by�� ���� where(���ǿ� �°� �ο� �߷���)��� �����ϸ��
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >= 500;

-- order by�� �׻� ���� ���߿� ����
select deptno, round(avg(sal),1), sum(sal), min(sal), max(sal)
from emp
group by deptno
order by deptno;

-- ����(job)�� "���"�� ������ �����ϰ�, ���޺� �޿� �Ѿ�
-- �޿��Ѿ��� ��������� ����
select job, sum(sal)
from emp
where job <> '���'
group by job;

-- ��� �޿��� ���� ���� �μ��� ��ձ޿�
select max(avg(sal))
from emp
group by deptno;


select *
from emp;

-- 1. �޿� �ְ��, ������, �Ѿ� �� ��� �޿� ���ϱ�
select max(sal) �޿��ְ��, min(sal) �޿�������, sum(sal) �Ѿ�, avg(sal) ���
from emp;
-- 2. ���޺��� �޿� �ְ��, ������, �Ѿ�, ��� �޿� ���ϱ�
select job, max(sal), min(sal), sum(sal), avg(sal)
from emp
group by job;
-- 3. ���޺� ����� ���ϱ�
select job, count(*)
from emp
group by job;
-- 4. ������ �� ���ϱ�
select count(*)
from emp
where job='����';
-- 5. �޿� �����װ� �޿� �ְ���� ���� ���ϱ�
select max(sal)-min(sal)
from emp;
-- 6. �μ��� �����, ��� �޿� ���ϱ�(�μ���ȣ ������ ����)
select deptno, count(*), avg(sal)
from emp
group by deptno
order by deptno;
-- 7. �μ���ȣ�� �μ��̸�(dname), ������(loc), �����, ��ձ޿� ���ϱ�
select deptno �μ���ȣ,
        decode(deptno, 10, '�渮��',
                        20, '�λ��',
                        30, '������',
                        40, '�����') �μ���,
        decode(deptno, 10,'����',
                        20,'��õ',
                        30,'����',
                        40,'����') ����,
        count(*) �����, round(avg(sal)) ��ձ޿�
from emp
group by deptno;


-- DQL(Data Query Language) - select
-- DML(Data Manupulation Language) - ����
-- -insert update delete

-- Ʈ����� - ���� ����

--CRUD ������ó��
--insert - create
--select - read
--update - update
--delete - delete


-- Ʈ����� ����
--�� ������ commit
--�� �ȵ��� �� rollback
-- �� �� �ϳ��� ���� �� �� ���� Ʈ������� �������� �����̴�.


-- �μ� ���̺��� ����
-- desc : describe( �����ϴ�)
desc dept;
select * from dept;

-- �μ����̺� 50, ȫ����, ��� �μ� �߰�
-- insert into ���̺�� (Į����1, �÷���2, ...)
-- values(��1, ��2,....);
-- ���ڴ� ����ǥ ����, ����/��¥�� ����ǥ
insert into dept(deptno, dname, loc)
values(50, 'ȫ����', '���');

desc emp;
select * from emp;
-- ��� ���̺� ������ �߰�
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values ('1015', '������','����', 1009, sysdate, 2000, 500, 50);


-- ������ ����/���� update
-- where ���� �ʼ����� �ƴ����� where�� ������ ��ü�� �����ϰԵ�.
-- set �� ���� �����ϰ����ϴ� �÷��� ����
update emp
set job = '����',
    sal = 1000
where ename = '������';

select * from emp;

-- ������ ���� - delete
-- �̸��� �������� ���� ����
delete from emp
where ename = '������';


-- ó�� DML�� ������ �������� ��������� �۾� ���
rollback;
-- ó�� DML�� ������ �������� ��������� �۾��� ó��
commit;
-- Ŀ�����Ŀ� �ٽ� ���� Ʈ������� ������
