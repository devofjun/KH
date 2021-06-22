package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import studentDao.StudentDao;
import studentVo.ConsultVo;

public class StudentConsultListService implements IStudentService {
	
	StudentDao dao = StudentDao.getInstance();
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sno = request.getParameter("sno");
		List<ConsultVo> list = dao.getConsult(sno);
		System.out.println(list);
		
		JSONArray jsonArray = new JSONArray();
		for(ConsultVo consultVo : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("c_no", consultVo.getC_no());
			jsonObject.put("sno", consultVo.getSno());
			jsonObject.put("c_content", consultVo.getC_content());
			jsonObject.put("c_date", consultVo.getC_date());
						
			jsonArray.add(jsonObject);
		}
		// 만들어진 JSON을 다시 String으로 바꿔서 데이터를 넘겨준다.
		// 받는 곳에서 다시 JSON으로 읽어들이면 된다.
		String data = jsonArray.toJSONString();
		request.setAttribute("data", data);
		
		return IStudentService.DATA;
	}

}
