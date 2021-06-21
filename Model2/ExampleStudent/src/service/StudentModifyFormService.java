package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentDao.StudentDao;
import studentVo.StudentVo;

public class StudentModifyFormService implements IStudentService{

	StudentDao dao = StudentDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sno = request.getParameter("sno");
		
		StudentVo vo =dao.getStudent(sno);
		
		request.setAttribute("vo", vo);
		
		return "student_modify_form";
	}

}
