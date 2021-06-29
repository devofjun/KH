package com.kh.exam01.persitence;

import java.util.List;

import com.kh.exam01.domain.StudentVo;

public interface StudentDao {
	public void insertStudent(StudentVo studentVo);
	public List<StudentVo> selectStdList();
	public StudentVo selectStudent(String sno);
	public void updateStudent(StudentVo studentVo);
	public void deleteStudent(String sno);
}
