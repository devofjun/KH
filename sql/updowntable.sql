create table tbl_user(
    u_id varchar2(14),
    u_pw varchar2(14),
    u_name varchar2(14)
);

create table tbl_score(
    u_id varchar2(15),
    score number
);

insert into tbl_user (u_id, u_pw, u_name)
values ('test', '1234', 'test');

insert into tbl_score (u_id, score)
values ('test', '100');

commit;

select * from gameuser;
desc gameuser;