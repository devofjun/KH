create user model2 identified by 1234;
grant connect, resource to model2;


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

-- 이미 생성된 게시글에 그룹 번호 매기기
update tbl_board set
    re_group = b_no;


select * from tbl_board;
commit;

delete from tbl_board
where re_seq=3;

truncate table tbl_board; -- 빠른 대신 rollback 안됨
----------------------
-- 로그인 테이블 생성
----------------------
create table tbl_member(
    user_id varchar2(20) constraint pk_member_id primary key,
    user_pw varchar2(20) not null,
    user_name varchar2(20) not null
);

select * from tbl_member;

insert into tbl_board(b_no, b_title, b_content, m_id)
values (seq_bno.nextval, '제목1', '내용1', 'hong');

insert into tbl_board(b_no, b_title, b_content, m_id)
values (seq_bno.nextval, '제목2', '내용2', 'hong2');

commit;

-----
-- 페이징

drop sequence seq_bno;
create sequence seq_bno;

truncate table tbl_board;

-- 반복문에서 insert하기
begin
    for i in 1..500 loop
        insert into tbl_board(b_no, b_title, b_content, m_id, re_group)
        values (seq_bno.nextval,
            '제목' || i,
            '내용' || i,
            'hong',
            seq_bno.nextval);
    end loop;
end;
/
commit;

select * from tbl_board order by b_no desc;

-- 10개 (500~491)
select * from
(select rownum rnum, a.* from
(select * from tbl_board
order by re_group desc, re_seq asc) a)
where rnum >= 11 and rnum <= 20;

select * from tbl_board
where b_title like '%제목5%'
order by re_group desc, re_seq asc;


----------------------------------
-- 댓글 테이블 생성
-----------------------------------

create table tbl_comment(
    c_no number constraint pk_con primary key,
    b_no number constraint fk_bno references tbl_board(b_no),
    c_content varchar2(200) not null,
    m_id varchar2(20) constraint fk_c_mid references tbl_member(user_id),
    c_date timestamp default sysdate
);

create sequence seq_cno;

-- 커넥션 풀(Connection pool)


select max(b_no) from tbl_board;
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '댓글1', 'hong', sysdate);
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '댓글2', 'hong', sysdate);
insert into tbl_comment(c_no, b_no, c_content, m_id, c_date)
values (seq_cno.nextval, 500, '댓글3', 'hong', sysdate);

delete from tbl_comment;

commit;
select * from tbl_comment;