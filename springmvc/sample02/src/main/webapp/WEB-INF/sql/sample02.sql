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
values('hong', '1234', '홍길동');

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

select * from tbl_board order by b_no desc;

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

commit;



-- 메세지(쪽지) 테이블
truncate table tbl_message;
create table tbl_message(
	msg_no number primary key, -- 쪽지 번호
	msg_content varchar2(200) not null, -- 쪽지 내용
	msg_sender varchar2(50) references tbl_member(user_id), -- 보낸사람
	msg_receiver varchar2(50) references tbl_member(user_id), -- 받는사람
	msg_senddate timestamp default sysdate, -- 보낸시각
	msg_opendate timestamp -- 읽은시각	
);

-- 쪽지 번호용 시퀀스
create sequence seq_message_no;

-- 메세지 테이블 확인
select * from tbl_message;


-- 포인트 카테고리(타입) 테이블
create table tbl_point_cate(
	point_code varchar(4) primary key,
	point_desc varchar(30)	not null
);

-- 포인트 테이블
create table tbl_point(
	point_no number primary key, -- 포인트번호
	user_id varchar2(50) references tbl_member(user_id), -- 아이디
	point_code  varchar2(4) references tbl_point_cate(point_code), -- 포인트코드
	point_score number default 0,
	point_date timestamp default sysdate
);

-- 포인트 번호용 시퀀스
create sequence seq_point_no;

-- 사용자 테이블에 포인트 컬럼 추가
alter table tbl_member
add (user_point number default 0);

-- 포인트 카테고리(타입) 테이블에 쪽지보내기/쓰기에 대한 데이터 추가
insert into tbl_point_cate(point_code, point_desc)
values ('1001', '쪽지보내기');
insert into tbl_point_cate(point_code, point_desc)
values ('1002', '쪽지읽기');
commit;

-- 쪽지 테이블 내용 지우기
truncate table tbl_message;
-- 포인트 테이블 내용 지우기
truncate table tbl_point;
-- 포인트는 모두 0점으로 설정
update tbl_member set
    user_point = 0;
commit;

select * from tbl_message;
select * from tbl_point;
select * from tbl_member;


insert into tbl_message(msg_no, msg_content, msg_sender, msg_receiver) values (seq_message_no.nextval, 
'123', 'hong', 'kim');


-- 게시판 테이블에 댓글 갯수 컬럼 추가
alter table tbl_board
add(comment_cnt number default 0);
commit;

-- 기존에 입력한 댓글이 있긴 떄문에, 입력된 갯수만큼 댓글수 변경
update tbl_board set
    comment_cnt = (select count(*) from tbl_comment where b_no = 500)
where b_no = 500;



-- 파일 업로드
create table tbl_attach(
    file_Name varchar2(200) primary key,
    b_no number references tbl_board(b_no)
);
commit;