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

-- Ŀ�ø��� ������ ��� ��ȸ
select *
from emp
where comm is not null;