package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentDao.StudentDao;
import studentVo.StudentVo;

public class StudentRegistRunService implements IStudentService{

	StudentDao dao = StudentDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		System.out.println(sname);
		int syear = Integer.parseInt(request.getParameter("syear"));
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		int score = Integer.parseInt(request.getParameter("score"));
		StudentVo vo =new StudentVo(sno, sname, syear, gender, major, score);		
		
		boolean result = dao.insertStudent(vo);
		HttpSession session = request.getSession();
		session.setAttribute("resultRegist", result);
		return IStudentService.REDIRECT+"/StudentList.kh";
	}

}
