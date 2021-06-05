<%@page import="com.kh.db.UIDao"%>
<%@page import="com.kh.db.UIVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 요청데이터 한글 변환
	request.setCharacterEncoding("utf-8");
	// 
	String sno = request.getParameter("SNO");
	String sname = request.getParameter("SNAME");
	String syear = request.getParameter("SYEAR");
	String gender = request.getParameter("GENDER");
	String major = request.getParameter("MAJOR");
	String score = request.getParameter("SCORE");

	int i_syear = Integer.parseInt(syear);
	int i_score = Integer.parseInt(score);

	UIVo vo = new UIVo(sno, sname, i_syear, gender, major, i_score);
	System.out.println("regist_vo:" + vo);
	UIDao dao = UIDao.getInstance();
	boolean result = dao.insertContent(vo);
	
	String strResult = "";
	if(result){
		strResult = "등록완료";
	} else {
		strResult = "등록실패";
	}
	
%>
<%@ include file="include/header.jsp"%>
<title>등록 처리 결과</title>
<%@ include file="include/bodystarter.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="jumbotron">
			<h2><%=strResult %></h2>
			<p>학생 목록으로 이동하시려면 아래의 목록 버튼을 클릭해주세요.</p>
			<p>
				<a class="btn btn-primary btn-large" href="index.jsp">목록</a>
			</p>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>