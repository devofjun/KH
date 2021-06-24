create user springmvc2 identified by 1234;
grant connect, resource to springmvc2;

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

select * from tbl_board;

commit;