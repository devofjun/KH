create user springmvc2 identified by 1234;
grant connect, resource to springmvc2;

-- 회원 테이블 

drop table tbl_member;  
create table tbl_member(
    user_id varchar2(50) primary key,
    user_pw varchar2(50) not null,
    user_name varchar2(50) not null,
    user_email varchar2(50),
    reg_date timestamp default sysdate,
    update_date timestamp
);

insert into tbl_member(user_id, user_pw, user_name)
values('test', '1234', 'beng');

select * from tbl_member;

commit;

-- 게시글 생성 쿼리

drop table tbl_board;
create table tbl_board(
    b_no number primary key,
    b_title varchar2(100) not null,
    b_content varchar(1000),
    user_id varchar(50) references tbl_member(user_id),
    b_reg_date timestamp default sysdate,
    b_viewcnt number default 0,
    re_group number default 0,
    re_seq number default 0,
    re_level number default 0
);

drop sequence seq_board_bno;
create sequence seq_board_bno;

truncate table tbl_board;

select * from tbl_board;

commit;

begin
    for i in 1..500 loop
        insert into tbl_board(b_no, b_title, b_content, user_id, re_group)
        values(seq_board_bno.nextval,
                '제목' || i,
                '내용' || i,
                'test',
                seq_board_bno.nextval);
    end loop;
end;
/

select * from 
(select rownum rnum, a.* from 
(select * from tbl_board 
where b_title like '%제목6%'
order by b_no desc)a)
where rnum between 1 and 10;

select count(*) from tbl_board;


-- 댓글 생성 쿼리

create table tbl_comment(
    c_no number primary key, -- 댓글 번호(PK)
    b_no number references tbl_board(b_no), -- 해당 글번호(FK)
    user_id varchar2(50) references tbl_member(user_id), -- 회원 아이디(FK)
    c_content varchar2(100) not null, -- 댓글 내용
    c_regdate timestamp default sysdate -- 댓글 작성일
);

create sequence seq_comment_cno;

insert into tbl_comment(c_no, b_no, user_id, c_content)
values(seq_comment_cno.nextval, 500, 'test', '댓글1');

insert into tbl_comment(c_no, b_no, user_id, c_content)
values(seq_comment_cno.nextval, 500, 'test', '댓글2');

insert into tbl_comment(c_no, b_no, user_id, c_content)
values(seq_comment_cno.nextval, 500, 'test', '댓글3');

select * from tbl_comment
where b_no = 500
order by c_no desc;