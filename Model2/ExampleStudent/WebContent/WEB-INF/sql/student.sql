create user USER1001 identified by U1234;
grant connect, resource to USER1001;

drop table TBL_STUDENT;

create table TBL_STUDENT(
    SNO varchar2(8) constraint pk_student_sno primary key,
    SNAME varchar2(10) not null,
    SYEAR number(1) not null,
    GENDER varchar2(3) not null,
    MAJOR varchar2(10) not null,
    SCORE number(3) default 0 constraint nn_score not null,
    constraint gender_chk check(GENDER = '남' or GENDER = '여'),
    constraint score_chk check(SCORE between 0 and 100),
    constraint year_chk check(SYEAR between 1 and 4),
    constraint major_chk check(MAJOR='컴공' or MAJOR='물리' or MAJOR='화학' or MAJOR='생물')
);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('18-12345', '정병준', 4, '남', '컴공', 100);

insert into TBL_STUDENT(SNO, SNAME, SYEAR, GENDER, MAJOR, SCORE)
values('18-54321', '홍길동', 1, '남', '물리', 11);

select * from TBL_STUDENT;

commit;