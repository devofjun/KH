create user SPRING_EXAM01 identified by 1234;
grant connect, resource to SPRING_EXAM01;


create table TBL_STUDENT(
    SNO varchar2(8) primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(2) not null,
    MAJOR varchar2(10) not null,
    SCORE number(3) default 0 not null
);

select * from tbl_student;
insert into tbl_student(sno, sname, syear, gender, major, score)
    values('10001234', '테스터', 4, 'F', '컴공', '100');

insert into tbl_student(sno, sname, syear, gender, major, score)
    values('1234', '정병준', 4, 'F', '컴공', '100');

commit;

truncate table tbl_consult;
create table tbl_consult(
    consult_no number primary key,
    sno varchar2(8) references tbl_student(sno) not null,
    consult_content varchar2(500),
    consult_date timestamp default sysdate
);

drop sequence seq_consult_no;
create sequence seq_consult_no;

insert into tbl_consult(consult_no, sno, consult_content)
values (seq_consult_no.nextval, '10001234', '상담내용6');

commit;

select * from tbl_consult;

select c.consult_no, s.sname, c.consult_content, c.consult_date
from tbl_consult c, tbl_student s where c.sno = s.sno and c.sno='1234';

select  c.consult_no, s.sname, c.consult_content, c.consult_date
from tbl_consult c, (select * from tbl_student where sno='1234' ) s
where sno = '1234';