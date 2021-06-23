create user springmvc identified by 1234;
grant connect, resource to springmvc;

-- springmvc 접속
-- 회원 테이블
create table tbl_member(
    user_id varchar2(50) primary key,
    user_pw varchar2(50) not null,
    user_name varchar2(50) not null,
    user_email varchar2(50),
    reg_date timestamp default sysdate,
    update_date timestamp
);

commit;

select * from tbl_member;

-- 게시판 테이블(tbl_board)
create table tbl_board(
    b_no number primary key, -- 글번호
    b_title varchar2(100) not null, -- 글제목
    b_content varchar(1000), -- 글내용
    user_id varchar(50) references tbl_member(user_id), -- 작성자
    b_regdate timestamp default sysdate, -- 글 작성시간
    b_viewcnt number default 0, -- 조회수
    re_group number default 0, -- 글그룹(원글번호)
    re_seq number default 0, -- 같은 글그룹 내에서 출력 순서
    re_level number default 0  -- 답글 들여쓰기용
);

create sequence seq_board_bno; -- 1부터 1씩 증가

select * from tbl_board;


