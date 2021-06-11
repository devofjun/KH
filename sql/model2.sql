-- 글번호(PK) - b_no
-- 글제목 - b_title
-- 글내용 - b_content
-- 작성일 - b_date
-- 작성자 - m_id
-- 조회수 - b_readcount
-- 첨부파일 - b_filepath
-- 답글그룹 - re_group
-- 답글순서 - re_seq
-- 들여쓰기 - re_level

-- 시퀀스(seq_bno)
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

insert into tbl_board values(seq_bno.nextval, '제목2', '내용2', sysdate, 'hong', 0,0,0,0,'smile.png');

commit;