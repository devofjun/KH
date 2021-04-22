-- ���̺� ����
-- create table ���̺�� (
--  �÷���1 ������Ÿ�� ��������,
--  �÷���1 ������Ÿ�� ��������
-- );
-- emp01 ���̺����(��������(���),��������(�̸�), ����(�޿�))
create table emp01(
    empno number(4), -- ����4�ڸ�, �������� ����
    ename varchar2(14), -- ���� 14�ڸ�(�ѱ� 3byte)
    sal number(7, 3) -- ��ü 7�ڸ�, �Ҽ������� 3�ڸ�
);

insert into emp01 (empno, ename, sal)
values (1001, '������', 2000); -- ������Ÿ���� �Ʒ�ó�� �ڵ����� �����ֱ⵵ �Ѵ�.
insert into emp01 (empno, ename, sal)
values('1002', 100, 1000);    -- '1002' -> 1002 / 100 -> '100'

insert into emp01 (empno, ename, sal)
values ('��õ��', '����', 1000); -- ��ȿ���� ���� ����

-- �÷� �߰�
-- �̹� ������ ���̺�(emp01)�� �÷� �߰�
alter table emp01
add birth date; -- date������Ÿ���� birth��� �̸��� �÷��� �߰���

-- �÷� ����
-- ���ǻ���: ���̸� �����Ҷ� �ø��°� �������� ���̴°� ������ �� �� �ִ�.
-- �̹� ������ ���̺�(emp01)�� �̸�(ename) �÷��� ���������� ����
-- update ename(x)
-- modify ename(o)
alter table emp01
modify ename varchar(30);

-- �÷� ����
-- �̹� ������ ���̺�(emp01)�� �̸�(ename) �÷��� ����
-- delete(x), drop(o)
alter table emp01
drop column ename;

-- ���̺�� �����ϱ�(rename A to B)
rename emp01 to emp02;

-- ���̺� ����(drop)
-- delete table(x)
-- ���̺��� �����͸� ����(x), ���̺� ��ü�� ����(o)
drop table emp02;

-- ���̺��� ��� ������ ����
truncate table emp01;


select * from emp01;
desc emp02;