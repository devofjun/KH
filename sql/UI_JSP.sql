drop table TBL_STUDENT;
create table TBL_STUDENT(
    SNO varchar2(8) constraint pk_SNO primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(3) not null,
    MAJOR varchar(10) not null,
    SCORE number(3) default 0 constraint score_nn not null,
    constraint score_chk check(SCORE between 0 and 100),
    constraint year_chk check(SYEAR between 1 and 4)
);

alter table TBL_STUDENT modify (SCORE not null);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('18-12345', '정병준', 2, '남', '컴퓨터', 100);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('18-12346', '이름', 1, '남', '컴퓨터', 99);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('18-12347', '김이름', 2, '남', '컴퓨터', 12);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('19-54321', '테스터', 1, '남', '컴퓨터', 77);

commit;

select * from TBL_STUDENT order by sno;

select * from TBL_STUDENT where SNAME='김학생' order by sno;



update TBL_STUDENT
set SCORE = 95
where SNO = '18-12345';
