package com.kh.exam01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.exam01.domain.StudentVo;
import com.kh.exam01.persitence.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentDaoTest {
	@Inject
	StudentDao studentDao;
	
	@Test
	public void list() {
		List<StudentVo> list =studentDao.selectStdList();
		//System.out.println(list);
	}
	
	@Test
	public void select() {
		String sno = "12345678";
		studentDao.selectStudent(sno);
	}
	
	@Test
	public void insert() {
		StudentVo vo = new StudentVo();
		vo.setSno("4040404");
		vo.setSname("이름");
		vo.setSyear(1);
		vo.setGender("F");
		vo.setMajor("컴공");
		vo.setScore(70);
		studentDao.insertStudent(vo);
	}
	
	@Test
	public void update() {
		StudentVo vo = new StudentVo();
		vo.setSno("4040404");
		vo.setSname("이름잉");
		vo.setSyear(3);
		vo.setGender("M");
		vo.setMajor("소공");
		vo.setScore(80);
		studentDao.updateStudent(vo);
	}
	
	@Test
	public void delete() {
		String sno = "4040404";
		studentDao.deleteStudent(sno);
	}
}
