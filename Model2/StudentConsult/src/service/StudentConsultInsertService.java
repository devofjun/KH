package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentDao.StudentDao;
import studentVo.ConsultVo;

public class StudentConsultInsertService implements IStudentService {
	StudentDao dao = StudentDao.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sno = request.getParameter("sno");
		String c_content = request.getParameter("c_content");
		
		ConsultVo vo = new ConsultVo(0, sno, c_content, null);
		boolean result = dao.insertConsult(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("result", result);
		
		return IStudentService.REDIRECT + "/StudentList.kh";
	}

}
