drop table TBL_STUDENT;
create table TBL_STUDENT2(
    SNO varchar2(8) constraint pk_SNO2 primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(3) not null,
    MAJOR varchar(10) not null,
    SCORE number(3) default 0 constraint score_nn2 not null,
    constraint score_chk2 check(SCORE between 0 and 100)
);

alter table TBL_STUDENT modify (SCORE not null);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201001, '���л�', 2, '��', '�İ�', 100);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201002, '���л�', 2, '��', '�İ�', 70);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201003, '���л�', 2, '��', '����', 80);
insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values(20201004, '���л�', 2, '��', '����', 23);

commit;

select * from TBL_STUDENT order by sno;

select * from TBL_STUDENT where SNAME='���л�' order by sno;



update TBL_STUDENT
set GENDER = '��'
where SNO = '20201001';