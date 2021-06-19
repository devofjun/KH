create user model2 identified by 1234;
grant connect, resource to model2;


-- �۹�ȣ(PK) - b_no
-- ������ - b_title
-- �۳��� - b_content
-- �ۼ��� - b_date
-- �ۼ��� - m_id
-- ��ȸ�� - b_readcount
-- ÷������ - b_filepath
-- ��۱׷� - re_group
-- ��ۼ��� - re_seq
-- �鿩���� - re_level

-- ������(seq_bno)
create sequence seq_bno
start with 1
increment by 1;

create table tbl_board(
    b_no number constraint pk_board_bno primary key,
    b_title varchar2(50) not null,
    b_content varchar2(500),
    b_date TIMESTAMP default sysdate,
    m_id varchar2(20) not null,
    b_readcount number default 0,
    re_group number default 0,
    re_seq number default 0,
    re_level number default 0,
    b_filepath varchar2(200)
);

insert into tbl_board values(seq_bno.nextval, '����2', '����2', sysdate, 'hong', 0,0,0,0,'smile.png');

-- �̹� ������ �Խñۿ� �׷� ��ȣ �ű��
update tbl_board set
    re_group = b_no;


select * from tbl_board;
commit;

delete from tbl_board
where re_seq=3;

truncate table tbl_board; -- ���� ��� rollback �ȵ�
----------------------
-- �α��� ���̺� ����
----------------------
create table tbl_member(
    user_id varchar2(20) constraint pk_member_id primary key,
    user_pw varchar2(20) not null,
    user_name varchar2(20) not null
);

select * from tbl_member;

insert into tbl_board(b_no, b_title, b_content, m_id)
values (seq_bno.nextval, '����1', '����1', 'hong');

insert into tbl_board(b_no, b_title, b_content, m_id)
values (seq_bno.nextval, '����2', '����2', 'hong2');

commit;

-----
-- ����¡

drop sequence seq_bno;
create sequence seq_bno;

truncate table tbl_board;

-- �ݺ������� insert�ϱ�
begin
    for i in 1..500 loop
        insert into tbl_board(b_no, b_title, b_content, m_id, re_group)
        values (seq_bno.nextval,
            '����' || i,
            '����' || i,
            'hong',
            seq_bno.nextval);
    end loop;
end;
/
commit;

select * from tbl_board order by b_no desc;

-- 10�� (500~491)
select * from
(select rownum rnum, a.* from
(select * from tbl_board
order by re_group desc, re_seq asc) a)
where rnum >= 11 and rnum <= 20;

select * from tbl_board
where b_title like '%����5%'
order by re_group desc, re_seq asc;


----------------------------------
-- ��� ���̺� ����
-----------------------------------

create table tbl_comment(
    c_no number constraint pk_con primary key,
    b_no number constraint fk_bno references tbl_board(b_no),
    c_content varchar2(200) not null,
    m_id varchar2(20) constraint fk_c_mid references tbl_member(user_id),
    c_date timestamp default sysdate
);

create sequence seq_cno;

-- Ŀ�ؼ� Ǯ(Connection pool)


select max(b_no) from tbl_board;
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '���1', 'hong', sysdate);
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '���2', 'hong', sysdate);
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '���3', 'hong', sysdate);

delete from tbl_comment;

commit;
select * from tbl_comment;