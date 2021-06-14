package com.kh.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteRunService implements IService{
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글쓰기 처리
		// enctype="multipart/form-data"
		// -> form에서 바이너리 데이터로 넘어온 경우에는 request 처리할 수 없다.
		String uploadPath = request.getServletContext().getRealPath("upload"); // 프로젝트의 로컬에서의 실제 경로
		System.out.println(uploadPath); // 톰캣의 자원을 이클립스에서 가져와서 쓰기 때문에 경로가 길 수 있다.
		File f = new File(uploadPath); // 파일 생성하기 위한 파일객체
		if(!f.exists()) { // 존재하지 않다면
			f.mkdir();
		}
		/*
		String saveDirectory = "upload"; // 업로드 될 경로
		int maxPostSize = 5 * 1024; // 업로드할 파일의 최대 크기(5MB)
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, new DefaultFileRenamePolicy());
		*/
		// -> 생성자가 문제없이 실행됐다면 업로드가 되어있는 상태
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String m_id = request.getParameter("m_id");
		System.out.println("b_title: " + b_title);
		System.out.println("b_content: " + b_content);	
		System.out.println("m_id: " + m_id);
		/*
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boolean result = boardDao.insertArticle(boardVo);
		
		// 세션은 서버쪽에 저장되는 정보이다.
		HttpSession session = request.getSession();
		session.setAttribute("resultWrite", result);
		*/
		return IService.REDIRECT + "/BoardList.do";
	}

}
