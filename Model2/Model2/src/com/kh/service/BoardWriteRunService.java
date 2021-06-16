package com.kh.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.vo.BoardVo;
import com.kh.vo.MemberVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteRunService implements IService{
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 글쓰기 처리
		// form태그 -> enctype="multipart/form-data"
		// -> form에서 바이너리 데이터로 넘어온 경우에는 request 처리할 수 없다.
		String uploadPath = request.getServletContext().getRealPath("upload"); // 프로젝트의 로컬에서의 실제 경로
		System.out.println(uploadPath); // 톰캣의 자원을 이클립스에서 가져와서 쓰기 때문에 경로가 길 수 있다.
		File f = new File(uploadPath); // 파일 생성하기 위한 파일객체
		if(!f.exists()) { // 존재하지 않다면 디렉토리를 생성한다.
			f.mkdir();
		}
		
		int maxPostSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 크기(5MB)
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		// MultipartRequest(request, 파일업로드 위치, 파일 최대크기, 인코딩, 중복되는 이름에 대한 정책)
		// -> 생성자가 문제없이 실행됐다면 업로드가 되어있는 상태가 된다.
		
		// 바이너리 데이터로 오기 때문에 request로는 읽을 수 없다. 그래서 multi로 바꿈
		String b_title = multi.getParameter("b_title");
		String b_content = multi.getParameter("b_content");
		//String m_id = multi.getParameter("m_id");
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		String m_id = memberVo.getUser_id();
		String b_filepath = multi.getFilesystemName("b_filepath");
		// ㄴ 서버쪽(upload)에 저장된 파일명
		System.out.println("b_title: " + b_title);
		System.out.println("b_content: " + b_content);	
		System.out.println("m_id: " + m_id);
		System.out.println("b_file_path: " + b_filepath);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		boardVo.setB_filepath(b_filepath);
		boolean result = boardDao.insertArticle(boardVo);
		
		// 세션은 서버쪽에 저장되는 정보이다.
		session.setAttribute("resultWrite", result);
		
		return IService.REDIRECT + "/BoardList.do";
	}

}
