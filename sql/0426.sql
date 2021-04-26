
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

select * from emp02;