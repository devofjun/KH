package com.kh.exam01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.exam01.domain.StudentVo;
import com.kh.exam01.persitence.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Inject
	StudentDao studentDao;
	
	@Override
	public void stdRegistRun(StudentVo studentVo) {
		studentDao.insertStudent(studentVo);
	}

	@Override
	public List<StudentVo> listAll() {
		List<StudentVo> list = studentDao.selectStdList();
		return list;
	}

	@Override
	public StudentVo getStudent(String sno) {
		StudentVo vo = studentDao.selectStudent(sno);
		return vo;
	}

	@Override
	public void stdModifyRun(StudentVo studentVo) {
		studentDao.updateStudent(studentVo);
	}

	@Override
	public void stdRemoveRun(String sno) {
		studentDao.deleteStudent(sno);
	}

}
