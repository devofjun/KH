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