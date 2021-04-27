-- �� ����ϴ� ���� : �ݺ��Ǵ� �۾��� ���̰ų� ������ ����������

-- system���� ����
-- user01 ����ڿ��� �� ���� ���� �ο�
grant create view to user01;

-- user01�� ����
-- emp ���̺��� �����ؼ� emp_copy ���̺� ����
-- ���������� ���簡 �ȵ�
create table emp_copy
as
select * from emp;

-- 30�� �μ����� �ٹ��ϴ� ���
select *
from emp
where deptno = 30;

-- 30�� �μ����� �ٹ��ϴ� ����� ���� �� ����
-- ���� ���������� �����ϴ� ���� �ƴ� ������ ���� ���̺�
create view emp_view30
as
select *
from emp_copy
where deptno = 30;

-- ������ �並 ���ؼ� ����
select *
from emp_view30;

-- �������� Ȯ��(��ųʸ�)
select * from user_constraints;

-- �� Ȯ��
select * from user_views;

-- ��� ���ȿ� �����ϴ�.
-- ���� ���� user01 ����ڿ��Դ� �Ϻθ� ���̵���
drop view emp_view30;
create view emp_view20
as
select empno, ename, deptno
from emp_copy
where deptno = 20;

select *
from emp_view20;

-- �信 ���ؼ� crud �۾��� ����
-- �並 ������� insert
insert into emp_view20(empno, ename, deptno)
values (1015, '������', 10);

select * from emp_copy; -- insert Ȯ�ε�

-- ����(emp, dept)
create view emp_dname_view
as
select e.empno, e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno;

select * from emp_dname_view;

-- �� ����
-- �並 �����Ѵٰ��ؼ� ���̺��� ���������� �ʴ´�.
drop view emp_dname_view;

-- �����ϴ� �䰡 �ִ� ��� ���� �߻�
-- ������ ���� �����, ������ �����ϴ� ���
create or replace view emp_view30
as
select empno, ename,deptno
from emp
where deptno = 30;

-- ���� �������� �ʴ� employees��� ���̺� ���������ϴ� ���� ��
-- [force | noforce] : �⺻���� noforce
-- ���̺��� �������� �ʴ��� ������ �渣 ���� - force
create or replace force view employees_view30
as
select * from employees
where deptno =30;

select * from user_views;


-- ���ǿ� ���� �÷��� ���ؼ� �並 ���� ���� �Ұ�
create or replace view emp_chk20
as
select empno, ename, deptno
from emp_copy
where deptno = 20 with check option;


select * from emp_chk20;

select * from user_views;

-- with check option : deptno ���� �Ұ�
update emp_chk20
set deptno = 20;

-- Ŀ�̼ǿ� ���ؼ� ����
update emp_chk20
set ename = 'ȫ�浿';

create or replace view view_read20
as
select empno,ename,sal, comm, deptno
from emp_copy
where deptno = 30 with read only;

-- ���ǿ� ���� �÷� �̿��� �ٸ� �÷��� �����Ҽ� ����.
update view _read20
set comm = 10;

select * from view_read20;







-- �ٹ�ȣ �������¹�
select rownum, empno, ename, deptno
from emp_copy;

-- �Խ����� �Խñ��� 100����
-- ���������� 10���� ��� 1������

-- rownum ���� select �� ����
select rownum empno, ename, deptno
from emp_copy
order by empno desc;

delete from emp_copy
where empno = 1015;
commit;

-- ���������� �ڵ� -> �װ���� �ζ��κ�
-- �ֱ� �Ի� ������ 5���� ��ȸ
select * from (select rownum rnum, a.* from(select empno, ename, deptno, hiredate 
                                            from emp_copy
                                            order by hiredate desc) a)
where rnum between 1 and 5;
-- select������ rownum�� where������ rownum�� �ٸ��� ������ �ζ���? ��������?�� �Ѵ�
-- 1. �켱 ������� �����Ѵ�.
-- 2. ���ĵ� ���̺� rnum�� �־��ش�.
-- 3. ���ĵ� ���̺��� rnum�� 1~5������ �����͸� �߷�����.






-- ������(Sequence) : ���������� ����Ǵ� ��ȣ
-- �ǵ����� �ȵ� = �ѹ� ����� ���ڴ� ������ �ʴ´�.

create table emp_copy2(
    empno number(4) primary key,
    ename varchar2(10) not null
);
-- ����� ���� �Ի��ϸ� �����ȣ�� �ڵ��ο� - ������ ���
-- 1001�� ���� 1�� ����
create sequence seq_empno
start with 1001
increment by 1; -- �⺻������ 1���� 1�� ����


insert into emp_copy2(empno, ename)
values (seq_empno.nextval, 'ȫ�浿');

insert into emp_copy2(empno, ename)
values (seq_empno.nextval, '������');

select * from emp_copy2;