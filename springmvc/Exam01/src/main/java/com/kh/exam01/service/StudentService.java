package com.kh.exam01.service;

import java.util.List;

import com.kh.exam01.domain.StudentVo;

public interface StudentService {
	public void stdRegistRun(StudentVo studentVo);
	public List<StudentVo> listAll();
	public StudentVo getStudent(String sno);
	public void stdModifyRun(StudentVo studentVo);
	public void stdRemoveRun(String sno);
}
