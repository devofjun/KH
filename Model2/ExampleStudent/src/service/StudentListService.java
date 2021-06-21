package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;
import studentVo.StudentVo;

public class StudentListService implements IStudentService{

	private StudentDao dao = StudentDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<StudentVo> list = dao.getStudentList();
		request.setAttribute("list", list);
		
		return "student_list";
	}

}
