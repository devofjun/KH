package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.dao.CommentDao;
import com.kh.vo.CommentVo;

public class CommentListService implements IService {
	
	CommentDao commentDao = CommentDao.getInstance();
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		System.out.println("b_no:"+b_no);
		
		List<CommentVo> list = commentDao.getCommentList(b_no);
		System.out.println("list:"+list);
		
		// 비동기방식으로 데이터를 처리하기 때문에 자바스크립트로는 자바의 ArrayList로는 처리 할 수 없다.
		// 때문에 json으로 데이터를 바꿔서 넘겨주는 것이다.
		// 라이브러리 사용 json-simple-1.1.1.jar
		JSONArray jsonArray = new JSONArray(); // [ ]
		for(CommentVo commentVo : list) {
			JSONObject jsonObject = new JSONObject(); // { }
			jsonObject.put("c_no", commentVo.getC_no()); // {"c_no" : 1}
			jsonObject.put("b_no", commentVo.getB_no());
			jsonObject.put("c_content", commentVo.getC_content());
			jsonObject.put("m_id", commentVo.getM_id());
			jsonObject.put("c_date", commentVo.getC_date().toString()); // 이게 숫자값으로 출력되는데 문자형태로 변환해주지 않으면 자바스크립트에서 json형태로 받지 못함 
			jsonArray.add(jsonObject);
		}
		String data = jsonArray.toJSONString();
		System.out.println("data:"+ data);
		request.setAttribute("data", data);
		return IService.DATA;
	}

}
