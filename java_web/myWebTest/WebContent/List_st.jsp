<%@page import="com.kh.db.TestStudentVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.db.TestStudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	TestStudentDao dao = TestStudentDao.getInstance();
	ArrayList<TestStudentVo> voList = dao.getStudentList();
	System.out.println("voList: "+voList);
%>
<%@ include file="include/header.jsp"%>
<title>학생 목록</title>
<%@ include file="include/bodystarter.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생목록</h2>
				<p>등록하고 싶다면 아래 버튼 눌러</p>
				<p>
					<a id="btn_Regist" class="btn btn-primary btn-large" href="#">등록</a>
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
				<%for(TestStudentVo vo : voList) { %>
					<tr>
						<td><%=vo.getStNum() %></td>
						<td><%=vo.getStName() %></td>
						<td><%=vo.getStMajor() %></td>
						<td><%=vo.getStYear() %></td>
					</tr>
				<%} %>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>