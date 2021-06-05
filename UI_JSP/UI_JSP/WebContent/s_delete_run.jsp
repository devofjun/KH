<%@page import="com.kh.db.UIDao"%>
<%@page import="com.kh.db.UIVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 요청데이터 한글 변환
	request.setCharacterEncoding("utf-8");
	// 
	String sno = request.getParameter("SNO");
	//System.out.println(sno);
	
	UIDao dao = UIDao.getInstance();
	boolean result = dao.deleteContent(sno);
	
	String strResult = "";
	if(result){
		strResult = "삭제완료";
	} else {
		strResult = "삭제실패";
	}
%>

<%@ include file="include/header.jsp"%>
<title>삭제처리 결과</title>
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