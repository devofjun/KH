create table tbl_student(
    st_num number constraint pk_student_num primary key,
    st_name varchar2(20) not null,
    st_major varchar2(20) not null,
    st_year number(1) default 1,
    st_score number(3) default 0,
    st_etc varchar2(500)
);

select * from tbl_student;
