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

commit;