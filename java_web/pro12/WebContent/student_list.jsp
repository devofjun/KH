<%@page import="com.kh.db.StudentVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.db.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StudentDao dao = StudentDao.getInstance();
	ArrayList<StudentVo> list = dao.listStudent();
	
%>
<%@ include file="include/header.jsp" %>
<title>Insert title here</title>
<%@ include file="include/bodystarter.jsp" %>
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생목록</h2>
				<p>등록된 학생 목록입니다.</p>
				<p>
					<a class="btn btn-primary btn-large" href="student_regist_form.jsp">학생 등록</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>전공</th>
						<th>학년</th>
					</tr>
				</thead>
				<tbody>
				<%
					for(StudentVo vo : list) {
				%>
					<tr>
						<td><%=vo.getSt_num() %></td>
						<td><a href="student_content.jsp"><%=vo.getSt_name() %></a></td>
						<td><%=vo.getSt_major() %></td>
						<td><%=vo.getSt_year() %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="include/footer.jsp" %>