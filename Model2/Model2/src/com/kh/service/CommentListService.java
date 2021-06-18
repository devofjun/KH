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
		
		// dao로 부터 댓글 데이터를 리스트형식으로 받아온다.
		List<CommentVo> list = commentDao.getCommentList(b_no);
		System.out.println("list:"+list);
		
		// 비동기방식은 자바스크립트로 처리하는데 자바의 ArrayList로는 처리 할 수 없다.
		// 때문에 json으로 데이터를 바꿔서 넘겨주는 것이다.
		// 제이슨을 쉽게 쓸 수 있게 해주는 라이브러리 사용 json-simple-1.1.1.jar
		JSONArray jsonArray = new JSONArray(); // [ ] json 배열
		for(CommentVo commentVo : list) {
			JSONObject jsonObject = new JSONObject(); // { } 하나의 json 개체
			jsonObject.put("c_no", commentVo.getC_no()); // {"c_no" : 1} 개체에 데이터를 담는다.
			jsonObject.put("b_no", commentVo.getB_no());
			jsonObject.put("c_content", commentVo.getC_content());
			jsonObject.put("m_id", commentVo.getM_id());
			jsonObject.put("c_date", commentVo.getC_date().toString()); // Timestamp가 숫자값으로 출력되는데 문자형태로 변환해주지 않으면 자바스크립트에서 json형태로 받지 못함 
			jsonArray.add(jsonObject);
		}
		// 만들어진 JSON을 다시 String으로 바꿔서 데이터를 넘겨준다.
		// 받는 곳에서 다시 JSON으로 읽어들이면 된다.
		String data = jsonArray.toJSONString();
		System.out.println("data:"+ data);
		request.setAttribute("data", data);
		return IService.DATA;
	}

}