drop table TBL_STUDENT2;
create table TBL_STUDENT(
    SNO varchar2(8) constraint pk_SNO primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(3) not null,
    MAJOR varchar(10) not null,
    SCORE number(3) default 0 constraint score_nn not null,
    constraint score_chk check(SCORE between 0 and 100)
);

alter table TBL_STUDENT modify (SCORE not null);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201001, '김학생', 2, '남', '컴공', 100);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201002, '박학생', 2, '여', '컴공', 70);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201003, '정학생', 2, '남', '전자', 80);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201004, '김학생', 2, '여', '물리', 23);

commit;

select * from TBL_STUDENT order by sno;

select * from TBL_STUDENT where SNAME='김학생' order by sno;



update TBL_STUDENT
set GENDER = '남'
where SNO = '20201001';
