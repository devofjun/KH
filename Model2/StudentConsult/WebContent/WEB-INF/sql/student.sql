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

----------------------------------
-- 상담내역
----------------------------------

-- 상담 테이블 생성
create table TBL_CONSULT(
    C_NO number constraint pk_consult_cno primary key,
    SNO varchar2(8) constraint fk_sno references TBL_STUDENT(SNO),
    C_CONTENT varchar2(500) not null,
    C_DATE varchar2(10) default to_char(sysdate, 'yyyy-MM-dd') not null
);
drop table tbl_consult;

-- c_no를 위한 시퀀스 생성
drop sequence SEQ_CONSULT;
create sequence SEQ_CONSULT
start with 1
increment by 1;

-- test data insert
insert into TBL_CONSULT(C_NO, SNO, C_CONTENT, C_DATE)
    values (SEQ_CONSULT.nextval,
        '18-12345', 
        '아무내용', 
        '2020-01-01');

truncate table tbl_consult;

begin
    for i in 1..5 loop
        insert into TBL_CONSULT(C_NO, SNO, C_CONTENT)
            values (SEQ_CONSULT.nextval,
            '18-12345', 
            '상담신청 ' || i || '트째');
    end loop;
end;
/

begin
    for i in 1..3 loop
        insert into TBL_CONSULT(C_NO, SNO, C_CONTENT)
            values (SEQ_CONSULT.nextval,
            '18-54321', 
            '상담신청 ' || i || '번째입니다.');
    end loop;
end;
/

commit;

-- 조회
select * from tbl_consult;
select * from TBL_CONSULT where sno='18-54321' order by C_DATE desc, c_no desc;



select to_char(sysdate, 'yyyy-MM-dd')
from dual;

