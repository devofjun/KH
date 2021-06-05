drop table TBL_STUDENT;
create table TBL_STUDENT(
    SNO varchar2(8) constraint pk_SNO primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(3) not null,
    MAJOR varchar(10) not null,
    SCORE number(3) default 0,
    constraint score_chk check(SCORE between 0 and 100)
);

alter table TBL_STUDENT modify (SCORE not null);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201004, '±èÇÐ»ý', 2, '¿©', 'È­ÇÐ', 99);


select * from TBL_STUDENT order by sno;

select * from TBL_STUDENT where SNAME='±èÇÐ»ý' order by sno;

commit

update TBL_STUDENT
set GENDER = '³²'
where SNO = '20201001';
