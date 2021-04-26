
-- ������ ��ųʸ����� ���� ���� Ȯ��
desc user_constraints;

select * from user_constraints;

select constraint_name, constraint_type, table_name
from user_constraints;

-- NOT NULL (NULL ���� ������� ����)
-- ���� �ݵ�� �����ؼ� �־��(������� ���ƶ�)
-- ���, �̸��� �ΰ��� ������� ����
create table user02(
    empno number(4) not null,
    ename varchar2(20) not null,
    job varchar2(10),
    deptno number(2)
);
-- user02 ���̺� ������ �Է�
-- insert���� �÷����� ��������
-- desc��ɾ�� ������ ������� values ���� �Է�

insert into user02(empno, ename, job, deptno)
values (1001, '����', '���', 10);

desc user02;
insert into user02
values (1002, '���μ�', '�븮',20);

-- ���̺� ������ ������
truncate table user02;

-- not null ���������� ����� �÷�(empno, ename)�� �ΰ� �־��
insert into user02
values(null, null, '���', 10); -- ������

-- not null ���������� ������� ���� �÷�(job, deptno)�� �ΰ� �־��
insert into user02(empno, ename, job, deptno)
values(1001, '����', null, null); -- �������� ����

-- not null ���������� �ش� �÷��� �����͸� �ݵ�� �ֵ��� ����

-- ���̺����
DROP TABLE emp02 CASCADE CONSTRAINTS;
-- ���̺�� ����
rename user02 to emp02;
-- ���ǵ� �������� ����
select constraint_name, constraint_type, table_name
from user_constraints;


-- ���(unique), �̸�(not null), ����, �μ���ȣ
create table emp03(
    empno number(4) unique,
    ename varchar(10) not null,
    job varchar(10),
    deptno number(2)
);

insert into emp03(empno, ename, job, deptno)
values(1001, '����', '���', 10);

insert into emp03(empno, ename, job, deptno)
values(1001, '�ڻ��', '�븮', 20); -- �����߻� unique �������� ����

-- unique ���������� ����� empno �÷��� �ΰ� �־��
insert into emp03(empno, ename, job, deptno)
values(null, '�ڻ��', '�븮', 20); -- unique���� �ΰ��� ����
-- unique : �ߺ����� �ʴ� ������, �ΰ��� ����Ѵ�.

-- �������ǿ� �̸� �ֱ�
create table emp04(
    empno number(4) constraint uk_emp04_empno unique,
    ename varchar2(10) constraint nn_emp04_ename not null,
    job varchar2(10),
    deptno number(2)
);

-- primary key = unique + not null
-- �ٸ����� �����ϱ� �뵵�� ���ȴ�.
-- primay key �����غ���
create table emp05(
    empno number(4) constraint pk_emp05_empno primary key,
    ename varchar2(10) constraint nn_emp05_ename not null,
    job varchar2(10),
    deptno number(2)
);

insert into emp05(empno, ename, job, deptno)
values (null, '����', '���', 10); -- primary key���� null�� ������� ����


insert into emp05(empno, ename, job, deptno)
values (1001, '����', '���', 10);

insert into emp05(empno, ename, job, deptno)
values (1001, '�ڻ��', '�븮', 20); -- unique �������ǿ� �����




select *
from user_constraints;
select * from emp05;