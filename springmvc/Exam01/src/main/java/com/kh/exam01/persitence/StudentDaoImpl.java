package com.kh.exam01.persitence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.exam01.domain.StudentVo;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	private static final String NAMESPACE = "com.kh.Exam01.student.";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertStudent(StudentVo studentVo) {
		sqlSession.insert(NAMESPACE+"insertStudent", studentVo);	
	}

	@Override
	public List<StudentVo> selectStdList() {
		List<StudentVo> list = sqlSession.selectList(NAMESPACE+"selectStdList");
		return list;
	}

	@Override
	public StudentVo selectStudent(String sno) {
		StudentVo vo = sqlSession.selectOne(NAMESPACE+"selectStudent", sno);
		return vo;
	}

	@Override
	public void updateStudent(StudentVo studentVo) {
		sqlSession.update(NAMESPACE+"updateStudent", studentVo);
	}

	@Override
	public void deleteStudent(String sno) {
		sqlSession.delete(NAMESPACE+"deleteStudent", sno);
	}

}
