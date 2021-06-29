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

commit;