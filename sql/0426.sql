
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


-- foreign key ����غ���
-- �μ����̺�(dept)�� �μ���ȣ(deptno) �÷��� ����
-- �ش��÷��� ���� ������ �����Ǵ� ���̺� �����ϴ� ���� ���� �� �ִ�.

create table emp06(
    empno number(4) constraint pk_emp06_empno primary key,
    ename varchar2(10) constraint nn_emp06_ename not null,
    job varchar2(10),
    deptno number(2) 
);

insert into emp06(empno, ename, job, deptno)
values (1001, '����', '���', 10);

-- �μ����̺� ���� �μ��� 60�� �μ��� ����
insert into emp06(empno, ename, job, deptno)
values (1001, '�ڻ��', '�븮', 60); -- 60�� �μ� ������� ����


-- check �������� ����غ���
-- check ���� ������ �ش� �÷��� ���� Ư�� ���̳� ������ ����
-- ���(pk), �̸�(nn), �޿�(500�̻� 5000����), ����(M, F)

create table emp07(
    empno number(4) constraint pk_emp07_empno primary key,
    ename varchar2(10) constraint nn_emp07_ename not null,
    sal number(7,2) constraint ck_emp07_sal check(sal between 500 and 5000),
    gender varchar2(1) constraint ck_emp07_gender check(gender in ('M', 'F'))
);

-- �޿��� üũ ������ ����� ������ �Է�
-- check �������� ����
insert into emp07(empno, ename, sal, gender)
values (1001, '����', 6000, 'F');

-- ����(gender)�� �������� ���� M, F �̿��� ���� �Է�
-- check �������� ����
insert into emp07(empno, ename, sal, gender)
values(1001, '����', 1000, 'A'); -- 'A' �� gender�� ���� ���� �ƴ�

-- default �������� -> �����Ǿ��ִٸ� �⺻���� �Էµǵ����Ѵ�.
-- ���� �Ի��� ���� �Ӽ��� ����ð��� �⺻������ ���� ���鶧 ���� ���ȴ�.
-- �ش��÷��� �⺻��(default) ����
-- �μ����̺� loc(��ġ, ����)�� '����'�̶�� ���� �⺻������ ����
create table dept01(
    deptno number(2),
    dname varchar(10),
    loc varchar2(10) default '����'
);

-- loc�� �� �����ϰ� ������ �߰�
insert into dept01(deptno, dname)
values (10, '�渮��');

select * from dept01;


select *
from user_constraints;

select * from emp07;


-- number puzzle �� ���� ���̺� ���� �� �������� ����
drop table tbl_score;
drop table tbl_user;

create table tbl_user(
    u_id varchar2(20)
        constraint pk_user_id primary key,
    u_pw varchar2(20)
        constraint nn_user_pw not null,
    u_name varchar2(20)
        default '�ƹ���'
);

create table tbl_score(
    u_id varchar2(20) constraint fk_score_id references tbl_user(u_id),
    score number constraint nn_score_socre not null
);

select * from tbl_user;