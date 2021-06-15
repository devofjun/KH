package com.kh.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteRunService implements IBoardService {
	
	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uploadPath = request.getServletContext().getRealPath("upload");
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		int maxPostSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		String m_id = multi.getParameter("m_id");
		String b_filepath = multi.getFilesystemName("b_filepath");
		
		BoardVo vo = new BoardVo(0, b_title, b_content, null, m_id, 0, 0, 0, 0, b_filepath);
		boolean result = dao.insertArticle(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("resultWrite", result);
		
		return IBoardService.REDIRECT + "/BoardList.do";
	}

}
