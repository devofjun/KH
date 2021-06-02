<%@page import="com.kh.db.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int st_num = Integer.parseInt(request.getParameter("st_num"));
	StudentDao dao = StudentDao.getInstance();
	boolean result = dao.deleteStudent(st_num);
	String strResult = "삭제 실패";
	if (result == true) {
		strResult = "삭제 성공";
	}
%>	
<%@ include file="include/header.jsp"%>
<title>학생 삭제 처리 결과</title>
<%@ include file="include/bodystarter.jsp"%>
<div class="row">
	<div class="col-md-12">
		<div class="jumbotron">
			<h2><%=strResult%></h2>
			<p>학생 목록으로 이동하시려면 아래의 목록 버튼을 클릭해주세요.</p>
			<p>
				<a class="btn btn-primary btn-large" href="student_list.jsp">목록</a>
			</p>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>