<%@page import="com.kh.db.StudentDao"%>
<%@page import="com.kh.db.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// request = JSP 안에 만들어져있는 내장 객체
	request.setCharacterEncoding("utf-8");
	String st_num = request.getParameter("st_num");
	String st_name = request.getParameter("st_name");
	String st_major = request.getParameter("st_major");
	String st_year = request.getParameter("st_year");
	String st_score = request.getParameter("st_score");
	String st_etc = request.getParameter("st_etc");
	
	int i_st_num = Integer.parseInt(st_num);
	int i_st_year = Integer.parseInt(st_year);
	int i_st_score = Integer.parseInt(st_score);
	
	StudentVo studentVo = new StudentVo(i_st_num, st_name, st_major, i_st_year, i_st_score, st_etc);
	System.out.println(studentVo);
	StudentDao dao = StudentDao.getInstance();
	//dao.getConnection();
	boolean result = dao.insertStudent(studentVo);
	String strResult = "등록 실패";
	if(result == true) {
		strResult = "등록 성공";
	}
%>
<%@ include file="include/header.jsp" %>
<title>학생 등록 처리 결과</title>
<%@ include file="include/bodystarter.jsp" %>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2><%=strResult %></h2>
					<p>학생 목록으로 이동하시려면 아래의 목록 버튼을 클릭해주세요.</p>
					<p>
						<a class="btn btn-primary btn-large" href="student_list.jsp">목록</a>
					</p>
				</div>
			</div>
		</div>
<%@ include file="include/footer.jsp" %>